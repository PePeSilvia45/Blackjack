/*
 *  create a simple blackjack dealer with the hopes of developing play
    
    if score over 11 the Ace(11) == 1 !!!!
    deck class cleaner using txt file and reading it in

 */
package blackjack;

/**
 * @author James.P
 */
public class Blackjack {

    /**
     * @param args
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        while (true) {
            GameEnd.shuffle();
            Dealer.deal();
            //players turn
            while (true) {
                if (Dealer.playerStick()) {
                    break;
                }
            }
            GameEnd.scoring();
            GameEnd.keepPlaying();
        }
    }

    

    

}
