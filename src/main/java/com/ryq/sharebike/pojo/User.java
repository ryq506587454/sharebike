package com.ryq.sharebike.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/*
User实体类：
userId：自增
state：状态：0：未用车 1：有未还车 2：有预约车 3：销户
grade：级别：0：普通用户 1：维修人员 2：系统管理员
 */

@Table(name = "user")
@JsonIgnoreProperties(value = {"handler" })
public class User {
    @Id
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "balance")
    private Float balance;
    @Column(name = "state")
    private Integer state;
    @Column(name = "grade")
    private Integer grade;
    @Column(name = "registerDate")
    private Date registerDate;


    public User(Integer userId, String name, String phone, Integer state, Integer grade) {
        this.userId = userId;
        this.userName = name;
        this.phone = phone;
        this.state = state;
        this.grade = grade;
    }

    public User() {
    }

    public User(Integer userId, String phone, String password, Float balance, Integer state, Integer grade, Date registerDate) {
        this.userId = userId;
        this.phone = phone;
        this.password = password;
        this.balance = balance;
        this.state = state;
        this.grade = grade;
        this.registerDate = registerDate;
    }

    public User(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public User(String name, String phone, String password, Date registerDate) {
        this.userName = name;
        this.phone = phone;
        this.password = password;
        this.registerDate = registerDate;
    }

    public User(String name, String phone, String password) {
        this.userName = name;
        this.phone = phone;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }


    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", state=" + state +
                ", grade=" + grade +
                ", registerDate=" + registerDate +
                '}';
    }
}
