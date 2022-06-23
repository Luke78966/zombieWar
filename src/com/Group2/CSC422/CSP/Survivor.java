package com.Group2.CSC422.CSP;

import com.Group2.CSC422.CSP.Player;
import com.Group2.CSC422.CSP.Weapon;

public abstract class Survivor extends Player {
    public Weapon weapon;

    public void setWeapon(Weapon w){
        weapon = w;
    }
    public Weapon getWeapon(){
        return weapon;
    }
}
