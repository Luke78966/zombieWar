package com.Group2.CSC422.CSP;

public class WarRecord {

    private Player loser;
    private Player winner;

    public WarRecord(Player winner, Player loser) {
        this.winner = winner;
        this.loser = loser;
    }

    @Override
    public String toString() {
        if (winner instanceof Zombie) {
            return winner.getName() + " " + winner.getId() + " killed "
                    + loser.getName() + " " + loser.getId();
        } else if (winner instanceof Survivor) {
            return winner.getName() + " " + winner.getId() + " killed " +
                    loser.getName() + " " + loser.getId() + " with " + ((Survivor) winner).getWeapon();
        } else {
            return null;
        }
    }
}

