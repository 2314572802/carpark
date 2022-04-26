package com.xfy.carpark.mapper;

import com.xfy.carpark.DO.CarMsgDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarMsgMapper {
    /**
     * 查询所有固定车辆
     */
    List<CarMsgDO> queryFixCarInfo(@Param("pageNum") Integer pageNum, @Param("val") Integer val);

    /**
     * 根据车主姓名查询固定固定车辆信息
     */
    List<CarMsgDO> queryCarMsgByUserName(String userName);

    /**
     * 新增固定车辆信息
     */
    boolean insertFixCarMsg(CarMsgDO carMsgDO);

    /**
     * 修改车辆的时间
     */
    boolean updateCarMsg(CarMsgDO carMsgDO);

    /**
     * 删除固定车辆
     */
    boolean deleteCarMsg(Integer carId);

    /**
     * 查询所有自由车辆信息
     */
    List<CarMsgDO> queryFreeCarInfo(@Param("pageNum") Integer pageNum, @Param("val") Integer val);

    /**
     * 根据车位编号查询自由车辆信息
     */
    List<CarMsgDO> queryFreeCarMsgByParkId(Integer parkId);

    /**
     * 新增自由车辆信息
     */
    boolean insertFreeCarMsg(CarMsgDO carMsgDO);

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

    /**
     * 分页查询总固定条数
     */
    Integer queryTotal(String type);

    /**
     * 分页查询总自由条数
     */
    Integer queryFreeTotal(String type);
}
