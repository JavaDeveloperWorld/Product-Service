package com.example.village.mapper;

import com.example.village.model.ProductSubProduct;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductSubProductMapper implements RowMapper<ProductSubProduct> {
    @Override
    public ProductSubProduct mapRow(ResultSet rs, int i) throws SQLException {
        ProductSubProduct productSubProduct=new ProductSubProduct();
        productSubProduct.setProductName(rs.getString("pid"));
        productSubProduct.setSubName(rs.getString("sid"));
        return productSubProduct;
    }
}
