package com.ryq.sharebike.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
state:状态 0：待修 1：在修 2：正在使用 3：已被预约 4：可以使用
startTime:第一次使用的时间
serviceTime：总共使用时长
 */
@Table(name = "bike")
@JsonIgnoreProperties(value = {"handler" })
public class Bike {
    @Id
    @Column(name = "bikeId")
    private Integer bikeId;
    @Column(name = "state")
    private Integer state;
    @Column(name = "startTime")
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @Column(name = "serviceTime")
    private Integer serviceTime;
    private BikeType type;

    public Bike() {
    }

    public Bike(Integer state, Date startTime, Integer serviceTime, BikeType type) {
        this.state = state;
        this.startTime = startTime;
        this.serviceTime = serviceTime;
        this.type = type;
    }

    public Integer getBikeId() {
        return bikeId;
    }

    public void setBikeId(Integer bikeId) {
        this.bikeId = bikeId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Integer serviceTime) {
        this.serviceTime = serviceTime;
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeId=" + bikeId +
                ", state=" + state +
                ", startTime=" + startTime +
                ", serviceTime=" + serviceTime +
                ", type=" + type +
                '}';
    }
}
