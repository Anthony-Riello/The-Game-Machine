import java.text.DecimalFormat;

/**
 * Designed to be a central hub for Game Running and Point System
 *
 * @author Anthony Riello
 * @version - V1 09/28/2022
 */
public class Game_Runner {
    private static double points = 0.00;
    public static final DecimalFormat df = new DecimalFormat("0.00"); // So it prints with two decimal places

    /*
    Methods to show and edit points
     */
    public static String getPoints() {
        return df.format(points);
    }

    public static void addPoints(double add) {
        points += add;
    }

    public static void losePoints(double subtract) {
        points -= subtract;
    }

    public static void main(String[] args) {
        Game_Select.Startup();
        Game_Select.Select();
    }
}