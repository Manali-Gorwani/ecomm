package com.project.sessionmanager.controllers;

import com.project.sessionmanager.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;


@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orderspage")
    public String orderspage(){
        return this.orderService.orderspage();
    }

    @GetMapping("/orderplace")
    public String orderplace(){
        return this.orderService.orderplace();
    }

    @PostMapping("/checkout")
    public String orderCheckout(HttpServletRequest req, Model m, RedirectAttributes redirectAttributes){
        return this.orderService.orderCheckout(req, m, redirectAttributes);
    }
}
