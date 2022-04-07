package com.xfy.carpark.serviceImpl;

import com.xfy.carpark.DO.AdminDO;
import com.xfy.carpark.mapper.IndexAdminMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IndexServiceImpl {

    @Resource
    private IndexAdminMapper indexAdminMapper;

    public List<AdminDO> queryAdmin() {
        return indexAdminMapper.queryAdmin();
    }
}
