/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author PARKj
 */
public class Dealer {

    public static ArrayList<String> playerHand = new ArrayList<String>();
    public static ArrayList<String> dealerHand = new ArrayList<String>();
    public static Random rnd = new Random();
    public static Scanner userIn = new Scanner(System.in);
    public static int playerScore = 0;
    public static int dealerScore = 0;
    public static int playerAces = 0;
    public static int dealerAces = 0;
    
    public static void deal() {
        
        Betting.showBalance();
        Betting.bet();
        dealer(PlayDeck.playDeck.size());
        System.out.println("Dealer has\n[ ** ] [ " + dealerHand.get(1) + " ]");
        System.out.println("\nPlayer has");
        playerHand.forEach(card -> {
            System.out.print("[ " + card + " ] ");
        });
        System.out.println("\ntotal: " + playerScore);

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
        String cardtxt = PlayDeck.playDeck.get(n);
        String cardVal = PlayDeck.playDeckScore.get(n);
        if ("11".equals(cardVal)) playerAces++;
        playerScore = playerScore + Integer.valueOf(cardVal);
        playerHand.add(cardtxt);
        PlayDeck.playDeck.remove(n);
        PlayDeck.playDeckScore.remove(n);
        if (playerAces == 2) {
            playerScore-=10;
            playerAces--;
        }
    }

    public static void dealerDeal(int cardsLeft) {

        int n = rnd.nextInt(cardsLeft);
        String cardtxt = PlayDeck.playDeck.get(n);
        String cardVal = PlayDeck.playDeckScore.get(n);
        if ("11".equals(cardVal)) dealerAces++;
        dealerHand.add(cardtxt);
        PlayDeck.playDeck.remove(n);
        dealerScore = dealerScore + Integer.valueOf(cardVal);
        PlayDeck.playDeckScore.remove(n);
        if (dealerAces == 2) {
            dealerScore-=10;
            dealerAces--;
        }
    }

    public static boolean playerStick() throws InterruptedException {

        if (playerScore == 21 || playerScore > 21) {
            return true;
        }
        Betting.showBet();
        System.out.print("\nStick or Hit?\n>>");
        String response = userIn.next();
        if (response.equalsIgnoreCase("stick")) {
            dealerStick();
            return true;
        } else if (response.equalsIgnoreCase("hit")) {
            playerHit(PlayDeck.playDeck.size());
        }
        return false;
    }

    public static void playerHit(int cardsLeft) {
        int n = rnd.nextInt(cardsLeft);
        String cardtxt = PlayDeck.playDeck.get(n);
        String cardVal = PlayDeck.playDeckScore.get(n);
        if ("11".equals(cardVal)) playerAces++;
        playerHand.add(cardtxt);
        PlayDeck.playDeck.remove(n);
        if (playerScore > 10 && "11".equals(cardVal)) {
            playerScore = playerScore + 1;
            playerAces--;
        } else {
            playerScore = playerScore + Integer.valueOf(cardVal);
            if(playerScore > 11 && playerAces != 0) {
                playerScore -= 10;
                playerAces--;
            }
        }
        PlayDeck.playDeckScore.remove(n);
        System.out.print("\nPlayer hits : ");
        System.out.print("[ " + playerHand.get(playerHand.size() - 1) + " ] ");
        System.out.println("\nPlayer has");
        playerHand.forEach(card -> {
            System.out.print("[ " + card + " ] ");
        });
        System.out.println("\ntotal: " + playerScore);
    }

    public static void dealerHit(int cardsLeft) throws InterruptedException {
        while (dealerScore < 16) {
            int n = rnd.nextInt(cardsLeft);
            dealerHand.add(PlayDeck.playDeck.get(n));
            PlayDeck.playDeck.remove(n);
            if (dealerScore > 10 && "11".equals(PlayDeck.playDeckScore.get(n))) {
                dealerScore = dealerScore + 1;
            } else {
                dealerScore = dealerScore + Integer.valueOf(PlayDeck.playDeckScore.get(n));
                if(dealerScore > 11 && dealerAces != 0) {
                dealerScore -= 10;
                dealerAces--;
            }
            }
            PlayDeck.playDeckScore.remove(n);
            System.out.print("\ndealer hits : ");
            System.out.print("[ " + dealerHand.get(dealerHand.size() - 1) + " ] ");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println();
        System.out.println("Dealer Sticks");
        TimeUnit.MILLISECONDS.sleep(500);
    }

    public static void dealerStick() throws InterruptedException {
        boolean stick = false;
        while (stick == false) {
            System.out.println("\nDealer has");
            dealerHand.forEach(card -> {
                System.out.print("[ " + card + " ] ");
            });
            System.out.println("\ntotal: " + dealerScore);
            if (dealerScore < 16) {
                dealerHit(PlayDeck.playDeck.size());
            } else {
                stick = true;
            }
        }
    }

}
