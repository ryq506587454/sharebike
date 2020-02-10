package com.ryq.sharebike.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user_bike")
@JsonIgnoreProperties(value = {"handler" })
public class UseBike {
  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "userId")
  private Integer userId;
  @Column(name = "bikeId")
  private Integer bikeId;
  @Column(name = "borrowDate")
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date borrowDate;
  @Column(name = "backDate")
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date backDate;
  @Column(name = "money")
  private Float money;

  public UseBike() {
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

  public Integer getBikeId() {
    return bikeId;
  }

  public void setBikeId(Integer bikeId) {
    this.bikeId = bikeId;
  }

  public Date getBorrowDate() {
    return borrowDate;
  }

  public void setBorrowDate(Date borrowDate) {
    this.borrowDate = borrowDate;
  }

  public Date getBackDate() {
    return backDate;
  }

  public void setBackDate(Date backDate) {
    this.backDate = backDate;
  }

  public Float getMoney() {
    return money;
  }

  public void setMoney(Float money) {
    this.money = money;
  }
}
