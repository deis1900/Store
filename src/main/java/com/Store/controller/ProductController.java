package com.Store.controller;

import com.Store.model.Product;
import com.Store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product) {

        if (product.getId() == null) {
            this.productService.addProduct(product);
        } else {
            this.productService.updateProduct(product);
        }

        return "redirect:/product/products";

    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") Integer id) {

        this.productService.removeProduct(id);
        return "redirect:/product/products";
    }

    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }
}
