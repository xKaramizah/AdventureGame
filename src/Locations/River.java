package Locations;

import Monsters.Bear;
import Player.*;

public class River extends BattleLoc {
    public River(Player player) {
        super(player,"River", "Water", new Bear(), false);
    }

}
