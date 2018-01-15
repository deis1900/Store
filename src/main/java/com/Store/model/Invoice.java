package com.Store.model;

import com.Store.service.CustomerServiceImpl;
import com.Store.service.ProductServiceImpl;
import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Invoice")
public class Invoice implements Serializable {

    @Id
    @Column(name = "INVOICE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "INVOICE_DATE")
    @NaturalId
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "dd-mm-yyyy hh:mm:ss")
    private Date checkDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    private List<Product> products = new ArrayList<Product>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customerId) {

        this.customer = new CustomerServiceImpl().getCustomerById(customerId);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Integer> productsId) {
        for (Integer p: productsId){
            products.add(new ProductServiceImpl().getProductById(p));
        }
    }

    public void removeProducts(List<Integer> productsId) {
        ProductServiceImpl productServiceimpl = new ProductServiceImpl();
        for (Integer p: productsId){
            products.remove(productServiceimpl.getProductById(p));
        }
    }

}
