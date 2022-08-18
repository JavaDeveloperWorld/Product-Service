package com.example.village.service.balans;

import com.example.village.dao.balance.BalanceRepositoy;
import com.example.village.model.Balans;
import com.example.village.model.UserTableSum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalansServiceImpl implements BalansService {
    @Autowired
    BalanceRepositoy balanceRepositoy;

    public float takeBalance(int customer_id){
        return balanceRepositoy.takeBalance(customer_id);
    }
    public List<Balans> allBalance(){
        return balanceRepositoy.allBalance();
    }
    public void insertBalans(Balans balans){
        balanceRepositoy.insertBalans(balans);
    }
    public float takeBalanceWithMail(String mail){
        return balanceRepositoy.takeBalanceWithMail(mail);
    }
    public List<Balans> userBalance(String mail,Integer limit,Integer offset){
        if(limit==null){
            limit = 10;
        }
        if(offset==null){
            offset = 0;
        }
        return balanceRepositoy.userBalance(mail,limit,offset);
    }
    public List<Balans> adminUserBalance(Integer id,Integer limit,Integer offset){
        if(limit==null){
            limit = 10;
        }
        if(offset==null){
            offset = 0;
        }
        return balanceRepositoy.adminUserBalance(id,limit,offset);
    }
    public List<UserTableSum> userSellingCounts(String  email){
        return balanceRepositoy.userSellingCounts(email);
    }
}
