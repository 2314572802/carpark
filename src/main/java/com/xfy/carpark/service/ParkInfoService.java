package com.xfy.carpark.service;

import com.xfy.carpark.DO.ParkInformationDO;

import java.util.List;

public interface ParkInfoService {

    /**
     * 查出所有车位信息
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
     * 根据id查询车位信息
     */
//    List<ParkInformationDO> queryParkById(Integer parkId);

    /**
     * 修改查询出来的信息
     */
    boolean updateParkInfo(ParkInformationDO parkInformationDO);

    /**
     * 删除标记
     */
    boolean deleteParkInfo(ParkInformationDO parkInformationDO);
}
