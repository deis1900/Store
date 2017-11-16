package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import system.model.Product;
import system.service.ProductService;

@Controller
@RequestMapping(name = "/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    //@Qualifier(productService)
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listProducts(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }

    @RequestMapping(value= "/product/add", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product){

        if(product.getId() == 0){
            this.productService.addProduct(product);
        }else{
            this.productService.updateProduct(product);
        }

        return "redirect:/products";

    }

    @RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){

        this.productService.removeProduct(id);
        return "redirect:/products";
    }

    @RequestMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        model.addAttribute("product", this.productService.getProductById(id));
        model.addAttribute("listProducts", this.productService.listProducts());
        return "product";
    }
}
