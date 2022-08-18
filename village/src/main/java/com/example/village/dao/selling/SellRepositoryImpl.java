package com.example.village.dao.selling;

import com.example.village.mapper.SellingMapper;
import com.example.village.model.Selling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SellRepositoryImpl implements SellRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Selling>getSellingByCustomerId(int id){
        String sql="select *,s.status as sstatus,c.status as cstatus,sp.price as sbprice,sp.photo as sbphoto,s.phone as sphone,s.address as saddress,c.address as caddress,c.photo as cus_photo from village.selling as s join village.subproduct as sp on s.sbproduct_id=sp.id " +
                "join village.customer as c on s.customer_id=c.id where (s.status=1 or s.status=2) and c.id=?";
        return jdbcTemplate.query(sql,new Object[]{id},new SellingMapper());
    }
    public List<Selling>getUnreadySell(String email){
        String sql="select *,s.status as sstatus,c.status as cstatus,sp.price as sbprice,sp.photo as sbphoto,s.phone as sphone,s.address as saddress,c.address as caddress,c.photo as cus_photo from village.selling as s join village.subproduct as sp on s.sbproduct_id=sp.id " +
                "join village.customer as c on s.customer_id=c.id where s.status=2 and c.email=?";
        return jdbcTemplate.query(sql,new Object[]{email},new SellingMapper());
    }
    public List<Selling>getAllSell(String email, int limit , int offset){
        String sql="select *,s.status as sstatus,c.status as cstatus,sp.price as sbprice,sp.photo as sbphoto,s.phone as sphone,s.address as saddress,c.address as caddress,c.photo as cus_photo from village.selling as s join village.subproduct as sp on s.sbproduct_id=sp.id " +
                "join village.customer as c on s.customer_id=c.id where (s.status=2 or s.status=1) and c.email=? limit ? offset ?";
        return jdbcTemplate.query(sql,new Object[]{email, limit, offset },new SellingMapper());
    }
    public List<Selling>getAdminUnreadySell(String email){
        String sql="select *,s.status as sstatus,c.status as cstatus,sp.price as sbprice,sp.photo as sbphoto,s.phone as sphone,s.address as saddress,c.address as caddress,c.photo as cus_photo from village.selling as s join village.subproduct as sp on s.sbproduct_id=sp.id " +
                "join village.customer as c on s.customer_id=c.id where s.status=2 and c.email<>?";
        return jdbcTemplate.query(sql,new Object[]{email},new SellingMapper());
    }
    public List<Selling>getAllUnreadySell(){
        String sql="select *,s.status as sstatus,c.status as cstatus,sp.price as sbprice,sp.photo as sbphoto,s.phone as sphone,s.address as saddress,c.address as caddress,c.photo as cus_photo from village.selling as s join village.subproduct as sp on s.sbproduct_id=sp.id " +
                "join village.customer as c on s.customer_id=c.id where s.status=2";
        return jdbcTemplate.query(sql,new SellingMapper());
    }
    public List<Selling>getReadySell(String email){
        String sql="select *,s.status as sstatus,c.status as cstatus,sp.price as sbprice,sp.photo as sbphoto,s.phone as sphone,s.address as saddress,c.address as caddress,c.photo as cus_photo from village.selling as s join village.subproduct as sp on s.sbproduct_id=sp.id " +
                "join village.customer as c on s.customer_id=c.id where s.status=1 and c.email<>?";
        return jdbcTemplate.query(sql,new Object[]{email},new SellingMapper());
    }
    public List<Selling>getAllReadySell(){
        String sql="select *,s.status as sstatus,c.status as cstatus,sp.price as sbprice,sp.photo as sbphoto,s.phone as sphone,s.address as saddress,c.address as caddress,c.photo as cus_photo from village.selling as s join village.subproduct as sp on s.sbproduct_id=sp.id " +
                "join village.customer as c on s.customer_id=c.id where s.status=1";
        return jdbcTemplate.query(sql,new SellingMapper());
    }
    public float getBalans(String email){
        String sql="select sum(unpaid) from village.selling where customer_id=(select id from village.customer where email=?) and status=1";
        float balans;
        if(jdbcTemplate.queryForObject(sql,new Object[]{email},Float.class)!=null){
            balans=jdbcTemplate.queryForObject(sql,new Object[]{email},Float.class);
        }else {
            balans=0;
        }
        balans=0-balans;
        return balans;
    }
    public int countSubProduct(String email){
        String sql="select count(sbproduct_id) from village.selling where customer_id=(select id from village.customer where email=?) and status=1";
        int count=jdbcTemplate.queryForObject(sql,new Object[]{email},Integer.class);
        return count;
    }
    public int countUnusedSubProduct(String email){
        String sql="select count(sbproduct_id) from village.selling where customer_id=(select id from village.customer where email=?) and status=2";
        int count=jdbcTemplate.queryForObject(sql,new Object[]{email},Integer.class);
        return count;
    }
    public float sumBonus(String email){
        String sql="select sum(bonus) from village.selling where customer_id=(select id from village.customer where email=?) and status=1";
        float bonus;
        if((jdbcTemplate.queryForObject(sql,new Object[]{email},Float.class))!=null){
             bonus=jdbcTemplate.queryForObject(sql,new Object[]{email},Float.class);
        }else {
            bonus=0;
        }
        return bonus;
    }
    public void insertSell(Selling selling){
        String sql="insert into village.selling(customer_id,sbproduct_id,count,price,sum_price,unpaid,bonus,address,phone,date,status) " +
                "values(?,?,?,?,?,?,?,?,?,?,2)";
        jdbcTemplate.update(sql,selling.getCustomer().getId(),selling.getSubProduct().getId(),selling.getCount(),selling.getPrice(),selling.getSum_price(),
                selling.getUnpaid(),selling.getBonus(),selling.getAddress(),selling.getPhone(),selling.getDate());
    }
    public void deleteOrder(int id){
        String sql="delete from village.selling where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
    }
    public void updateOrder(float unpaid,int id){
        String sql="update village.selling set unpaid=? where id=?";
        jdbcTemplate.update(sql,new Object[]{unpaid,id});
    }
    public void confirmOrder(int id){
        String sql="update village.selling set status=1 where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
    }
}
