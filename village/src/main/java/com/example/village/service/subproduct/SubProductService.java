package com.example.village.service.subproduct;

import com.example.village.model.SubProduct;

import java.util.List;

public interface SubProductService {
    public List<SubProduct> getSelectedSubProduct(int id);
    public List<SubProduct> getActiveSubProduct();
    public int activeCount();
    public int deactiveCount();
    public int noConnectWithSubProductCount();
    public List<SubProduct>getAllNonConnectionSubproduct();
    public List<SubProduct> getAllSubProduct();
    public List<SubProduct> getSubProductById(int id);
    public void updateSubProduct(SubProduct subProduct);
    public void deleteSubProduct(int id);
    public void insertSubProduct(SubProduct subProduct);
    public void updateSubProductStatus(int id);
    public void insertSubProductConnection(int product_id, int sub_product_id);
    public List<SubProduct>getActiveListFromStockByProductname(String name);
}
