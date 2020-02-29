package com.study.designpattern.proxy.dbstaticproxy;

import java.util.Date;

public class Order {
    private Long orderId;
    private Date createDataTime;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getCreateDataTime() {
        return createDataTime;
    }

    public void setCreateDataTime(Date createDataTime) {
        this.createDataTime = createDataTime;
    }
}
