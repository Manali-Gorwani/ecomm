package com.project.sessionmanager.services;

import com.project.sessionmanager.models.Orders;
import com.project.sessionmanager.models.Product;
import com.project.sessionmanager.models.User;
import com.project.sessionmanager.repo.OrdersRepository;
import com.project.sessionmanager.repo.ProductRepository;
import com.project.sessionmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    UserRepository userRepository;

    public String productadd(){
        return "productadd";
    }

    public String products(Model m){
        List<Product> products=this.productRepository.findAll();
        /*for(Product p : products){
            System.out.println(p.getProductname());
        }*/
        m.addAttribute("products", products);
        return "products";
    }


    public String doproductadd(HttpServletRequest req, Model m,RedirectAttributes redirectAttributes){
        String productname=req.getParameter("productname");
        Integer price=Integer.parseInt(req.getParameter("price"));
        System.out.println(productname + " " + price );

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(username);
        User s= userRepository.findByUsername(username) ;
        System.out.println(s.getStatus());
        if(s.getStatus().equals("INACTIVE")){
            String msg="Your ID is inactive. Wait till your ID gets activated.";
            redirectAttributes.addFlashAttribute("msg", msg);
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/productadd";
        }

        if(productname.length() < 4){
            String msg="Product name should be more than 4 characters";
            redirectAttributes.addFlashAttribute("msg", msg);
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/productadd";
        }

        if(price <= 0){
            String msg="price should be greater than 0";
            redirectAttributes.addFlashAttribute("msg", msg);
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/productadd";
        }
        Product p = this.productRepository.findByProductname(productname);
        System.out.println(p);
        if(p!=null){
            String msg="Product with same name already exists";
            m.addAttribute("message", msg);
            if(p!=null){
                redirectAttributes.addFlashAttribute("msg", msg);
                redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
                return "redirect:/productadd";
            }
        }

        Product prod = new Product(productname,price);
        this.productRepository.save(prod);
        String msg="Product added successfully";
        redirectAttributes.addFlashAttribute("msg", msg);
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/productadd";
    }
}
