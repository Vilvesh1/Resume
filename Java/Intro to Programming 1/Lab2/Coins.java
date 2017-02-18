
import java.util.*;
// This program calculates the amount of coins you have in total along with the total value, and it also splits you value amount into coins
public class Coins {
   
    public static final Scanner CONSOLE = new Scanner(System.in);
// This is the main method which states the methods to call
    public static void main(String[] args) {
    System.out.println("Lab 2 written by VILVESH SRINIVASAN");  
      
    TotalnumberofCoinsandValue();
    GroupingCoins();
    
    }
    
// This method calculates the amount of coins you have in total along with the total value     
    public static void TotalnumberofCoinsandValue(){
  
        int quarters;
        int dimes;
        int nickels;
        int pennies;
        double quartersvalue;
        double dimesvalue;
        double nickelsvalue;
        double penniesvalue;
        
        
      

        
        System.out.println("Enter the amount of quarters:");
        quarters = CONSOLE.nextInt();
        quartersvalue = quarters * 0.25;
        
        System.out.println("Enter the amount of dimes:");
        dimes = CONSOLE.nextInt();
        dimesvalue = dimes * 0.10;
        
        System.out.println("Enter the amount of nickels:");
        nickels = CONSOLE.nextInt();
        nickelsvalue = nickels * 0.05;
        
        System.out.println("Enter the amount of pennies:");
        pennies = CONSOLE.nextInt();
        penniesvalue = pennies * 0.01;
        
        
        
        
        System.out.print("Number of Coins = ");
        System.out.println(quarters + dimes + nickels + pennies);
        System.out.print("Total Value = $");
        System.out.println(quartersvalue + dimesvalue + nickelsvalue + penniesvalue);
        
        
        
    }
    // This method splits you value amount into coins
    public static void GroupingCoins(){ 
        int quarters;
        int dimes;
        int nickels;
        int pennies;
        int total;
        
       
        total = CONSOLE.nextInt();
        quarters = total / 25;
        total = total % 25;
        dimes = total / 10;
        total = total % 10;
        nickels = total / 5;
        total = total % 5;
        pennies = total;

        System.out.println("You have: " +quarters+ " quarters " +dimes+ " dimes " +nickels+ " nickels " +pennies+ " pennies ");
    }
}