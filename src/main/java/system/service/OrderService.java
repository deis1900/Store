package system.service;

import system.model.Order;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    void updateOrder(Order order);

    List<Order> listOrders();

    Order getOrderById(Integer id);

    void removeOrder(Integer id);
}
