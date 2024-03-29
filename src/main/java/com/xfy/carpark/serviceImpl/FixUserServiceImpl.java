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
    public List<FixUserDO> queryUserInfo(Integer pageNum, Integer val) {
        return fixUserMapper.queryUserInfo(pageNum, val);
    }

    @Override
    public List<FixUserDO> queryUserInfoByCarNum(String userCarNum) {
        return fixUserMapper.queryUserInfoByCarNum(userCarNum);
    }

    @Override
    public boolean insertUserInfo(FixUserDO fixUserDO) {
        return fixUserMapper.insertUserInfo(fixUserDO);
    }

    @Override
    public boolean updateUserInfo(FixUserDO fixUserDO) {
        return fixUserMapper.updateUserInfo(fixUserDO);
    }

    @Override
    public boolean deleteUserInfo(Integer userId) {
        return fixUserMapper.deleteUserInfo(userId);
    }

    @Override
    public List<FixUserDO> queryUserNameByInputUserName(String userName) {
        return fixUserMapper.queryUserNameByInputUserName(userName);
    }

    @Override
    public Integer queryUserIdByUserName(String userName) {
        return fixUserMapper.queryUserIdByUserName(userName);
    }

    @Override
    public Integer queryTotal() {
        return fixUserMapper.queryTotal();
    }

}
