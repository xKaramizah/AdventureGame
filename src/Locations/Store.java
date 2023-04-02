package Locations;

import Armors.*;
import Player.*;
import Weapons.*;

public class Store extends SafeLoc {

    public Store(Player player) {
        super(player,"Store");
    }

    @Override
    public void onLocation(Player player) {
        System.out.print("""
                Welcome to store.
                -------------------------------------------
                |  1  - Weapons                           |
                |  2  - Armors                            |
                |  3  - Back to Main Manu                 |
                -------------------------------------------
                What are you looking for? : """);
        byte selectID = sc.nextByte();
        if (selectID == 1) {
            Weapons[] weapons = {new Gun(), new Sword(), new Rifle()};
            for (Weapons weapon : weapons) {
                System.out.println(weapon.getId() + " " + weapon.getType() + " -  Damage: " + weapon.getDamage() + "\tCost: " + weapon.getCost());
            }
            System.out.print("Make a wish: ");
            selectID = sc.nextByte();
            switch (selectID) {
                case 1 -> buyWeapon(player, weapons[0]);
                case 2 -> buyWeapon(player, weapons[1]);
                case 3 -> buyWeapon(player, weapons[2]);
                default -> System.out.println("Invalid selection");
            }
        } else if (selectID == 2) {
            Armors[] armors = {new LightArmor(), new MediumArmor(), new HeavyArmor()};
            for (Armors armor : armors) {
                System.out.println(armor.getId() + " " + armor.getType() + " -  Damage: " + armor.getBlock() + "\tCost: " + armor.getCost());
            }
            System.out.print("Make a wish: ");
            selectID = sc.nextByte();

            switch (selectID) {
                case 1 -> buyArmor(player, armors[0]);
                case 2 -> buyArmor(player, armors[1]);
                case 3 -> buyArmor(player, armors[2]);
                default -> System.out.println("Invalid selection");
            }
        }
    }

    public void buyArmor(Player player, Armors armor) {
        if (armor.getCost() > player.getCoin()) {
            System.out.println("You do not have enough coin!" + "\n Weapon cost: " + armor.getCost() + "\n Your total coin: " + player.getCoin());
        } else {
            System.out.println("BOUGHT YOURSELF A NEW --> " + armor.getType());
            player.setCoin((player.getCoin() - armor.getCost()));
            this.getPlayer().getInventory().setArmor(armor);
            System.out.print("See your new stats under below: ");
            player.printInfo();
        }
    }

    public void buyWeapon(Player player, Weapons weapon) {
        if (weapon.getCost() > player.getCoin()) {
            System.out.println("You do not have enough coin!" + "\n Weapon cost: " + weapon.getCost() + "\n Your total coin: " + player.getCoin());
        } else {
            System.out.println("BOUGHT YOURSELF A NEW --> " + weapon.getType());
            player.setCoin((player.getCoin() - weapon.getCost()));
            this.getPlayer().getInventory().setWeapon(weapon);
            System.out.println("See your new stats under below: ");
            player.printInfo();
        }
    }
}
