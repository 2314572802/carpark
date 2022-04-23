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
}
