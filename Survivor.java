package com.Group2.CSC422.CSP;

public abstract class Survivor extends Player{
    public Weapon weapon;

    public void setWeapon(Weapon w){
        weapon = w;
    }
    public Weapon getWeapon(){
        return weapon;
    }
}
