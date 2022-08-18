package com.example.village.dao.maxsell;

import com.example.village.mapper.MaxSellMapper;
import com.example.village.model.MaxSell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaxSellRepositoryImpl implements MaxSellRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MaxSell> getAllMaxSell(){
        String sql="SELECT *,ms.id as max_id,sp.id as sp_id FROM village.max_sell as ms " +
                "join village.subproduct as sp on ms.sbproduct_id=sp.id where ms.status=1 order by ms.max_count";
        return jdbcTemplate.query(sql,new MaxSellMapper());
    }
    public List<MaxSell> getMaxSellByProductId(int id){
        String sql="SELECT *,ms.id as max_id,sp.id as sp_id FROM village.max_sell as ms " +
                "join village.subproduct as sp on ms.sbproduct_id=sp.id where ms.status=1 and sp.id=? order by ms.max_count";
        return jdbcTemplate.query(sql,new Object[]{id},new MaxSellMapper());
    }
    public void insertMaxSell(MaxSell maxSell){
        String sql="insert into village.max_sell (sbproduct_id,max_count,status) values(?,?,1)";
         jdbcTemplate.update(sql,maxSell.getSubProduct().getId(),maxSell.getMaxCount());
    }
    public void updateMaxSell(MaxSell maxSell){
        String sql="update village.max_sell set max_count=? where sbproduct_id=?";
        jdbcTemplate.update(sql,maxSell.getMaxCount(),maxSell.getSubProduct().getId());
    }
}
