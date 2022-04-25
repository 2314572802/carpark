package com.xfy.carpark.DO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
public class CarMsgDO {
    /**
     * 车辆编号
     */
    private Integer carId;

    /**
     * 车位编号
     */
    private Integer parkId;

    /**
     * 车主编号
     */
    private Integer userId;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtStart;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtEnd;

    /**
     * 车位类型
     */
    private String parkType;

    /**
     * 车主姓名
     */
    private String userName;

    /**
     * 删除标记
     */
    private String carDMark;
}
