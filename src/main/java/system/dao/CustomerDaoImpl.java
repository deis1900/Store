package system.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import system.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@Repository
@Transactional
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

    private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public void addCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(customer);
        logger.info("Customer saved successfully, Customer Details=" + customer);
    }

    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(customer);
        logger.info("Customer updated successfully, Customer Details=" + customer);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Customer> listCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Customer> customersList = session.createQuery("FROM Customer").list();
        for (Customer c : customersList) {
            logger.info("Customer List:" + c);
        }
        return customersList;
    }

    @Override
    @Transactional
    public Customer getCustomerById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, new Integer(id));
        logger.info("Customer loaded successfully, Customer details=" + customer);
        return customer;
    }

    @Override
    @Transactional
    public void removeCustomer(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, new Integer(id));
        if (null != customer) {
            session.delete(customer);
        }
        logger.info("Customer deleted successfully, customer details=" + customer);
    }

}
