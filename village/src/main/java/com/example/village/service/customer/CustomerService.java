package com.example.village.service.customer;

import com.example.village.model.Customer;
import com.example.village.model.Subscribe;

import java.util.List;

public interface CustomerService {
    public void insertCustomer(Customer customer);
    public List<Customer> getAllActiveCustomers();
    public List<Customer>getAllDeactiveCustomers();
    public int getCount();
    public int getNCount();
    public void changeStatusCustomer(int id);
    public void changeRoleCustomer(int id,String value);
    public void deleteCustomer(int id);
    public List<Customer>getListByID(int id);
    public List<Customer>getCustomerByEmail(String  email);
    public void updateCustomerWithoutPassword(Customer customer);
    public void insertUserSecret(Customer customer);
    public int getBlCount();
    public List<Customer>getAllBlockedCustomers();
    public void setCustomerBlock(int id);
    public void insertSubscribeMail(Subscribe subscribe);
    public void updateCustomerPhoto(Customer customer);
    public void updateUserSecret(Customer customer);
    public void updateCustomer(Customer customer);
}
