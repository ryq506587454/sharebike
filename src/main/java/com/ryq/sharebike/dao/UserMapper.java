package com.ryq.sharebike.dao;

import com.ryq.sharebike.pojo.*;
import com.ryq.sharebike.util.CommnMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/*
普通用户dao
 */
@Mapper
public interface UserMapper extends CommnMapper<User>{
    //登录(完成)
    User Login(@Param("User") User user);
    //注册
    int Register(@Param("User") User user);
    //获取user
    List<User> getUser(@Param("findUser") User User);
    //预约车辆
    int appointmentBike(@Param("userId") int userId,@Param("bikeId") int bikeId,@Param("startTime") Date date);
    //使用车辆
    int useBike(@Param("userId") int userId,@Param("bikeId") int bikeId,@Param("borrowDate") Date date);
    //变更用户状态state
    int changUserStateById(@Param("userId") int id, @Param("state") int state);
    //变更用户余额
    int changUserBalanceById(@Param("userId") int id, @Param("balance") float balance);
    //添加支付记录
    int addPayRecord(@Param("userId") int id,@Param("payDate") Date payDate, @Param("money") float money);
    //查询未还车辆
    Integer checkNoBack(@Param("userId") int userId);
    //查询借车时间
    Date checkBorrowTime(@Param("userId") int userId);
    //增加还车记录
    int addBackBikeRecordById(@Param("userId") int userId,@Param("backTime") Date backTime, @Param("money") float money);
    //查询未完成的预约记录
    Integer checkAppointmenting(@Param("userId") int userId);
    //添加预约完成记录
    int addFinshAppointment(@Param("userId") int userId,@Param("endTime") Date endTime);
    //添加充值记录
    int addRechargeRecord(@Param("userId") int userId,@Param("rechargeTime") Date rechargeTime, @Param("money") float money);
    //查询充值记录
    List<RechargeRecord> findRechargeRecord(@Param("userId") int userId);
    //查询支付记录
    List<PaymentRecord> findPaymentRecord(@Param("userId") int userId);
    //查询用车记录
    List<UseBike> findUseRecord(@Param("userId") int userId);





}

