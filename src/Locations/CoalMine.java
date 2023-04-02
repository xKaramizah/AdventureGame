package Locations;

import Monsters.Snake;
import Player.*;

public class CoalMine extends BattleLoc{
    public CoalMine(Player player) {
        super(player, "Coal Mine", "Weapons", new Snake((int) (Math.random() * 4 + 3)), true);
    }
}
