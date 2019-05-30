package com.ryq.sharebike.dao;

import com.ryq.sharebike.pojo.Bike;
import com.ryq.sharebike.pojo.BikeType;
import com.ryq.sharebike.pojo.RepairRecord;
import com.ryq.sharebike.util.CommnMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
/*
车子相关Dao
 */
@Mapper
public interface BikeMapper extends CommnMapper<Bike> {
    //根据Id查车
    Bike getBikeById(@Param("id") int id);
    //更改车辆状态
    int changBikeStateById(@Param("bikeId") int bikeId,@Param("state") int state);
    //根据BikeID修改车辆数量
    int changBikeNumberByBikeId(@Param("bikeId") int bikeId,@Param("number") int number);
    //根据车辆状态查找
    List<Bike> findBikeByState(@Param("state") int state);
    //增加车辆
    int addBike(@Param("bike") Bike bike,@Param("typeId")int typeId);
    //查询type
    List<BikeType> findBikeType(@Param("typeId")int typeId);
    //根绝TypeId修改车辆数量
    int changBikeNumberByTypeId(@Param("typeId")int typeId,@Param("number")int number);
    //添加车辆种类
    int addBikeType(@Param("bikeType") BikeType bikeType);
    //根据供应商和种类查找车辆种类
    BikeType findBikeTypeByDetil(@Param("bikeType")BikeType bikeType);

}
