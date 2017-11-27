package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.model.Customer;
import system.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerServiceImpl) {
        this.customerService = customerServiceImpl;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("test", "Hi from test.");
        return "test";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomers(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "customer";
    }

    @RequestMapping(value = "/customer/add", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer") Customer customer) {

        if (customer.getId() == null){
            this.customerService.addCustomer(customer);
        } else {
            this.customerService.updateCustomer(customer);
        }

        return "redirect:/customer/customers";

    }

    @RequestMapping("/remove/{id}")
    public String removeCustomer(@PathVariable("id") Integer id) {

        this.customerService.removeCustomer(id);
        return "redirect:/customer/customers";
    }

    @RequestMapping("/edit/{id}")
    public String editCustomer(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customer", this.customerService.getCustomerById(id));
        model.addAttribute("listCustomers", this.customerService.listCustomers());
        return "customer";
    }

}
