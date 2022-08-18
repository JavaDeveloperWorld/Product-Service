package com.example.village.service.subproduct;

import com.example.village.dao.subproduct.SubProductRepository;
import com.example.village.model.SubProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubProductServiceImpl implements SubProductService {
    @Autowired
    SubProductRepository subProductRepository;

    public List<SubProduct> getSelectedSubProduct(int id){
        return subProductRepository.getSelectedSubProduct(id);
    }

    public List<SubProduct> getActiveSubProduct(){return subProductRepository.getActiveSubProduct();}

    public int activeCount(){
        return subProductRepository.activeCount();
    }
    public int deactiveCount(){
        return subProductRepository.deactiveCount();
    }
    public int noConnectWithSubProductCount(){
        return subProductRepository.noConnectWithSubProductCount();
    }
    public List<SubProduct>getAllNonConnectionSubproduct(){
        return subProductRepository.getAllNonConnectionSubproduct();
    }
    public List<SubProduct> getAllSubProduct(){
        return subProductRepository.getAllSubProduct();
    }
    public List<SubProduct> getSubProductById(int id){
        return subProductRepository.getSubProductById(id);
    }
    public void updateSubProduct(SubProduct subProduct){
        subProductRepository.updateSubProduct(subProduct);
    }
    public void updateSubProductStatus(int id){
        subProductRepository.updateSubProductStatus(id);
    }
    public void deleteSubProduct(int id){
        subProductRepository.deleteSubProduct(id);
    }
    public void insertSubProduct(SubProduct subProduct){
        subProductRepository.insertSubProduct(subProduct);
    }
    public void insertSubProductConnection(int product_id, int sub_product_id){
        subProductRepository.insertSubProductConnection(product_id,sub_product_id);
    }
    public List<SubProduct>getActiveListFromStockByProductname(String name){
        return subProductRepository.getActiveListFromStockByProductname(name);
    }
}
