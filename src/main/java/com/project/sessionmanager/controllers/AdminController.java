package com.project.sessionmanager.controllers;

import com.project.sessionmanager.models.User;
import com.project.sessionmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/sellers")
    public String sellers(Model m){
        //List<User> seller=this.userRepository.findAll();
        List<User> seller=this.userRepository.findByRole("ROLE_SELLER");
        m.addAttribute("seller", seller);
        return "sellerapproval";
    }

    @GetMapping("/updateStatus")
    public String updateStatus(HttpServletRequest req, Model model, RedirectAttributes redirectAttributes){
        String s = req.getParameter("seller");
        //System.out.println(s);
        User seller = userRepository.findByUsername(s);
        String currentStatus=seller.getStatus();
        System.out.println(currentStatus);
        System.out.println(currentStatus.equals("INACTIVE"));

        if( currentStatus.equals("INACTIVE")  ){
            seller.setStatus("ACTIVE");
        }else{
            seller.setStatus("INACTIVE");
        }
        this.userRepository.save(seller);
        return "redirect:/sellers";
    }

}
