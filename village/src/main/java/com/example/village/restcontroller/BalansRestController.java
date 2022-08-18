package com.example.village.restcontroller;

import com.example.village.model.Balans;
import com.example.village.model.UserTableSum;
import com.example.village.service.balans.BalansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class BalansRestController {
    @Autowired
    BalansService balansService;

    @GetMapping("/customerBalans")
    public float customerBalans(Principal principal){
        return balansService.takeBalanceWithMail(principal.getName());
    }
    @GetMapping("/userBalans")
    public List<Balans> userBalans(Principal principal, @RequestParam( name= "limit", required = false) Integer limit, @RequestParam(name = "offset", required = false) Integer offset){
        return balansService.userBalance(principal.getName(),limit,offset);
    }
    @GetMapping("/userSellingData")
    public List<UserTableSum> userBalans(Principal principal){
        return balansService.userSellingCounts(principal.getName());
    }
}
