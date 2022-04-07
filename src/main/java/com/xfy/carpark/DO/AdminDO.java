package com.xfy.carpark.DO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminDO {
    /**
     * id
     */
    private Integer admId;

    /**
     * 管理员用户名
     */
    private String admName;

    /**
     * 管理员电话
     */
    private String admPhone;

    /**
     * 管理员密码
     */
    private String admPwd;

    /**
     * 管理员头像
     */
    private String admPic;

    /**
     * 删除标记
     */
    private String admDMark;
}
