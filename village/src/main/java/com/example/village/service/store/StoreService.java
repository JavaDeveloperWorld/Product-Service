package com.example.village.service.store;

import com.example.village.model.Store;

import java.util.List;

public interface StoreService {
    public List<Store> getAllActiveList();
    public void updateStoreBySubId(Store store);
    public List<Store>getActiveListBySubProductId(int id);
    public void updateStoreById(int id,float count);
    public List<Store>getMinActiveList();
    public void insertStore(Store store);
    public void deleteStore(int id);
}
