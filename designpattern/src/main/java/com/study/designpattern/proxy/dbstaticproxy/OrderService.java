package com.study.designpattern.proxy.dbstaticproxy;

public class OrderService implements IOrderService {
    private OrderDao orderDao;

    public OrderService() {
        orderDao = new OrderDao();
    }

    @Override
    public void createOrder(Order order) {
        orderDao.insert(order);
    }
}
