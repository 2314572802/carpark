package com.xfy.carpark.controller;

import com.xfy.carpark.DO.FixUserDO;
import com.xfy.carpark.service.FixUserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class FixUserController {

    @Resource
    private FixUserService fixUserService;

    @GetMapping("/carpark/queryUserInfo")
    public List<FixUserDO> queryUserInfo() {
        return fixUserService.queryUserInfo();
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
