package com.study.designpattern.proxy.dbstaticproxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void createOrder(Order order) {
        Date date = order.getCreateDataTime();
        int dbRouter = Integer.parseInt(yearFormat.format(date));
        DynamicDataSorceEntity.set(dbRouter);
        System.out.println("静态代理类自动分配到【DB_" +  dbRouter + "】数据源处理数据" );
        orderService.createOrder(order);
        DynamicDataSorceEntity.restore();
    }
}
