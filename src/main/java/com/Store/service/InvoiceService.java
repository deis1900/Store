package com.Store.service;

import com.Store.model.Invoice;

import java.util.List;

public interface InvoiceService {

    void addInvoice(Invoice invoice);

    void updateInvoice(Invoice invoice);

    List<Invoice> listInvoices();

    Invoice getInvoiceById(Integer id);

    void removeInvoice(Integer id);

    List<Invoice> getCustomerWithId(Integer id);
}
