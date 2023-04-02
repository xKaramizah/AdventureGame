import Locations.*;
import Player.*;

import java.util.Scanner;

public class Game {
    private final Scanner sc = new Scanner(System.in);
    protected Player player;
    Location location = null;

    public void start() {
        System.out.println("GAME STARTED!");
        System.out.print("Enter a player name: ");
        player = new Player(sc.next());
        boolean isQuit = false;
        System.out.println("Your Adventure Started " + player.getPlayerName() + "\n =====================");

        player.selectChar();
        while (true) {

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

            byte travelID = sc.nextByte();
            if (travelID < 0 || travelID > 6) {
                System.out.println("Invalid selection! Try again.");
                continue;
            }

            switch (travelID) {
                case 1 -> {
                    location = new SafeHouse(player);
                }
                case 2 -> {
                    location = new Store(player);
                }
                case 3 -> {
                    if (player.getInventory().isFood()) {
                        System.out.println("""
                                -----------------------------------
                                  Your already cleared the CAVE !
                                    Travel to another location
                                -----------------------------------""");
                        continue;
                    }
                    location = new Cave(player);

                }
                case 4 -> {
                    if (player.getInventory().isWood()) {
                        System.out.println("""
                                -----------------------------------
                                 Your already cleared the FOREST !
                                    Travel to another location
                                -----------------------------------""");
                        continue;
                    }
                    location = new Forest(player);
                }
                case 5 -> {
                    if (player.getInventory().isWater()) {
                        System.out.println("""
                                -----------------------------------
                                  Your already cleared the RIVER!
                                    Travel to another location
                                -----------------------------------""");
                        continue;
                    }
                    location = new River(player);
                }
                case 6 -> {
                    location = new CoalMine(player);
                }
                case 0 -> {
                    isQuit = true;
                }
            }
            if (isQuit) {
                System.out.println("""
                        -----------------------------------
                        \t\t\tBYE BYE !
                        -----------------------------------""");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("""
                        -----------------------------------
                        \t\t\tGAME OVER !
                        -----------------------------------""");
                break;
            }
            if (player.getInventory().isWater() && player.getInventory().isWood() && player.getInventory().isFood()) {
                System.out.println("""
                        -----------------------------------
                        \t\tYOU WON THE GAME !
                        -----------------------------------""");
                break;
            }

        }
    }
}
