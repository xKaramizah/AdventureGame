package Locations;

import Monsters.Vampire;
import Player.*;

public class Forest extends BattleLoc {
    public Forest(Player player) {
        super(player, "Forest", "Wood", new Vampire(), false);
    }

}
