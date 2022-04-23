package com.xfy.carpark.controller;

import com.xfy.carpark.DO.CarMsgDO;
import com.xfy.carpark.service.CarMsgService;
import com.xfy.carpark.service.FixUserService;
import com.xfy.carpark.service.ParkInfoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CarMsgController {

    @Resource
    private CarMsgService carMsgService;

    @Resource
    private ParkInfoService parkInfoService;

    @Resource
    private FixUserService fixUserService;

    @GetMapping("/carpark/queryFixCarInfo")
    public List<CarMsgDO> queryFixCarInfo() {
        return carMsgService.queryFixCarInfo();
    }

    @GetMapping("/carpark/queryCarMsgByUserName")
    public List<CarMsgDO> queryCarMsgByUserName(String userName) {
        return carMsgService.queryCarMsgByUserName(userName);
    }

    @PostMapping("/carpark/insertFixCarMsg")
    @Transactional(rollbackFor = Exception.class)
    public String insertFIxCarMsg(CarMsgDO carMsgDO) {
        if (carMsgDO != null) {
            String parkType = parkInfoService.queryParkTypeById(carMsgDO.getParkId());
            if (parkType.equals("free")) {
                return "errorParkType";
            } else {
                String parkStatus = parkInfoService.queryFixParkById(carMsgDO.getParkId());
                if (parkStatus.equals("1")) {
                    return "reParkId";
                } else {
                    String userName = fixUserService.queryUserNameById(carMsgDO.getUserId());
                    if (userName.equals(carMsgDO.getUserName())) {
                        return "errorUserName";
                    } else {

                    }
                }
            }

        }
    }
}
