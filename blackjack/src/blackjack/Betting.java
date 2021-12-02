/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author PARKj
 */
public class Betting {

    public static Scanner userIn = new Scanner(System.in);
    public static double balance;
    public static double playerBet;
    public static double winnings;
    public static boolean playerDouble = false;

    public static void buyIn() {

        System.out.println("Please enter your buy in");
        System.out.print(">>");
        balance = balance + userIn.nextDouble();

    }

    public static void showBalance() {

        System.out.println("\nBalance: £" + balance + "\n");

    }

    public static void bet() {

        checkBalance();
        System.out.println("Please State your bet (min: £0.50)");
        System.out.print(">>");
        while (true) {
            playerBet = userIn.nextDouble();
            if (balance - playerBet < 0.00) {
                System.out.println("Insufficiant funds!");
                System.out.println("Please State your bet (min: £0.50)");
                System.out.print(">>");
            } else {
                balance -= playerBet;
                break;
            }
        }
    }

    public static void doubleBet() throws InterruptedException {
        while (true) {
            if (balance < playerBet) {
                System.out.println("Insufficiant funds!");
                System.out.println("Do you want to add more funds "
                        + "and double your bet?(y / n)");
                System.out.print(">>");
                String response = userIn.next();
                if (response.equalsIgnoreCase("y")) {
                    playerDouble = true;
                    showBet();
                    showBalance();
                    checkBalance();
                } else if (response.equalsIgnoreCase("n")) {
                    break;
                }
            } else {
                System.out.println("Bet doubled. One more card!");
                balance -= playerBet;
                playerBet = playerBet * 2;
                break;
            }
        }

    }

    public static void showBet() {

        System.out.println("\nBet: £" + playerBet);
        System.out.println("New Balance: £" + balance);

    }

    public static double playerWinnings() {

        if (GameEnd.playerBlackJack == true) {
            winnings = playerBet * 2.5;
        } else if (GameEnd.push == true) {
            winnings = playerBet;
        } else if (GameEnd.playerWin == true) {
            winnings = playerBet * 2;
        } else {
            winnings = 0;
        }
        balance += winnings;
        return winnings;

    }

    public static void showWinnings() {
        System.out.println("\nWinnnings: £" + playerWinnings());

        GameEnd.playerWin = false;
        GameEnd.playerBlackJack = false;
        GameEnd.push = false;
    }

    public static void checkBalance() {
        if (balance <= 0) {
            System.out.println("Out of Funds!");
            buyIn();
        } else if (balance < playerBet) {
            System.out.println("Insufficiant funds!");
            buyIn();
        }
    }
}
