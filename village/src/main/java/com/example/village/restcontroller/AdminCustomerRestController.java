package com.example.village.restcontroller;

import com.example.village.model.Balans;
import com.example.village.model.Customer;
import com.example.village.model.Selling;
import com.example.village.service.balans.BalansService;
import com.example.village.service.customer.CustomerService;
import com.example.village.service.selling.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminCustomerRestController {
    @Autowired
    SellService sellService;
    @Autowired
    CustomerService customerService;
    @Autowired
    BalansService balansService;

    @PutMapping("/lookCustomerSelling")
    public List<Selling>getCustomerSell(@RequestBody int id){
        return sellService.getSellingByCustomerId(id);
    }
    @GetMapping("/adminBlCount")
    public int getBlockedCustomers(){
        return customerService.getBlCount();
    }
    @GetMapping("/adminBlockedCustomer")
    public List<Customer> getAllActiveCustomer(){
        return customerService.getAllBlockedCustomers();
    }
    @GetMapping("/adminUserBalance")
    public List<Balans> adminUserBalance(@RequestParam( name= "id", required = false) Integer id,@RequestParam( name= "limit", required = false) Integer limit, @RequestParam(name = "offset", required = false) Integer offset){
        return balansService.adminUserBalance(id,limit,offset);
    }
    @PostMapping("/setBlockCustomer")
    public void setCustomerBlock(@RequestBody int id){
         customerService.setCustomerBlock(id);
    }
    @PostMapping("/setUnlockCustomer")
    public void setUnlockCustomer(@RequestBody int id){
        customerService.changeStatusCustomer(id);
    }
}
