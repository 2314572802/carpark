package com.xfy.carpark.mapper;

import com.xfy.carpark.DO.PayMsgDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PayMsgMapper {

    /**
     * 查询所有固定车辆的收费信息
     */
    List<PayMsgDO> queryFixPayMsg();

    /**
     * 根据车牌号查询固定车辆的收费信息
     */
    List<PayMsgDO> queryFixPayMsgByUserCarNum(String userCarNum);

    /**
     * 新增固定车辆的收费信息
     */
    boolean insertFixPayMsg(PayMsgDO payMsgDO);

    /**
     * 按年收费
     */
    void insertPayMsgYear(Integer carMsgId);

    /**
     * 按月收费
     */
    void insertPayMsgMonth(Integer carMsgId);

    /**
     * 删除固定车辆收费信息
     */
    boolean deleteFixPayMsg(Integer pmId);

    /**
     * 查询所有自由车辆的收费信息
     */
    List<PayMsgDO> queryFreePayMsg();

    /**
     * 根据车辆id查询对应的自由车辆收费信息
     */
    List<PayMsgDO> queryFreePayMsgByCarMsgId(Integer carMsgId);

    /**
     * 新增自由车辆收费信息
     */
    boolean insertFreePayMsg(PayMsgDO payMsgDO);

    /**
     * 新增自由车辆收费金额
     */
    boolean updatePayMoneyByCarMsgId(@Param("payMoney") Integer payMoney, @Param("carMsgId") Integer carMsgId);
}
