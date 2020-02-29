package com.study.designpattern.proxy.dbstaticproxy;

public class OrderDao {

    public void insert(Order order) {
        System.out.println("Dao,orderId = [" + order.getOrderId() + "插入]");
    }
}
