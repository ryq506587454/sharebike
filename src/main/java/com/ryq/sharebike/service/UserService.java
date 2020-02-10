package com.ryq.sharebike.service;

import com.github.pagehelper.Page;
import com.ryq.sharebike.pojo.PaymentRecord;
import com.ryq.sharebike.pojo.RechargeRecord;
import com.ryq.sharebike.pojo.UseBike;
import com.ryq.sharebike.pojo.User;

import java.util.List;

/*
普通用户Ser
 */
public interface UserService {
    //普通用户登陆
    User Login(User user);
    //普通用户注册
    int Register(User user);
    //立即用车
    int useBike(int userId, int bikeId);
    //还车
    int backBike(int userId,long bal);
    //预约
    int appointmentBike(int userId,int bikeId);
    //完成预约
    int finshAppointment(int userId);
    //充值
    int Recharge(int userId,float money);
    //查询用户充值记录
    Page<RechargeRecord> findRechargeRecord(int pageNo, int pageSize,int userId);
    //查询支付记录
    List<PaymentRecord> findPaymentRecord(int userId);
    //查询用户用车记录
    Page<UseBike> findUseRecord(int pageNo, int pageSize,int userId);
    //车辆报修
    int reportRepair(int bikeId);
    //用户查重
    User check(Long phone);
    //查询正在使用的车的记录
    UseBike findUseingBike(int userId);


}
