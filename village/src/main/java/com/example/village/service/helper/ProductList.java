package com.example.village.service.helper;

import com.example.village.model.Product;
import com.example.village.model.ProductSubProduct;
import com.example.village.model.SubProduct;
import com.example.village.service.product.ProductService;
import com.example.village.service.subproduct.SubProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductList {
    private List<SubProduct>getSubFromProduct=new ArrayList<>();

    @Autowired
    ProductService productService;
    @Autowired
    SubProductService subProductService;

    private List<ProductSubProduct>getAllConnectionList(){
        return productService.getAllProductSub();
    }
    private List<SubProduct>getAllSubProductList(){
        return subProductService.getAllSubProduct();
    }

    public List<SubProduct>getSubFromProduct(String value){
        getSubFromProduct.clear();
       for (int i=0;i<getAllConnectionList().size();i++){
           if(value.equals(productService.getAllProductSub().get(i).getProductName())){
                getSubFromProduct.add(new SubProduct(0,getAllConnectionList().get(i).getSubName(),null,0,null,null,0));
           }
       }
       return getSubFromProduct;
    }
    public List<SubProduct>getProductInfoByName(String name){
        getSubFromProduct.clear();
        for (int i=0;i<getAllSubProductList().size();i++){
            if(name.equals(getAllSubProductList().get(i).getName())){
                getSubFromProduct.add(getAllSubProductList().get(i));
            }
        }
        return getSubFromProduct;
    }
}
