package com.xfy.carpark.controller;

import com.xfy.carpark.DO.AdminDO;
import com.xfy.carpark.service.IndexService;
import org.springframework.http.HttpMessage;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class IndexController {

    @Resource
    private IndexService indexService;

    @GetMapping("/queryAdmin")
    //@Transactional(rollbackFor = Exception.class)
    public List<AdminDO> queryAdmin() {
        return indexService.queryAdmin();
    }
}
