package com.example.village.dao.store;

import com.example.village.mapper.StoreMapper;
import com.example.village.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StoreRepositoryImpl implements StoreRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void updateStoreBySubId(Store store){
        String sql="update village.store set count=? where sbproduct_id=?";
        jdbcTemplate.update(sql,store.getCount(),store.getSubProduct().getId());
    }
    public void updateStoreById(int id,float count){
        String sql="update village.store set count=? where id=?";
        jdbcTemplate.update(sql,count,id);
    }
    public void insertStore(Store store){
        String sql="insert into village.store(sbproduct_id,count,maxCount,minCount,status) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,store.getSubProduct().getId(),store.getCount(),store.getMaxCount(),store.getMinCount(),store.getStatus());
    }
    public void deleteStore(int id){
        String sql="delete from village.store where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
    }
    public List<Store>getAllActiveList(){
        String sql="select *,village.store.status as dstatus,village.subproduct.id as sbid from village.store " +
                "join village.subproduct on village.store.sbproduct_id=village.subproduct.id where village.store.status=1";
        return jdbcTemplate.query(sql,new StoreMapper());
    }
    public List<Store>getMinActiveList(){
        String sql="select *,village.store.status as dstatus,village.subproduct.id as sbid from village.store " +
                "join village.subproduct on village.store.sbproduct_id=village.subproduct.id where village.store.status=1 and village.store.count<=village.store.minCount";
        return jdbcTemplate.query(sql,new StoreMapper());
    }
    public List<Store>getActiveListBySubProductId(int id){
        String sql="select *,village.store.status as dstatus,village.subproduct.id as sbid from village.store " +
                "join village.subproduct on village.store.sbproduct_id=village.subproduct.id where village.store.status=1 and village.store.sbproduct_id=?";
        return jdbcTemplate.query(sql,new Object[]{id},new StoreMapper());
    }
}
