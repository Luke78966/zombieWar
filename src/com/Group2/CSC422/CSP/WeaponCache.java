package com.Group2.CSC422.CSP;

import java.util.ArrayList;
import java.util.Random;

public class WeaponCache {
    public ArrayList<Weapon> cache;



    public WeaponCache(int amount){
       cache = randomGenerate(amount);
    }

    private ArrayList<Weapon> randomGenerate(int amount){
        Random rand = new Random();
        ArrayList<Weapon> temp = new ArrayList();

        for(int i = 0; i < amount; i++){
            int num = rand.nextInt(7);
            switch(num){
                case 0: temp.add(new Shotgun());
                        break;
                case 1: temp.add(new SubmachineGun());
                        break;
                case 2: temp.add(new AssaultRifle());
                        break;
                case 3: temp.add(new Pistol());
                        break;
                case 4: temp.add(new Axe());
                        break;
                case 5: temp.add(new Crowbar());
                        break;
                case 6: temp.add(new FryingPan());
                        break;
            }
        }
        return temp;
    }

    public void equipSurvivors(ArrayList<Player> list){
        Random rand = new Random();
        for(int i = 0; i < list.size(); i++){
            int num = rand.nextInt(cache.size());
            if(list.get(i) instanceof Survivor){
                ((Survivor) list.get(i)).setWeapon(cache.get(num));
                cache.remove(num);
                cache.trimToSize();
            }
        }
    }
}
