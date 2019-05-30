package com.ryq.sharebike;

import com.ryq.sharebike.pojo.Bike;
import com.ryq.sharebike.pojo.RepairRecord;
import com.ryq.sharebike.pojo.User;
import com.ryq.sharebike.serviceImp.AdminServiceImp;
import com.ryq.sharebike.serviceImp.RepairmenServiceImp;
import com.ryq.sharebike.serviceImp.UserServiceImp;
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
public class RepairBusTest {
    @Autowired(required = false)
    private RepairmenServiceImp repairmenServiceImp;
    @Autowired(required = false)
    private UserServiceImp userServiceImp;
    @Autowired(required = false)
    private AdminServiceImp adminServiceImp;

    @Test
    public void Login() {
        User user = new User("15488888888", "123456");
        System.out.println(repairmenServiceImp.Login(user));
    }

    @Test
    public void Register() {
        User user = new User("repMan1", "15588888888", "123456");
        System.out.println(repairmenServiceImp.Register(user));
    }

    @Test
    public void findBrokeBike() {
        List<Bike> bikes = adminServiceImp.findBrokeBike();
        String msg;
        if (bikes == null || bikes.isEmpty()) {
            msg = "未查询到待维修的车辆";
        }
        for (Bike bike : bikes) {
            System.out.println(bike.toString());
        }
    }

    @Test
    public void getRepairRecord() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date bDate = formatter.parse("2019-05-01");
        Date eDate = formatter.parse("2019-05-30");
        List<RepairRecord> repairRecords = repairmenServiceImp.findRepairRecord(bDate, null,1);
        System.out.println(repairRecords.size());
        for (RepairRecord repairRecord : repairRecords) {
            System.out.println(repairRecord);
        }
    }

    @Test
    public void finshRepair() {
        User user = userServiceImp.Login(new User("15488888888", "123456"));
        int a = repairmenServiceImp.finshRepair(user.getUserId(), 6);
        if (a == 0) {
            System.out.println("无该车信息");
        } else if (a == 1) {
            System.out.println("该车未处于维修状态");
        } else if (a == 2) {
            System.out.println("维修完成");
        } else if(a == 3){
            System.out.println("没有该车的维修记录");
        }else {
            System.out.println("出现未知错误");
        }
    }

    @Test
    public void beginRepair(){
        User user = userServiceImp.Login(new User("15488888888", "123456"));
        int a = repairmenServiceImp.beginRepair(user.getUserId(),5);
        if (a == 0) {
            System.out.println("无该车信息");
        } else if (a == 1) {
            System.out.println("该车不处于待修状态");
        } else if (a == 2) {
            System.out.println("开始维修");
        } else if(a == 3){
            System.out.println("维修员正在维修车辆已达上限");
        } else {
            System.out.println("出现未知错误");
        }
    }
}

