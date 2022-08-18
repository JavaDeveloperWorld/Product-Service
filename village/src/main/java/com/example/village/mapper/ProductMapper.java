package com.example.village.mapper;

import com.example.village.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        Product product=new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("product_name"));
        product.setPhoto(rs.getString("product_icon"));
        product.setDescription(rs.getString("description"));
        product.setStatus(rs.getInt("status"));
        return product;
    }
}
