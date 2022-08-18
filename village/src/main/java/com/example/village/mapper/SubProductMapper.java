package com.example.village.mapper;

import com.example.village.model.SubProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubProductMapper implements RowMapper<SubProduct> {

    @Override
    public SubProduct mapRow(ResultSet rs, int i) throws SQLException {
        SubProduct subProduct=new SubProduct();
        subProduct.setId(rs.getInt("id"));
        subProduct.setName(rs.getString("sbproduct_name"));
        subProduct.setDescription(rs.getString("description"));
        subProduct.setPrice(rs.getFloat("price"));
        subProduct.setType(rs.getString("type"));
        subProduct.setPhoto(rs.getString("photo"));
        subProduct.setStatus(rs.getInt("status"));
        return subProduct;
    }
}
