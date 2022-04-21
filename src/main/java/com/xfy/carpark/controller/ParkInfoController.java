package com.xfy.carpark.controller;

import com.xfy.carpark.DO.ParkInformationDO;
import com.xfy.carpark.service.ParkInfoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ParkInfoController {

    @Resource
    private ParkInfoService parkInfoService;

    @GetMapping("/carpark/queryPark")
    public List<ParkInformationDO> queryPark() {
        return parkInfoService.queryPark();
    }

//    @GetMapping("/carpark/queryParkById")
//    public List<ParkInformationDO> queryParkById(Integer parkId) {
//        return parkInfoService.queryParkById(parkId);
//    }

    @GetMapping("/carpark/queryParkByType")
    public List<ParkInformationDO> queryParkByType(String parkType) {
        return parkInfoService.queryParkByType(parkType);
         
    }

    @PostMapping("/carpark/insertParkInfo")
    @Transactional(rollbackFor = Exception.class)
    public boolean insertParkInfo(ParkInformationDO parkInformationDO) {
        if (parkInformationDO.getParkType().length() != 0) {
            parkInfoService.insertParkInfo(parkInformationDO);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/carpark/updateParkInfo")
    @Transactional(rollbackFor = Exception.class)
    public boolean updateParkInfo(ParkInformationDO parkInformationDO) {
        if (parkInformationDO.getParkId() != null) {
            parkInfoService.updateParkInfo(parkInformationDO);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/carpark/deleteParkInfo")
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteParkInfo(ParkInformationDO parkInformationDO) {
        if (parkInformationDO.getParkId() != null) {
            parkInfoService.deleteParkInfo(parkInformationDO);
            return true;
        } else {
            return false;
        }
    }
}
