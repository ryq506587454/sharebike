package com.ryq.sharebike;

import com.ryq.sharebike.pojo.PaymentRecord;
import com.ryq.sharebike.pojo.RechargeRecord;
import com.ryq.sharebike.pojo.UseBike;
import com.ryq.sharebike.pojo.User;
import com.ryq.sharebike.serviceImp.UserServiceImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBusTEST {
    @Autowired(required = false)
    private UserServiceImp userServiceImp;

//   @Test
//    public void Login() {
//        User user = new User("15388888888", "123456");
//        System.out.println(userServiceImp.Login(user));
//    }

//    @Test
//    public void Register() {
//        User user = new User("test3", "15888888888", "123456");
//        System.out.println(userServiceImp.Register(user));
//    }

//    @Test
//    public void useBike() {
//        String msg;
//        User user = userServiceImp.Login(new User("15188888888", "123456"));
//        if (user.getState() == 0 && user.getBalance() > 0) {
//            switch (userServiceImp.useBike(user.getUserId(), 4)) {
//                case 0:
//                    msg = "开锁失败,所选车辆已被报修";
//                    break;
//                case 1:
//                    msg = "开锁失败,所选车辆正在维修";
//                    break;
//                case 2:
//                    msg = "开锁失败,所选车辆已被使用";
//                    break;
//                case 3:
//                    msg = "开锁失败,所选车辆已被预约";
//                    break;
//                case 4:
//                    msg = "开锁成功，开始计时";
//                    break;
//                case -1:
//                default:
//                    msg = "出现预期之外的错误";
//                    break;
//            }
//        } else if (user.getState() == 1) {
//            msg = "开锁失败，您有未还车辆";
//        } else if (user.getState() == 2) {
//            msg = "预约失败，您有预约车辆";
//        } else if (user.getBalance() <= 0) {
//            msg = "账户余额不足";
//        } else {
//            msg = "出现预期之外的错误";
//        }
//        System.out.println(msg);
//    }

//    @Test
//    public void appointBike() {
//        String msg;
//        User user = userServiceImp.Login(new User("15188888888", "123456"));
//        if (user.getState() == 0 && user.getBalance() > 0) {
//            switch (userServiceImp.appointmentBike(user.getUserId(), 11)) {
//                case 0:
//                    msg = "预约失败,所选车辆已被报修";
//                    break;
//                case 1:
//                    msg = "预约失败,所选车辆正在维修";
//                    break;
//                case 2:
//                    msg = "预约失败,所选车辆已被使用";
//                    break;
//                case 3:
//                    msg = "预约失败,所选车辆已被预约";
//                    break;
//                case 4:
//                    msg = "预约成功，开始计时";
//                    break;
//                case -1:
//                default:
//                    msg = "出现预期之外的错误";
//                    break;
//            }
//        } else if (user.getState() == 1) {
//            msg = "预约失败，您有未还车辆";
//        } else if (user.getState() == 2) {
//            msg = "预约失败，您有预约车辆";
//        } else if (user.getBalance() <= 0) {
//            msg = "账户余额不足";
//        } else {
//            msg = "出现预期之外的错误";
//        }
//        System.out.println(msg);
//    }

//    @Test
//    public void backBike() {
//        String msg;
//        User user = userServiceImp.Login(new User("15188888888", "123456"));
//        int a = userServiceImp.backBike(user.getUserId(), user.getBalance().longValue());
//        switch (a) {
//            case 1:
//                msg = "还车成功";
//                break;
//            case -1:
//                msg = "未查询到使用记录";
//                break;
//            case 0:
//            default:
//                msg = "出现未知错误";
//        }
//        System.out.println(msg);
//    }

//    @Test
//    public void finshAppointment() {
//        int timeFlag = 0;
//        User user = userServiceImp.Login(new User("15188888888", "123456"));
//        String msg;
//        int bikeId = userServiceImp.finshAppointment(user.getUserId());
//        if (timeFlag == 0) {
//            switch (bikeId) {
//                case -1:
//                    msg = "未查询到预约记录";
//                    break;
//                case 0:
//                    msg = "出现未知错误";
//                    break;
//                default:
//                    msg = "预约时间超时,自动取消预约";
//            }
//        } else if (timeFlag == 1) {
//            switch (bikeId) {
//                case -1:
//                    msg = "未查询到预约记录";
//                    break;
//                case 0:
//                    msg = "出现未知错误";
//                    break;
//                default:
//                    msg = "开始用车";
//                    userServiceImp.useBike(user.getUserId(), bikeId);
//            }
//        } else {
//            msg = "出现未知错误";
//        }
//        System.out.println(msg);
//    }

//    @Test
//    public void recharge() {
//        User user = userServiceImp.Login(new User("15288888888", "123456"));
//        String msg;
//        switch (userServiceImp.Recharge(user.getUserId(), 15)) {
//            case 1:
//                msg = "充值成功";
//                break;
//            case 0:
//                msg = "充值失败";
//                break;
//            case -1:
//            default:
//                msg = "用户不存在";
//                break;
//        }
//        System.out.println(msg);
//    }

//    @Test
//    public void getRechargeRecord() throws ParseException {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        User user = userServiceImp.Login(new User("15288888888", "123456"));
//        List<RechargeRecord> rechargeRecords = userServiceImp.findRechargeRecord(user.getUserId());
//        if(rechargeRecords == null||rechargeRecords.size()==0){
//            System.out.println("无充值记录");
//        }else {
//            for (RechargeRecord rechargeRecord : rechargeRecords) {
//                System.out.println(rechargeRecord.toString());
//            }
//        }
//    }

    @Test
    public void getPaymentRecord(){
        User user = userServiceImp.Login(new User("15388888888", "123456"));
        List<PaymentRecord> paymentRecords = userServiceImp.findPaymentRecord(user.getUserId());
        if(paymentRecords == null||paymentRecords.isEmpty()){
            System.out.println("无使用记录");
        }else{
            for (PaymentRecord paymentRecord : paymentRecords) {
                System.out.println(paymentRecord.toString());
            }
        }
    }

    @Test
    public void reportRepair(){
        int a =  userServiceImp.reportRepair(13);
        if(a == -1){
            System.out.println("不存在该车辆");
        }else if(a == 0){
            System.out.println("该车已被报修");
        }else{
            System.out.println("报修成功");
        }

    }

//    @Test
//    public void getUseRecord(){
//        User user = userServiceImp.Login(new User("15288888888", "123456"));
//
//    }
}
