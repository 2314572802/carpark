package com.xfy.carpark.service;

import com.xfy.carpark.DO.AdminDO;
import com.xfy.carpark.DO.ParkInformationDO;

import java.util.Collection;
import java.util.List;


public interface IndexService {

    /**
     * 查询所有admin
     */
    List<AdminDO> queryAdmin();

    /**
     * 根据用户名查询Admin是否存在
     * @param admName 用户名
     */
    List<AdminDO> queryAdminByName(String admName);

    /**
     * 添加管理员
     * @param adminDO
     */
    AdminDO insertAdmin(AdminDO adminDO);

    /**
     * 根据账号密码判断是否存在
     * @param admName 用户名
     * @param admPwd 密码
     */
    List<AdminDO> queryAdminByPassword(String admName, String admPwd);

    /**
     * 查询所有车位信息
     */
    List<ParkInformationDO> queryParkInfo();

    /**
     * 修改密码
     */
    List<AdminDO> updateAdmPwd(String password1, String admName);
}
