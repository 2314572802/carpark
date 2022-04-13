package com.xfy.carpark.controller;

import com.xfy.carpark.DO.ParkInformationDO;
import com.xfy.carpark.service.ParkInfoService;
import org.springframework.web.bind.annotation.GetMapping;
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
}
