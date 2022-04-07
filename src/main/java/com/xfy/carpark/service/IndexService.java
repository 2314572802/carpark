package com.xfy.carpark.service;

import com.xfy.carpark.DO.AdminDO;

import java.util.List;


public interface IndexService {

    /**
     * 查询所有admin
     */
    List<AdminDO> queryAdmin();

    /**
     * 根据用户名查询Admin
     * @param admName 用户名
     */
    List<AdminDO> queryAdminByName(String admName);

    /**
     * 添加管理员
     * @param adminDO
     */
    AdminDO insertAdmin(AdminDO adminDO);
}
