package com.ryq.sharebike.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
消费记录
 */
@Table(name = "payment_record")
@JsonIgnoreProperties(value = {"handler"})
public class PaymentRecord {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "money")
    private Integer money;
    @Column(name = "payDate")
    private Date payDate;

    public PaymentRecord() {
    }

    public PaymentRecord(Integer id, Integer userId, Integer money, Date payDate) {
        this.id = id;
        this.userId = userId;
        this.money = money;
        this.payDate = payDate;
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

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "PaymentRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", money=" + money +
                ", payDate=" + payDate +
                '}';
    }
}
