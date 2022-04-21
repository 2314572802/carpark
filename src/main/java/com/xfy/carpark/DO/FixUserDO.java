package com.xfy.carpark.DO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class FixUserDO {
    /**
     * 车主编号
     */
    private Integer userId;

    /**
     * 车主姓名
     */
    private String userName;

    /**
     * 车主电话
     */
    private String userPhone;

    /**
     * 车主年龄
     */
    private Integer userAge;

    /**
     * 车主性别
     */
    private Integer userGender;

    /**
     * 车主车牌号
     */
    private String userCarNum;

    /**
     * 车主删除标记
     */
    private String userDMark;
}
