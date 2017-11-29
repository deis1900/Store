package system.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Invoice")
public class Invoice {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Invoice_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date checkDate;

    @Column(name = "AMOUNT")
    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Customer_id")
    private Customer customer;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "Product")
    private List<Product> products = new ArrayList<Product>();

    public Invoice() {
    }

    public Invoice(Customer customer, List<Product> products, Date checkDate, double amount) {
        this.customer = customer;
        this.products = products;
        this.checkDate = checkDate;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date date) {
        this.checkDate = checkDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", product=" + products +
                ", checkDate=" + checkDate +
                ", amount=" + amount +
                '}';
    }
}
