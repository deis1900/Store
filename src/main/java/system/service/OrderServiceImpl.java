package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.dao.OrderDao;
import system.model.Customer;
import system.model.Order;
import system.model.Product;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao){
        this.orderDao = orderDao;
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        this.orderDao.addOrder(order);
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        this.orderDao.updateOrder(order);
    }

    @Override
    @Transactional
    public List<Order> listOrders() {
        return this.orderDao.listOrders();
    }

    @Override
    @Transactional
    public Order getOrderById(int id) {
        return this.orderDao.getOrderById(id);
    }

    @Override
    public void removeOrder(int id) { this.orderDao.removeOrder(id);}

    @Override
    @Transactional
    public List<Order> getOrderByCustomer(Customer customer){
        return this.orderDao.getOrderByCustomer(customer);
    }

    @Override
    @Transactional
    public List<Order> getOrderByProduct (Product product){
        return orderDao.getOrderByProduct(product);
    }
}
