package com.Store.dao;

import com.Store.model.Customer;

import java.util.List;


public interface CustomerDao {

    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    List<Customer> listCustomers();

    Customer getCustomerById(Integer id);

    void removeCustomer(Integer id);


}
