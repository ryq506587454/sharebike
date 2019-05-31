package com.ryq.sharebike.controller;
/*
跳转
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GoController {
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/waitRepairBike")
    public String waitRepairBike(){
        return "waitRepairBike";
    }
    @RequestMapping(value = "RepairFinshRecord")
    public String RepairFinshRecord(){
        return "RepairFinshRecord";
    }
    @RequestMapping(value = "RepairUnFinshRecord")
    public String RepairUnFinshRecord(){
        return "RepairUnFinshRecord";
    }
    @RequestMapping(value = "beginRepairBike")
    public String beginRepairBike(){
        return "beginRepairBike";
    }
    @RequestMapping(value = "finshRepairBike")
    public String finshRepairBike(){
        return "finshRepairBike";
    }
    @RequestMapping(value = "UserIndex")
    public String UserIndex(){return "UserIndex";}
    @RequestMapping(value = "UserUseBike")
    public String UserUserBike(){return "UserUseBike";}
    @RequestMapping(value = "UserAppointBike")
    public String UserAppointBike(){return "UserAppointBike";}
    @RequestMapping(value = "UserInfo")
    public String UserInfo(){return "UserInfo";}
    @RequestMapping(value = "UserRechare")
    public String UserRechare(){return "UserRechare";}
    @RequestMapping(value = "AdminaAddBike")
    public String AdminaAddBike(){return "AdminaAddBike";}
    @RequestMapping ( value = "AdminFindAllBike")
    public String AdminFindAllBike(){return "AdminFindAllBike";}


}
