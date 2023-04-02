package Locations;

import Player.*;

public class Cave extends BattleLoc {

    public Cave(Player player) {
        super(player,"Cave", "Food");
    }

    @Override
    public void onLocation(Player player) {
        System.out.println("You are at " + this.getName() + " now. There are rumors about DEAD PEOPLE walk around!! ");
    }
}
