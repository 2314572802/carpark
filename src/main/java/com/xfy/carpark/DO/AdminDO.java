package com.xfy.carpark.DO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
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
     * 管理员密码
     */
    private String admPwd;

    /**
     * 管理员电话
     */
    private String admPhone;

    /**
     * 管理员邮箱
     */
    private String admEmail;

    /**
     * 管理员性别
     */
    private Integer admGender;

    /**
     * 管理员年龄
     */
    private Integer admAge;

    /**
     * 删除标记
     */
    private String admDMark;

}
