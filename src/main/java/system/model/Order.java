package system.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY/*, cascade = {CascadeType.MERGE, CascadeType.PERSIST}*/)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY/*, cascade = {CascadeType.MERGE, CascadeType.PERSIST}*/)
    @JoinColumn(name = "PRODUCT_ID")
    private List<Product> product;

    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.DATE)
    private Date orderDate;

    @Column(name = "AMOUNT")
    private double amount;

    public Order(){
    }

    public Order(Customer customer, List<Product> product, Date orderDate, double amount) {
        this.customer = customer;
        this.product = product;
        this.orderDate = orderDate;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", product=" + product +
                ", orderDate=" + orderDate +
                ", amount=" + amount +
                '}';
    }
}
