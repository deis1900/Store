package system.dao;

import system.model.Product;

import java.util.List;

public interface ProductDao {
    void addProduct (Product product);
    void updateProduct (Product product);
    List<Product> listProducts ();
    Product getProductById (int id);
    void removeProduct (int id);
}