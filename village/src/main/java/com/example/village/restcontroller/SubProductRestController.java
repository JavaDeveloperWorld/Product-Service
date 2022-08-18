package com.example.village.restcontroller;

import com.example.village.model.MaxSell;
import com.example.village.model.SubProduct;
import com.example.village.service.maxsell.MaxSellService;
import com.example.village.service.subproduct.SubProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SubProductRestController {
    private int id;

    @Autowired
    MaxSellService maxSellService;
    @Autowired
    SubProductService subProductService;

    @GetMapping("/getAllSubProductCount")
    public int getAllSubProductCount(){
        return subProductService.getAllSubProduct().size();
    }
    @GetMapping("/getAllSubProduct")
    public List<SubProduct> getAllSubProduct(){
        return subProductService.getAllSubProduct();
    }
    @GetMapping("/getActiveSubProduct")
    public List<SubProduct> getActiveSubProduct(){
        return subProductService.getActiveSubProduct();
    }
    @PutMapping("/getActiveSubProductFromDepo")
    public List<SubProduct> getActiveSubProductFromDepo(@RequestBody String name){
        return subProductService.getActiveListFromStockByProductname(name);
    }
    @GetMapping("/getMaxSubProduct")
    public List<MaxSell>getMaxSubProductlist(){
        return maxSellService.getAllMaxSell();

    }
    @GetMapping("/allActiveSubProducts")
    public int getActiveSubProductCount(){
         return subProductService.activeCount();
    }
    @GetMapping("/allDeactiveSubProducts")
    public int getDeactiveSubProduct(){
         return subProductService.deactiveCount();
    }
    @GetMapping("/allNonConnectionWithService")
    public int allNonConnectionWithService(){
        return subProductService.noConnectWithSubProductCount();
    }
    @GetMapping("/getNonSub")
    public List<SubProduct>getNonSub(){
        return subProductService.getAllNonConnectionSubproduct();
    }
    @PutMapping("/getSubProductById")
    public List<SubProduct>getSubProductById(@RequestBody int id){
        return subProductService.getSubProductById(id);
    }
    @PutMapping("/updateSubProduct")
    public void updateSubProduct(@RequestBody SubProduct subProduct){
         subProductService.updateSubProduct(subProduct);
    }
    @PostMapping("/deleteSubProduct")
    public void deleteSubProduct(@RequestBody int id){
        subProductService.deleteSubProduct(id);
    }
    @PostMapping("/insertSubProduct")
    public void insertSubProduct(@RequestBody SubProduct subProduct){
        subProductService.insertSubProduct(subProduct);
    }
    @PostMapping("/connectUpdateSubproduct")
    public void connectUpdateSubservice(@RequestBody ArrayList<Integer> list){
        int service_id=list.get(list.size()-1);
        list.remove(list.size()-1);
        for (int i=0;i<list.size();i++) {
            subProductService.updateSubProductStatus(list.get(i));
           subProductService.insertSubProductConnection(service_id, list.get(i));
        }
    }

}
