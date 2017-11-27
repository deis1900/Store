package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.dao.OrderDao;
import system.model.Order;
import system.model.Product;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
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
    public Order getOrderById(Integer id) {
        return this.orderDao.getOrderById(id);
    }

    @Override
    public void removeOrder(Integer id) {
        this.orderDao.removeOrder(id);
    }

}
