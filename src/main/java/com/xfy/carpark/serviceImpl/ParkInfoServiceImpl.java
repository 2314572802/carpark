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
}
