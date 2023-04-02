package Locations;

import Player.*;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    private String award;
    public static Scanner sc = new Scanner(System.in);

    public Location(Player player, String name) {
        this.name = name;
        this.player = player;
    }

    public Location(Player player, String name, String award) {
        this.name = name;
        this.player = player;
        this.award = award;
    }

    public String getName() {
        return this.name;
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public abstract boolean onLocation();
}
