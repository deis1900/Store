package com.Store.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.Store.model.Product;

import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class ProductDaoImpl implements ProductDao {

    private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public void addProduct(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);
        logger.info("Customer saved successfully, Customer Details= " + product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(product);
        logger.info("Product updated successfully, Product Details= " + product);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Product> listProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> productsList = session.createQuery("FROM Product").list();
        for (Product p : productsList) {
            logger.info("Product List: " + p);
        }
        return productsList;
    }

    @Override
    @Transactional
    public Product getProductById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, id);
        logger.info("Product loaded successfully, Product details= " + product);
        return product;
    }

    @Override
    @Transactional
    public void removeProduct(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = (Product) session.load(Product.class, id);
        if (null != product) {
            session.delete(product);
        }
        logger.info("Product deleted successfully, Product details= " + product);
    }


}
