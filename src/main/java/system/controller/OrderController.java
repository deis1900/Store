package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.model.Customer;
import system.model.Order;
import system.model.Product;
import system.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String listOrders(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("customer", new Customer());
        model.addAttribute("listOrders", this.orderService.listOrders());
        model.addAttribute("listProduct", new Product());
        return "order";
    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order) {

        if (order.getId() == null
                && order.getCustomer() == null
                && order.getProduct() == null) {
            this.orderService.addOrder(order);
        } else {
            this.orderService.updateOrder(order);
        }

        return "redirect:/order/orders";

    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") Integer id) {

        this.orderService.removeOrder(id);
        return "redirect:/order/orders";
    }

    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("order", this.orderService.getOrderById(id));
        model.addAttribute("listOrders", this.orderService.listOrders());
        return "order";
    }

}
