package com.example.village.mapper;

import com.example.village.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int i) throws SQLException {
        Customer customer=new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setSurname(rs.getString("surname"));
        customer.setPhone(rs.getString("phone"));
        customer.setAddress(rs.getString("address"));
        customer.setAge(rs.getString("age"));
        customer.setEmail(rs.getString("email"));
        customer.setGender(rs.getString("gender"));
        customer.setPhoto(rs.getString("photo"));
        customer.setPassword(rs.getString("cpassword"));
        customer.setConfirmPassword(rs.getString("confirmPassword"));
        customer.setStatus(rs.getInt("cstatus"));
        return customer;
    }
}
