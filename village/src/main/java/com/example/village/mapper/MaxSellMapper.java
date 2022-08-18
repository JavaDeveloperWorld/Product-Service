package com.example.village.mapper;

import com.example.village.model.MaxSell;
import com.example.village.model.SubProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MaxSellMapper implements RowMapper<MaxSell> {
    @Override
    public MaxSell mapRow(ResultSet rs, int i) throws SQLException {
        MaxSell maxSell=new MaxSell();
        maxSell.setId(rs.getInt("max_id"));
        maxSell.setSubProduct(new SubProduct(rs.getInt("sp_id"),rs.getString("sbproduct_name"),
                rs.getString("description"),rs.getFloat("price"),rs.getString("type"),
                rs.getString("photo"),rs.getInt("status")));
        maxSell.setMaxCount(rs.getInt("max_count"));
        return maxSell;
    }
}
