package com.xfy.carpark.serviceImpl;

import com.xfy.carpark.DO.AdminDO;
import com.xfy.carpark.mapper.IndexAdminMapper;
import com.xfy.carpark.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {

    @Resource
    private IndexAdminMapper indexAdminMapper;

    @Override
    public List<AdminDO> queryAdmin() {
        return indexAdminMapper.queryAdmin();
    }

    @Override
    public List<AdminDO> queryAdminByName(String admName) {
        return indexAdminMapper.queryAdminByName(admName);
    }

    @Override
    public List<AdminDO> queryAdminByPassword(String admName, String admPwd) {
        return indexAdminMapper.queryAdminByPassword(admName, admPwd);
    }

    @Override
    public boolean updateAdmInfo(AdminDO adminDO) {
        return indexAdminMapper.updateAdmInfo(adminDO);
    }

    @Override
    public AdminDO queryAdminByName4Info(String userName) {
        return indexAdminMapper.queryAdminByName4Info(userName);
    }

    @Override
    public boolean updateAdmPwd(AdminDO adminDO) {
        return indexAdminMapper.updateAdmPwd(adminDO);
    }

    @Override
    public boolean insertAdmin(AdminDO adminDO) {
        return indexAdminMapper.insertAdmin(adminDO);
    }
}
