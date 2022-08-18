package com.example.village.dao.bonus;

import com.example.village.model.Bonus;

import java.util.List;

public interface BonusRepository {
    public List<Bonus> getAllList();
    public List<Bonus>getTopStar();
    public List<Bonus>getBigStar();
    public List<Bonus>getMiddleStar();
    public List<Bonus>getNewStar();
    public List<Bonus> userBalance(String mail);
    public void insertBonus(int id);
    public void updateBonus(int id,float bonus);
    public List<Bonus> userAdminBalance(int id);
}
