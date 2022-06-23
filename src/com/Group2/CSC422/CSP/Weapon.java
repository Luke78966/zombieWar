package com.Group2.CSC422.CSP;

import java.util.Random;

public abstract class Weapon {
    private int accuracy;
    private int damage;

    public boolean hit(){
        Random rand = new Random();
        boolean hit = rand.nextInt(101) <= accuracy;
        return hit;
    }

    public void setDamage(int d){
        damage = d;
    }
    public int getDamage(){
        return damage;
    }
    public void setAccuracy(int a){
        accuracy = a;
    }
    public int getAccuracy(){
        return accuracy;
    }

    @Override
    public String toString(){
        String name = this.getClass().getSimpleName();
        char c = name.charAt(0);
        if(c == 'A'){
            name = "an " + name;
        }else{
            name = "a " + name;
        }
        return name;
    }
}
