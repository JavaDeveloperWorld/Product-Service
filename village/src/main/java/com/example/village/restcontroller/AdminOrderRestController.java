package com.example.village.restcontroller;

import com.example.village.model.Selling;
import com.example.village.model.Store;
import com.example.village.model.SubProduct;
import com.example.village.service.selling.SellService;
import com.example.village.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminOrderRestController {
    private List<Selling>getAllNewOrders=new ArrayList<>();
    private List<Selling>getAllFinishOrders=new ArrayList<>();
    private List<Selling>tempList=new ArrayList<>();
    private List<Store>getStoreList=new ArrayList<>();

    @Autowired
    SellService sellService;
    @Autowired
    StoreService storeService;

    @GetMapping("/allNewOrders")
    public List<Selling>getAllNewOrders(){
        getAllNewOrders=sellService.getAllUnreadySell();
        return getAllNewOrders;
    }
    @PostMapping("/deleteOrder")
    public void deleteOrder(@RequestBody List<Selling> sell){
        sellService.deleteOrder(sell.get(0).getId());
        getStoreList=storeService.getActiveListBySubProductId(sell.get(0).getSubProduct().getId());
       storeService.updateStoreById(sell.get(0).getSubProduct().getId(),getStoreList.get(0).getCount()+sell.get(0).getCount());
    }
    @PostMapping("/deleteFinishOrder")
    public void deleteFinishOrder(@RequestBody List<Selling> sell){
        sellService.deleteOrder(sell.get(0).getId());
    }
    @PostMapping("/confirmOrder")
    public void confirmOrder(@RequestBody int id){
        sellService.confirmOrder(id);
    }
    @PostMapping("/payLoan")
    public void payLoan(@RequestBody List<String> list){
        sellService.updateOrder(Float.valueOf(list.get(1)),Integer.valueOf(list.get(0)));
    }
    @PutMapping("/allNewOrderById")
    public List<Selling>allNewOrderById(@RequestBody int id){
        tempList.clear();
        for (int i=0;i<getAllNewOrders.size();i++){
            if(id==getAllNewOrders.get(i).getId()){
                tempList.add(getAllNewOrders.get(i));
            }
        }
        return tempList;
    }
    @PutMapping("/allFinishOrderById")
    public List<Selling>allFinishOrderById(@RequestBody int id){
        tempList.clear();
        for (int i=0;i<getAllFinishOrders.size();i++){
            if(id==getAllFinishOrders.get(i).getId()){
                tempList.add(getAllFinishOrders.get(i));
            }
        }
        return tempList;
    }
    @GetMapping("/allFinishOrders")
    public List<Selling>getAllFinishOrders(){
        getAllFinishOrders=sellService.getAllReadySell();
        return getAllFinishOrders;
    }
    @GetMapping("/allNewOrdersCount")
    public int getAllNewOrdersCount(){
        return sellService.getAllUnreadySell().size();
    }
    @GetMapping("/allFinishOrdersCount")
    public int getAllFinishOrdersCount(){
        return sellService.getAllReadySell().size();
    }
}
