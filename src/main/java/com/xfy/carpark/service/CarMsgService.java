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
}
