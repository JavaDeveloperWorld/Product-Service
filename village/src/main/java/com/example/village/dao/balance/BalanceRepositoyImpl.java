package com.example.village.dao.balance;

import com.example.village.mapper.BalansMapper;
import com.example.village.mapper.SellingMapper;
import com.example.village.model.Balans;
import com.example.village.model.Selling;
import com.example.village.model.UserTableSum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BalanceRepositoyImpl implements BalanceRepositoy {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public float takeBalance(int customer_id){
        float balans=0;
        String sql="SELECT *, b.id as bid,b.status as bstatus,c.status as cstatus, c.address as caddress,c.photo as cus_photo FROM village.balans as b join village.customer  as c on b.customer_id=c.id where b.customer_id=? order by b.id desc limit 1";
        List<Balans>list=jdbcTemplate.query(sql,new Object[]{customer_id},new BalansMapper());
        balans=list.get(0).getBalance();
        return balans;
    }
    public float takeBalanceWithMail(String mail){
        float balans=0;
        String sql="SELECT *, b.id as bid,b.status as bstatus,c.status as cstatus, c.address as caddress,c.photo as cus_photo FROM village.balans as b join village.customer  as c on b.customer_id=c.id where c.email=? order by b.id desc limit 1";
        List<Balans>list=jdbcTemplate.query(sql,new Object[]{mail},new BalansMapper());
        balans=list.get(0).getBalance();
        return balans;
    }
    public void insertBalans(Balans balans){
        String sql="insert into village.balans(customer_id,payment,balance,date,status) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,balans.getCustomer().getId(),balans.getPayment(),balans.getBalance(),balans.getDate(),balans.getStatus());
    }
    public List<Balans> allBalance(){
        String sql="select *,b.id as bid,b.status as bstatus,c.address as caddress,c.photo as cus_photo,c.status as cstatus from village.balans as b join village.customer as c on b.customer_id=c.id where b.status=1 order by b.date desc";
        return jdbcTemplate.query(sql,new BalansMapper());
    }
    public List<Balans> userBalance(String mail,int limit,int offset){
        String sql="select *,b.id as bid,b.status as bstatus,c.address as caddress,c.photo as cus_photo,c.status as cstatus from village.balans as b join village.customer as c on b.customer_id=c.id where b.status=1 and c.email=? order by b.date desc limit ? offset ?";
        return jdbcTemplate.query(sql,new Object[]{mail,limit,offset},new BalansMapper());
    }
    public List<Balans> adminUserBalance(int id,int limit,int offset){
        String sql="select *,b.id as bid,b.status as bstatus,c.address as caddress,c.photo as cus_photo,c.status as cstatus from village.balans as b join village.customer as c on b.customer_id=c.id where b.status=1 and b.customer_id=? order by b.date desc limit ? offset ?";
        return jdbcTemplate.query(sql,new Object[]{id,limit,offset},new BalansMapper());
    }
    public List<UserTableSum> userSellingCounts(String  email){
        String sql="select sum(sum_price) as sumpri,sum(sum_price-unpaid) as sumpay,sum(unpaid) as sumunpay from village.selling join village.customer on village.selling.customer_id=village.customer.id where village.customer.email=?";
        return jdbcTemplate.query(sql,new Object[]{email},(rs,num)->new UserTableSum(rs.getFloat("sumpri"),rs.getFloat("sumpay"),rs.getFloat("sumunpay")));
    }
}
