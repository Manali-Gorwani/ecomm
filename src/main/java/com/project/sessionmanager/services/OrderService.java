package com.project.sessionmanager.services;

import com.project.sessionmanager.models.Orders;
import com.project.sessionmanager.models.Product;
import com.project.sessionmanager.repo.OrdersRepository;
import com.project.sessionmanager.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrdersRepository ordersRepository;


    public String orderspage(){
        return "orderspage";
    }


    public String orderplace(){
        return "orderplace";
    }

    public String orderCheckout(HttpServletRequest req, Model m,RedirectAttributes redirectAttributes){

        HttpSession session = req.getSession();
        String address = req.getParameter("address");
        List<String> cartItems = (List<String>) session.getAttribute("cartItems");
        Map<Integer, Integer> itemCount = new HashMap<Integer, Integer>();
        Map<String, Integer> itemNameList = new HashMap<String, Integer>();

        Integer totalAmount=0;
        if(cartItems == null) {
            String msg="Nothing to checkout";
            redirectAttributes.addFlashAttribute("msg", msg);
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/getCart";
        } else {
            Orders order = new Orders();
            order.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());

            totalAmount = 0;
            Integer totalQuantity = 0;

            for (String cartItem : cartItems) {
                Integer prodId = Integer.parseInt(cartItem);

                Product prod = productRepository.findByProductid(prodId);
                String prodName=prod.getProductname();

                if (itemCount.containsKey(prodId)) {
                    itemCount.put(prodId, itemCount.get(prodId) + 1);
                    itemNameList.put(prodName,itemCount.get(prodId)+1);
                } else {
                    itemCount.put(prodId, 1);
                    itemNameList.put(prodName,1);
                }
            }

            for(Integer productId : itemCount.keySet()) {
                Integer productQuantity = itemCount.get(productId);

                Product product = productRepository.getById(productId);
                if(product == null) {
                    System.out.println("Invalid product id in the cart");
                } else {
                    totalQuantity += productQuantity;
                    totalAmount += product.getPrice() * productQuantity;
                }
            }
            order.setAddress(address);
            order.setNoOfItems(totalQuantity);
            order.setTotalAmount(totalAmount);

            /*List<Integer> intList = new ArrayList<Integer>();
            for(String s : cartItems) intList.add(Integer.valueOf(s));
            order.setItems(intList);*/

            ordersRepository.save(order);
        }

        redirectAttributes.addFlashAttribute("message", "Your Order Is Placed Successfully");
        //redirectAttributes.addFlashAttribute("itemList",itemCount);
        redirectAttributes.addFlashAttribute("itemList",itemNameList);
        redirectAttributes.addFlashAttribute("cartCount",cartItems.size());
        redirectAttributes.addFlashAttribute("totalAmount",totalAmount);
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/orderplace";
    }
}
