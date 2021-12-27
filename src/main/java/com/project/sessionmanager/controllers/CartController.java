package com.project.sessionmanager.controllers;

import com.project.sessionmanager.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;

//@RestController
//@RequestMapping("/products")
@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/addProductToCart")
    public String addProductToCart(HttpServletRequest req, Model m, RedirectAttributes redirectAttributes){
        return this.cartService.addProductToCart(req,m,redirectAttributes);
    }

    @GetMapping("/getCart")
    public String getCart(HttpServletRequest req, Model m){
        return this.cartService.getCart(req, m);
    }
}
