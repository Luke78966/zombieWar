package com.Group2.CSC422.CSP;

public class Main {
    public static void main(String[] args){

        int AMOUNT = 15;
        warHandler handler = new warHandler(AMOUNT);
        WeaponCache cache = new WeaponCache(AMOUNT);
        cache.equipSurvivors(handler.characterArray);
        handler.printReport();
    }
}
