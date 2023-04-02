package Locations;

import Player.*;

public class Forest extends BattleLoc{

    public Forest(Player player){

        super(player,"Forest", "Wood");
    }

    @Override
    public void onLocation(Player player) {
        System.out.println("You are at " +this.getName() + " now. Be careful!");
    }
}
