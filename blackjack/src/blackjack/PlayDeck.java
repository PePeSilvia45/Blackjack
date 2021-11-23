package blackjack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author PARKj
 */
public class PlayDeck {

    public static ArrayList<String> playDeck = deck();
    public static ArrayList<String> playDeckScore = deckScore();
    public static ArrayList<String> discard = new ArrayList<String>();

    static public ArrayList<String> deck() {

        String fileName = "playDeck.txt";
        File playDeckFile = new File(fileName);
        ArrayList<String> playDeckWhichCard = new ArrayList<>();
        try (Scanner fileReader = new Scanner(playDeckFile)) {
            while (fileReader.hasNextLine()) {
                playDeckWhichCard.add(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found" + e);
        }
        return playDeckWhichCard;
    }

    static public ArrayList<String> deckScore() {

        String fileName = "playDeckScore.txt";
        File playDeckFile = new File(fileName);
        ArrayList<String> playDeckCardValue = new ArrayList<>();
        try (Scanner fileReader = new Scanner(playDeckFile)) {
            while (fileReader.hasNextLine()) {
                playDeckCardValue.add(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found" + e);
        }
        return playDeckCardValue;
    }
}
