package com.xfy.carpark.service;

import com.xfy.carpark.DO.FixUserDO;

import java.util.List;

public interface FixUserService{
    /**
     * 查询所有车主信息
     */
    List<FixUserDO> queryUserInfo();
}
