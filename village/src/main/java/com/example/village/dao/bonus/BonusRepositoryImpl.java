package com.example.village.dao.bonus;

import com.example.village.mapper.BonusMapper;
import com.example.village.model.Bonus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BonusRepositoryImpl implements BonusRepository {
    private List<Bonus>personBonus=new ArrayList<>();

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Bonus>getAllList(){
        String sql="select *,c.status as cstatus,c.photo as cus_photo,b.status as bstatus,b.id as bid from village.bonus as b join customer as c on b.customer_id=c.id";
        return jdbcTemplate.query(sql,new BonusMapper());
    }
    public List<Bonus>getTopStar(){
        String sql="select *,c.status as cstatus,c.photo as cus_photo,b.status as bstatus,b.id as bid from village.bonus as b join customer as c on b.customer_id=c.id where b.position=?";
        return jdbcTemplate.query(sql,new Object[]{"top"},new BonusMapper());
    }
    public List<Bonus>getBigStar(){
        String sql="select *,c.status as cstatus,c.photo as cus_photo,b.status as bstatus,b.id as bid from village.bonus as b join customer as c on b.customer_id=c.id where b.position=?";
        return jdbcTemplate.query(sql,new Object[]{"big"},new BonusMapper());
    }
    public List<Bonus>getMiddleStar(){
        String sql="select *,c.status as cstatus,c.photo as cus_photo,b.status as bstatus,b.id as bid from village.bonus as b join customer as c on b.customer_id=c.id where b.position=?";
        return jdbcTemplate.query(sql,new Object[]{"middle"},new BonusMapper());
    }
    public List<Bonus>getNewStar(){
        String sql="select *,c.status as cstatus,c.photo as cus_photo,b.status as bstatus,b.id as bid from village.bonus as b join customer as c on b.customer_id=c.id where b.position=?";
        return jdbcTemplate.query(sql,new Object[]{"new"},new BonusMapper());
    }
    public List<Bonus> userBalance(String mail){
        String sql="select *,c.status as cstatus,c.photo as cus_photo,b.status as bstatus,b.id as bid from village.bonus as b join customer as c on b.customer_id=c.id where c.email=?";
        return jdbcTemplate.query(sql,new Object[]{mail},new BonusMapper());
    }
    public List<Bonus> userAdminBalance(int id){
        String sql="select *,c.status as cstatus,c.photo as cus_photo,b.status as bstatus,b.id as bid from village.bonus as b join customer as c on b.customer_id=c.id where b.customer_id=?";
        return jdbcTemplate.query(sql,new Object[]{id},new BonusMapper());
    }
    public void insertBonus(int id){
        String sql="insert into village.bonus(customer_id,bonus,position,status) values(?,0,?,1)";
         jdbcTemplate.update(sql,id,"simple");
    }
    public void updateBonus(int id,float bonus){
        String sql="update village.bonus set bonus=?,position=?,status=1 where customer_id=?";
        jdbcTemplate.update(sql,bonus,"simple",id);
    }
}
