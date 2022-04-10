package com.xfy.carpark.controller;

import com.xfy.carpark.DO.AdminDO;
import com.xfy.carpark.DO.ParkInformationDO;
import com.xfy.carpark.mapper.IndexAdminMapper;
import com.xfy.carpark.service.IndexService;
import com.xfy.carpark.util.CodeUtil;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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



    @GetMapping("/queryAdmin")
    public List<AdminDO> queryParkInfo() {
        return indexService.queryAdmin();
    }

    @GetMapping("/queryAdminByName")
    public List<AdminDO> queryAdminByName(String admName) {
        return indexService.queryAdminByName(admName);
    }

    @GetMapping("/queryParkInfo")
    public String ListParkInfo(Model model, HttpServletRequest request) {
        String admName = request.getParameter("username");
        String admPwd = request.getParameter("password");
        if (indexService.queryAdminByPassword(admName, admPwd).size() != 0) {
            if (!CodeUtil.checkVerifyCode(request)) {
                return "errorCode";
            } else {
                List<ParkInformationDO> parkInformationDOList = indexService.queryParkInfo();
                model.addAttribute("parkInformationDOList", parkInformationDOList);
                return "listParkInfo";
            }
        } else {
            return "success";
        }
    }

    @PostMapping("/insertAdmin")
    @Transactional(rollbackFor = Exception.class)
    public AdminDO insertAdmin(AdminDO adminDO, HttpServletRequest request) {
        if (queryAdminByName(request.getParameter("username")).size() == 0) {
            adminDO.setAdmName(request.getParameter("username"));
            adminDO.setAdmPwd(request.getParameter("password2"));
            return indexService.insertAdmin(adminDO);
        } else {
            return null;
        }
    }

    @PutMapping("/updateAdmPwd")
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
