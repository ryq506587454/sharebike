package com.ryq.sharebike.dao;

import com.ryq.sharebike.pojo.RepairRecord;
import com.ryq.sharebike.util.CommnMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
@Mapper
public interface RepairMapper extends CommnMapper<RepairRecord> {
    //查询维修记录（null 为无穷）
    List<RepairRecord> findRepairRecord(@Param("bDate")Date bDate, @Param("eDate")Date eDate,@Param("flag") int flag);
    //添加完成维修记录
    int addFinshRepairRecord(@Param("userId") int userId,@Param("bikeId") int bikeId,@Param("date")Date date);
    //查询维修员正在维修的车
    List<RepairRecord> findRepairIngByUserId(@Param("userId") int userId);
    //添加开始维修记录
    int addBeginRepairRecord(@Param("userId") int userId,@Param("bikeId") int bikeId,@Param("date")Date date);
}
