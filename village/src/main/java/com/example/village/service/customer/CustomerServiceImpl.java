package com.example.village.service.customer;

import com.example.village.dao.customer.CustomerRepository;
import com.example.village.model.Customer;
import com.example.village.model.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public void insertCustomer(Customer customer){
        customerRepository.insertCustomer(customer);
    }
    public List<Customer> getAllActiveCustomers(){
        return customerRepository.getAllActiveCustomers();
    }
    public List<Customer>getAllDeactiveCustomers(){
        return customerRepository.getAllDeactiveCustomers();
    }
    public int getCount(){
        return customerRepository.getCount();
    }
    public int getNCount(){
        return customerRepository.getNCount();
    }
    public void changeStatusCustomer(int id){
        customerRepository.changeStatusCustomer(id);
    }
    public void changeRoleCustomer(int id,String value){
        customerRepository.changeRoleCustomer(id, value);
    }
    public void deleteCustomer(int id){
        customerRepository.deleteCustomer(id);
    }
    public List<Customer>getListByID(int id){
       return   customerRepository.getListByID(id);
    }
    public List<Customer>getCustomerByEmail(String  email){
        return customerRepository.getCustomerByEmail(email);
    }
    public void updateCustomerWithoutPassword(Customer customer){
        customerRepository.updateCustomerWithoutPassword(customer);
    }
    public void insertUserSecret(Customer customer){
        customerRepository.insertUserSecret(customer);
    }
    public int getBlCount(){return customerRepository.getBlCount();}
    public List<Customer>getAllBlockedCustomers(){
        return customerRepository.getAllBlockedCustomers();
    }
    public void setCustomerBlock(int id){
        customerRepository.setCustomerBlock(id);
    }
    public void insertSubscribeMail(Subscribe subscribe){customerRepository.insertSubscribeMail(subscribe);}
    public void updateCustomerPhoto(Customer customer){customerRepository.updateCustomerPhoto(customer);}
    public void updateUserSecret(Customer customer){customerRepository.updateUserSecret(customer);}
    public void updateCustomer(Customer customer){customerRepository.updateCustomer(customer);}
}
