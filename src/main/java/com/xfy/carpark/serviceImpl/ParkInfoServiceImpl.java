package com.xfy.carpark.serviceImpl;

import com.xfy.carpark.DO.ParkInformationDO;
import com.xfy.carpark.mapper.ParkInfoMapper;
import com.xfy.carpark.service.ParkInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ParkInfoServiceImpl implements ParkInfoService {

    @Resource
    private ParkInfoMapper parkInfoMapper;

    @Override
    public List<ParkInformationDO> queryPark() {
        return parkInfoMapper.queryPark();
    }

    @Override
    public List<ParkInformationDO> queryParkByType(String parkType) {
        return parkInfoMapper.queryParkByType(parkType);
    }

    @Override
    public boolean insertParkInfo(ParkInformationDO parkInformationDO) {
        return parkInfoMapper.insertParkInfo(parkInformationDO);
    }

    @Override
    public boolean updateParkInfo(ParkInformationDO parkInformationDO) {
        return parkInfoMapper.updateParkInfo(parkInformationDO);
    }

    @Override
    public boolean deleteParkInfo(ParkInformationDO parkInformationDO) {
        return parkInfoMapper.deleteParkInfo(parkInformationDO);
    }

    @Override
    public String queryFixParkById(Integer parkId) {
        return parkInfoMapper.queryFixParkById(parkId);
    }

    @Override
    public String queryParkTypeById(Integer parkId) {
        return parkInfoMapper.queryParkTypeById(parkId);
    }

    @Override
    public List<ParkInformationDO> queryParkId(Integer parkId) {
        return parkInfoMapper.queryParkId(parkId);
    }

    @Override
    public void updateParkInfoById(Integer parkId) {
        parkInfoMapper.updateParkInfoById(parkId);
    }

    @Override
    public String queryFreeParkById(Integer parkId) {
        return parkInfoMapper.queryFreeParkById(parkId);
    }
}
