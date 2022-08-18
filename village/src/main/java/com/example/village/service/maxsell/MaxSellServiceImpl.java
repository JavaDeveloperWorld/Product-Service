package com.example.village.service.maxsell;

import com.example.village.dao.maxsell.MaxSellRepository;
import com.example.village.model.MaxSell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaxSellServiceImpl implements MaxSellService {
    @Autowired
    MaxSellRepository maxSellRepository;

    public List<MaxSell> getAllMaxSell(){
        return maxSellRepository.getAllMaxSell();
    }
    public List<MaxSell> getMaxSellByProductId(int id){
        return maxSellRepository.getMaxSellByProductId(id);
    }
    public void insertMaxSell(MaxSell maxSell){
        maxSellRepository.insertMaxSell(maxSell);
    }
    public void updateMaxSell(MaxSell maxSell){
        maxSellRepository.updateMaxSell(maxSell);
    }
}
