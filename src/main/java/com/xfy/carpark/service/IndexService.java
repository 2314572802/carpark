package com.xfy.carpark.service;

import com.xfy.carpark.DO.AdminDO;

import java.util.List;


public interface IndexService {

    /**
     * 查询所有admin
     */
    List<AdminDO> queryAdmin();
}
