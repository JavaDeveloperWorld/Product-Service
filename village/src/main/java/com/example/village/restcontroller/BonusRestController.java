package com.example.village.restcontroller;

import com.example.village.model.Bonus;
import com.example.village.service.bonus.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class BonusRestController {
    @Autowired
    BonusService bonusService;

    @GetMapping("/getTopStar")
    public List<Bonus> getTopStar(){
        return bonusService.getTopStar();
    }
    @GetMapping("/getBigStar")
    public List<Bonus> getBigStar(){
        return bonusService.getBigStar();
    }
    @GetMapping("/getMiddleStar")
    public List<Bonus> getMiddleStar(){
        return bonusService.getMiddleStar();
    }
    @GetMapping("/getNewStar")
    public List<Bonus> getNewStar(){
        return bonusService.getNewStar();
    }
    @GetMapping("/getUserBonus")
    public List<Bonus> getUserBonus(Principal principal){
        return bonusService.userBalance(principal.getName());
    }
    @PutMapping("/getAdminUserBonus")
    public List<Bonus> getAdminUserBonus(@RequestBody int id){
        return bonusService.userAdminBalance(id);
    }
}
