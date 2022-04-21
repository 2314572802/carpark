package com.xfy.carpark.serviceImpl;

import com.xfy.carpark.DO.FixUserDO;
import com.xfy.carpark.mapper.FixUserMapper;
import com.xfy.carpark.service.FixUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FixUserServiceImpl implements FixUserService {

    @Resource
    private FixUserMapper fixUserMapper;

    @Override
    public List<FixUserDO> queryUserInfo() {
        return fixUserMapper.queryUserInfo();
    }
}
