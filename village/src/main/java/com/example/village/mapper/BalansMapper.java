package com.example.village.mapper;

import com.example.village.model.Balans;
import com.example.village.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BalansMapper implements RowMapper<Balans> {

    @Override
    public Balans mapRow(ResultSet rs, int i) throws SQLException {
        Balans balans=new Balans();
        balans.setId(rs.getInt("bid"));
        balans.setCustomer(new Customer(rs.getInt("customer_id"),rs.getString("name"),
                rs.getString("surname"),rs.getString("age"),rs.getString("phone"),rs.getString("caddress"),
                rs.getString("email"),rs.getString("gender"),
                rs.getString("cus_photo"),rs.getString("password"),rs.getString("confirmPassword"),rs.getInt("cstatus")));
        balans.setPayment(rs.getFloat("payment"));
        balans.setBalance(rs.getFloat("balance"));
        balans.setDate(rs.getString("date"));
        balans.setStatus(rs.getInt("bstatus"));
        return balans;
    }
}
