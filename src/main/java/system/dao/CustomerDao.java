package system.dao;

import system.model.Customer;

import java.util.List;


public interface CustomerDao{

    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    List<Customer> listCustomers();
    Customer getCustomerById(int id);
    void removeCustomer(int id);


}
