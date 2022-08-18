package com.example.village.service.product;

import com.example.village.dao.product.ProductRepository;
import com.example.village.model.Product;
import com.example.village.model.ProductSubProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllList(){
      return productRepository.getAllList();
    }
    public List<Product>getActiveList(){
        return productRepository.getActiveList();
    }
    public List<Product>getDeactiveList(){
        return productRepository.getDeactiveList();
    }
    public void insertProduct(Product product){
        productRepository.insertProduct(product);
    }
    public List<Product>getProductById(int id){
        return productRepository.getProductById(id);
    }
    public void updateProduct(Product product){productRepository.updateProduct(product);}
    public List<ProductSubProduct>getAllProductSub(){return productRepository.getAllProductSub();}
}
