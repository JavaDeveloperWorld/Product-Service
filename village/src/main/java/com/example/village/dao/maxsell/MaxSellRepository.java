package com.example.village.dao.maxsell;

import com.example.village.model.MaxSell;

import java.util.List;

public interface MaxSellRepository {
    public List<MaxSell> getAllMaxSell();
    public List<MaxSell> getMaxSellByProductId(int id);
    public void insertMaxSell(MaxSell maxSell);
    public void updateMaxSell(MaxSell maxSell);
}
