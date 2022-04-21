package com.xfy.carpark.controller;

import com.xfy.carpark.DO.AdminDO;
import com.xfy.carpark.mapper.IndexAdminMapper;
import com.xfy.carpark.service.IndexService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class IndexController {

    public static String userName = null;

    @Resource
    private IndexService indexService;

    @GetMapping("/carpark/queryAdmin")
    public List<AdminDO> queryParkInfo() {
        return indexService.queryAdmin();
    }

    @GetMapping("/carpark/queryAdminByName")
    public List<AdminDO> queryAdminByName(String admName)  {
        return indexService.queryAdminByName(admName);
    }

    @GetMapping("/carpark/queryAdminByName4Info")
    public AdminDO queryAdminByName4Info()  {
        return indexService.queryAdminByName4Info(userName);
    }

    @PostMapping("/carpark/queryParkInfo")
    public boolean ListParkInfo(@RequestBody  AdminDO adminDO) {
        userName = adminDO.getAdmName();
        String admName = adminDO.getAdmName();
        String admPwd = adminDO.getAdmPwd();
        if (indexService.queryAdminByPassword(admName, admPwd).size() != 0) {
            System.out.println(userName);
            return true;

        } else {
            return false;
        }
    }

    @PostMapping("/carpark/insertAdmin")
    @Transactional(rollbackFor = Exception.class)
    public boolean insertAdmin(@RequestBody AdminDO adminDO) {
        if (queryAdminByName(adminDO.getAdmName()).size() == 0) {
            indexService.insertAdmin(adminDO);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/carpark/updateAdmInfo")
    @Transactional(rollbackFor = Exception.class)
    public boolean updateAdmInfo(AdminDO adminDO) {
        if (adminDO.getAdmName().length() != 0) {
            indexService.updateAdmInfo(adminDO);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/carpark/updateAdmPwd")
    @Transactional(rollbackFor = Exception.class)
    public boolean updateAdmPwd(AdminDO adminDO) {
        if (adminDO.getAdmName().length() != 0) {
            indexService.updateAdmPwd(adminDO);
            return true;
        } else {
            return false;
        }
    }
}
