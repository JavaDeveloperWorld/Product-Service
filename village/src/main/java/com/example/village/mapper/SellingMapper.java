package com.example.village.mapper;

import com.example.village.model.Customer;
import com.example.village.model.Selling;
import com.example.village.model.SubProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SellingMapper implements RowMapper<Selling> {
    @Override
    public Selling mapRow(ResultSet rs, int i) throws SQLException {
        Selling selling=new Selling();
        selling.setId(rs.getInt("id"));
        selling.setCustomer(new Customer(rs.getInt("customer_id"),rs.getString("name"),
                rs.getString("surname"),rs.getString("age"),rs.getString("phone"),rs.getString("caddress"),
                rs.getString("email"),rs.getString("gender"),
                rs.getString("cus_photo"),rs.getString("password"),rs.getString("confirmPassword"),rs.getInt("cstatus")));

        selling.setSubProduct(new SubProduct(rs.getInt("sbproduct_id"),rs.getString("sbproduct_name"),
                rs.getString("description"),rs.getFloat("sbprice"),rs.getString("type"),
                rs.getString("sbphoto"),rs.getInt("status")));
        selling.setCount(rs.getFloat("count"));
        selling.setPrice(rs.getFloat("price"));
        selling.setSum_price(rs.getFloat("sum_price"));
        selling.setUnpaid(rs.getFloat("unpaid"));
        selling.setBonus(rs.getFloat("bonus"));
        selling.setAddress(rs.getString("saddress"));
        selling.setPhone(rs.getString("sphone"));
        selling.setDate(rs.getString("date"));
        selling.setStatus(rs.getInt("sstatus"));
        return selling;
    }
}
