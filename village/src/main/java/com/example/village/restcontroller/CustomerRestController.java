package com.example.village.restcontroller;

import com.example.village.model.Balans;
import com.example.village.model.Customer;
import com.example.village.model.Subscribe;
import com.example.village.service.balans.BalansService;
import com.example.village.service.bonus.BonusService;
import com.example.village.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;



@RestController
public class CustomerRestController {
    private Balans balans=new Balans();
    private DateTimeFormatter fr=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime now=LocalDateTime.now();

    @Autowired
    CustomerService customerService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    BonusService bonusService;
    @Autowired
    BalansService balansService;

    @GetMapping("/adminActiveCustomer")
    public List<Customer> getAllActiveCustomer(){
        return customerService.getAllActiveCustomers();
    }

    @GetMapping("/adminDeactiveCustomer")
    public List<Customer> getAllDeactiveCustomer(){
        return customerService.getAllDeactiveCustomers();
    }
    @GetMapping("/adminCount")
    public int getAllCustomerCount(){
        return customerService.getCount();
    }
    @GetMapping("/adminNCount")
    public int getAllDeactiveCount(){
        return customerService.getNCount();
    }
    @PutMapping("/changeCustomerStatusRole")
    public void changeStatus(@RequestBody String[] id){
        if(id[1].equals("User")){
            id[1]="ROLE_USER";
        }else if(id[1].equals("Admin")){
            id[1]="ROLE_ADMIN";
        }
        Customer customer=new Customer();
        customer.setId(Integer.valueOf(id[0]));
        balans.setCustomer(customer);
        balans.setPayment(0);
        balans.setBalance(0);
        balans.setStatus(1);
        balans.setDate(fr.format(now));
        balansService.insertBalans(balans);
        customerService.changeStatusCustomer(Integer.valueOf(id[0]));
        customerService.changeRoleCustomer(Integer.valueOf(id[0]),id[1]);
        bonusService.insertBonus(Integer.valueOf(id[0]));
    }
    @PutMapping("/deleteCustomer")
    public void deleteCustomer(@RequestBody int id){
        customerService.deleteCustomer(id);
    }
    @PutMapping("/getListbyId")
    public List<Customer>getCustomerById(@RequestBody int id){
        return customerService.getListByID(id);
    }
    @GetMapping("/adminName")
    public List<Customer> customerDate(Principal principal){
        return customerService.getCustomerByEmail(principal.getName());
    }
    @PostMapping("/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomerWithoutPassword(customer);
    }
    @PostMapping("/updateCustomerByAdmin")
    public void updateCustomerByAdmin(@RequestBody Customer customer){
        customerService.updateUserSecret(customer);
        String password=passwordEncoder.encode(customer.getPassword());
        customer.setPassword(password);
        customer.setConfirmPassword(password);
        customerService.updateCustomer(customer);
    }
    @PostMapping("/insertSubscribe")
    public void insertCustomer(@RequestBody String  mail){
        Subscribe subscribe=new Subscribe();
        subscribe.setMail(mail);
        subscribe.setCheck((byte)0);

        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        subscribe.setDate(dtf.format(now));
        customerService.insertSubscribeMail(subscribe);
    }

    @Value("${app.file.storage.path}")
    private String fileBasePath;

    @PostMapping("/downloadFile")
    public void uploadPhoto(@RequestParam("file") MultipartFile imageFile,Principal principal){
        try {
            Random r = new Random();
            Customer customer=new Customer();
            customer.setEmail(principal.getName());
            byte[] bytes = imageFile.getBytes();
            String dataForCustomer=new Date().getTime()+"_"+r.nextInt()+"_"+imageFile.getOriginalFilename();
            customer.setPhoto(dataForCustomer);
            String filePath= fileBasePath +dataForCustomer;
            Files.write(Paths.get(filePath),bytes);
            customerService.updateCustomerPhoto(customer);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
