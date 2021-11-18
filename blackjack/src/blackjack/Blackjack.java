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
    public static Random rnd = new Random();
    public static Scanner userIn = new Scanner(System.in);
    public static int playerScore = 0;
    public static int dealerScore = 0;

    public static void main(String[] args) {
        
        deal();
            
        boolean stick = false;
        //players turn
        while (stick == false) {
            System.out.print("Stick or Hit?");
            String response = userIn.next();
            if (response.equalsIgnoreCase("stick")) {
                stick = true;
            } else if (response.equalsIgnoreCase("hit")) {
                playerHit(playDeck.size());
            }
            if(playerScore > 21){
                System.out.println("BUST!");
                System.exit(0);
            }else if (playerScore == 21){
                System.out.println("You Win");
                System.exit(0);
            }
        }
        
        //dealers turn 
        stick = false;
        while (stick == false) {
        if (dealerScore < 16){
            dealerHit(playDeck.size());
        }
        else if (dealerScore > 21 && playerScore < 21) {
            System.out.println("Dealer bust Player Wins!");
            System.exit(0);
        }
        else {
            stick = true;
        }
        }
        if (playerScore > dealerScore){
            System.out.println("Player Wins!");
        }
        else System.out.println("Dealer Wins");
    }

    public static void dealer(int cardsLeft) {

        playerDeal(cardsLeft);
        cardsLeft = cardsLeft - 1;
        dealerDeal(cardsLeft);
        cardsLeft = cardsLeft - 1;
        playerDeal(cardsLeft);
        cardsLeft = cardsLeft - 1;
        dealerDeal(cardsLeft);
    }

    public static void playerDeal(int cardsLeft) {

        int n = rnd.nextInt(cardsLeft);
        playerHand.add(playDeck.get(n));
        playDeck.remove(n);
        playerScore = playerScore + Integer.valueOf(playDeckScore.get(n));
        playDeckScore.remove(n);

    }

    public static void dealerDeal(int cardsLeft) {

        int n = rnd.nextInt(cardsLeft);
        dealerHand.add(playDeck.get(n));
        playDeck.remove(n);
        dealerScore = dealerScore + Integer.valueOf(playDeckScore.get(n));
        playDeckScore.remove(n);

    }

    public static void deal() {
        dealer(playDeck.size());
        
        System.out.print("Player has ");
        playerHand.forEach(card -> {
            System.out.print(card + " ");
        });
        System.out.println("total: " + playerScore);
        if (playerScore == 21) {
            System.out.println("WINNER!");
        }

        System.out.print("Dealer has ");
        dealerHand.forEach(card -> {
            System.out.print(card + " ");
        });
        System.out.println("total: " + dealerScore);
        if (dealerScore == 21) {
            System.out.println("Dealer Wins");
        }
    }

    public static void playerHit(int cardsLeft){
        
        int n = rnd.nextInt(cardsLeft);
        playerHand.add(playDeck.get(n));
        playDeck.remove(n);
        playerScore = playerScore + Integer.valueOf(playDeckScore.get(n));
        playDeckScore.remove(n);
        System.out.print("Player has ");
        playerHand.forEach(card -> {
            System.out.print(card + " ");
        });
        System.out.println("total: " + playerScore);
        
    }
    
    public static void dealerHit(int cardsLeft){
        while(dealerScore < 16){
            int n = rnd.nextInt(cardsLeft);
            dealerHand.add(playDeck.get(n));
            playDeck.remove(n);
            dealerScore = dealerScore + Integer.valueOf(playDeckScore.get(n));
            playDeckScore.remove(n);
            System.out.print("dealer has ");
            dealerHand.forEach(card -> {
                System.out.print(card + " ");
            });
            System.out.println("total: " + dealerScore);
        }
        
    }
    
    public static void shuffle() {

        int i = 0;
        while (i < 52) {
            playDeck.add(discard.get(i));
            i++;
        }
        discard.clear();
        System.out.println("Suffled");

    }

}
