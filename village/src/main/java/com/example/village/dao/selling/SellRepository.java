package com.example.village.dao.selling;

import com.example.village.model.Selling;

import java.util.List;

public interface SellRepository {
    public List<Selling> getUnreadySell(String email);
    public List<Selling>getReadySell(String email);
    public float getBalans(String email);
    public int countSubProduct(String email);
    public float sumBonus(String email);
    public void insertSell(Selling selling);
    public List<Selling>getAllUnreadySell();
    public List<Selling>getAllReadySell();
    public void deleteOrder(int id);
    public void updateOrder(float unpaid,int id);
    public List<Selling>getSellingByCustomerId(int id);
    public List<Selling>getAdminUnreadySell(String email);
    public List<Selling>getAllSell(String email, int limit , int offset);
    public void confirmOrder(int id);
    public int countUnusedSubProduct(String email);
}
