package com.xfy.carpark.mapper;

import com.xfy.carpark.DO.FixUserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FixUserMapper {
    /**
     * 查询所有车主信息
     */
    List<FixUserDO> queryUserInfo();
}
