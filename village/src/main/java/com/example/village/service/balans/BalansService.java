package com.example.village.service.balans;

import com.example.village.model.Balans;
import com.example.village.model.UserTableSum;

import java.util.List;

public interface BalansService {
    public float takeBalance(int customer_id);
    public List<Balans> allBalance();
    public void insertBalans(Balans balans);
    public float takeBalanceWithMail(String mail);
    public List<Balans> userBalance(String mail,Integer limit,Integer offset);
    public List<Balans> adminUserBalance(Integer id,Integer limit,Integer offset);
    public List<UserTableSum> userSellingCounts(String  email);
}
