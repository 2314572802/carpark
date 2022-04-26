package com.xfy.carpark.service;

import com.xfy.carpark.DO.ParkInformationDO;

import java.util.List;

public interface ParkInfoService {

    /**
     * 查出所有车位信息
     */
    List<ParkInformationDO> queryPark(Integer pageNum, Integer val);

    /**
     * 根据车位类型查询相关信息
     */
    List<ParkInformationDO> queryParkByType(String parkType);

    /**
     * 新建车位信息
     */
    boolean insertParkInfo(ParkInformationDO parkInformationDO);

    /**
     * 修改查询出来的信息
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
     * 根据车位编号查询自由车位类型
     */
    String queryFreeParkById(Integer parkId);

    /**
     * 分页查询总条数
     */
    Integer queryTotal();
}
