package com.xfy.carpark.service;

import com.xfy.carpark.DO.AdminDO;

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
    boolean insertAdmin(AdminDO adminDO);

    /**
     * 根据账号密码判断是否存在
     */
    List<AdminDO> queryAdminByPassword(String admName, String admPwd);

    /**
     * 修改个人信息
     */
    boolean updateAdmInfo(AdminDO adminDO);

    /**
     * 根据登录时的admName查询用户信息
     */
    AdminDO queryAdminByName4Info(String userName);

    /**
     * 修改密码
     */
    boolean updateAdmPwd(AdminDO adminDO);
}
