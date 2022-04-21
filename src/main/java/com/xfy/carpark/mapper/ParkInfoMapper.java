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
     * 根据id查询车位信息
     */
//    List<ParkInformationDO> queryParkById(Integer parkId);

    /**
     * 修改查询出的信息
     */
    boolean updateParkInfo(ParkInformationDO parkInformationDO);

    /**
     * 删除标记
     */
    boolean deleteParkInfo(ParkInformationDO parkInformationDO);
}
