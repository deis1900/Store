package com.Store.controller;

import com.Store.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.Store.service.InvoiceService;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public String listInvoices(Model model) {
        model.addAttribute("invoice", new Invoice());
        //model.addAttribute("product", new Product());
        model.addAttribute("listInvoices", this.invoiceService.listInvoices());
        return "invoice";
    }

    @RequestMapping(value = "/invoice/add", method = RequestMethod.POST)
    public String addInvoice(@Valid Invoice invoice, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "invoice";
        }else{
            if (invoice.getId() == null) {
                this.invoiceService.addInvoice(invoice);
            } else {
                this.invoiceService.addInvoice(invoice);
            }
            status.setComplete();
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
    public String ClientOrder(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("invoice", new Invoice());
        //model.addAttribute("product", new Product());
        model.addAttribute("invoices", this.invoiceService.getCustomerWithId(id));
        if (invoiceService.getInvoiceById(id) == null) {
            return "No customer with this " + id + "";
        } else {
            return "CustomerID";
        }

    }

}
