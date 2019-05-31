package com.ryq.sharebike.serviceImp;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ryq.sharebike.dao.BikeMapper;
import com.ryq.sharebike.dao.RepairMapper;
import com.ryq.sharebike.dao.StatisticMapper;
import com.ryq.sharebike.dao.UserMapper;
import com.ryq.sharebike.pojo.Bike;
import com.ryq.sharebike.pojo.BikeType;
import com.ryq.sharebike.pojo.User;
import com.ryq.sharebike.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImp implements AdminService {
    @Autowired(required = false)
    private BikeMapper bikeMapper;
    @Autowired(required = false)
    private RepairMapper repairMapper;
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private StatisticMapper statisticMapper;

    @Override
    public int addBike(BikeType type) {
        List<BikeType> bikeTypes = bikeMapper.findBikeType(type.getTypeId());
        if(bikeTypes == null || bikeTypes.size() == 0){
            return -1;
        }
        BikeType bikeType = bikeTypes.get(0);
        if (type.getNumber() == 1) {
            bikeMapper.addBike(new Bike(4, Calendar.getInstance().getTime(), 0, bikeType), type.getTypeId());
            bikeMapper.changBikeNumberByTypeId(bikeType.getTypeId(), bikeType.getNumber() + type.getNumber());
            return 1;
        } else {
            for (int i = 0; i < type.getNumber(); i++) {
                bikeMapper.addBike(new Bike(4, Calendar.getInstance().getTime(), 0, bikeType), type.getTypeId());
            }
            bikeMapper.changBikeNumberByTypeId(bikeType.getTypeId(), bikeType.getNumber() + type.getNumber());
            return type.getNumber();
        }

    }

    @Override
    public Page<Bike> findAllBike(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return bikeMapper.findAllBike();
    }

    @Override
    public int addBikeType(BikeType type) {
        if(bikeMapper.findBikeTypeByDetil(type) == null){
            return bikeMapper.addBikeType(type);
        }else{
            return 0;
        }

    }

    @Override
    public List<BikeType> findBikeType(int typeId) {
        return  bikeMapper.findBikeType(typeId);
    }

    @Override
    public int changUserState(int userId, int state) {
        return userMapper.changUserStateById(userId,state);
    }

    @Override
    public List<User> findUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    public List<Bike> findBrokeBike() {
        return bikeMapper.findBikeByState(0);
    }

    @Override
    public List<User> findUserByRegister(Date bDate, Date eDate) {
        return statisticMapper.findUserByRegisterDate(bDate,eDate);
    }

    @Override
    public Bike findBikeByBikeId(int bikeId) {
        return bikeMapper.getBikeById(bikeId);
    }

}
