package Player;

import Armors.*;
import Weapons.*;

public class Inventory{

    private Armors armor;
    private Weapons weapon;
    private boolean food;
    private boolean wood;
    private boolean water;

    public Inventory() {
        this.armor = new Armors("Body",0,0,0);
        this.weapon = new Weapons("Fist",0,0,0);
    }

    public Armors getArmor() {
        return this.armor;
    }

    public void setArmor(Armors armor) {
        this.armor = armor;
    }

    public Weapons getWeapon() {
        return this.weapon;
    }

    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }

    public boolean isFood() {
        return this.food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isWood() {
        return this.wood;
    }

    public void setWood(boolean wood) {
        this.wood = wood;
    }

    public boolean isWater() {
        return this.water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }
}
