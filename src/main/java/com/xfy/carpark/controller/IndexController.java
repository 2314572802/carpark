package com.xfy.carpark.controller;

import com.xfy.carpark.DO.AdminDO;
import com.xfy.carpark.mapper.IndexAdminMapper;
import com.xfy.carpark.service.IndexService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class IndexController {

    @Resource
    private IndexService indexService;

    @Resource
    private IndexAdminMapper indexAdminMapper;

    @GetMapping("/carpark/queryAdmin")
    public List<AdminDO> queryParkInfo() {
        return indexService.queryAdmin();
    }

    @GetMapping("/carpark/queryAdminByName")
    public List<AdminDO> queryAdminByName(String admName)  {
        return indexService.queryAdminByName(admName);
    }

    @PostMapping("/carpark/queryParkInfo")
    public boolean ListParkInfo(@RequestBody  AdminDO adminDO) {
        String admName = adminDO.getAdmName();
        String admPwd = adminDO.getAdmPwd();
        if (indexService.queryAdminByPassword(admName, admPwd).size() != 0) {
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

    @PutMapping("/carpark/updateAdmPwd")
    public boolean updateAdmPwd(HttpServletRequest request) {
        String admName = request.getParameter("username");
        String admPwd = request.getParameter("password");
        if (indexAdminMapper.queryAdminByPassword(admName, admPwd).size() != 0) {
            String password1 = request.getParameter("password2");
            indexService.updateAdmPwd(password1, admName);
            return true;
        } else {
            return false;
        }
    }
}
