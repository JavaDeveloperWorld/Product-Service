package com.example.village.mapper;

import com.example.village.model.Store;
import com.example.village.model.SubProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StoreMapper implements RowMapper<Store> {
    @Override
    public Store mapRow(ResultSet rs, int i) throws SQLException {
        Store store=new Store();
        store.setId(rs.getInt("id"));
        store.setSubProduct(new SubProduct(rs.getInt("sbid"),rs.getString("sbproduct_name"),rs.getString("description"),
                rs.getFloat("price"),rs.getString("type"),rs.getString("photo"),rs.getInt("status")));
        store.setCount(rs.getFloat("count"));
        store.setMaxCount(rs.getFloat("maxCount"));
        store.setMinCount(rs.getFloat("minCount"));
        store.setStatus(rs.getInt("dstatus"));
        return store;
    }
}
