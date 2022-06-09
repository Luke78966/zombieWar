package com.Group2.CSC422.CSP;

public abstract class Player {
    private int health;
    private int damage;
    boolean alive = true;

    public int getHealth(){
        return health;
    }
    public void setHealth(int i){
        health = i;
    }
    public int getDamage(){
        return damage;
    }
    public void setDamage(int i){
        damage = i;
    }
    public void die(){
        alive = false;
    }
}
