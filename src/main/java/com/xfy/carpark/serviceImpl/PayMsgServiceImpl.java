package com.xfy.carpark.serviceImpl;

import com.xfy.carpark.DO.PayMsgDO;
import com.xfy.carpark.mapper.PayMsgMapper;
import com.xfy.carpark.service.PayMsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class PayMsgServiceImpl implements PayMsgService {

    @Resource
    private PayMsgMapper payMsgMapper;

    @Override
    public List<PayMsgDO> queryFixPayMsg() {
        return payMsgMapper.queryFixPayMsg();
    }

    @Override
    public List<PayMsgDO> queryFixPayMsgByUserCarNum(String userCarNum) {
        return payMsgMapper.queryFixPayMsgByUserCarNum(userCarNum);
    }

    @Override
    public boolean insertFixPayMsg(PayMsgDO payMsgDO) {
        return payMsgMapper.insertFixPayMsg(payMsgDO);
    }

    @Override
    public void insertPayMsgYear(Integer carMsgId) {
        payMsgMapper.insertPayMsgYear(carMsgId);
    }

    @Override
    public void insertPayMsgMonth(Integer carMsgId) {
        payMsgMapper.insertPayMsgMonth(carMsgId);
    }

    @Override
    public boolean deleteFixPayMsg(Integer pmId) {
        return payMsgMapper.deleteFixPayMsg(pmId);
    }

    @Override
    public List<PayMsgDO> queryFreePayMsg() {
        return payMsgMapper.queryFreePayMsg();
    }

    @Override
    public List<PayMsgDO> queryFreePayMsgByCarMsgId(Integer carMsgId) {
        return payMsgMapper.queryFreePayMsgByCarMsgId(carMsgId);
    }

    @Override
    public boolean insertFreePayMsg(PayMsgDO payMsgDO) {
        return payMsgMapper.insertFreePayMsg(payMsgDO);
    }

    @Override
    public boolean updatePayMoneyByCarMsgId(Integer payMoney, Integer carMsgId) {
        return payMsgMapper.updatePayMoneyByCarMsgId(payMoney, carMsgId);
    }
}
