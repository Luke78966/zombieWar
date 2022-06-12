package com.Group2.CSC422.CSP;

public abstract class Player {
    private int health;
    private int damage;
    private String name;
    private int id = 0;
    boolean alive = true;

    public int getHealth() {
        return health;
    }

    public void setHealth(int i) {
        health = i;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int i) {
        damage = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void die() {
        alive = false;
    }
}
