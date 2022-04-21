package com.xfy.carpark.controller;

import com.xfy.carpark.DO.FixUserDO;
import com.xfy.carpark.service.FixUserService;
import org.springframework.web.bind.annotation.GetMapping;
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
}
