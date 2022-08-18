package com.example.village.dao.balance;

import com.example.village.model.Balans;
import com.example.village.model.UserTableSum;

import java.util.List;

public interface BalanceRepositoy {
    public float takeBalance(int customer_id);
    public List<Balans> allBalance();
    public void insertBalans(Balans balans);
    public float takeBalanceWithMail(String mail);
    public List<Balans> userBalance(String mail,int limit,int offset);
    public List<Balans> adminUserBalance(int id,int limit,int offset);
    public List<UserTableSum> userSellingCounts(String  email);
}
