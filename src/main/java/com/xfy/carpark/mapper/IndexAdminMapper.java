package com.xfy.carpark.mapper;

import com.xfy.carpark.DO.AdminDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IndexAdminMapper {

    /**
     * 查询所有管理员
     */
    List<AdminDO> queryAdmin();

    /**
     * 根据账号查询管理员是否存在
     */
    List<AdminDO> queryAdminByName(String admName);

    /**
     * 创建管理员
     */
    List<AdminDO> insertAdmin(AdminDO adminDO);

    /**
     * 根据账号和密码查询是否存在
     */
    List<AdminDO> queryAdminByPassword(@Param("admName") String admName, @Param("admPwd") String admPwd);

    /**
     * 查询所有车位信息
    List<ParkInformationDO> parkInfoList();*/
}
