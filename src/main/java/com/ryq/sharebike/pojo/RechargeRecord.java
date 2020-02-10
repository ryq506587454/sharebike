package com.ryq.sharebike.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/*
充值记录
 */
@Table(name = "recharge_record")
@JsonIgnoreProperties(value = {"handler"})
public class RechargeRecord {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @Column(name = "rechargeDate")
    private Date rechargeDate;
    @Column(name = "money")
    private Float money;

    public RechargeRecord() {
    }

    public RechargeRecord(Integer id, Integer userId, Date rechargeDate, Float money) {
        this.id = id;
        this.userId = userId;
        this.rechargeDate = rechargeDate;
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getRechargeDate() {
        return rechargeDate;
    }

    public void setRechargeDate(Date rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "RechargeRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", rechargeDate=" + rechargeDate +
                ", money=" + money +
                '}';
    }
}
