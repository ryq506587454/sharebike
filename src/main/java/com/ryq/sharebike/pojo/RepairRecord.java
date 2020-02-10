package com.ryq.sharebike.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "payment_record")
@JsonIgnoreProperties(value = {"handler"})
public class RepairRecord {
  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "userId")
  private Integer userId;
  @Column(name = "bikeId")
  private Integer bikeId;
  @Column(name = "repairDate")
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date repairDate;
  @Column(name = "finshDate")
  @JSONField(format="yyyy-MM-dd HH:mm:ss")
  private Date finshDate;

  public RepairRecord() {
  }

  public RepairRecord(Integer id, Integer userId, Integer bikeId, Date repairDate, Date finshDate) {
    this.id = id;
    this.userId = userId;
    this.bikeId = bikeId;
    this.repairDate = repairDate;
    this.finshDate = finshDate;
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

  public Date getRepairDate() {
    return repairDate;
  }

  public void setRepairDate(Date repairDate) {
    this.repairDate = repairDate;
  }

  public Date getFinshDate() {
    return finshDate;
  }

  public void setFinshDate(Date finshDate) {
    this.finshDate = finshDate;
  }

  @Override
  public String toString() {
    return "RepairRecord{" +
            "id=" + id +
            ", userId=" + userId +
            ", bikeId=" + bikeId +
            ", repairDate=" + repairDate +
            ", finshDate=" + finshDate +
            '}';
  }


}
