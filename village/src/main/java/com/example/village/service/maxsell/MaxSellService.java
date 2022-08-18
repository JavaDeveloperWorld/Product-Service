package com.example.village.service.maxsell;

import com.example.village.model.MaxSell;

import java.util.List;

public interface MaxSellService {
    public List<MaxSell> getAllMaxSell();
    public List<MaxSell> getMaxSellByProductId(int id);
    public void insertMaxSell(MaxSell maxSell);
    public void updateMaxSell(MaxSell maxSell);
}
