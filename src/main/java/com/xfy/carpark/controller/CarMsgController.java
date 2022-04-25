package com.xfy.carpark.controller;

import com.xfy.carpark.DO.CarMsgDO;
import com.xfy.carpark.DO.ParkInformationDO;
import com.xfy.carpark.service.CarMsgService;
import com.xfy.carpark.service.FixUserService;
import com.xfy.carpark.service.ParkInfoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @Resource
    private FixUserController fixUserController;

    @GetMapping("/carpark/queryFixCarInfo")
    public List<CarMsgDO> queryFixCarInfo() {
        return carMsgService.queryFixCarInfo();
    }

    @GetMapping("/carpark/queryFreeCarInfo")
    public List<CarMsgDO> queryFreeCarInfo() {
        return carMsgService.queryFreeCarInfo();
    }

    @GetMapping("/carpark/queryCarMsgByUserName")
    public List<CarMsgDO> queryCarMsgByUserName(String userName) {
        return carMsgService.queryCarMsgByUserName(userName);
    }

    @GetMapping("/carpark/queryFreeCarMsgByParkId")
    public List<CarMsgDO> queryFreeCarMsgByParkId(Integer parkId) {
        return carMsgService.queryFreeCarMsgByParkId(parkId);
    }

    @PostMapping("/carpark/insertFixCarMsg")
    @Transactional(rollbackFor = Exception.class)
    public String insertFixCarMsg(CarMsgDO carMsgDO) {
        if (carMsgDO != null) {
            List<ParkInformationDO> parkInformationDOList = parkInfoService.queryParkId(carMsgDO.getParkId());
            if (parkInformationDOList.size() != 0) {
                String parkType = parkInfoService.queryParkTypeById(carMsgDO.getParkId());
                if ("free".equals(parkType)) {
                    return "errorParkType";
                } else {
                    String parkStatus = parkInfoService.queryFixParkById(carMsgDO.getParkId());
                    if ("1".equals(parkStatus)) {
                        return "reParkId";
                    } else {
                        if (!fixUserController.queryUserNameByInputUserName(carMsgDO.getUserName())) {
                            return "errorUserName";
                        } else {
                            carMsgDO.setUserId(fixUserService.queryUserIdByUserName(carMsgDO.getUserName()));
                            boolean flag = carMsgService.insertFixCarMsg(carMsgDO);
                            if (flag) {
                                parkInfoService.updateParkInfoById(carMsgDO.getParkId());
                                return "true";
                            } else {
                                return "false";
                            }
                        }
                    }
                }
            } else {
                return "errorParkId";
            }
        }
        return "false";
    }

    @PostMapping("/carpark/insertFreeCarMsg")
    @Transactional(rollbackFor = Exception.class)
    public String insertFreeCarMsg(CarMsgDO carMsgDO) {
        if (carMsgDO != null) {
            List<ParkInformationDO> parkInformationDOList = parkInfoService.queryParkId(carMsgDO.getParkId());
            if (parkInformationDOList.size() != 0) {
                String parkType = parkInfoService.queryParkTypeById(carMsgDO.getParkId());
                if ("fix".equals(parkType)) {
                    return "errorParkType";
                } else {
                    String parkStatus = parkInfoService.queryFreeParkById(carMsgDO.getParkId());
                    if ("1".equals(parkStatus)) {
                        return "reParkId";
                    } else {
                        boolean flag = carMsgService.insertFreeCarMsg(carMsgDO);
                        if (flag) {
                            parkInfoService.updateParkInfoById(carMsgDO.getParkId());
                            return "true";
                        } else {
                            return "false";
                        }
                    }
                }
            } else {
                return "errorParkId";
            }
        }
        return "false";
    }

    @PutMapping("/carpark/updateCarMsg")
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCarMsg(CarMsgDO carMsgDO) {
        if (carMsgDO.getCarId() != null) {
            carMsgService.updateCarMsg(carMsgDO);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/carpark/deleteCarMsg")
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteCarMsg(CarMsgDO carMsgDO) {
        if (carMsgDO.getCarId() != null) {
            carMsgService.deleteCarMsg(carMsgDO.getCarId());
            return true;
        } else {
            return false;
        }
    }
}
