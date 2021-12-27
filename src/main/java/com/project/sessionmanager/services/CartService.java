package com.project.sessionmanager.services;

import com.project.sessionmanager.models.Product;
import com.project.sessionmanager.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    ProductRepository productRepository;

    public String addProductToCart(HttpServletRequest req, Model model, RedirectAttributes redirectAttributes){
        String s = req.getParameter("prod");
        //System.out.println(s);

        HttpSession session = req.getSession();
        List<String> cartItems = (List<String>) session.getAttribute("cartItems");
        if(cartItems == null) {
            cartItems = new ArrayList<>();
        }
        session.setAttribute("cartItems", cartItems);
        cartItems.add(s);

        return "redirect:/products";
    }


    public String getCart(HttpServletRequest req, Model model){
        HttpSession session = req.getSession();

        List<String> cartItems = (List<String>) session.getAttribute("cartItems");
        Map<String, Integer> itemCount = new HashMap<String, Integer>();

        if(cartItems == null) {
            cartItems = new ArrayList<>();
        }
        else{
            for (String cartItem : cartItems) {
                Integer prodId = Integer.parseInt(cartItem);

                Product prod = productRepository.findByProductid(prodId);
                String prodName=prod.getProductname();
                System.out.println(prodName);


                if (itemCount.containsKey(prodName)) {
                    itemCount.put(prodName, itemCount.get(prodName) + 1);

                } else {
                    itemCount.put(prodName, 1);
                }
            }
        }

        model.addAttribute("cartCount", cartItems.size());
        //model.addAttribute("cartItems", String.join(" ", cartItems));
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("itemCount", itemCount);
        return "cartpage";
    }

}
