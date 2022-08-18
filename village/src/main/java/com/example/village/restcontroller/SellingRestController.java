package com.example.village.restcontroller;

import com.example.village.model.*;
import com.example.village.service.balans.BalansService;
import com.example.village.service.bonus.BonusService;
import com.example.village.service.maxsell.MaxSellService;
import com.example.village.service.selling.SellService;
import com.example.village.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SellingRestController {
    private DateTimeFormatter fr=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime now=LocalDateTime.now();

    @Autowired
    SellService sellService;
    @Autowired
    StoreService storeService;
    @Autowired
    MaxSellService maxSellService;
    @Autowired
    BalansService balansService;
    @Autowired
    BonusService bonusService;

    @GetMapping("/getUnreadySellCount")
    public int getUnreadySellCount(Principal principal){
        return sellService.getAdminUnreadySell(principal.getName()).size();
    }
    @GetMapping("/getReadySellCount")
    public int getReadySellCount(Principal principal){
        return sellService.getReadySell(principal.getName()).size();
    }

    @GetMapping("/getUnreadySell")
    public List<Selling> getUnreadySell(Principal principal){
        return sellService.getUnreadySell(principal.getName());
    }
    @GetMapping("/getAllSell")
    public List<Selling> getAllSell(Principal principal, @RequestParam( name= "limit", required = false) Integer limit, @RequestParam(name = "offset", required = false) Integer offset){
        return sellService.getAllSell(principal.getName(), limit, offset);
    }
    @GetMapping("/getReadySell")
    public List<Selling> getReadySell(Principal principal){
        return sellService.getReadySell(principal.getName());
    }

    @GetMapping("/usedSubProductCount")
    public int usedSubProductCount(Principal principal){
        return sellService.countSubProduct(principal.getName());
    }
    @GetMapping("/unUsedSubProductCount")
    public int unUsedSubProductCount(Principal principal){
        return sellService.countUnusedSubProduct(principal.getName());
    }
    @GetMapping("/userBonus")
    public float userBonus(Principal principal){
        return sellService.sumBonus(principal.getName());
    }

    @PutMapping("/insertOrder")
    public void insertOrder(@RequestBody ArrayList<String> list){
      Selling selling=new Selling();
      selling.setCustomer(new Customer(Integer.valueOf(list.get(0)),null,null,null,null,null,null,null,null,null,null,0));
      selling.setSubProduct(new SubProduct(Integer.valueOf(list.get(1)),null,null,0,null,null,0));
      selling.setCount(Float.valueOf(list.get(2)));
      selling.setPrice(Float.valueOf(list.get(3)));
      selling.setSum_price(Float.valueOf(list.get(4)));
      selling.setUnpaid(Float.valueOf(list.get(5)));
      selling.setBonus(Float.valueOf(list.get(6)));
      selling.setAddress(list.get(7));
      selling.setPhone(list.get(8));
      selling.setDate(fr.format(now));

      bonusService.updateBonus(selling.getCustomer().getId(),selling.getBonus());

      Balans balans=new Balans();
      balans.setBalance(balansService.takeBalance(selling.getCustomer().getId()));
      if(selling.getUnpaid()<=balans.getBalance()){
          balans.setBalance(balans.getBalance()-selling.getUnpaid());
          balans.setPayment(selling.getUnpaid());
          selling.setUnpaid(0);
      }else {
          balans.setPayment(balans.getBalance()-selling.getUnpaid());
          selling.setUnpaid(Math.abs(balans.getPayment()));
      }
      balans.setDate(selling.getDate());
      balans.setCustomer(selling.getCustomer());
      balans.setStatus(1);

      balansService.insertBalans(balans);
      float count=0;
      for(int i=0;i<storeService.getAllActiveList().size();i++){
          if(selling.getSubProduct().getId()==storeService.getAllActiveList().get(i).getSubProduct().getId()){
              count=storeService.getAllActiveList().get(i).getCount();
              count=count-selling.getCount();
              break;
          }
      }

      sellService.insertSell(selling);

        Store store=new Store();
        store.setSubProduct(selling.getSubProduct());
        store.setCount(count);
        storeService.updateStoreBySubId(store);
        MaxSell maxSell=new MaxSell();
        if(maxSellService.getMaxSellByProductId(selling.getSubProduct().getId()).isEmpty()){
            maxSell.setSubProduct(selling.getSubProduct());
            maxSell.setMaxCount(1);
            maxSellService.insertMaxSell(maxSell);
        }else{
            maxSell.setSubProduct(selling.getSubProduct());
            maxSell.setMaxCount(maxSellService.getMaxSellByProductId(selling.getSubProduct().getId()).get(0).getMaxCount()+Math.round(selling.getCount()));
            maxSellService.updateMaxSell(maxSell);
        }
    }
}
