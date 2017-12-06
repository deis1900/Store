package com.Store.service;

import com.Store.dao.ProductDao;
import com.Store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        this.productDao.addProduct(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        this.productDao.updateProduct(product);
    }

    @Override
    @Transactional
    public List<Product> listProducts() {
        return this.productDao.listProducts();
    }

    @Override
    @Transactional
    public Product getProductById(Integer id) {
        return this.productDao.getProductById(id);
    }

    @Override
    public void removeProduct(Integer id) {
        this.productDao.removeProduct(id);
    }
}
