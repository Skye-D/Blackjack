import java.lang.*;
import java.util.*;

public class Blackjack {
    public static void main(String[] args) {
        deal1();
    }

    public static String deal1() {

        int playerCardCount = 0;
        int dealerCardCount = 0;
        double cardValue = Math.floor(Math.random() * 10 + 1);
        double cardValue2 = Math.floor(Math.random() * 10 + 1);
        int dealcount = 0;


        dealerCardCount += cardValue;
        playerCardCount += cardValue2;

        System.out.println("Dealer has " + (dealerCardCount));
        System.out.println("You have " + playerCardCount);
        System.out.println("Type 's' to stay or 'h' hit and press enter.");
        
        while ((dealerCardCount <= 21) && (playerCardCount <= 21)) {
            Scanner cont = new Scanner(System.in);
            Scanner scan = new Scanner(System.in);
            String str = scan.next();
            char action = str.charAt(0);
            
            if ((action == 'h') || (action == 's')){
                
                if (dealerCardCount >= 21) {
                    System.out.println ("The dealer has busted with a score of " + dealerCardCount + ". You win!");
                }
                if (playerCardCount > 21) {
                    System.out.println ("You have busted with a score of " + playerCardCount + ". Dealer wins!");

                }
                if (action == 'h') {
                    playerCardCount += (int) cardValue;
                    if (playerCardCount > 21){
                        System.out.println("You now have " + playerCardCount + ". You have busted. Dealer wins.");
                        break;
                    }
                    dealerCardCount += (int) cardValue2;
                    System.out.println("you now have " + playerCardCount + ". The dealer has drawn and now has " + dealerCardCount + ".");
                } else if ((action == 'h') && (dealerCardCount > 16)) {
                    playerCardCount += (int) cardValue;
                    System.out.println("you now have " + playerCardCount + ". The dealer has not drawn since their score totals 16 or more. The dealer has " + dealerCardCount + ". Would you like to hit or stay?");
                    str = scan.next();
                    action = str.charAt(0);
                }
                
                if ((action == 's') && (dealerCardCount <= 16)) {
                    while (dealerCardCount <= 16) {
                        dealerCardCount += (int) cardValue;
                    }if ((dealerCardCount > playerCardCount) && (dealerCardCount <= 21)) {
                        System.out.println ("you have " + playerCardCount + ". The dealer has drawn and now has " + dealerCardCount + ". Dealer wins");
                        break;
                    }} else if ((action == 's') && (dealerCardCount >= 16)) {
                    playerCardCount += (int) cardValue;
                    if ((dealerCardCount > playerCardCount) && (dealerCardCount <= 21)){
                        System.out.println ("you now have " + playerCardCount + ". The dealer has not drawn since their score totals 16 or more. The dealer has " + dealerCardCount + ". Dealer wins!");
                        break;
                    } else if (dealerCardCount < playerCardCount) {
                        System.out.println ("you now have " + playerCardCount + ". The dealer has not drawn since their score totals 16 or more. The dealer has " + dealerCardCount + ". You win!");
                        break;
                    }
                    
                    else {
                        System.out.println("You and the dealer have tied!");
                        break;
                    }


                }
                if (dealerCardCount >= 21) {
                    System.out.println ("Game Finished. Dealer busted with a score of " + dealerCardCount + ". Player wins!");
                }
            }
            
            else {
                System.out.println("Please enter a valid entry of either 's' or 'h'.");
            }
        }return "-1";
    }
}
