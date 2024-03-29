package com.xfy.carpark.mapper;

import com.xfy.carpark.DO.FixUserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FixUserMapper {
    /**
     * 查询所有车主信息
     */
    List<FixUserDO> queryUserInfo(@Param("pageNum") Integer pageNum, @Param("val") Integer val);

    /**
     * 根据车牌号查询
     */
    List<FixUserDO> queryUserInfoByCarNum(String userCarNum);

    /**
     * 新增车主
     */
    boolean insertUserInfo(FixUserDO fixUserDO);

    /**
     * 修改车主信息
     */
    boolean updateUserInfo(FixUserDO fixUserDO);

    /**
     * 删除标记
     */
    boolean deleteUserInfo(Integer userId);

    /**
     * 校验输入车主姓名是否存在
     */
    List<FixUserDO> queryUserNameByInputUserName(String userName);

    /**
     * 根据新增时的车主姓名查询对应车主编号
     */
    Integer queryUserIdByUserName(String userName);

    /**
     * 根据新增时的车辆id查询相应的车牌号
     */
    String queryUserCarNumByUserId(Integer carMsgId);

    /**
     * 分页查询总条数
     */
    Integer queryTotal();
}
