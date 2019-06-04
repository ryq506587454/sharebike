package com.ryq.sharebike.dao;

import com.github.pagehelper.Page;
import com.ryq.sharebike.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface StatisticMapper  {
    //根据用户的注册时间显示
    List<User> findUserByRegisterDate(@Param("bDate")Date bDate,@Param("eDate")Date eDate);
    //查询所有用户信息
    Page<User> findAllUser(@Param("grade") int grade);
}
