package com.example.village.service.selling;

import com.example.village.dao.selling.SellRepository;
import com.example.village.model.Selling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellServiceImpl implements SellService{
    @Autowired
    SellRepository sellRepository;

    public List<Selling> getUnreadySell(String email){
        return sellRepository.getUnreadySell(email);
    }
    public List<Selling>getAllUnreadySell(){return sellRepository.getAllUnreadySell();}
    public List<Selling>getReadySell(String email){
        return sellRepository.getReadySell(email);
    }
    public List<Selling>getAllReadySell(){return sellRepository.getAllReadySell();}
    public float getBalans(String email){
        return sellRepository.getBalans(email);
    }
    public int countSubProduct(String email){
        return sellRepository.countSubProduct(email);
    }
    public float sumBonus(String email){
        return sellRepository.sumBonus(email);
    }
    public void insertSell(Selling selling){
        sellRepository.insertSell(selling);
    }
    public void deleteOrder(int id){sellRepository.deleteOrder(id);}
    public void updateOrder(float unpaid,int id){sellRepository.updateOrder(unpaid,id);}
    public List<Selling>getSellingByCustomerId(int id){return sellRepository.getSellingByCustomerId(id);}
    public List<Selling>getAdminUnreadySell(String email){return sellRepository.getAdminUnreadySell(email);}
    public List<Selling>getAllSell(String email, Integer limit, Integer offset){
        if(limit==null){
            limit = 10;
        }
        if(offset==null){
            offset = 0;
        }
        return sellRepository.getAllSell(email, limit, offset);
    }
    public void confirmOrder(int id){sellRepository.confirmOrder(id);}
    public int countUnusedSubProduct(String email){return sellRepository.countUnusedSubProduct(email);}
}
