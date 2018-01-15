package com.Store.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String type;
    private String size;
    private String material;
    private String color;
    private long dateOfLastChange;
//
//    @ManyToMany(mappedBy = "products", cascade = CascadeType.ALL)
//    private List<Invoice> invoices = new ArrayList<Invoice>();

    public Product() {
    }

    public Product(String type, String size, String material, String color, long dateOfLastChange) {
        this.type = type;
        this.size = size;
        this.material = material;
        this.color = color;
        this.dateOfLastChange = dateOfLastChange;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public long getDateOfLastChange() {
        return dateOfLastChange;
    }
//
//    public void setDateOfLastChange(long dateOfLastChange) {
//        this.dateOfLastChange = dateOfLastChange;
//    }
//
//    public List<Invoice> getInvoices() {
//        return invoices;
//    }
}
