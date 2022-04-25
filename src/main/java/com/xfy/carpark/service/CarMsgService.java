package com.xfy.carpark.service;

import com.xfy.carpark.DO.CarMsgDO;

import java.util.List;

public interface CarMsgService {
    /**
     * 查询所有固定车辆
     */
    List<CarMsgDO> queryFixCarInfo();

    /**
     * 根据车主姓名查询固定车辆信息
     */
    List<CarMsgDO> queryCarMsgByUserName(String userName);

    /**
     * 新增固定车辆信息
     */
    boolean insertFixCarMsg(CarMsgDO carMsgDO);

    /**
     * 新增自由车辆信息
     */
    boolean insertFreeCarMsg(CarMsgDO carMsgDO);

    /**
     * 修改固定车辆的时间
     */
    boolean updateCarMsg(CarMsgDO carMsgDO);

    /**
     * 删除固定车辆
     */
    boolean deleteCarMsg(Integer carId);

    /**
     * 查询所有自由车辆信息
     */
    List<CarMsgDO> queryFreeCarInfo();

    /**
     * 根据车位编号查询自由车辆信息
     */
    List<CarMsgDO> queryFreeCarMsgByParkId(Integer parkId);

    /**
     * 根据固定车辆收费信息的车辆id查询对应的车辆id是否存在
     */
    List<CarMsgDO> queryUserIdByCarId(Integer carMsgId);

    /**
     * 根据车辆id查询是否为自由车辆
     */
    List<CarMsgDO> queryFreeCarMsgByCarId(Integer carMsgId);

    /**
     * 根据自由车辆id查询停车时长
     */
    Integer queryGmtTimeByCarId(Integer carMsgId);
}
