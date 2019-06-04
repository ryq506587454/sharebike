package com.ryq.sharebike;


import com.ryq.sharebike.dao.StatisticMapper;
import com.ryq.sharebike.pojo.Bike;
import com.ryq.sharebike.pojo.BikeType;
import com.ryq.sharebike.pojo.User;
import com.ryq.sharebike.serviceImp.AdminServiceImp;
import com.ryq.sharebike.serviceImp.RepairmenServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminBusTest {
    @Autowired(required = false)
    private AdminServiceImp adminServiceImp;
    @Autowired
    private RepairmenServiceImp repairmenServiceImp;

//    @Test
//    public void addBike() {
//        BikeType bt = new BikeType(2, 5);
//        int a = adminServiceImp.addBike(bt);
//        if (a == -1) {
//            System.out.println("未知bike类型");
//        } else {
//            System.out.println("共增加" + a);
//        }
//    }

    /*
    0:全部
     */
//    @Test
//    public void findBikeType() {
//        List<BikeType> bikeTypes = adminServiceImp.findBikeType(0);
//        System.out.println(bikeTypes.size());
//    }

//    @Test
//    public void addBikeType() {
//        BikeType type = new BikeType(1, "天工大");
//        int a = adminServiceImp.addBikeType(type);
//        if (a == 0) {
//            System.out.println("已存在该车型");
//        } else if (a == 1) {
//            System.out.println("添加成功");
//        }
//    }

    @Test
    public void findUser() {
        List<User> users = adminServiceImp.findUser(new User(0, null, null, -1, 1));
        if (users == null || users.size() == 0) {
            System.out.println("没有使用用户");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

//    @Test
//    public void findBrokeBike() {
//        List<Bike> bikes = adminServiceImp.findBrokeBike();
//        if (bikes == null || bikes.size() == 0){
//            System.out.println("目前无待修车辆");
//        }else{
//            for (Bike bike : bikes) {
//                System.out.println(bike.toString());
//            }
//        }
//    }

//    @Test
//    public void beginRepair(){
//        int userId = 0;
//        int a = repairmenServiceImp.beginRepair(userId,5);
//        if (a == 0) {
//            System.out.println("无该车信息");
//        } else if (a == 1) {
//            System.out.println("该车不处于待修状态");
//        } else if (a == 2) {
//            System.out.println("开始维修");
//        } else if(a == 3){
//            System.out.println("维修员正在维修车辆已达上限");
//        } else {
//            System.out.println("出现未知错误");
//        }
//    }

    @Test
    public void staticUserByRegister() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date bDate = formatter.parse("2019-05-01");
        Date eDate = formatter.parse("2019-05-30");
        List<User> users = adminServiceImp.findUserByRegister(eDate,null);
        if(users == null||users.size() == 0){
            System.out.println("未查询到用户");
        }else {
            for (User user : users) {
                System.out.println(user.toString());
            }
        }
    }


}
