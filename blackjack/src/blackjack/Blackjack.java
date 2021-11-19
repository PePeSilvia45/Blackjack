/*
 *  create a simple blackjack dealer with the hopes of developing play
    
    if score over 11 the Ace(11) == 1 !!!!
    deck class cleaner using txt file and reading it in

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

        while (true) {
            System.out.println(playDeck.size());
            System.out.println(playDeckScore.size());
            shuffle();
            deal();
            //players turn
            while (true) {
                if (playerStick()) {
                    break;
                }
            }
            scoring();
            keepPlaying();
        }
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

    public static void deal() {

        dealer(playDeck.size());

        System.out.print("Player has ");
        playerHand.forEach(card -> {
            System.out.print(card + " ");
        });
        System.out.println("total: " + playerScore);

        System.out.println("Dealer has ** " + dealerHand.get(1) + " ");

    }

    public static void playerDeal(int cardsLeft) {

        int n = rnd.nextInt(cardsLeft);
        playerHand.add(playDeck.get(n));
        playDeck.remove(n);
        playerScore = playerScore + Integer.valueOf(playDeckScore.get(n));
        playDeckScore.remove(n);

    }

    public static boolean playerStick() {
        if (playerScore == 21 || playerScore > 21) {
            return true;
        }
        System.out.print("Stick or Hit?\n>>");
        String response = userIn.next();
        if (response.equalsIgnoreCase("stick")) {
            dealerStick();
            return true;
        } else if (response.equalsIgnoreCase("hit")) {
            playerHit(playDeck.size());
        }
        return false;
    }

    public static void playerHit(int cardsLeft) {

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

    public static void dealerDeal(int cardsLeft) {

        int n = rnd.nextInt(cardsLeft);
        dealerHand.add(playDeck.get(n));
        playDeck.remove(n);
        dealerScore = dealerScore + Integer.valueOf(playDeckScore.get(n));
        playDeckScore.remove(n);

    }

    public static void dealerStick() {
        boolean stick = false;
        while (stick == false) {
            System.out.print("Dealer has ");
            dealerHand.forEach(card -> {
                System.out.print(card + " ");
            });
            System.out.println("total: " + dealerScore);
            if (dealerScore < 16) {
                dealerHit(playDeck.size());
            } else {
                stick = true;
            }
        }
    }

    public static void dealerHit(int cardsLeft) {
        while (dealerScore < 16) {
            int n = rnd.nextInt(cardsLeft);
            dealerHand.add(playDeck.get(n));
            playDeck.remove(n);
            dealerScore = dealerScore + Integer.valueOf(playDeckScore.get(n));
            playDeckScore.remove(n);
            System.out.print("dealer hits ");
            dealerHand.forEach(card -> {
                System.out.print(card + " ");
            });
            dealerScore = 22;
            System.out.println("total: " + dealerScore);
        }

    }

    public static void scoring() {

        if (playerScore == 21 && playerHand.size() == 2) {
            System.out.println("Player Wins BLACKJACK!");
        } else if (playerScore == dealerScore && playerScore <= 21 && dealerScore <= 21) {
            System.out.println("Push");
        } else if (playerScore > dealerScore && playerScore <= 21) {
            System.out.println("Player Wins!");
        } else if (playerScore < dealerScore && dealerScore <= 21) {
            System.out.println("Dealer Wins");
        } 
        if (dealerScore > 21 && playerScore <= 21) {
            System.out.println("Dealer Bust\nPlayer Wins");
        }
    }

    public static void keepPlaying() {
        int keepPlaying = 0;
        while (keepPlaying != 1 || keepPlaying != 2) {
            System.out.println("Would you like to play again? (y / n) >>");
            String response = userIn.next();
            if (response.equalsIgnoreCase("y")) {

                for (String card : playerHand) {
                    discard.add(card);
                }
                playerHand.clear();

                for (String card : dealerHand) {
                    discard.add(card);
                }
                dealerHand.clear();

                playerScore = 0;
                dealerScore = 0;
                System.out.println(discard.size());

                break;
            } else if (response.equalsIgnoreCase("n")) {
                System.out.println("Thankyou for Playing");
                System.exit(0);
            } else {
                keepPlaying = 0;
            }
        }

    }

    public static void shuffle() {

        if (playDeck.size() < 17 && playDeckScore.size() < 17) {
            System.out.print("Shuffling...");
            discard.clear();
            playDeck.clear();
            playDeck = PlayDeck.deck();
            playDeckScore.clear();
            playDeckScore = PlayDeck.deckScore();
            System.out.println("Suffled");
            System.out.println(playDeck.size());
            System.out.println(playDeckScore.size());
        }
    }

}
