package com.project.sessionmanager.controllers;

import com.project.sessionmanager.models.CustomerUserDetails;
import com.project.sessionmanager.models.User;
import com.project.sessionmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;


@Controller
public class SigninController {

    @GetMapping("/signin")
    public String signin(){
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/doregistration")
    public String doregistration(HttpServletRequest req, Model m){
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String emailid=req.getParameter("emailid");
        System.out.println(username + " " + password + " "+ emailid);

        if(username.length() < 4 || password.length() < 4){
            String msg="ERROR MSG";
            m.addAttribute("message", msg);
            return "error1";
        }

        User u = this.userRepository.findByUsername(username);
        System.out.println(u);
        if(u!=null){
            return "usernamemismatch";
        }
        /*if(username.length() < 4){
            String msg="Username length should be greater than 4";
            m.addAttribute("message", msg);
            return "error";
        }
        if(password.length() < 4){
            String msg="Password length should be greater than 4";
            m.addAttribute("message", msg);
            return "error";
        }
        if(u!=null){
            String msg="please try another username";
            m.addAttribute("message", msg);
            return "error";
        }
        */

        User user = new User(username,this.bCryptPasswordEncoder.encode(password),emailid, "ROLE_NORMAL");
        this.userRepository.save(user);
        return "registrationsuccess";
    }
}
