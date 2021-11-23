/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author PARKj
 */
public class GameEnd {

    public static void scoring() {

        if (Dealer.playerScore == 21 && Dealer.playerHand.size() == 2) {
            System.out.println("Player Wins BLACKJACK!");
        } else if (Dealer.playerScore == Dealer.dealerScore && Dealer.playerScore <= 21 && Dealer.dealerScore <= 21) {
            System.out.println("Push");
        } else if (Dealer.playerScore > Dealer.dealerScore && Dealer.playerScore <= 21) {
            System.out.println("Player Wins!");
        } else if (Dealer.playerScore < Dealer.dealerScore && Dealer.dealerScore <= 21) {
            System.out.println("Dealer Wins");
        } else if (Dealer.playerScore > 21) {
            System.out.println("Player Bust");
        } else if (Dealer.dealerScore > 21 && Dealer.playerScore <= 21) {
            System.out.println("Dealer Bust\nPlayer Wins");
        }
    }

    public static void keepPlaying() {
        int keepPlaying = 0;
        while (keepPlaying != 1 || keepPlaying != 2) {
            System.out.println("\nWould you like to play again? (y / n) >>");
            String response = Dealer.userIn.next();
            if (response.equalsIgnoreCase("y")) {

                Dealer.playerHand.forEach(card -> {
                    PlayDeck.discard.add(card);
                });
                Dealer.playerHand.clear();

                Dealer.dealerHand.forEach(card -> {
                    PlayDeck.discard.add(card);
                });
                Dealer.dealerHand.clear();

                Dealer.playerScore = 0;
                Dealer.dealerScore = 0;

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

        if (PlayDeck.playDeck.size() < 17 && PlayDeck.playDeckScore.size() < 17) {
            System.out.print("Shuffling...");
            PlayDeck.discard.clear();
            PlayDeck.playDeck.clear();
            PlayDeck.playDeck = PlayDeck.deck();
            PlayDeck.playDeckScore.clear();
            PlayDeck.playDeckScore = PlayDeck.deckScore();
            System.out.println("Suffled");
            System.out.println(PlayDeck.playDeck.size());
            System.out.println(PlayDeck.playDeckScore.size());
        }
    }

}
