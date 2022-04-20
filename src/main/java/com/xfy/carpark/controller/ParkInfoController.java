package com.xfy.carpark.controller;

import com.xfy.carpark.DO.ParkInformationDO;
import com.xfy.carpark.service.ParkInfoService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/carpark/queryParkByType")
    public List<ParkInformationDO> queryParkByType(String parkType) {
        return parkInfoService.queryParkByType(parkType);
         
    }

    @PostMapping("/carpark/insertParkInfo")
    @Transactional(rollbackFor = Exception.class)
    public boolean insertParkInfo(@RequestBody ParkInformationDO parkInformationDO) {
        parkInfoService.insertParkInfo(parkInformationDO);
        return true;
    }
}
