package com.xfy.carpark.controller;

import com.xfy.carpark.DO.ParkInformationDO;
import com.xfy.carpark.service.ParkInfoService;
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
public class ParkInfoController {

    @Resource
    private ParkInfoService parkInfoService;

    @GetMapping("/carpark/queryPark")
    public Map<String, Object> queryPark(Integer pageCode, Integer val) {//pageCode:页数；cal:条数
        Map<String, Object> parkMap = new HashMap<>();
        Integer pageNum = (pageCode - 1) * val;
        List<ParkInformationDO> parkInformationDOList = parkInfoService.queryPark(pageNum, val);//每页的数据
        parkMap.put("pageData", parkInformationDOList);
        Integer total = parkInfoService.queryTotal();//总条数
        parkMap.put("total", total);
        Integer pageTotal = total/val;//总页数
        parkMap.put("pageTotal", pageTotal);
        return parkMap;
    }

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
