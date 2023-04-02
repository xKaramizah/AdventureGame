package Locations;

import Player.*;

public abstract class BattleLoc extends Location {
    public BattleLoc(Player player, String name, String award) {
        super(player, name, award);
    }
}
