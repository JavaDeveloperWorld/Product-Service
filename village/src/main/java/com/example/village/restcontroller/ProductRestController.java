package com.example.village.restcontroller;

import com.example.village.model.Product;
import com.example.village.model.ProductSubProduct;
import com.example.village.model.SubProduct;
import com.example.village.service.helper.ProductList;
import com.example.village.service.maxsell.MaxSellService;
import com.example.village.service.product.ProductService;
import com.example.village.service.subproduct.SubProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {
    private int id;
    private String name="";
    @Autowired
    ProductList productList;
    @Autowired
    ProductService productService;
    @Autowired
    SubProductService subProductService;
    @Autowired
    MaxSellService maxSellService;

    @GetMapping("/getAllProduct")
    public List<Product>getlist(){
        return productService.getAllList();
    }
    @PutMapping("/getAllProductSub")
    public List<SubProduct>getAllProductSub(@RequestBody String value){
        return productList.getSubFromProduct(value);
    }
    @GetMapping("/getActiveProduct")
    public List<Product>getActiveProduct(){
        return productService.getActiveList();
    }

    @GetMapping("/getActiveProductCount")
    public int getActiveService(){
        return productService.getActiveList().size();
    }
    @GetMapping("/getDeactiveProductCount")
    public int getDeactiveService(){
        return productService.getDeactiveList().size();
    }

    @PostMapping("/setProductID")
    public void setSubProductlist(@RequestBody int id){
       this.id=id;
    }

    @PostMapping("/setSingleSub")
    public void setSingleSubID(@RequestBody String  name){
        this.name=name;
    }
    @GetMapping("/getSubProductByID")
    public List<SubProduct> getSubProductlist(){
        if(name.equals("")) {
            if (id == -1) {
                return subProductService.getActiveSubProduct();
            } else {
                return subProductService.getSelectedSubProduct(id);
            }
        }else {
            String t=name;
            name="";
          return productList.getProductInfoByName(t);
        }
    }

    @PutMapping("/getProductById")
    public List<Product> getProductlist(@RequestBody int id){
        return productService.getProductById(id);
    }

    @PostMapping("/insertProduct")
    public void insertService(@RequestBody Product product){
        productService.insertProduct(product);
    }
    @PostMapping("/updateProduct")
    public void updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }


}
