package system.dao;

import system.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    void addInvoice(Invoice invoice);

    void updateInvoice(Invoice invoice);

    List<Invoice> listInvoices();

    Invoice getInvoiceById(Integer id);

    void removeInvoice(Integer id);
}
