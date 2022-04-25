package com.xfy.carpark.serviceImpl;

import com.xfy.carpark.DO.CarMsgDO;
import com.xfy.carpark.mapper.CarMsgMapper;
import com.xfy.carpark.service.CarMsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CarMsgServiceImpl implements CarMsgService {

    @Resource
    private CarMsgMapper carMsgMapper;

    @Override
    public List<CarMsgDO> queryFixCarInfo() {
        return carMsgMapper.queryFixCarInfo();
    }

    @Override
    public List<CarMsgDO> queryCarMsgByUserName(String userName) {
        return carMsgMapper.queryCarMsgByUserName(userName);
    }

    @Override
    public boolean insertFixCarMsg(CarMsgDO carMsgDO) {
        return carMsgMapper.insertFixCarMsg(carMsgDO);
    }

    @Override
    public boolean insertFreeCarMsg(CarMsgDO carMsgDO) {
        return carMsgMapper.insertFreeCarMsg(carMsgDO);
    }

    @Override
    public boolean updateCarMsg(CarMsgDO carMsgDO) {
        return carMsgMapper.updateCarMsg(carMsgDO);
    }

    @Override
    public boolean deleteCarMsg(Integer carId) {
        return carMsgMapper.deleteCarMsg(carId);
    }

    @Override
    public List<CarMsgDO> queryFreeCarInfo() {
        return carMsgMapper.queryFreeCarInfo();
    }

    @Override
    public List<CarMsgDO> queryFreeCarMsgByParkId(Integer parkId) {
        return carMsgMapper.queryFreeCarMsgByParkId(parkId);
    }

    @Override
    public List<CarMsgDO> queryUserIdByCarId(Integer carMsgId) {
        return carMsgMapper.queryUserIdByCarId(carMsgId);
    }

    @Override
    public List<CarMsgDO> queryFreeCarMsgByCarId(Integer carMsgId) {
        return carMsgMapper.queryFreeCarMsgByCarId(carMsgId);
    }

    @Override
    public Integer queryGmtTimeByCarId(Integer carMsgId) {
        return carMsgMapper.queryGmtTimeByCarId(carMsgId);
    }
}
