package system.dao;

import system.model.Order;

import java.util.List;

public interface OrderDao {

    void addOrder(Order order);

    void updateOrder(Order order);

    List<Order> listOrders();

    Order getOrderById(Integer id);

    void removeOrder(Integer id);
}
