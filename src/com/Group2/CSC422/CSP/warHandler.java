package com.Group2.CSC422.CSP; /**
 * warHandler.java
 */

import java.util.ArrayList;
import java.util.Random;

public class warHandler {
    public ArrayList<Player> characterArray;
    public ArrayList<WarRecord> gameResultRecord = new ArrayList<>();

    public warHandler(int amount) {
        characterArray = randomGenerate(amount);
    }

    public ArrayList randomGenerate(int amount) {
        // Randomly generate an arraylist of survivors and zombies
        ArrayList<Player> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < amount; i++) {
            int num = rand.nextInt(5);
            switch (num) {
                case 0:
                    list.add(new Newbie());
                    break;
                case 1:
                    list.add(new Soldier());
                    break;
                case 2:
                    list.add(new Mercenary());
                    break;
                case 3:
                    list.add(new CommonInfect());
                    break;
                case 4:
                    list.add(new Tank());
                    break;
            }
        }
        return list;
    }

    public int getNumZombies() {
        // return number of zombies that are alive
        int count = 0;
        for (Player player : characterArray) {
            if (player instanceof Zombie && player.alive) {
                count++;
            }
        }
        return count;
    }

    public int getNumSurvivors() {
        // return number of survivors that are alive
        int count = 0;
        for (Player player : characterArray) {
            if (player instanceof Survivor && player.alive) {
                count++;
            }
        }
        return count;
    }

    public void attack(Player attacker, Player defender) {
        //Subtract attacking players damage from defending player's health. Set alive to false if health <= 0
        if (attacker instanceof Zombie) {
            int damage = attacker.getDamage();
            int health = defender.getHealth();
            int result = health - damage;

            if (result <= 0) {
                defender.die();
                gameResultRecord.add(new WarRecord(attacker, defender));
            } else {
                defender.setHealth(result);
            }
        } else {
            if (attacker instanceof Survivor) {
                if (((Survivor) attacker).getWeapon().hit()) {
                    int damage = ((Survivor) attacker).getWeapon().getDamage();
                    int health = defender.getHealth();
                    int result = health - damage;
                    if (result <= 0) {
                        defender.die();
                        gameResultRecord.add(new WarRecord(attacker, defender));
                    } else {
                        defender.setHealth(result);
                    }
                }
            }
        }
    }


    /**
     * Class to record winners and losers
     */
//    private class WarRecord {
//        private Player loser;
//        private Player winner;
//
//        public WarRecord(Player winner, Player loser) {
//            this.loser = loser;
//            this.winner = winner;
//        }
//
//        @Override
//        public String toString() {
//            if(winner instanceof Zombie){
//            return winner.getName() + " " + winner.getId() + " killed "
//                    + loser.getName() + " " + loser.getId();}
//            else if(winner instanceof Survivor){
//                return winner.getName() + " " + winner.getId() + " killed " +
//                        loser.getName() + " " + loser.getId() + " with " + ((Survivor) winner).getWeapon();
//            }
//            else{
//                return null;
//            }
//        }
//    }
    public void survivorsFight() {
        //Make every survivor attack each zombie in arrayList
        int numPlayers = characterArray.size();
        for (int i = 0; i < numPlayers; i++) {
            if (characterArray.get(i) instanceof Survivor && characterArray.get(i).alive) {
                for (int j = 0; j < numPlayers; j++) {
                    if (characterArray.get(j) instanceof Zombie && characterArray.get(j).alive) {
                        attack(characterArray.get(i), characterArray.get(j));
                    }
                }
            }
        }
    }

    public void zombiesFight() {
        //Make every zombie attack each living survivor in arrayList
        int numPlayers = characterArray.size();
        for (int i = 0; i < numPlayers; i++) {
            if (characterArray.get(i) instanceof Zombie && characterArray.get(i).alive) {
                for (int j = 0; j < numPlayers; j++) {
                    if (characterArray.get(j) instanceof Survivor && characterArray.get(j).alive) {
                        attack(characterArray.get(i), characterArray.get(j));
                    }
                }
            }
        }
    }

    public void startWar() {
        //Check for remaining survivors or zombies in arraylist. If there are both then execute one round of combat
        boolean run = true;
        while (run) {
            if (getNumSurvivors() == 0 || getNumZombies() == 0) {
                run = false;
            } else {
                survivorsFight();
                zombiesFight();
            }
        }
    }


    public int numOfPlayersLeft(String playerType) {
        // Return the number of players left from each types
        int count = 0;

        switch (playerType) {
            case "Newbie":
                for (Player player : characterArray) {
                    if (player instanceof Newbie) {
                        count++;
                    }
                }
                break;
            case "Soldier":
                for (Player player : characterArray) {
                    if (player instanceof Soldier) {
                        count++;
                    }
                }
                break;
            case "Mercenary":
                for (Player player : characterArray) {
                    if (player instanceof Mercenary) {
                        count++;
                    }
                }
                break;
            case "Common Infected":
                for (Player player : characterArray) {
                    if (player instanceof CommonInfect) {
                        count++;
                    }
                }
                break;
            case "Tank":
                for (Player player : characterArray) {
                    if (player instanceof Tank) {
                        count++;
                    }
                }
                break;
        }

        return count;
    }


    public void printReport() {
        // Display results and call startWar()
        System.out.println("We have " + getNumSurvivors() + " survivors trying to make it to safety (" + numOfPlayersLeft("Newbie") + " newbie, " +
                +numOfPlayersLeft("Soldier") + " soldiers, " + numOfPlayersLeft("Mercenary") + " mercenaries)");
        System.out.println("But there are " + getNumZombies() + " zombies waiting for them (" + numOfPlayersLeft("Common Infected") + " common infected, " +
                +numOfPlayersLeft("Tank") + " tanks)");
        startWar();

        for (WarRecord result : gameResultRecord) {
            System.out.println(result);
        }
        if (getNumSurvivors() > 0) {
            System.out.println("It seems " + getNumSurvivors() + " made it to safety.");
        } else {
            System.out.println("None of the survivors made it.");
        }

    }
}
