package com.example.village.mapper;

import com.example.village.model.Bonus;
import com.example.village.model.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BonusMapper implements RowMapper<Bonus> {
    @Override
    public Bonus mapRow(ResultSet rs, int i) throws SQLException {
        Bonus bonus=new Bonus();
        bonus.setId(rs.getInt("bid"));
        bonus.setCustomer(new Customer(rs.getInt("customer_id"),rs.getString("name"),
                rs.getString("surname"),rs.getString("age"),rs.getString("phone"),
                rs.getString("address"),rs.getString("email"),rs.getString("gender"),
                rs.getString("cus_photo"),rs.getString("password"),rs.getString("confirmPassword"),rs.getInt("cstatus")));
        bonus.setBonus(rs.getFloat("bonus"));
        bonus.setPosition(rs.getString("position"));
        bonus.setStatus(rs.getInt("bstatus"));
        return bonus;
    }
}
