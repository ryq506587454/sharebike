package com.ryq.sharebike.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/*
state:0:普通 1：自动
 */
@Table(name = "bike_type")
@JsonIgnoreProperties(value = {"handler" })
public class BikeType {
    @Id
    @Column(name = "typeId")
    private Integer typeId;
    @Column(name = "kind")
    private Integer kind;
    @Column(name = "supplier")
    private String supplier;
    @Column(name = "number")
    private Integer number;

    public BikeType() {
    }

    public BikeType(Integer typeId, Integer number) {
        this.typeId = typeId;
        this.number = number;
    }

    public BikeType(Integer kind, String supplier) {
        this.kind = kind;
        this.supplier = supplier;
    }

    public BikeType(Integer typeId, Integer kind, String supplier, Integer number) {
        this.typeId = typeId;
        this.kind = kind;
        this.supplier = supplier;
        this.number = number;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "BikeType{" +
                "typeId=" + typeId +
                ", kind=" + kind +
                ", supplier='" + supplier + '\'' +
                ", number=" + number +
                '}';
    }
}
