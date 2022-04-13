package com.xfy.carpark.service;

import com.xfy.carpark.DO.ParkInformationDO;

import java.util.List;

public interface ParkInfoService {

    /**
     * 查出所有车位信息
     */
    List<ParkInformationDO> queryPark();
}
