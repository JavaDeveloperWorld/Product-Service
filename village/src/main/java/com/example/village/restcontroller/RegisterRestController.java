package com.example.village.restcontroller;

import com.example.village.model.Customer;
import com.example.village.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterRestController {
    @Autowired
    CustomerService customerService;
    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping("/registerSuccess")
    public void insertCustomer(@RequestBody Customer customer){
        customerService.insertUserSecret(customer);
        String photoWay;
        if(customer.getGender().equals("Qadın"))
        {
            photoWay="emptyPersonLady.png";
        }else {
            photoWay="emptyPerson.png";
        }
        String encodedPassword=passwordEncoder.encode(customer.getPassword());
        customer.setPhoto(photoWay);
        customer.setPassword(encodedPassword);
        customer.setConfirmPassword(encodedPassword);
        customerService.insertCustomer(customer);
    }
}
