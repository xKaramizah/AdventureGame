package Locations;

import Player.*;

public class SafeHouse extends SafeLoc {

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("---------------------------------------------------------" + "\nYou are at " + this.getName() + " now. TAKE REST! ");
        if (getPlayer().getLife() < getPlayer().getMaxLife()) {
            getPlayer().setLife(getPlayer().getMaxLife());
            System.out.println("LIFE REGENERATED: " + getPlayer().getLife() +
                    "\n---------------------------------------------------------");
        }
        System.out.println("---------------------------------------------------------");
        return true;
    }
}