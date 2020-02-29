package com.study.designpattern.proxy.dbstaticproxy;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class OrderServiceStaticProxyTest {

    public static void main(String[] args) throws ParseException {
        OrderServiceStaticProxy proxy = new OrderServiceStaticProxy(new OrderService());
        Order order = new Order();
        order.setOrderId(10101010L);
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy/MM/dd");


        order.setCreateDataTime(yearFormat.parse("2019/01/31"));
        proxy.createOrder(order);
    }
}
