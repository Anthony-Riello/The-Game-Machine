import java.util.Arrays;
import java.util.LinkedList;

/**
 * Designed to play the Game of Poker
 *
 * @author Anthony Riello
 * @version - V1 09/28/2022
 */
public class Poker {

    private String suit;

    private String face;

    final private LinkedList<String> hand = new LinkedList<>();

    /*
    Methods to create the cards randomly
     */
    public String getSuit() {
        int num = (int) (Math.random() * 4) + 1;
        if (num == 1) {
            suit = "♠";
        }
        else if (num == 2) {
            suit = "♦";
        }
        else if (num == 3) {
            suit = "♣";
        }
        else if (num == 4) {
            suit = "♥";
        }
        return suit;
    }

    public String getFace() {
        int num = (int) (Math.random() * 13) + 1;
        if (num == 1) {
            face = "Ace";
        }
        else if (num == 2) {
            face = "2";
        }
        else if (num == 3) {
            face = "3";
        }
        else if (num == 4) {
            face = "4";
        }
        else if (num == 5) {
            face = "5";
        }
        else if (num == 6) {
            face = "6";
        }
        else if (num == 7) {
            face = "7";
        }
        else if (num == 8) {
            face = "8";
        }
        else if (num == 9) {
            face = "9";
        }
        else if (num == 10) {
            face = "10";
        }
        else if (num == 11) {
            face = "Jack";
        }
        else if (num == 12) {
            face = "Queen";
        }
        else if (num == 13) {
            face = "King";
        }
        return face;
    }

    public LinkedList<String> createHand() { // Puts cards into linked list
        for (int i = 0; i < 5; i++) {
            hand.add(getFace() + " of " + getSuit());
        }
        checkDupes();
        return hand;
    }

    public void checkDupes() { // Two for loops to check if one card equals another to remove it
        String card = "";
        for (int j = 0; j < hand.size(); j++) {
            for (int i = 0; i < hand.size(); i++) {
                if (i != j) {
                    if (hand.get(j).equals(hand.get(i))) { // Finds a duplicate and sets it to card for removal
                        card = hand.get(i);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < hand.size(); i++) {
            if (card.equals(hand.get(i))) {
                removeCard(Integer.toString(i+1)); // Removes the Duplicate card
                break;
            }
        }
        addCards();
    }

    public void getCard(String card) { // Prints out a single card of choice
        int numCard = Integer.parseInt(card);
        System.out.println(hand.get(numCard - 1));
    }

    public LinkedList<String> showHand() { // Prints the entire linked list of cards
        return hand;
    }

    public void removeCard(String card) {
        if (!card.equals("")) { // So it can handle exceptions
            int numCard = Integer.parseInt(card);
            hand.remove(numCard - 1);
        }
    }

    public void addCards() { // Adds cards if the hand is not five cards
        boolean size = hand.size() != 5;
        if (size) {
            for (int i = hand.size(); i < 5; i++) {
                hand.add(getFace() + " of " + getSuit());
            }
            checkDupes();
        }
    }

    public void PokerCombo() { // Checks to see what hand combination you got
        String result = "You Lost!"; // So if you don't get any hand
        String[] faces = new String[5];
        String[] suits = new String[5];
        double pointCount = 0.0;

        // Puts Numbers in one array and suits in another array
        for (int i = 0; i < hand.size(); i++) {
            String[] oneCard = new String[5];
            oneCard[i] = hand.get(i);
            String[] subCard = oneCard[i].split(" ");
            faces[i] = subCard[0];
            suits[i] = subCard[2];
        }

        // Changes the Picture cards and the Ace to their number values
        for (int i = 0; i < 5; i++) {
            switch (faces[i]) {
                case "Jack":
                    faces[i] = "11";
                    break;
                case "Queen":
                    faces[i] = "12";
                    break;
                case "King":
                    faces[i] = "13";
                    break;
                case "Ace":
                    faces[i] = "14";
                    break;
            }
        }

        // Changes Numbered Stings to Numbered Integers
        int[] intFaces = new int[5];
        for (int i = 0; i < 5; i++) {
            intFaces[i] = Integer.parseInt(faces[i]);
        }
        Arrays.sort(intFaces);

        // Checked if suits equal each other
        String checkSuit = suits[0];
        int suitResult = 0;
        for (int i = 0; i < 5; i++) {
            if (suits[i].equals(checkSuit)) {
                suitResult += 1;
            }
        }

        /*
        Checks if cards equal each other
         */
        int checkFirst = intFaces[0];
        int resultFirst = 0;
        int checkSecond= intFaces[1];
        int resultSecond = 0;
        int checkThird = intFaces[2];
        int resultThird = 0;
        int checkFourth = intFaces[3];
        int resultFourth = 0;

        for (int i = 0; i < 5; i++) {
            if (intFaces[i] == checkFirst) {
                resultFirst += 1;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (intFaces[i] == checkSecond) {
                resultSecond += 1;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (intFaces[i] == checkThird) {
                resultThird += 1;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (intFaces[i] == checkFourth) {
                resultFourth += 1;
            }
        }

        // Checks if the user got a Pair
        if (resultFirst == 2 || resultSecond == 2 || resultThird == 2 || resultFourth == 2) {
            result = "Pair!";
            pointCount = 0.50;
        }

        // Checks if the user got a Two Pair
        if (resultFirst == 2 && resultThird == 2 ||
                resultSecond == 2 && resultFourth == 2 ||
                resultFirst == 2 && resultFourth == 2) {
            result = "Two Pair!";
            pointCount = 1.50;
        }

        // Checks if the user got a Three of a Kind
        if (resultFirst == 3 || resultSecond == 3 || resultThird == 3) {
            result = "Three of a Kind!";
            pointCount = 3.00;
        }

        // Checks if the user got a Straight
        int straightResult = 0;
        for (int i = 0; i < 4; i++) {
            int checkStraight = intFaces[i];
            if ((checkStraight + 1) == intFaces[i + 1]) {
                straightResult += 1;
            }
        }
        if (straightResult == 4) {
            result = "Straight";
            pointCount = 5.00;
        }

        // Checks if the user got a Flush
        if (suitResult == 5) {
            result = "Flush!";
            pointCount = 10.00;
        }

        // Checks if the user got a Full House
        if (resultFirst == 2 && resultThird == 3 || resultFirst == 3 && resultFourth == 2) {
            result = "Full House!";
            pointCount = 50.00;
        }

        // Checks if the user got a Four of a Kind
        if (resultFirst == 4 || resultSecond == 4) {
            result = "Four of a Kind!";
            pointCount = 100.00;
        }

        // Checks if the user got a Straight Flush
        if (straightResult == 4 && suitResult == 5) {
            result = "Straight Flush!";
            pointCount = 500.00;
        }

        // Checks if the user got a Royal Flush
        if (Arrays.equals(intFaces, new int[] {10, 11, 12, 13, 14}) && suitResult == 5) {
            result = "Royal Flush!";
            pointCount = 1000.00;
        }

        if (result.equals("You Lost!")) { // Losses points if the user didn't get any combination
            Game_Runner.losePoints(1.00);
            System.out.println("You didn't get anything! Better luck next time!");
            System.out.println("You lost $1.00\n");
        }
        else {
            System.out.println("\nYou got a " + result + "\nYou Won: $" + Game_Runner.df.format(pointCount) + "\n");
            Game_Runner.addPoints(pointCount); // Adds the point count respectively to the combination they got
        }
    }
}