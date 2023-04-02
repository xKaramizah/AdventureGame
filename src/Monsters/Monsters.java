package Monsters;

import Player.*;

public abstract class Monsters {
    private int monsterID;
    private String monsterType;
    private int damage;
    private int life;
    private int maxLife;
    private int coin;

    public Monsters(int monsterID, String monsterType, int damage, int life, int maxLife, int coin) {
        this.monsterType = monsterType;
        this.monsterID = monsterID;
        this.damage = damage;
        this.life = life;
        this.maxLife = maxLife;
        this.coin = coin;
    }

    public String getMonsterType() {
        return this.monsterType;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public int getMonsterID() {
        return this.monsterID;
    }

    public void setMonsterID(int monsterID) {
        this.monsterID = monsterID;
    }

    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
//        if (this.life < 0){
//            this.life = 0;
//        }
    }

    public int getMaxLife() {
        return this.maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getCoin() {
        return this.coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void hit(Player player) {
        if ((this.getDamage() - player.block()) > 0) {
            int newLife = player.getLife() - this.getDamage();
            if (newLife < 0) newLife = 0;
            {
                player.setLife(newLife);
            }
            System.out.println(this.getMonsterType() + " hits " + player.getPlayerName() + " for " + this.getDamage() + " damage!");
        } else {
            System.out.println(this.getMonsterType() + " attacked " + player.getPlayerName() + " but it was blocked!");
        }
    }
}
