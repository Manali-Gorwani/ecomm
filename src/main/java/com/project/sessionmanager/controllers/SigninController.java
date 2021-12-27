package com.project.sessionmanager.controllers;

import com.project.sessionmanager.services.SigninService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class SigninController {

    @Autowired
    SigninService signinService;

    @GetMapping("")
    public String getfirstpage(){
        return this.signinService.firstpage();
    }


    @GetMapping("/signin")
    public String signin(){
        return this.signinService.signin();
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        return this.signinService.logoutPage(request, response, redirectAttributes);
    }

    @GetMapping("/registration")
    public String registration(){
        return this.signinService.registration();
    }

    @PostMapping("/doregistration")
    public String doregistration(HttpServletRequest req, RedirectAttributes redirectAttributes){
        return this.signinService.doregistration(req,redirectAttributes);
    }

}
