package com.ryq.sharebike.serviceImp;

import com.ryq.sharebike.dao.BikeMapper;
import com.ryq.sharebike.dao.RepairMapper;
import com.ryq.sharebike.dao.UserMapper;
import com.ryq.sharebike.pojo.Bike;
import com.ryq.sharebike.pojo.RepairRecord;
import com.ryq.sharebike.pojo.User;
import com.ryq.sharebike.service.RepairmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class RepairmenServiceImp implements RepairmenService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private BikeMapper bikeMapper;
    @Autowired(required = false)
    private RepairMapper repairMapper;

    @Override
    public User Login(User user) {
        return userMapper.Login(user);
    }

    @Override
    public int Register(User user) {
        user.setGrade(1);
        user.setRegisterDate(Calendar.getInstance().getTime());
        user.setState(0);
        return userMapper.Register(user);
    }


    /*
        flag:1: 已完成的
             2: 未完成的
         */
    @Override
    public List<RepairRecord> findRepairRecord(Date bDate, Date eDate, int flag) {
        return repairMapper.findRepairRecord(bDate, eDate, flag);
    }

    @Override
    public int beginRepair(int userId, int bikeId) {
        Bike b = bikeMapper.getBikeById(bikeId);
        if(repairMapper.findRepairIngByUserId(userId).size()==5){
            return 3;
        }
        if (b == null) {
            return 0;
        } else if (b.getState() != 0) {
            return 1;
        } else if (b.getState() == 0) {
            repairMapper.addBeginRepairRecord(userId, bikeId, Calendar.getInstance().getTime());
            bikeMapper.changBikeNumberByBikeId(bikeId, b.getType().getNumber() - 1);
            bikeMapper.changBikeStateById(bikeId, 1);
            return 2;
        } else {
            return -1;
        }

    }

    @Override
    public int finshRepair(int userId, int bikeId) {
        Bike b = bikeMapper.getBikeById(bikeId);
        if (b == null) {
            return 0;
        } else if (b.getState() != 1) {
            return 1;
        } else if (b.getState() == 1) {
            if (repairMapper.addFinshRepairRecord(userId, bikeId, Calendar.getInstance().getTime()) == 0) {
                return 3;
            } else {
                bikeMapper.changBikeNumberByBikeId(bikeId, b.getType().getNumber() + 1);
                bikeMapper.changBikeStateById(bikeId, 4);
                return 2;
            }
        } else {
            return -1;
        }
    }

    @Override
    public List<RepairRecord> findRepairRecordByUserId(int userId) {
        return repairMapper.findRepairIngByUserId(userId);
    }


}
