package com.example.village.dao.message;

import com.example.village.mapper.MessageMapper;
import com.example.village.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageRepositoryImpl implements MessageRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insertMessage(Message message){
        String sql="insert into village.message(customer_id,message,answer,village.message.read,village.message.date,status) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,message.getCustomer().getId(),message.getMessage(),message.getAnswer(),message.getRead(),message.getDate(),message.getStatus());
    }
    public void answerMessage(Message message){
        String sql="update village.message set answer=?,village.message.read=1,village.message.date=? where id=?";
        jdbcTemplate.update(sql,message.getAnswer(),message.getDate(),message.getId());
    }
    public List<Message>getUserMessage(String email,int limit,int offset){
        String sql="select *,c.status as cstatus,m.id as message_id,c.photo as cus_photo from village.message as m join village.customer as c on m.customer_id=c.id where c.email=? order by m.date asc limit ? offset ?";
        return jdbcTemplate.query(sql,new Object[]{email,limit,offset},new MessageMapper());
    }
    public List<Message>getUserLastMessage(String email){
        String sql="select *,c.status as cstatus,m.id as message_id,c.photo as cus_photo from village.message as m join village.customer as c on m.customer_id=c.id where c.email=? and m.date=(select max(village.message.date) from village.message)";
        return jdbcTemplate.query(sql,new Object[]{email},new MessageMapper());
    }
    public List<Message>getAllList(){
        String sql="select *,village.customer.status as cstatus,village.message.id as message_id,village.customer.photo as cus_photo from village.message join village.customer on village.message.customer_id=village.customer.id";
        return jdbcTemplate.query(sql,new MessageMapper());
    }
    public List<Message>getAllUnreadList(){
        String sql="select *,village.customer.status as cstatus,village.message.id as message_id,village.customer.photo as cus_photo from village.message join village.customer on village.message.customer_id=village.customer.id where village.message.read=0";
        return jdbcTemplate.query(sql,new MessageMapper());
    }
}
