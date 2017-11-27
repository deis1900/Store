package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.dao.CustomerDao;
import system.model.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        this.customerDao.addCustomer(customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        this.customerDao.updateCustomer(customer);
    }

    @Override
    @Transactional
    public List<Customer> listCustomers() {
        return this.customerDao.listCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomerById(Integer id) {
        return this.customerDao.getCustomerById(id);
    }

    @Override
    public void removeCustomer(Integer id) {
        this.customerDao.removeCustomer(id);
    }
}
