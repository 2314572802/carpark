package com.xfy.carpark.mapper;

import com.xfy.carpark.DO.ParkInformationDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ParkInfoMapper {

    /**
     * 查询所有车位信息
     */
    List<ParkInformationDO> queryPark();

    /**
     * 根据车位类型查询相关信息
     */
    List<ParkInformationDO> queryParkByType(String parkType);

    /**
     * 新建车位信息
     */
    boolean insertParkInfo(ParkInformationDO parkInformationDO);

    /**
     * 修改查询出的信息
     */
    boolean updateParkInfo(ParkInformationDO parkInformationDO);

    /**
     * 删除标记
     */
    boolean deleteParkInfo(ParkInformationDO parkInformationDO);

    /**
     * 根据车位id查询是否为固定车位
     */
    String queryFixParkById(Integer parkId);

    /**
     * 根据车位id查询固定车位类型
     */
    String queryParkTypeById(Integer parkId);

    /**
     * 根据新增时传入的车位id判断该车位是否存在
     */
    List<ParkInformationDO> queryParkId(Integer parkId);

    /**
     * 车辆新增成功时修改车位的状态
     */
    void updateParkInfoById(Integer parkId);

    /**
     * 根据车位id查询自由车位类型
     */
    String queryFreeParkById(Integer parkId);
}
