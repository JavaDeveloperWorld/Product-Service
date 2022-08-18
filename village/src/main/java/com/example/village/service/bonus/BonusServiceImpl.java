package com.example.village.service.bonus;

import com.example.village.dao.bonus.BonusRepository;
import com.example.village.model.Bonus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonusServiceImpl implements BonusService {
    @Autowired
    BonusRepository bonusRepository;

    public List<Bonus> getAllList(){
        return bonusRepository.getAllList();
    }
    public List<Bonus>getTopStar(){
        return bonusRepository.getTopStar();
    }
    public List<Bonus>getBigStar(){
        return bonusRepository.getBigStar();
    }
    public List<Bonus>getMiddleStar(){
        return bonusRepository.getMiddleStar();
    }
    public List<Bonus>getNewStar(){
        return bonusRepository.getNewStar();
    }
    public List<Bonus> userBalance(String mail){
        return bonusRepository.userBalance(mail);
    }
    public void insertBonus(int id){
        bonusRepository.insertBonus(id);
    }
    public void updateBonus(int id,float bonus){
        bonusRepository.updateBonus(id,bonus);
    }
    public List<Bonus> userAdminBalance(int id){
       return bonusRepository.userAdminBalance(id);
    }
}
