package system.dao;

import system.model.Customer;
import system.model.Order;
import system.model.Product;

import java.util.List;

public interface OrderDao {

    void addOrder (Order order);
    void updateOrder (Order order);
    List<Order> listOrders();
    List<Order> getOrderByCustomer(Customer customer);
    List<Order> getOrderByProduct(Product product);
    Order getOrderById(int id);
    void removeOrder(int id);
}
