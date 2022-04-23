package com.xfy.carpark.mapper;

import com.xfy.carpark.DO.CarMsgDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMsgMapper {
    /**
     * 查询所有固定车辆
     */
    List<CarMsgDO> queryFixCarInfo();

    /**
     * 根据车主姓名查询固定固定车辆信息
     */
    List<CarMsgDO> queryCarMsgByUserName(String userName);
}
