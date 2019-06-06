package com.ryq.sharebike.serviceImp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ryq.sharebike.dao.BikeMapper;
import com.ryq.sharebike.dao.UserMapper;
import com.ryq.sharebike.pojo.*;
import com.ryq.sharebike.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
普通用户Ser实现类
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private BikeMapper bikeMapper;
    @Override
    public User Login(User user) {
        return userMapper.Login(user);
    }

    @Override
    public int Register(User user) {
        user.setGrade(0);
        user.setRegisterDate(Calendar.getInstance().getTime());
        user.setState(0);
        return userMapper.Register(user);
    }

    /*
    state:状态 0：报废 1：在修 2：正在使用 3：已被预约 4：可以使用 5:数量不足
     */
    @Override
    public int useBike(int userId, int bikeId) {
        Bike b = bikeMapper.getBikeById(bikeId);
        Integer appoBikeId =  userMapper.checkAppointmenting(userId);
        switch (b.getState()) {
            case 0:
            case 1:
            case 2:
                return b.getState();
            case 3:
                if(appoBikeId == null){
                    return -2;
                }else{
                    if(b.getBikeId() == appoBikeId){
                        if (userMapper.addFinshAppointment(userId, Calendar.getInstance().getTime()) != 0
                                && userMapper.changUserStateById(userId, 1) != 0
                                && bikeMapper.changBikeStateById(b.getBikeId(), 1) != 0) {
                            userMapper.useBike(userId, b.getBikeId(), Calendar.getInstance().getTime());
                            return 4;
                        } else {
                            return -1;
                        }
                    }else{
                        return 3;
                    }
                }
            case 4:
                if(appoBikeId == null) {
                    int i = userMapper.changUserStateById(userId, 1);
                    bikeMapper.changBikeStateById(bikeId, 2);
                    if (i == 1) {
                        bikeMapper.changBikeNumberByBikeId(bikeId, b.getType().getNumber() - 1);
                        userMapper.useBike(userId, bikeId, Calendar.getInstance().getTime());
                        return 4;
                    } else {
                        return -1;
                    }
                }else{
                    return 3;
                }
            default:
                return -1;
        }
    }

    @Override
    public int backBike(int userId, long bal) {
        Integer bikeId = userMapper.checkNoBack(userId);
        if (bikeId == null) {
            return -1;
        }
        Bike b = bikeMapper.getBikeById(bikeId);
        Date borrowTime = userMapper.checkBorrowTime(userId);
        Date currentDate = new Date();
        long money = ((currentDate.getTime() - borrowTime.getTime()) / (1000 * 60 * 60));
        if (money == 0) {
            money = 1;
        }
        if (b.getType().getKind() == 1) {
            money = money * 2;
        }
        long balance = bal - money;
        if (userMapper.addBackBikeRecordById(userId, Calendar.getInstance().getTime(), (float) money) != 0
                && userMapper.addPayRecord(userId, Calendar.getInstance().getTime(), (float) money) != 0
                && userMapper.changUserBalanceById(userId, (float) balance) != 0
                && userMapper.changUserStateById(userId, 0) != 0
                && bikeMapper.changBikeNumberByBikeId(b.getBikeId(), b.getType().getNumber() + 1) != 0
                && bikeMapper.changBikeStateById(b.getBikeId(), 4) != 0) {
            return (int) money;
        } else {
            return 0;
        }
    }

    @Override
    public int appointmentBike(int userId, int bikeId) {
        Bike b = bikeMapper.getBikeById(bikeId);
        switch (b.getState()) {
            case 0:
            case 1:
            case 2:
            case 3:
                return b.getState();
            case 4:
                int i = bikeMapper.changBikeStateById(bikeId, 3);
                userMapper.changUserStateById(userId, 2);
                if (i == 1) {
                    bikeMapper.changBikeNumberByBikeId(bikeId, b.getType().getNumber() - 1);
                    userMapper.appointmentBike(userId, bikeId, Calendar.getInstance().getTime());
                    return 4;
                } else {
                    return -1;
                }
            default:
                return -1;
        }
    }

    @Override
    public int finshAppointment(int userId) {
        Integer bikeId = userMapper.checkAppointmenting(userId);
        if (bikeId == null) {
            return -1;
        }
        Bike b = bikeMapper.getBikeById(bikeId);
        if (userMapper.addFinshAppointment(userId, Calendar.getInstance().getTime()) != 0
                && userMapper.changUserStateById(userId, 0) != 0
                && bikeMapper.changBikeNumberByBikeId(b.getBikeId(), b.getType().getNumber() + 1) != 0
                && bikeMapper.changBikeStateById(b.getBikeId(), 4) != 0) {
            return bikeId;
        } else {
            return 0;
        }
    }

    @Override
    public int Recharge(int userId, float money) {
        List<User> users  = userMapper.getUser(new User(userId,null,null,-1,-1));
        if(users == null || users.size() == 0){
            return -1;
        }
        User u = users.get(0);
        if(userMapper.changUserBalanceById(u.getUserId(),u.getBalance()+money)!=0
                && userMapper.addRechargeRecord(u.getUserId(),Calendar.getInstance().getTime(),money)!=0){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public Page<RechargeRecord> findRechargeRecord(int pageNo, int pageSize,int userId) {
        PageHelper.startPage(pageNo,pageSize);
        return userMapper.findRechargeRecord(userId);
    }

    @Override
    public List<PaymentRecord> findPaymentRecord(int userId) {
        return userMapper.findPaymentRecord(userId);
    }

    @Override
    public int reportRepair(int bikeId) {
        Bike b = bikeMapper.getBikeById(bikeId);
        if(b == null){
            return -1;
        }
        if(b.getState() == 0){
            return 0;
        }else if(b.getState() == 1){
            return -2;
        }else if(b.getState() == 2){
            return -3;
        }else if(b.getState() == 3){
            return -4;
        }else {
            return bikeMapper.changBikeStateById(bikeId,0);
        }

    }

    @Override
    public User check(Long phone) {
        return userMapper.findUserByPhone(phone);
    }

    @Override
    public UseBike findUseingBike(int userId) {
        return userMapper.findUseingBike(userId);
    }

    @Override
    public Page<UseBike> findUseRecord(int pageNo, int pageSize,int userId) {
        PageHelper.startPage(pageNo,pageSize);
        return userMapper.findUseRecord(userId);
    }


}
