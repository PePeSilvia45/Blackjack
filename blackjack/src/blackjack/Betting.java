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
    
    public static void buyIn() {
        
        System.out.println("Please enter your buy in");
        System.out.print(">>");
        balance = userIn.nextDouble();
        
    }
    
    public static void showBalance(){
        
        System.out.println("\nBalance: £" + balance + "\n");
        
    }
    
    public static void bet(){
        
        System.out.println("Please State your bet (min: £0.50)");
        System.out.print(">>");
        playerBet = userIn.nextDouble();
        balance -= playerBet;
        
    }
    
    public static void showBet(){
        
        System.out.println("\nBet: £" + playerBet);
        System.out.println("New Balance: £"+balance);
        
    }
    
    public static double playerWinnings(){
        
        if(GameEnd.playerBlackJack == true){
            winnings = playerBet*2.5;
        }else if (GameEnd.push == true){
            winnings = playerBet;
        }else if (GameEnd.playerWin == true){
            winnings = playerBet*2;
        }else{
            winnings = 0;
        }
        balance += winnings;
        return winnings;
        
    }
    
    public static void showWinnings(){
        System.out.println("\nWinnnings: £" + playerWinnings());
    }
    
}
