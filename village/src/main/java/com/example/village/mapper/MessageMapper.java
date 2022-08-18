package com.example.village.mapper;

import com.example.village.model.Customer;
import com.example.village.model.Message;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageMapper implements RowMapper<Message> {
    @Override
    public Message mapRow(ResultSet rs, int i) throws SQLException {
        Message message=new Message();
        message.setId(rs.getInt("message_id"));
        message.setCustomer(new Customer(rs.getInt("customer_id"),rs.getString("name"),
                rs.getString("surname"),rs.getString("age"),rs.getString("phone"),
                rs.getString("address"),rs.getString("email"),rs.getString("gender"),
                rs.getString("cus_photo"),rs.getString("password"),rs.getString("confirmPassword"),rs.getInt("cstatus")));
        message.setMessage(rs.getString("message"));
        message.setRead(rs.getInt("read"));
        message.setAnswer(rs.getString("answer"));
        message.setDate(rs.getString("date"));
        message.setStatus(rs.getInt("status"));
        return message;
    }
}
