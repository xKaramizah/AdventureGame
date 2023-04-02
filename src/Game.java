import Locations.*;
import Monsters.*;
import Player.*;

import java.util.Scanner;

public class Game {
    private final Scanner sc = new Scanner(System.in);
    protected Player player;
    Location location;
    Monsters monster;
    private boolean isGameContinues = true;

    public void start() {
        System.out.println("GAME STARTED!");
        System.out.print("Enter a player name: ");
        player = new Player(sc.next());

        System.out.println("Your Adventure Started " + player.getPlayerName() + "\n =====================");

        player.selectChar();

        while (isGameContinues) {

            System.out.print("""
                                        
                    *************** SELECT LOCATION TO TRAVEL ***************
                    ---------------------------------------------------------
                    | 1 - Safe House  |  ->  Take rest and regenerate       |
                    | 2 - Store       |  ->  Let's spend some money         |
                    | 3 - Cave        |  ->  Zombie nest    (difficulty 1)  |
                    | 4 - Forest      |  ->  Vampire nest   (difficulty 2)  |
                    | 5 - River       |  ->  Bear nest      (difficulty 3)  |
                    | 6 - Coal Mine   |  ->  Snake nest     (gamble)        |
                    | 0 - QUIT        |  ->  Leave the game                 |
                    --------------------------------------------------------- \s""");
            player.printInfo();

            System.out.print("Select location to travel: ");

            int travelID = sc.nextByte();
            if (travelID < 0 || travelID > 5) {
                System.out.println("Invalid selection! Try again.");
                continue;
            }

            switch (travelID) {
                case 1 -> {
                    location = new SafeHouse(player);
                    location.onLocation(player);
                }
                case 2 -> {
                    location = new Store(player);
                    location.onLocation(player);
                }
                case 3 -> {
                    location = new Cave(player);
                    if (player.getInventory().isFood()){
                        System.out.println("\nYOU ALREADY CLEARED THIS LOCATION: " + location.getName());
                        break;
                    }
                    monster = new Zombie();
                    battle();
                }
                case 4 -> {
                    location = new Forest(player);
                    if (player.getInventory().isWood()){
                        System.out.println("\nYOU ALREADY CLEARED THIS LOCATION: " + location.getName());
                        break;
                    }
                    monster = new Vampire();
                    battle();
                }
                case 5 -> {
                    location = new River(player);
                    if (player.getInventory().isWater()){
                        System.out.println("\nYOU ALREADY CLEARED THIS LOCATION: " + location.getName());
                        break;
                    }
                    monster = new Bear();
                    battle();
                }
                default -> {
                    System.out.println("GOOD BYE !");
                    isGameContinues = false;
                }
            }
        }
    }

    public void battle() {
        location.onLocation(player);

        int numOfMonsters = (int) (Math.random() * 3 + 1);
        System.out.println(" --! " + numOfMonsters + " " + monster.getMonsterType() + " showed up there! \nAre you ready for fight? (Y/N)");
        String checkForBattle = sc.next();
        if (checkForBattle.equalsIgnoreCase("y")) {
            for (int i = 1; i <= numOfMonsters; i++) {
                System.out.println("Round " + i + " of " + numOfMonsters + ": A " + monster.getMonsterType() + " appeared!");
                while (monster.getLife() > 0 && player.getLife() > 0) {
                    if (Math.random()<0.5) {
                        player.hit(monster);
                    }

                    if (monster.getLife() <= 0) {
                        System.out.println(monster.getMonsterType() + " is dead! You earned " + monster.getCoin() + " coins.");
                        player.setCoin(player.getCoin() + monster.getCoin());
                        break;
                    }
                    monster.hit(player);

                    if (player.getLife() <= 0) {
                        System.out.println("You died!");
                        isGameContinues = false;
                        break;
                    }
                }
                if (!isGameContinues) {
                    break;
                }
                monster.setLife(monster.getMaxLife());
            }
            if (player.getLife() > 0) {
                if (location.getAward().equalsIgnoreCase("food")) {player.getInventory().setFood(true);}
                if (location.getAward().equalsIgnoreCase("wood")) {player.getInventory().setWood(true);}
                if (location.getAward().equalsIgnoreCase("water")) {player.getInventory().setWater(true);}

                System.out.println("You cleared " + location.getName() + " from " + numOfMonsters + " " + monster.getMonsterType() +
                        "\nAWARD COLLECTED: " + location.getAward()
                );
            }
        } else if (checkForBattle.equalsIgnoreCase("n")) {
            System.out.println("You can turn when you are ready.");
        } else {
            System.out.println("Invalid selection");
        }
    }
}
