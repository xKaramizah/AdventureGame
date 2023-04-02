package Locations;

import Player.*;

public class River extends BattleLoc {
    public River(Player player) {
        super(player,"River", "Water");
    }

    @Override
    public void onLocation(Player player) {
         System.out.println("You area at " + this.getName() + " side now..");
    }

}
