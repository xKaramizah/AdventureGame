package Locations;

import Monsters.*;
import Player.*;

public class Cave extends BattleLoc {
    public Cave(Player player) {
        super(player,"Cave", "Food", new Zombie(), false);
    }
}
