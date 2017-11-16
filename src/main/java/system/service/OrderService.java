package system.service;

import system.model.Customer;
import system.model.Order;
import system.model.Product;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);
    void updateOrder(Order order);
    List<Order> listOrders();
    Order getOrderById(int id);
    List<Order> getOrderByCustomer(Customer customer);
    List<Order> getOrderByProduct (Product product);
    void removeOrder(int id);
}
