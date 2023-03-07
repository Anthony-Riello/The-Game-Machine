import java.util.Objects;
import java.util.Scanner;

/**
 * Designed to Play the Game That was Selected
 *
 * @author Anthony Riello
 * @version - V2 10/5/2022
 */
public class Game_Player {

    public static void Play(int Game){
        if (Game == 1) {
            Poker game;
            game = new Poker(); // Sets up new Poker game

            System.out.println("\n\n");
            System.out.println("//////////////////////////");
            System.out.println("  ♣♠Welcome to Poker!♥♦");
            System.out.println("//////////////////////////");
            System.out.println("\nYour cards are: ");
            System.out.println(game.createHand() + "\n");

            System.out.println("Select Cards you would like to remove");
            System.out.println("You can do this by entering the number that correlates with your card\n");
            System.out.print("For Example: 1 = ");
            game.getCard("1");
            System.out.println("\nType 'Done' when you are all finished");

            Scanner Input = new Scanner(System.in);
            boolean done = false;

            while (!done) { // So when they type done the loop will stop
                String remove = Input.nextLine();
                try { // Trys to show card if they put in an input
                    if (!remove.equals("Done")) {
                        System.out.print("\nThe Card you are removing is: ");
                        game.getCard(remove);
                    }
                }
                catch (IndexOutOfBoundsException exception) { // When the user put in a number out of the scope
                    System.out.println("Nothing! Please Type in a Number that Correlates with your Card!!");
                    remove = ""; // To avoid exception
                }
                catch (NumberFormatException exception) { // When the user puts in a character
                    System.out.println("Nothing! Please Type in a Number, not a Character!!");
                    remove = ""; // To avoid exception
                }
                if (remove.equals("Done")) {
                    done = true;
                }
                else {
                    game.removeCard(remove);
                    System.out.println("Updated Hand: " + game.showHand());
                }
            }

            System.out.println();
            game.addCards();
            System.out.println("Your final Hand: " + game.showHand());

            game.PokerCombo();

            System.out.println("Would you like to play another game?");
            System.out.println("Type 'Yes' or 'No'");
            String decision = Input.nextLine(); // Choose if they want to play again

            while (!Objects.equals(decision, "Yes")&& !Objects.equals(decision, "No")) {
                System.err.println("Invalid Input!! Try Again!"); // If they make a mistake putting in an input
                decision = Input.nextLine();
            }
            if (Objects.equals(decision, "Yes")) {
                Game_Select.Select(); // Loops back to select another game
            }
            else if (Objects.equals(decision, "No")) // Terminates the program
                System.out.println("\nYour Final Earnings: $" + Game_Runner.getPoints());
                System.out.print("\nThank You For Playing!\nShutting Down...");
                System.exit(1);
            }
        else if (Game == 2) {
            BlackJack game;
            game = new BlackJack(); // Sets up new Black Jack game

            System.out.println("\n\n");
            System.out.println("//////////////////////////");
            System.out.println("♣♠Welcome to Black Jack!♥♦");
            System.out.println("//////////////////////////");
            System.out.println("\nYour cards are: ");
            System.out.println(game.createHand() + "\n");

            System.out.println("Would you like to Hit or Stay?");
            System.out.println("You can do this by entering 'Hit' or 'Stay'\n");
            
            Scanner Input = new Scanner(System.in);
            String decision = Input.nextLine();

            while(!decision.equals("Stay")) {
                if(decision.equals("Hit")) {
                    game.Hit();
                    System.out.println("Updated Hand: " + game.showHand());
                }
                else {
                    System.err.println("Invalid Input!! Try Again!");
                }
                decision = Input.nextLine();
            }

            System.out.println("""
                    Unfortunately, this game is not completed yet.\s
                    I wanted to put this here to hopefully implement a game like this in the future.\s
                    Also, it's to show that this program can do other things other than play poker.\s
                    For now, this will take you back to the game select screen. \s
                    Thank you for trying out my program <3""");
            Game_Select.Select();
        }
    }
}