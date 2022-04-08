package com.xfy.carpark.DO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ParkInformationDO {
    /**
     * 车位ID
     */
    private Integer parkId;

    /**
     * 车位类型
     */
    private String parkType;

    /**
     * 车位状态
     */
    private String parkStatus;

    /**
     * 删除标记
     */
    private String parkDMark;
}
