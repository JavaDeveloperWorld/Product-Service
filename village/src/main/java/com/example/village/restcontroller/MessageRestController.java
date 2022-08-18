package com.example.village.restcontroller;

import com.example.village.model.Customer;
import com.example.village.model.Message;
import com.example.village.service.customer.CustomerService;
import com.example.village.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class MessageRestController {
    private DateTimeFormatter fr=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime now=LocalDateTime.now();

    @Autowired
    CustomerService customerService;
    @Autowired
    MessageService messageService;

    @PutMapping("/writeCEO")
    public String writeMessage(@RequestBody String  value, Principal principal){
        List<Message>getUserLastMessage=messageService.getUserLastMessage(principal.getName());
        if(getUserLastMessage.isEmpty() || (!getUserLastMessage.get(0).getAnswer().equals(""))){
            Message message=new Message();
            message.setMessage(value);
            message.setRead(0);
            message.setAnswer("");
            message.setStatus(1);
            message.setDate(fr.format(now));
            Customer customer=customerService.getCustomerByEmail(principal.getName()).get(0);
            message.setCustomer(customer);
            messageService.insertMessage(message);
            return "ok";
        }else{
            return "no";
        }

    }
    @PostMapping("/writeAnswer")
    public void writeAnswer(@RequestBody List<String> list){
        Message message=new Message();
        message.setId(Integer.valueOf(list.get(0)));
        message.setAnswer(list.get(1));
        message.setDate(fr.format(now));
        messageService.answerMessage(message);
    }
    @GetMapping("/getMessage")
    public List<Message>getUserMessage(Principal principal,@RequestParam(name="limit", required=false) Integer limit,@RequestParam(name="offset", required = false) Integer offset){
        return messageService.getUserMessage(principal.getName(),limit,offset);
    }
    @GetMapping("/getAllMessage")
    public List<Message>getAllMessage(){
        return messageService.getAllList();
    }
    @GetMapping("/getAllUnreadMessage")
    public List<Message>getAllUnreadMessage(){
        return messageService.getAllUnreadList();
    }
    @GetMapping("/getAllUnreadMessageCount")
    public int getAllUnreadMessageCount(){
        return messageService.getAllUnreadList().size();
    }
}
