package blackjack;

import java.util.ArrayList;
/**
 * @author PARKj
 */
public class PlayDeck {
    
    static public ArrayList<String> deck(){
    
        ArrayList<String> playDeck = new ArrayList<>();
        playDeck.add("2C");playDeck.add("2S");playDeck.add("2D");playDeck.add("2H");
        playDeck.add("3C");playDeck.add("3S");playDeck.add("3D");playDeck.add("3H");
        playDeck.add("4C");playDeck.add("4S");playDeck.add("4D");playDeck.add("4H");
        playDeck.add("5C");playDeck.add("5S");playDeck.add("5D");playDeck.add("5H");
        playDeck.add("6C");playDeck.add("6S");playDeck.add("6D");playDeck.add("6H");
        playDeck.add("7C");playDeck.add("7S");playDeck.add("7D");playDeck.add("7H");
        playDeck.add("8C");playDeck.add("8S");playDeck.add("8D");playDeck.add("8H");
        playDeck.add("9C");playDeck.add("9S");playDeck.add("9D");playDeck.add("9H");
        playDeck.add("10C");playDeck.add("10S");playDeck.add("10D");playDeck.add("10H");
        playDeck.add("JC");playDeck.add("JS");playDeck.add("JD");playDeck.add("JH");
        playDeck.add("QC");playDeck.add("QS");playDeck.add("QD");playDeck.add("QH");
        playDeck.add("KC");playDeck.add("KS");playDeck.add("KD");playDeck.add("KH");
        playDeck.add("AC");playDeck.add("AS");playDeck.add("AD");playDeck.add("AH");
        return playDeck;
    }
    static public ArrayList<String> deckScore(){
    
        ArrayList<String> playDeck = new ArrayList<>();
        playDeck.add("2");playDeck.add("2");playDeck.add("2");playDeck.add("2");
        playDeck.add("3");playDeck.add("3");playDeck.add("3");playDeck.add("3");
        playDeck.add("4");playDeck.add("4");playDeck.add("4");playDeck.add("4");
        playDeck.add("5");playDeck.add("5");playDeck.add("5");playDeck.add("5");
        playDeck.add("6");playDeck.add("6");playDeck.add("6");playDeck.add("6");
        playDeck.add("7");playDeck.add("7");playDeck.add("7");playDeck.add("7");
        playDeck.add("8");playDeck.add("8");playDeck.add("8");playDeck.add("8");
        playDeck.add("9");playDeck.add("9");playDeck.add("9");playDeck.add("9");
        playDeck.add("10");playDeck.add("10");playDeck.add("10");playDeck.add("10");
        playDeck.add("10");playDeck.add("10");playDeck.add("10");playDeck.add("10");
        playDeck.add("10");playDeck.add("10");playDeck.add("10");playDeck.add("10");
        playDeck.add("10");playDeck.add("10");playDeck.add("10");playDeck.add("10");
        playDeck.add("11");playDeck.add("11");playDeck.add("11");playDeck.add("11");
        return playDeck;
    }
}
