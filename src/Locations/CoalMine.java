package Locations;

import Player.Player;

public class CoalMine extends BattleLoc{
    private int chance;
    public CoalMine(Player player) {
        super(player, "Coal Mine", "Weapons");

    }

    @Override
    public void onLocation(Player player) {
        System.out.println("Welcome the old coal mine. Be careful there are some snakes! ");

    }
}
