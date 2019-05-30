package com.ryq.sharebike.service;

import com.ryq.sharebike.pojo.Bike;
import com.ryq.sharebike.pojo.RepairRecord;
import com.ryq.sharebike.pojo.User;

import java.util.Date;
import java.util.List;

public interface RepairmenService {
    //维修人员登陆
    User Login(User user);
    //维修人员注册
    int Register(User user);
    //查看维修记录
    List<RepairRecord> findRepairRecord(Date bDate, Date eDate,int flag);
    //开始维修
    int beginRepair(int userId,int bikeId);
    //完成修车
    int finshRepair(int userId,int bikeId);
    //根据维修人员ID查看维修记录
    List<RepairRecord> findRepairRecordByUserId(int userId);

}
