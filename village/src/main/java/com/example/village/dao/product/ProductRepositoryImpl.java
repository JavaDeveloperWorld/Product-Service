package com.example.village.dao.product;

import com.example.village.mapper.ProductMapper;
import com.example.village.mapper.ProductSubProductMapper;
import com.example.village.model.Product;
import com.example.village.model.ProductSubProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product>getAllList(){
        String sql="select * from village.product";
        return jdbcTemplate.query(sql,new ProductMapper());
    }
    public List<Product>getActiveList(){
        String sql="select * from village.product where status=1";
        return jdbcTemplate.query(sql,new ProductMapper());
    }
    public List<Product>getDeactiveList(){
        String sql="select * from village.product where status=0";
        return jdbcTemplate.query(sql,new ProductMapper());
    }
    public void insertProduct(Product product){
        String sql="insert into village.product(product_name,product_icon,description,status) values(?,?,?,?)";
        jdbcTemplate.update(sql,product.getName(),product.getPhoto(),product.getDescription(),product.getStatus());
    }
    public void updateProduct(Product product){
        String sql="update village.product set product_name=?,product_icon=?,description=?,status=? where id=?";
        jdbcTemplate.update(sql,product.getName(),product.getPhoto(),product.getDescription(),product.getStatus(),product.getId());
    }
    public List<Product>getProductById(int id){
        String sql="select * from village.product where id=?";
        return jdbcTemplate.query(sql,new Object[]{id},new ProductMapper());
    }
    public List<ProductSubProduct>getAllProductSub(){
        String sql="select p.product_name as pid,sb.sbproduct_name as sid from village.product as p " +
                "join village.product_sub as ps on p.id=ps.product_id " +
                "join village.subproduct as sb on ps.sub_product=sb.id";
        return jdbcTemplate.query(sql,new ProductSubProductMapper());
    }
}
