package com.project.sessionmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "This is homepage";
    }

    @GetMapping("/first")
    public String first(){
        return "This is first page";
    }

}
