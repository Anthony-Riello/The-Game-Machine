import java.util.LinkedList;

/**
 * Designed to play the Game of Black Jack
 *
 * @author Anthony Riello
 * @version - V1 10/5/2022
 */
public class BlackJack extends Poker {

    private int CardCount = 2;

    final private LinkedList<String> hand = new LinkedList<>();

    public LinkedList<String> createHand() { // Puts cards into linked list
        for (int i = 0; i < 2; i++) {
            hand.add(getFace() + " of " + getSuit());
        }
        checkDupes();
        return hand;
    }

    public void addCards() { // Adds card when user hits
        if (hand.size() != CardCount) {
            hand.add(getFace() + " of " + getSuit());
            CardCount = hand.size();
            checkDupes();
        }
    }

    public void Hit() {
        hand.add(getFace() + " of " + getSuit());
        CardCount += 1;
        checkDupes();
    }

    public LinkedList<String> showHand() { // Prints the entire linked list of cards
        return hand;
    }
}
