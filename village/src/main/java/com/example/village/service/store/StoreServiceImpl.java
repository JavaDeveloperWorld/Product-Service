package com.example.village.service.store;

import com.example.village.dao.store.StoreRepository;
import com.example.village.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository storeRepository;

    public List<Store> getAllActiveList(){
        return storeRepository.getAllActiveList();
    }
    public void updateStoreBySubId(Store store){
        storeRepository.updateStoreBySubId(store);
    }
    public List<Store>getActiveListBySubProductId(int id){return storeRepository.getActiveListBySubProductId(id);}
    public void updateStoreById(int id,float count){storeRepository.updateStoreById(id,count);}
    public List<Store>getMinActiveList(){return storeRepository.getMinActiveList();}
    public void insertStore(Store store){storeRepository.insertStore(store);}
    public void deleteStore(int id){storeRepository.deleteStore(id);}
}
