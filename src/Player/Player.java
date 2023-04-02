package Player;

import Chars.*;
import Monsters.*;

import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private final String playerName;
    private String charType;
    private int damage;
    private int life;
    private int maxLife;
    private int coin;

    public Player(String playerName) {
        this.inventory = new Inventory();
        this.playerName = playerName;
    }

    public void printInfo() {
        System.out.println("\nPLAYER STATS   -->  TYPE\t: " + this.getCharType() +
                "\n\t\t\t\t\tLIFE\t\t: " + this.getLife() + "/" + this.getMaxLife() +
                "\n\t\t\t\t\tDAMAGE\t\t: " + this.getDamage() +
                "\n\t\t\t\t\tBLOCK\t\t: " + this.getInventory().getArmor().getBlock() +
                "\n\t\t\t\t\tCOIN\t\t: " + this.getCoin() +
                "\n\t\t\t\t\tWEAPON\t\t: " + this.getInventory().getWeapon().getType() +
                "\n\t\t\t\t\tARMOR\t\t: " + this.getInventory().getArmor().getType() +
                "\n\t\t\t\t\tFOOD STOCK\t: " + this.getInventory().isFood() +
                "\n\t\t\t\t\tWOOD STOCK\t: " + this.getInventory().isWood() +
                "\n\t\t\t\t\tWATER STOCK\t: " + this.getInventory().isWater()
        );
    }

    public void hit(Monsters monster) {
        int newLife = monster.getLife() - this.getDamage();
        if (newLife < 0) newLife = 0;
        monster.setLife(newLife);
        System.out.println(this.getPlayerName() + " hits " + monster.getMonsterType() + " for " + this.getDamage() + " damage!");
    }

    public int block() {
        return this.getInventory().getArmor().getBlock();
    }

    public void selectChar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                ----------------------------------------------------
                | 1 - Samurai |  ->  Damage: 5, Life: 21, Coin: 15 |
                | 2 - Archer  |  ->  Damage: 7, Life: 18, Coin: 20 |
                | 3 - Knight  |  ->  Damage: 8, Life: 24, Coin: 5  |
                ----------------------------------------------------\s""");
        System.out.print("Select character (ID): ");
        int id = sc.nextByte();
        while (id < 1 || id > 3) {
            System.out.print("Invalid selection! \nSelect character (ID): ");
            id = sc.nextByte();
        }

        switch (id) {
            case 1 -> initChars(new Samurai());
            case 2 -> initChars(new Archer());
            case 3 -> initChars(new Knight());
            default -> System.out.println("Invalid selection, try again!");
        }
    }

    public void initChars(Chars chars) {
        this.setCharType(chars.getCharType());
        this.setDamage(chars.getDamage());
        this.setLife(chars.getLife());
        this.setMaxLife(chars.getLife());
        this.setCoin(chars.getCoin());
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public String getCharType() {
        return this.charType;
    }

    public void setCharType(String charType) {
        this.charType = charType;
    }

    public int getDamage() {
        return this.damage + this.getInventory().getWeapon().getDamage();
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
        if (this.life < 0) {
            this.life = 0;
        }
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

    public Inventory getInventory() {
        return this.inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
