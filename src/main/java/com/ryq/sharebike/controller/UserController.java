package com.ryq.sharebike.controller;
/*
普通用户con
 */

import com.alibaba.fastjson.JSONObject;
import com.ryq.sharebike.pojo.RechargeRecord;
import com.ryq.sharebike.pojo.UseBike;
import com.ryq.sharebike.pojo.User;
import com.ryq.sharebike.serviceImp.UserServiceImp;
import com.ryq.sharebike.util.Utillist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired(required = false)
    private UserServiceImp userServiceImp;
    //辅助工具
    private Utillist<?> utillist;

    public Utillist<?> getUtillist() {
        return utillist;
    }

    public void setUtillist(Utillist<?> utillist) {
        this.utillist = utillist;
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public String login(@RequestBody User user, HttpSession session) {
        User userInfo = userServiceImp.Login(user);
        if (userInfo != null && userInfo.getGrade() != 0) {
            System.out.println("登陆成功");
            session.setAttribute("user", userInfo);
            return "1";
        } else if (userInfo != null && userInfo.getGrade() == 0) {
            System.out.println("登陆成功");
            session.setAttribute("user", userInfo);
            return "2";
        } else {
            System.out.println("登陆失败");
            return "0";
        }
    }

    @RequestMapping(value = "/useBike")
    @ResponseBody
    public String useBike(@RequestBody JSONObject data, HttpSession session) {
        String msg;
        User userInfo = (User) session.getAttribute("user");
        if ((userInfo.getState() == 0||userInfo.getState() == 2) && userInfo.getBalance() > 0) {
            switch (userServiceImp.useBike(userInfo.getUserId(), data.getInteger("bikeId"))) {
                case 0:
                    msg = "开锁失败,所选车辆已被报修";
                    break;
                case 1:
                    msg = "开锁失败,所选车辆正在维修";
                    break;
                case 2:
                    msg = "开锁失败,所选车辆已被使用";
                    break;
                case 3:
                    msg = "开锁失败,您已预约其他车辆";
                    break;
                case 4:
                    session.setAttribute("user", userServiceImp.Login(userInfo));
                    msg = "开锁成功，开始计时";
                    break;
                case -2:
                    msg = "开锁失败,所选车辆已被预约";
                    break;
                case -1:
                default:
                    msg = "出现预期之外的错误";
                    break;
            }
        } else if (userInfo.getState() == 1) {
            msg = "开锁失败，您有未还车辆";
        } else if (userInfo.getBalance() <= 0) {
            msg = "账户余额不足";
        } else {
            msg = "出现预期之外的错误";
        }
        System.out.println(msg);
        return msg;
    }

    @RequestMapping(value = "/appoBike")
    @ResponseBody
    public String appoBike(@RequestBody JSONObject data, HttpSession session) {
        String msg;
        User user = (User) session.getAttribute("user");
        if (user.getState() == 0 && user.getBalance() > 0) {
            switch (userServiceImp.appointmentBike(user.getUserId(), data.getInteger("bikeId"))) {
                case 0:
                    msg = "预约失败,所选车辆已被报修";
                    break;
                case 1:
                    msg = "预约失败,所选车辆正在维修";
                    break;
                case 2:
                    msg = "预约失败,所选车辆已被使用";
                    break;
                case 3:
                    msg = "预约失败,所选车辆已被预约";
                    break;
                case 4:
                    session.setAttribute("user", userServiceImp.Login(user));
                    msg = "预约成功，开始计时";
                    break;
                case -1:
                default:
                    msg = "出现预期之外的错误";
                    break;
            }
        } else if (user.getState() == 1) {
            msg = "预约失败，您有未还车辆";
        } else if (user.getState() == 2) {
            msg = "预约失败，您有预约车辆";
        } else if (user.getBalance() <= 0) {
            msg = "账户余额不足";
        } else {
            msg = "出现预期之外的错误";
        }
        System.out.println(msg);
        return msg;
    }

    @RequestMapping(value = "/backBike")
    @ResponseBody
    public String backBike(HttpSession session) {
        String msg;
        User user = (User) session.getAttribute("user");
        int a = userServiceImp.backBike(user.getUserId(), user.getBalance().longValue());
        switch (a) {
            case -1:
                msg = "未查询到使用记录";
                break;
            case 0:
                msg = "出现未知错误";
                break;
            default:
                msg = "还车成功,共花费 " + a + " 元";
                session.setAttribute("user", userServiceImp.Login(user));
        }
        System.out.println(msg);
        return msg;
    }

    @RequestMapping(value = "/quitLogin")
    @ResponseBody
    public void quitLogin(HttpSession session) {
        session.removeAttribute("user");
    }

    @RequestMapping(value = "/recharge")
    @ResponseBody
    public String recharge(@RequestBody JSONObject data, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String msg;
        switch (userServiceImp.Recharge(user.getUserId(), data.getInteger("money"))) {
            case 1:
                user = userServiceImp.Login(user);
                session.setAttribute("user", user);
                msg = "充值成功,剩余余额" + user.getBalance();
                break;
            case 0:
                msg = "充值失败";
                break;
            case -1:
            default:
                msg = "用户不存在";
                break;
        }
        return msg;
    }

    @ResponseBody
    @RequestMapping(value = "/getRechargeRecord")
    public Utillist<?> getRechargeRecord(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<RechargeRecord> rechargeRecords = userServiceImp.findRechargeRecord(user.getUserId());
        if (rechargeRecords == null || rechargeRecords.size() == 0) {
            utillist = Utillist.CreatUtillist("无充值记录", rechargeRecords, 100);
        } else {
            utillist = Utillist.CreatUtillist("充值记录", rechargeRecords, 101);
        }
        return utillist;
    }

    @ResponseBody
    @RequestMapping(value = "/getUsegeRecord")
    public Utillist<?> getUsegeRecord(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<UseBike> useBikes = userServiceImp.findUseRecord(user.getUserId());
        if (useBikes == null || useBikes.size() == 0) {
            utillist = Utillist.CreatUtillist("无充值记录", useBikes, 100);
        } else {
            utillist = Utillist.CreatUtillist("充值记录", useBikes, 101);
        }
        return utillist;
    }

    @ResponseBody
    @RequestMapping(value = "/finshAppo")
    public String finshAppo(@RequestBody JSONObject data,HttpSession session) {
        int timeFlag = data.getInteger("timeFlag");
        User user = (User) session.getAttribute("user");
        String msg;
        int bikeId = userServiceImp.finshAppointment(user.getUserId());
        if (timeFlag == 0) {
            switch (bikeId) {
                case -1:
                    msg = "未查询到预约记录";
                    break;
                case 0:
                    msg = "出现未知错误";
                    break;
                default:
                    msg = "预约时间超时,自动取消预约";
            }
        } else if (timeFlag == 1) {
            switch (bikeId) {
                case -1:
                    msg = "未查询到预约记录";
                    break;
                case 0:
                    msg = "出现未知错误";
                    break;
                default:
                    msg = "开始用车";
                    session.setAttribute("user", user);
                    userServiceImp.useBike(user.getUserId(), bikeId);
            }
        } else {
            msg = "出现未知错误";
        }
        System.out.println(msg);
        return msg;
    }


}
