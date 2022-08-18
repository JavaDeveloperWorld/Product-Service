package com.example.village.restcontroller;

import com.example.village.model.Store;
import com.example.village.model.SubProduct;
import com.example.village.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminStoreRestController {
    @Autowired
    StoreService storeService;

    @GetMapping("/getAllStoreProduct")
    public List<Store>getAllList(){
        return storeService.getAllActiveList();
    }
    @GetMapping("/getMinStoreProduct")
    public List<Store>getMinList(){
        return storeService.getMinActiveList();
    }
    @PostMapping("/insertStore")
    public void insertStore(@RequestBody ArrayList<String> list){
       Store store=new Store();
        SubProduct subProduct=new SubProduct();
        subProduct.setId(Integer.valueOf(list.get(0)));
       store.setSubProduct(subProduct);
       store.setStatus(Integer.valueOf(list.get(1)));
       store.setMinCount(Float.valueOf(list.get(2)));
       store.setCount(Float.valueOf(list.get(3)));
       store.setMaxCount(Float.valueOf(list.get(4)));
       storeService.insertStore(store);
    }
    @PostMapping("/updateStore")
    public void updateStore(@RequestBody ArrayList<Store> store){
        storeService.updateStoreById(store.get(0).getId(),store.get(0).getCount());
    }
    @PostMapping("/deleteStore")
    public void deleteStore(@RequestBody int id){
        storeService.deleteStore(id);
    }
}
