package com.xfy.carpark.DO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PayMsgDO {
    /**
     * 支付id
     */
    private Integer pmId;

    /**
     * 支付类型
     */
    private String pmType;

    /**
     * 车辆id
     */
    private Integer carMsgId;

    /**
     * 自由车位费率
     */
    private Integer pmRate;

    /**
     * 自由车位停车费
     */
    private Integer payMoney;

    /**
     * 固定车位支付方式
     */
    private String payMethod;

    /**
     * 删除标记
     */
    private String pmDMark;

    /**
     * 车牌号
     */
    private String userCarNum;

    /**
     * 停车时长
     */
    private Integer gmtTime;
}
