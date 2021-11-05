package com.project.sessionmanager.controllers;

import com.project.sessionmanager.models.Product;
import com.project.sessionmanager.models.User;
import com.project.sessionmanager.repo.ProductRepository;
import com.project.sessionmanager.repo.UserRepository;
import com.project.sessionmanager.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//@RestController
//@RequestMapping("/products")
@Controller
public class ProductAddController {

    @GetMapping("/productadd")
    public String productadd(){
        return "productadd";
    }

    /*@Autowired
    private ProductService productService;*/

    @Autowired
    ProductRepository productRepository;

    /*@GetMapping("")
    public List<Product> findAll(){
        return this.productService.findAll();
    }*/

    /*@GetMapping("/{productname}")
    public User getUser(@PathVariable String productname){
        return this.productService.getProduct(productname);
    }*/


    @PostMapping("/doproductadd")
    public String doproductadd(HttpServletRequest req, Model m){
        String productname=req.getParameter("productname");
        Integer price=Integer.parseInt(req.getParameter("price"));
        System.out.println(productname + " " + price );

        if(productname.length() < 4 || price <= 0){
            String msg="invalid details";
            m.addAttribute("message", msg);
            return "invaliddetails";
        }

        /*Product p = this.productRepository.findByName(productname);
        System.out.println(p);
        if(p!=null){
            return "productnamemismatch";
        }*/

        Product prod = new Product(productname,price);
        this.productRepository.save(prod);
        return "productaddsuccess";
    }
}
