package system.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import system.model.Invoice;

import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class InvoiceDaoImpl implements InvoiceDao {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    @Transactional
    public void addInvoice(Invoice invoice) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(invoice);
        logger.info("Invoice saved successfully, Invoice Details= " + invoice);
    }

    @Override
    @Transactional
    public void updateInvoice(Invoice invoice) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(invoice);
        logger.info("Invoice updated successfully, Invoice Details= " + invoice);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Invoice> listInvoices() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Invoice> invoicesList = session.createQuery("FROM Invoice").list();
        for (Invoice o : invoicesList) {
            logger.info("Invoice List:" + o);
        }
        return invoicesList;
    }

    @Override
    @Transactional
    public Invoice getInvoiceById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Invoice invoice = (Invoice) session.load(Invoice.class, id);
        logger.info("Invoice loaded successfully, Invoice details= " + invoice);
        return invoice;
    }

    @Override
    @Transactional
    public void removeInvoice(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Invoice invoice = (Invoice) session.load(Invoice.class, id);
        if (null != invoice) {
            session.delete(invoice);
            logger.info("Invoice deleted successfully, invoice details= " + invoice);
        }else{
            logger.info("Invoice not found.");
        }

    }

}
