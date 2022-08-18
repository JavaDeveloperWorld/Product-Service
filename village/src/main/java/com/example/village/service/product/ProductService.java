package com.example.village.service.product;

import com.example.village.model.Product;
import com.example.village.model.ProductSubProduct;

import java.util.List;

public interface ProductService {

    public List<Product> getAllList();
    public List<Product>getActiveList();
    public List<Product>getDeactiveList();
    public void insertProduct(Product product);
    public List<Product>getProductById(int id);
    public void updateProduct(Product product);
    public List<ProductSubProduct>getAllProductSub();
}
