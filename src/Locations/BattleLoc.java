package Locations;

import Armors.*;
import Monsters.*;
import Player.*;
import Weapons.*;

public abstract class BattleLoc extends Location {
    Monsters monster;
    private boolean isTreasure;

    public BattleLoc(Player player, String name, String award, Monsters monster, boolean isTreasure) {
        super(player, name, award);
        this.monster = monster;
        this.isTreasure = isTreasure;
    }

    @Override
    public boolean onLocation() {
        System.out.println("You area at " + this.getName() + " side now.. Be ready for monsters!");

        int numOfMonsters = (int) (Math.random() * this.monster.getMaxMonster() + 1);
        System.out.println("\n-----------------------------------" +
                "\n --! " + numOfMonsters + " " + this.monster.getMonsterType() + " showed up there! \nAre you ready for fight? (Y/N)");
        String checkForBattle = sc.next();

        if (checkForBattle.equalsIgnoreCase("y")) {
            boolean runAway = false;
            for (int i = 1; i <= numOfMonsters; i++) {

                System.out.println("Round " + i + " of " + numOfMonsters + ": A " + this.monster.getMonsterType() + " appeared!" +
                        "\n-----------------------------------");

                boolean isPlayerFirst = Math.random() < 0.5;

                while (this.monster.getLife() > 0 && getPlayer().getLife() > 0) {

                    if (isPlayerFirst) {
                        getPlayer().hit(this.monster);

                        if (this.monster.getLife() <= 0) {
                            System.out.println(this.monster.getMonsterType() + " is dead! You earned " + this.monster.getCoin() + " coins." +
                                    "\n-----------------------------------");
                            getPlayer().setCoin(getPlayer().getCoin() + this.monster.getCoin());
                            break;
                        }

                        this.monster.hit(getPlayer());

                        if (getPlayer().getLife() <= 0) {
                            System.out.println("You died!");
                            return false;
                        }
                    } else {
                        this.monster.hit(getPlayer());

                        if (getPlayer().getLife() <= 0) {
                            System.out.println("You died!");
                            return false;
                        }

                        getPlayer().hit(this.monster);

                        if (this.monster.getLife() <= 0) {
                            System.out.println(this.monster.getMonsterType() + " is dead! You earned " + this.monster.getCoin() + " coins." +
                                    "\n-----------------------------------");
                            getPlayer().setCoin(getPlayer().getCoin() + this.monster.getCoin());
                            break;
                        }
                    }
                }
                this.monster.setLife(this.monster.getMaxLife());

                if (i != numOfMonsters){
                    String continueFight;
                    System.out.println("YOUR HEALTH -> " + getPlayer().getLife() + "/" + getPlayer().getMaxLife() +
                            "\n Are you ready for next monster? (Y/N)");
                    continueFight = sc.next();
                    if (continueFight.equalsIgnoreCase("n")) {
                        runAway = true;
                        break;
                    }
                }
            }
            if (!runAway) {
                collectReward();
                if (this.isTreasure) {
                    collectTreasure();
                }
            }

        } else if (checkForBattle.equalsIgnoreCase("n")) {
            System.out.println("You can turn when you are ready.");
        } else {
            System.out.println("Invalid selection");
        }
        return true;
    }

    public void collectReward() {

        if (getPlayer().getLife() > 0) {
            if (this.getAward().equalsIgnoreCase("food")) {
                getPlayer().getInventory().setFood(true);
            }
            if (this.getAward().equalsIgnoreCase("wood")) {
                getPlayer().getInventory().setWood(true);
            }
            if (this.getAward().equalsIgnoreCase("water")) {
                getPlayer().getInventory().setWater(true);
            }

            System.out.println("You cleared " + this.getName() + " from " + monster.getMonsterType() +
                    "\n-----------------------------------");
        }
    }

    public void collectTreasure() {
        Weapons weapon;
        Armors armor;
        System.out.println("""
                YOU FOUND A TREASURE !! 
                -----------------------------------""");
        boolean isAnyWin = Math.random() < 0.55;
        if (isAnyWin) {

            double luckyNo = Math.random() * 100;
            if (luckyNo < 15) {
                luckyNo = Math.random() * 100;
                if (luckyNo < 50) {
                    weapon = new Gun();
                } else if (luckyNo < 80) {
                    weapon = new Sword();
                } else {
                    weapon = new Rifle();
                }
                System.out.println("YOU FOUND NEW WEAPON -> " + weapon.getType() + " with " + weapon.getDamage() + " damage ! " +
                        "\n\t\tYOUR WEAPON -> " + getPlayer().getInventory().getWeapon().getType() + " with " + getPlayer().getInventory().getWeapon().getDamage() + " damage !");
                System.out.print("Do you want to keep new weapon ? (Y/N)");
                String keepWeapon = sc.next();
                if (keepWeapon.equalsIgnoreCase("y")){
                    getPlayer().getInventory().setWeapon(weapon);
                }

            } else if (luckyNo < 30) {
                luckyNo = Math.random() * 100;
                if (luckyNo < 50) {
                    armor = new LightArmor();
                } else if (luckyNo < 80) {
                    armor = new MediumArmor();
                } else {
                    armor = new HeavyArmor();
                }

                System.out.println("YOU FOUND NEW ARMOR -> " + armor.getType() + " with " + armor.getBlock() + " block !" +
                        "\n\t\tYOUR ARMOR -> " + getPlayer().getInventory().getArmor().getType() + " with " + getPlayer().getInventory().getArmor().getBlock() + " block !");
                System.out.print("Do you want to keep new armor ? (Y/N)");
                String keepArmor = sc.next();
                if (keepArmor.equalsIgnoreCase("y")){
                    getPlayer().getInventory().setArmor(armor);
                }
            } else {
                luckyNo = Math.random() * 100;
                int coinAmount;
                if (luckyNo < 50) {
                    coinAmount = 1;
                } else if (luckyNo < 80) {
                    coinAmount = 5;
                } else {
                    coinAmount = 10;
                }
                System.out.println("YOU FOUND " + coinAmount + " COIN");
                getPlayer().setCoin(getPlayer().getCoin() + coinAmount);
                System.out.println("YOUR COIN AMOUNT IS " + getPlayer().getCoin() + " NOW !! ");
            }

        } else {
            System.out.println("Not lucky this time.. Treasure is EMPTY!");
        }
        System.out.println("-----------------------------------");
    }
}
