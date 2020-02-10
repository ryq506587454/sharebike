package com.ryq.sharebike.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ryq.sharebike.pojo.Bike;
import com.ryq.sharebike.pojo.RepairRecord;
import com.ryq.sharebike.pojo.User;
import com.ryq.sharebike.serviceImp.AdminServiceImp;
import com.ryq.sharebike.serviceImp.RepairmenServiceImp;
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
import java.util.List;

@Controller
@RequestMapping("/repair")
public class RepairController {
    protected static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired(required = false)
    private RepairmenServiceImp repairmenServiceImp;
    @Autowired(required = false)
    private AdminServiceImp adminServiceImp;
    String msg;
    //辅助工具
    private Utillist<?> utillist;
    public Utillist<?> getUtillist() {
        return utillist;
    }
    public void setUtillist(Utillist<?> utillist) {
        this.utillist = utillist;
    }
    @ResponseBody
    @RequestMapping(value = "/getWairRepairs")
    public Utillist<?> getWairRepairs() {
        List<Bike> bikes = adminServiceImp.findBrokeBike();
        if(bikes == null || bikes.size() == 0){
            msg ="未查询到结果";
            utillist=Utillist.CreatUtillist(msg,bikes,100);
        }else{
            utillist=Utillist.CreatUtillist(msg,bikes,101);
        }

        return utillist;
    }
    @ResponseBody
    @RequestMapping(value = "/getRepairFinshRecords")
    public Utillist<?> getRepairFinshRecords(@RequestBody JSONObject data) {
        System.out.println(data.getDate("bDate"));
        List<RepairRecord> repairRecords = repairmenServiceImp.findRepairRecord(data.getDate("bDate"),data.getDate("eDate"),1);
        if(repairRecords == null || repairRecords.size() == 0){
            msg ="未查询到结果";
            utillist=Utillist.CreatUtillist(msg,repairRecords,100);
        }else{
            utillist=Utillist.CreatUtillist(msg,repairRecords,101);
        }

        return utillist;
    }
    @ResponseBody
    @RequestMapping(value = "/getRepairUnFinshRecords")
    public Utillist<?> getRepairUnFinshRecords(@RequestBody JSONObject data) {
        List<RepairRecord> repairRecords = repairmenServiceImp.findRepairRecord(data.getDate("bDate"),data.getDate("eDate"),2);
        if(repairRecords == null || repairRecords.size() == 0){
            msg ="未查询到结果";
            utillist=Utillist.CreatUtillist(msg,repairRecords,100);
        }else{
            utillist=Utillist.CreatUtillist(msg,repairRecords,101);
        }

        return utillist;
    }
    @ResponseBody
    @RequestMapping(value = "/beginRepair")
    public String beginRepair(@RequestBody JSONObject data){
        String msg;
        int a = repairmenServiceImp.beginRepair(data.getInteger("userId"),data.getInteger("bikeId"));
        if (a == 0) {
            msg = "无该车信息";
            System.out.println("无该车信息");
        } else if (a == 1) {
            msg = "该车不处于待修状态";
            System.out.println("该车不处于待修状态");
        } else if (a == 2) {
            msg = "开始维修";
            System.out.println("开始维修");
        } else if(a == 3){
            msg = "维修员正在维修车辆已达上限";
            System.out.println("维修员正在维修车辆已达上限");
        } else {
            msg = "出现未知错误";
            System.out.println("出现未知错误");
        }
        return msg;
    }
    @ResponseBody
    @RequestMapping(value = "/finishRepair")
    public String finishRepair(@RequestBody JSONObject data, HttpSession session)
    {
        String msg;
        int a = repairmenServiceImp.finshRepair(data.getInteger("userId"),data.getInteger("bikeId"));
        if (a == 0) {
            msg = "无该车信息";
        } else if (a == 1) {
            msg = "该车未处于维修状态";
        } else if (a == 2) {
            msg = "维修完成";
        } else if(a == 3){
            msg = "没有该车的维修记录";

        }else {
            msg = "出现未知错误";
        }
        return msg;
    }
    @ResponseBody
    @RequestMapping(value = "/getRepairRecordsByUserId")
    public Utillist<?> getRepairRecordsByUserId(@RequestBody JSONObject data) {
        List<RepairRecord> repairRecords = repairmenServiceImp.findRepairRecordByUserId(data.getInteger("userId"));
        if(repairRecords == null || repairRecords.size() == 0){
            msg ="未查询到维修记录";
            utillist=Utillist.CreatUtillist(msg,repairRecords,100);
        }else{
            utillist=Utillist.CreatUtillist(msg,repairRecords,101);
        }

        return utillist;
    }


}
