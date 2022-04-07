package com.xfy.carpark.mapper;

import com.xfy.carpark.DO.AdminDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IndexAdminMapper {

    List<AdminDO> queryAdmin();

    List<AdminDO> queryAdminByName(String admName);

    int insertAdmin(AdminDO adminDO);
}
