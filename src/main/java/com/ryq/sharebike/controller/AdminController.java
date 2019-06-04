package com.ryq.sharebike.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ryq.sharebike.pojo.Bike;
import com.ryq.sharebike.pojo.BikeType;
import com.ryq.sharebike.pojo.User;
import com.ryq.sharebike.serviceImp.AdminServiceImp;
import com.ryq.sharebike.util.PageInfo;
import com.ryq.sharebike.util.Utillist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired(required = false)
    AdminServiceImp adminServiceImp;
    //辅助工具
    private Utillist<?> utillist;

    public Utillist<?> getUtillist() {
        return utillist;
    }

    public void setUtillist(Utillist<?> utillist) {
        this.utillist = utillist;
    }
    private int pagSize = 8;
    @ResponseBody
    @RequestMapping(value = "/getBikeKind")
    public Utillist<?> getBikeKind(){
        List<BikeType> bikeTypes = adminServiceImp.findBikeType(0);
        if(bikeTypes == null||bikeTypes.size() == 0){
            utillist = Utillist.CreatUtillist("查询失败",bikeTypes,100);
        }else{
            utillist = Utillist.CreatUtillist("查询成功",bikeTypes,101);
        }
        return utillist;
    }

    @ResponseBody
    @RequestMapping(value = "/addBike")
    public String addBike(@RequestBody BikeType bt) {
        String msg;
        int a = adminServiceImp.addBike(bt);
        if (a == -1) {
            msg ="未知bike类型";

        } else {
            msg ="共增加" + a +"辆";

        }
        return msg;
    }
    @ResponseBody
    @RequestMapping(value = "/findAllBike")
    public Utillist<?> findAllBike(@RequestBody JSONObject data){
        Page<Bike> bikes = adminServiceImp.findAllBike(data.getInteger("page"),pagSize);
        PageInfo<Bike> pageInfo = new PageInfo<>(bikes);
        if(bikes == null || bikes.size() == 0){
            utillist = Utillist.CreatUtillist("查询失败",pageInfo,100);
        }else{
            utillist = Utillist.CreatUtillist("查询成功",pageInfo,101);
        }
        PageHelper.clearPage();
        return utillist;
    }
    @ResponseBody
    @RequestMapping(value = "/findBikeById")
    public Utillist<?> findBikeById(@RequestBody JSONObject data){
        Bike bike = adminServiceImp.findBikeByBikeId(data.getInteger("bikeId"));
        if(bike == null){
            utillist = Utillist.CreatUtillist("未查询到该车辆",bike,100);
        }else{
            utillist = Utillist.CreatUtillist("查询到该车辆",bike,101);
        }
        return utillist;
    }
    @ResponseBody
    @RequestMapping(value = "/addBikeType")
    public String addBikeType(@RequestBody BikeType type) {
        int a = adminServiceImp.addBikeType(type);
        String msg;
        if (a == 0) {
            msg = "已存在该车型";
        } else if (a == 1) {
            msg = "添加成功";
        }else{
            msg = "发生未知错误";
        }
        return msg;
    }
    @ResponseBody
    @RequestMapping(value = "/findAllUser")
    public Utillist<?> findAllUser(@RequestBody JSONObject data){
        Page<User> users = adminServiceImp.findAllUser(data.getInteger("page"),pagSize,data.getInteger("grade"));
        PageInfo<User> pageInfo = new PageInfo<>(users);
        if(users == null || users.size() == 0){
            utillist = Utillist.CreatUtillist("查询失败",pageInfo,100);
        }else{
            utillist = Utillist.CreatUtillist("查询成功",pageInfo,101);
        }
        PageHelper.clearPage();
        return utillist;
    }





















}

