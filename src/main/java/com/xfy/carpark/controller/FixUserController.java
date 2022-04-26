package com.xfy.carpark.controller;

import com.xfy.carpark.DO.FixUserDO;
import com.xfy.carpark.DO.ParkInformationDO;
import com.xfy.carpark.service.FixUserService;
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
public class FixUserController {

    @Resource
    private FixUserService fixUserService;

    @GetMapping("/carpark/queryUserInfo")
    public Map<String, Object> queryUserInfo(Integer pageCode, Integer val) {
        Map<String, Object> fixUserMap = new HashMap<>();
        Integer pageNum = (pageCode - 1) * val;
        List<FixUserDO> fixUserDOList = fixUserService.queryUserInfo(pageNum, val);
        fixUserMap.put("pageData", fixUserDOList);
        Integer total = fixUserService.queryTotal();//总条数
        fixUserMap.put("total", total);
        Integer pageTotal = total/val;//总页数
        fixUserMap.put("pageTotal", pageTotal);
        return fixUserMap;
    }

    @GetMapping("/carpark/queryUserNameByInputUserName")
    public boolean queryUserNameByInputUserName(String userName) {
        List<FixUserDO> fixUserDOList = fixUserService.queryUserNameByInputUserName(userName);
        if (fixUserDOList.size() != 0) {
            return true;
        } else {
            return false;
        }
    }

    @GetMapping("/carpark/queryUserInfoByCarNum")
    public List<FixUserDO> queryUserInfoByCarNum(String userCarNum) {
        return fixUserService.queryUserInfoByCarNum(userCarNum);

    }

    @PostMapping("/carpark/insertUserInfo")
    @Transactional(rollbackFor = Exception.class)
    public boolean insertUserInfo(FixUserDO fixUserDO) {
        if (fixUserDO != null) {
            fixUserService.insertUserInfo(fixUserDO);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/carpark/updateUserInfo")
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUserInfo(FixUserDO fixUserDO) {
        if (fixUserDO.getUserId() != null) {
            fixUserService.updateUserInfo(fixUserDO);
            return true;
        }else {
            return false;
        }
    }

    @PutMapping("/carpark/deleteUserInfo")
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUserInfo(FixUserDO fixUserDO) {
        if (fixUserDO.getUserId() != null) {
            fixUserService.deleteUserInfo(fixUserDO.getUserId());
            return true;
        }else {
            return false;
        }
    }
}
