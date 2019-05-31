package com.ryq.sharebike.service;

import com.github.pagehelper.Page;
import com.ryq.sharebike.pojo.Bike;
import com.ryq.sharebike.pojo.BikeType;
import com.ryq.sharebike.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdminService {
    //添加车辆
    int addBike(BikeType type);
    //查看所有车辆信息
    Page<Bike> findAllBike(int pageNo,int pageSize);
    //增加车辆种类
    int addBikeType(BikeType type);
    //查看车辆种类
    List<BikeType> findBikeType(int typeId);
    //修改用户状态
    int changUserState(@Param("userId") int userId,@Param("satate") int state );
    //查看用户信息
    List<User> findUser(User user);
    //查看故障车辆
    List<Bike> findBrokeBike();
    //根据注册时间查看用户信息
    List<User> findUserByRegister(Date bDate,Date eDate);
    //根据用户车辆ID查询
    Bike findBikeByBikeId(int bikeId);




}
