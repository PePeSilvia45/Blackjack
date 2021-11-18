/*
 *  create a simple blackjack dealer with the hopes of developing play
 */
package blackjack;
/**
 * @author James.P
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {

    public static ArrayList<String> playDeck = PlayDeck.deck();
    public static ArrayList<String> playDeckScore = PlayDeck.deckScore();
    public static ArrayList<String> discard = new ArrayList<String>();
    public static ArrayList<String> playerHand = new ArrayList<String>();
    public static ArrayList<String> dealerHand = new ArrayList<String>();
    public static int playerScore = 0;
    public static int dealerScore = 0;
    
    public static Scanner userIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        dealer(playDeck.size());
        System.out.print("Player has ");
        for(String card : playerHand){
            System.out.print(card + " ");
        }System.out.println("total: " + playerScore);
        
        
        System.out.print("Dealer has ");
        for(String card : dealerHand){
            System.out.print(card + " ");
        }System.out.println("total: " + dealerScore);
    }
    
    public static void dealer(int cardsLeft){
        
        Random rnd = new Random();
        
        int n = rnd.nextInt(cardsLeft);
        playerHand.add(playDeck.get(n));
        playDeck.remove(n);
        playerScore = playerScore + Integer.valueOf(playDeckScore.get(n));
        playDeckScore.remove(n);
        
        n = rnd.nextInt(cardsLeft-1);
        dealerHand.add(playDeck.get(n));
        playDeck.remove(n);
        dealerScore = dealerScore + Integer.valueOf(playDeckScore.get(n));
        playDeckScore.remove(n);
        
        n = rnd.nextInt(cardsLeft-1);
        playerHand.add(playDeck.get(n));
        playDeck.remove(n);
        playerScore = playerScore + Integer.valueOf(playDeckScore.get(n));
        playDeckScore.remove(n);
        
        n = rnd.nextInt(cardsLeft-1);
        dealerHand.add(playDeck.get(n));
        playDeck.remove(n);
        dealerScore = dealerScore + Integer.valueOf(playDeckScore.get(n));
        playDeckScore.remove(n);
    }
    
    public static void deal(){
        
        //plaayer gets one then dealer gets 1 and then again
        
        
    }
    
    public static void shuffle(){
        
        int i = 0;
        while(i<52){
            playDeck.add(discard.get(i));
            i++;
        }
        discard.clear();
        System.out.println("Suffled");
    
    }
    
}
