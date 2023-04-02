package Locations;

import Player.*;

public class SafeHouse extends SafeLoc {

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public void onLocation(Player player) {
        System.out.println("---------------------------------------------------------" + "\nYou are at " + this.getName() + " now. TAKE REST! ");
        if (player.getLife() < player.getMaxLife()) {
            player.setLife(player.getMaxLife());
            System.out.println("LIFE REGENERATED: " + player.getLife() +
                    "\n---------------------------------------------------------");
        }
        System.out.println("---------------------------------------------------------");
    }
}