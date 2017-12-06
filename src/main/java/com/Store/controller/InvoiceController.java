package com.Store.controller;

import com.Store.model.Invoice;
import com.Store.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.Store.service.InvoiceService;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public String listInvoices(Model model) {
        model.addAttribute("invoice", new Invoice());
        model.addAttribute("product", new Product());
        model.addAttribute("listInvoices", this.invoiceService.listInvoices());
        return "invoice";
    }

    @RequestMapping(value = "/invoice/add", method = RequestMethod.POST)
    public String addInvoice(@ModelAttribute("invoice") Invoice invoice) {

        if (invoice.getId() == null) {
            this.invoiceService.addInvoice(invoice);
        } else {
            this.invoiceService.updateInvoice(invoice);
        }

        return "redirect:/invoice/invoices";

    }

    @RequestMapping("/remove/{id}")
    public String removeInvoice(@PathVariable("id") Integer id) {

        this.invoiceService.removeInvoice(id);
        return "redirect:/invoice/invoices";
    }

    @RequestMapping("/edit/{id}")
    public String editInvoice(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("invoice", this.invoiceService.getInvoiceById(id));
        model.addAttribute("listInvoices", this.invoiceService.listInvoices());
        return "invoice";
    }

    @RequestMapping("/{id}")
    public String ClientOrder(@PathVariable("id") Integer id, Model model){
        model.addAttribute("invoice", new Invoice());
        model.addAttribute("product", new Product());
        model.addAttribute("invoices", this.invoiceService.getCustomerWithId(id));
        if(invoiceService.getInvoiceById(id) == null){
            return "No customer with this "+ id + "";
        }else {
            return "CustomerID";
        }

    }

}
