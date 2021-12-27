package com.project.sessionmanager.controllers;

import com.project.sessionmanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;

//@RestController
//@RequestMapping("/products")
@Controller
public class ProductAddController {

    @Autowired
    ProductService productService;


    @GetMapping("/productadd")
    public String productadd(){
        return this.productService.productadd();
    }

    @GetMapping("/products")
    public String products(Model m){
        return this.productService.products(m);
    }








    @PostMapping("/doproductadd")
    public String doproductadd(HttpServletRequest req, Model m,RedirectAttributes redirectAttributes){
        return this.productService.doproductadd(req, m, redirectAttributes);
    }
}
