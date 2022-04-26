package com.xfy.carpark.controller;

import com.xfy.carpark.DO.CarMsgDO;
import com.xfy.carpark.DO.FixUserDO;
import com.xfy.carpark.DO.PayMsgDO;
import com.xfy.carpark.service.CarMsgService;
import com.xfy.carpark.service.PayMsgService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PayMsgController {

    @Resource
    private PayMsgService payMsgService;

    @Resource
    private CarMsgService carMsgService;

    @GetMapping("/carpark/queryFixPayMsg")
    public Map<String, Object> queryFixPayMsg(Integer pageCode, Integer val) {
        Map<String, Object> fixPayMsgMap = new HashMap<>();
        Integer pageNum = (pageCode - 1) * val;
        List<PayMsgDO> payMsgDOList = payMsgService.queryFixPayMsg(pageNum, val);
        fixPayMsgMap.put("pageData", payMsgDOList);
        Integer total = payMsgService.queryTotal();//总条数
        fixPayMsgMap.put("total", total);
        Integer pageTotal = total/val;//总页数
        fixPayMsgMap.put("pageTotal", pageTotal);
        return fixPayMsgMap;
    }

    @GetMapping("/carpark/queryFixPayMsgByUserCarNum")
    public List<PayMsgDO> queryFixPayMsgByUserCarNum(String userCarNum) {
        return payMsgService.queryFixPayMsgByUserCarNum(userCarNum);
    }

    @PostMapping("/carpark/insertFixPayMsg")
    @Transactional(rollbackFor = Exception.class)
    public String insertFixPayMsg(PayMsgDO payMsgDO) {
        if (payMsgDO != null) {
            List<CarMsgDO> carMsgDOList = carMsgService.queryUserIdByCarId(payMsgDO.getCarMsgId());
            if (carMsgDOList.size() == 0) {
                return "errorParkType";//请输入固定车位的车辆编号
            } else {
                boolean flag = payMsgService.insertFixPayMsg(payMsgDO);
                if (flag) {
                    if (payMsgDO.getPayMethod().equals("false")) {//按月收费 120/月
                        payMsgService.insertPayMsgYear(payMsgDO.getCarMsgId());
                    } else {
                        //按年收费
                        payMsgService.insertPayMsgMonth(payMsgDO.getCarMsgId());
                    }
                    return "true";
                } else {
                    return "false";//新增信息失败
                }
            }
        } else {
            return "error";//请正确输入
        }
    }

    @PutMapping("/carpark/updateFixPayMsg")
    @Transactional(rollbackFor = Exception.class)
    public boolean updateFixPayMsg(PayMsgDO payMsgDO) {
        if (payMsgDO.getPmId() == null) {
            return false;
        }
        if (payMsgDO.getPayMethod().equals("false")) {//按月收费 120/月
            payMsgService.insertPayMsgYear(payMsgDO.getCarMsgId());
        } else {
            //按年收费
            payMsgService.insertPayMsgMonth(payMsgDO.getCarMsgId());
        }
        return true;
    }

    @PutMapping("/carpark/deleteFixPayMsg")
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteFixPayMsg(PayMsgDO payMsgDO) {
        if (payMsgDO.getPmId() != null) {
            payMsgService.deleteFixPayMsg(payMsgDO.getPmId());
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/carpark/queryFreePayMsg")
    public Map<String, Object> queryFreePayMsg(Integer pageCode, Integer val) {
            Map<String, Object> freePayMsgMap = new HashMap<>();
            Integer pageNum = (pageCode - 1) * val;
            List<PayMsgDO> payMsgDOList = payMsgService.queryFreePayMsg(pageNum, val);
            freePayMsgMap.put("pageData", payMsgDOList);
            Integer total = payMsgService.queryFreeTotal();//总条数
            freePayMsgMap.put("total", total);
            Integer pageTotal = total/val;//总页数
            freePayMsgMap.put("pageTotal", pageTotal);
            return freePayMsgMap;
    }

    @GetMapping("/carpark/queryFreePayMsgByCarMsgId")
    public List<PayMsgDO> queryFreePayMsgByCarMsgId(Integer carMsgId) {
        return payMsgService.queryFreePayMsgByCarMsgId(carMsgId);
    }

    @PostMapping("/carpark/insertFreePayMsg")
    @Transactional(rollbackFor = Exception.class)
    public String insertFreePayMsg(PayMsgDO payMsgDO) {
        if (payMsgDO != null) {
            Integer carMsgId = payMsgDO.getCarMsgId();
            List<CarMsgDO> carMsgDOList = carMsgService.queryFreeCarMsgByCarId(carMsgId);
            if (carMsgDOList.size() == 0) {
                return "errorCarId";//请输入正确的自由车辆编号
            } else {
                Integer gmtTime = carMsgService.queryGmtTimeByCarId(carMsgId);
                Integer pmRate = payMsgDO.getPmRate();
                Integer payMoney = gmtTime * pmRate;
                boolean flag = payMsgService.insertFreePayMsg(payMsgDO);
                if (flag) {
                    payMsgService.updatePayMoneyByCarMsgId(payMoney, carMsgId);
                    return "true";
                } else {
                    return "false";
                }
            }
        } else {
            return "false";//新增失败！
        }
    }
}
