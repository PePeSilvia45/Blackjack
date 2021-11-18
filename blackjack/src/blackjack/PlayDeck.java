package blackjack;

import java.util.ArrayList;
/**
 * @author PARKj
 */
public class PlayDeck {
    
    static public ArrayList<String> deck(){
    
        ArrayList<String> playDeck = new ArrayList<>();
        playDeck.add("C2");playDeck.add("S2");playDeck.add("D2");playDeck.add("H2");
        playDeck.add("C3");playDeck.add("S3");playDeck.add("D3");playDeck.add("H3");
        playDeck.add("C4");playDeck.add("S4");playDeck.add("D4");playDeck.add("H4");
        playDeck.add("C5");playDeck.add("S5");playDeck.add("D5");playDeck.add("H5");
        playDeck.add("C6");playDeck.add("S6");playDeck.add("D6");playDeck.add("H6");
        playDeck.add("C7");playDeck.add("S7");playDeck.add("D7");playDeck.add("H7");
        playDeck.add("C8");playDeck.add("S8");playDeck.add("D8");playDeck.add("H8");
        playDeck.add("C9");playDeck.add("S9");playDeck.add("D9");playDeck.add("H9");
        playDeck.add("C10");playDeck.add("S10");playDeck.add("D10");playDeck.add("H10");
        playDeck.add("CJ");playDeck.add("SJ");playDeck.add("DJ");playDeck.add("HJ");
        playDeck.add("CQ");playDeck.add("SQ");playDeck.add("DQ");playDeck.add("HQ");
        playDeck.add("CK");playDeck.add("SK");playDeck.add("DK");playDeck.add("HK");
        playDeck.add("CA");playDeck.add("SA");playDeck.add("DA");playDeck.add("HA");
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
