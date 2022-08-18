package com.example.village.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String getHome(){
        return "index";
    }
    @RequestMapping("/details")
    public String details(){
        return "details";
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/forgotpassword")
    public String forgotpassword(){
        return "forgotpassword";
    }

    @RequestMapping("/adminView")
    public String adminView(){
        return "adminView";
    }
    @RequestMapping("/adminProduct")
    public String adminProduct(){
        return "adminProduct";
    }
    @RequestMapping("/adminSubProduct")
    public String adminSubProduct(){
        return "adminSubProduct";
    }
    @RequestMapping("/adminOrders")
    public String adminOrders(){
        return "adminOrders";
    }
    @RequestMapping("/adminStore")
    public String adminStore(){
        return "adminStore";
    }
    @RequestMapping("/adminMessage")
    public String adminMessage(){
        return "adminMessage";
    }
    @RequestMapping("/adminCustomer")
    public String adminCustomer(){
        return "adminCustomer";
    }

    @RequestMapping("/userDashboard")
    public String userDashboard(){
        return "userDashboard";
    }
    @RequestMapping("/userTable")
    public String userTable(){
        return "userTable";
    }
    @RequestMapping("/userView")
    public String userView(){
        return "userView";
    }
    @RequestMapping("/userBalance")
    public String userBalance(){
        return "userBalance";
    }
    @RequestMapping("/userMessage")
    public String userMessage(){
        return "userMessage";
    }
}
