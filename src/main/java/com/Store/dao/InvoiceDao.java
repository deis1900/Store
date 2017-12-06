package com.Store.dao;

import com.Store.model.Invoice;

import java.util.List;

public interface InvoiceDao {

    void addInvoice(Invoice invoice);

    void updateInvoice(Invoice invoice);

    List<Invoice> listInvoices();

    List<Invoice> getCustomerWithID(Integer id);

    Invoice getInvoiceById(Integer id);

    void removeInvoice(Integer id);
}
