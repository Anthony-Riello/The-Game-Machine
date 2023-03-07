import java.util.Scanner;

/**
 * Designed to Initiate a Game to be Played
 *
 * @author Anthony Riello
 * @version - V1 09/28/2022
 */
public class Game_Select {
    public static void Startup() { // Prints during the first time the program runs
        System.out.println("/////////////////////////////////////////////////");
        System.out.println("         Welcome to the Game Machine!!");
        System.out.println("/////////////////////////////////////////////////\n");
        System.out.println("           Created By Anthony Riello\n");
    }

    public static void Select() { // Choose a game
        System.out.println("\nSelect Game You Want to Play:");
        System.out.println("1: Poker");
        System.out.println("2: Black Jack");
        System.out.println("\nYou have: $" + Game_Runner.getPoints());
        System.out.println("\n(Type in Number to Select Game. Type 0 to Quit)");


        Scanner Input = new Scanner(System.in);
        int Game = Input.nextInt();

        while (Game != 1 && Game != 2) { // Loop so they can choose if they mess up
            if (Game == 0) {
                System.out.print("\nThank You For Playing!\nShutting Down...");
                System.exit(1);
            }
            System.err.println("Invalid Input!! Try Again!");
            Game = Input.nextInt();
        }
        Game_Player.Play(Game); // Moves on to play the actual game
    }
}