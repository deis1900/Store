package system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import system.dao.InvoiceDao;
import system.model.Invoice;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceDao invoiceDao;

    @Autowired
    public void setInvoiceDao(InvoiceDao invoiceDao) {
        this.invoiceDao = invoiceDao;
    }

    @Override
    @Transactional
    public void addInvoice(Invoice invoice) {
        this.invoiceDao.addInvoice(invoice);
    }

    @Override
    @Transactional
    public void updateInvoice(Invoice invoice) {
        this.invoiceDao.updateInvoice(invoice);
    }

    @Override
    @Transactional
    public List<Invoice> listInvoices() {
        for(Invoice invoice: invoiceDao.listInvoices()) {
            System.out.println(invoice.toString());
            System.out.println(invoice.getCustomer().toString());
        }

        return this.invoiceDao.listInvoices();
    }

    @Override
    @Transactional
    public Invoice getInvoiceById(Integer id) {
        return this.invoiceDao.getInvoiceById(id);
    }

    @Override
    public void removeInvoice(Integer id) {
        this.invoiceDao.removeInvoice(id);
    }

}
