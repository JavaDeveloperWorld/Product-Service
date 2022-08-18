package com.example.village.dao.customer;

import com.example.village.mapper.CustomerMapper;
import com.example.village.model.Customer;
import com.example.village.model.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertCustomer(Customer customer) {
        try {
            String sql = "insert into village.customer(name,surname,age,phone,photo,address,email,gender,password,confirmPassword,status) values(?,?,?,?,?,?,?,?,?,?,0)";
            jdbcTemplate.update(sql, customer.getName(), customer.getSurname(), customer.getAge(), customer.getPhone(),customer.getPhoto(),customer.getAddress(),
                    customer.getEmail(), customer.getGender(), customer.getPassword(), customer.getConfirmPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertUserSecret(Customer customer) {
        try {
            String sql = "insert into village.secretuser(user_mail,password,status) values(?,?,0)";
            jdbcTemplate.update(sql, customer.getEmail(),customer.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateUserSecret(Customer customer) {
        try {
            String sql = "update village.secretuser set password=? where user_mail=?";
            jdbcTemplate.update(sql,customer.getPassword(),customer.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertSubscribeMail(Subscribe subscribe) {
        try {
            String sql = "insert into village.subscribe(mail,check_customer,date,status) values(?,?,?,1)";
            jdbcTemplate.update(sql, subscribe.getMail(),subscribe.getCheck(),subscribe.getDate());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateCustomerPhoto(Customer customer) {
        try {
            String sql = "update village.customer set village.customer.photo=? where village.customer.email=?";
            jdbcTemplate.update(sql, customer.getPhoto(), customer.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateCustomer(Customer customer) {
        try {
            String sql = "update village.customer set village.customer.name=?,surname=?,age=?,phone=?,address=?,gender=?,password=?,confirmPassword=? where village.customer.email=?";
            jdbcTemplate.update(sql, customer.getName(), customer.getSurname(), customer.getAge(), customer.getPhone(),customer.getAddress(),
                    customer.getGender(),customer.getPassword(),customer.getConfirmPassword(), customer.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateCustomerWithoutPassword(Customer customer) {
        try {
            String sql = "update village.customer set village.customer.name=?,surname=?,age=?,phone=?,address=?,gender=? where village.customer.email=?";
            jdbcTemplate.update(sql, customer.getName(), customer.getSurname(), customer.getAge(), customer.getPhone(),customer.getAddress(),
                     customer.getGender(), customer.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Customer> getAllActiveCustomers(){
        String sql="select *,village.secretuser.password as cpassword,village.customer.status as cstatus from village.customer join village.secretuser on village.customer.email=village.secretuser.user_mail where village.customer.status=1";
        return jdbcTemplate.query(sql,new CustomerMapper());
    }
    public List<Customer>getAllDeactiveCustomers(){
        String sql="select *,village.secretuser.password as cpassword,village.customer.status as cstatus from village.customer join village.secretuser on village.customer.email=village.secretuser.user_mail where village.customer.status=0";
        return jdbcTemplate.query(sql,new CustomerMapper());
    }
    public List<Customer>getAllBlockedCustomers(){
        String sql="select *,village.secretuser.password as cpassword,village.customer.status as cstatus from village.customer join village.secretuser on village.customer.email=village.secretuser.user_mail where village.customer.status=2";
        return jdbcTemplate.query(sql,new CustomerMapper());
    }
    public int getCount(){
        return getAllActiveCustomers().size();
    }
    public int getNCount(){
        return getAllDeactiveCustomers().size();
    }
    public int getBlCount(){
        return getAllDeactiveCustomers().size();
    }

    public void changeStatusCustomer(int id){
        String sql="update village.customer set status=1 where id=?";
        jdbcTemplate.update(sql,id);
        changeStatusSecretCustomer(id);
    }
    private void changeStatusSecretCustomer(int id){
        String sql="update village.secretuser set status=1 where user_mail=(select email from village.customer where id=?)";
        jdbcTemplate.update(sql,id);
    }
    public void setCustomerBlock(int id){
        String sql="update village.customer set status=2 where id=?";
        jdbcTemplate.update(sql,id);
    }
    public void changeRoleCustomer(int id,String value){
        String sql="Insert into village.role(customer_email,name,status) values((select email from village.customer where id=?),?,?)";
        jdbcTemplate.update(sql,id,value,1);
    }
    public void deleteCustomer(int id){
        deleteCustomerSecret(id);
        String sql="delete from village.customer where id=?";
        jdbcTemplate.update(sql,id);
    }
    private void deleteCustomerSecret(int id){
        String sql="delete from village.secretuser where user_mail=(select email from village.customer where id=?)";
        jdbcTemplate.update(sql,id);
    }
    public List<Customer>getListByID(int id){
        String sql="select *,village.secretuser.password as cpassword,village.customer.status as cstatus from village.customer join village.secretuser on village.customer.email=village.secretuser.user_mail where village.customer.id=?";
        return jdbcTemplate.query(sql,new Object[]{id},new CustomerMapper());
    }
    public List<Customer>getCustomerByEmail(String  email){
        String sql="select *,village.customer.password as cpassword,village.customer.status as cstatus from village.customer where email=?";
        return jdbcTemplate.query(sql,new Object[]{email},new CustomerMapper());
    }


}
