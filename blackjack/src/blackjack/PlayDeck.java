package blackjack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author PARKj
 */
public class PlayDeck {
    
    static public ArrayList<String> deck(){
    
        String fileName = "playDeck.txt";
        File playDeckFile = new File(fileName);
        ArrayList<String> playDeck = new ArrayList<>();
        try(Scanner fileReader = new Scanner(playDeckFile)){
            while(fileReader.hasNextLine()){
                playDeck.add(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found" + e);
        }
        return playDeck;
    }
    static public ArrayList<String> deckScore(){
    
        String fileName = "playDeckScore.txt";
        File playDeckFile = new File(fileName);
        ArrayList<String> playDeck = new ArrayList<>();
        try(Scanner fileReader = new Scanner(playDeckFile)){
            while(fileReader.hasNextLine()){
                playDeck.add(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not Found" + e);
        }
        return playDeck;
    }
}
