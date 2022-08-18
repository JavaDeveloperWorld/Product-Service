package com.example.village.dao.subproduct;

import com.example.village.mapper.SubProductMapper;
import com.example.village.model.SubProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubProductRepositoryImpl implements SubProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<SubProduct> getSelectedSubProduct(int id){
        String sql="select sp.* from village.subproduct as sp join village.product_sub as pjs on sp.id=pjs.sub_product join village.product as p on pjs.product_id=p.id where pjs.status=1 and p.id="+id;
        return jdbcTemplate.query(sql,new SubProductMapper());
    }
    public List<SubProduct> getSubProductById(int id){
        String sql="select * from village.subproduct where id=?";
        return jdbcTemplate.query(sql,new Object[]{id},new SubProductMapper());
    }
    public List<SubProduct> getActiveSubProduct(){
        String sql="select * from village.subproduct where status=1";
        return jdbcTemplate.query(sql,new SubProductMapper());
    }
    public List<SubProduct>getActiveListFromStockByProductname(String name){
        String sql="select village.subproduct.* from village.subproduct join village.store on village.subproduct.id=village.store.sbproduct_id " +
                "join village.product_sub on village.subproduct.id=village.product_sub.sub_product " +
                "join village.product on village.product_sub.product_id=village.product.id" +
                " where village.subproduct.status=1 and village.store.count>0 and village.product.product_name='"+name+"'";
        return jdbcTemplate.query(sql,new SubProductMapper());
    }
    public List<SubProduct> getDeactiveSubProduct(){
        String sql="select * from village.subproduct where status=0";
        return jdbcTemplate.query(sql,new SubProductMapper());
    }
    public List<SubProduct> getAllSubProduct(){
        String sql="select * from village.subproduct";
        return jdbcTemplate.query(sql,new SubProductMapper());
    }
    public List<SubProduct>getAllNonConnectionSubproduct(){
        String sql="select * from village.subproduct where status=2";
        return jdbcTemplate.query(sql,new SubProductMapper());
    }
    public void updateSubProduct(SubProduct subProduct){
        String sql="update village.subproduct set sbproduct_name=?, description=?,price=?,type=?,photo=?,status=? where id=?";
         jdbcTemplate.update(sql,subProduct.getName(),subProduct.getDescription(),subProduct.getPrice(),subProduct.getType(),
                subProduct.getPhoto(),subProduct.getStatus(),subProduct.getId());
    }
    public void updateSubProductStatus(int id){
        String sql="update subproduct set status=1 where id=?";
        jdbcTemplate.update(sql,id);
    }
    public void insertSubProduct(SubProduct subProduct){
        String sql="insert into village.subproduct(sbproduct_name, description,price,type,photo,status) values(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,subProduct.getName(),subProduct.getDescription(),subProduct.getPrice(),subProduct.getType(),
                subProduct.getPhoto(),subProduct.getStatus());
    }
    public void insertSubProductConnection(int product_id, int sub_product_id){
        String sql="insert into village.product_sub(product_id, sub_product,status) values(?,?,1)";
        jdbcTemplate.update(sql,product_id,sub_product_id);
    }
    public void deleteSubProduct(int id){
        String sql="delete village.subproduct where id=?";
        jdbcTemplate.update(sql,id);
    }
    public int activeCount(){
        return getActiveSubProduct().size();
    }
    public int deactiveCount(){
        return getDeactiveSubProduct().size();
    }
    public int noConnectWithSubProductCount(){
        return getAllNonConnectionSubproduct().size();
    }
}
