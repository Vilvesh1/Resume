import java.util.*;
public class Playoffs { // This program simulates playoffs, and calculates wins useing randoms and a percent chance of a team winning specifiaclly Team 1
  public static final Scanner CONSOLE = new Scanner (System.in);
  public static void main (String[]args) { // This method tells if Team 1 won 10 more games than Team 2 or not 
    System.out.println("Lab 6 written by VILVESH SRINIVASAN");
    System.out.println();
    int outcome = 101;
    int chance = percentage(outcome);
    Random rand = new Random();
    System.out.println();
    
    int game_3 = ten_games(chance , rand);
    if (game_3  == 1)
    { System.out.println("Team 1 won 10 games more than the other team first!!");
      System.out.println();
    } else 
    { System.out.println("Team 2 won 10 games more than the other team first!!");
      System.out.println();
    }
  }
    
    public static int single_game( int chance , Random rand){ // This method tells if Team 1 won the single game match versus Team 2
      int num1 = rand.nextInt(100);
      if (num1 <= chance) 
    { //System.out.println("Team 1 won the first game");
      return 1;
    } else 
    { //System.out.println("Team 2 won the first game");
      return 0;
    }
   }
    
    public static int four_games(int chance , Random rand){ // This method tells if Team 1 won 4 game first before Team 2 or not calculate who wins the playoff
      int i = 1;
      int counter_1 = 0;
      int counter_2 = 0;
      while (i >= -5) {
        if (single_game(chance, rand) == 1) 
        { //System.out.println("Team 1 wins game");
          counter_1++;
        } else
        { //System.out.println("Team 2 wins game");
          counter_2++;
        }
        if (counter_1 == 4)
        { break;
        }else if (counter_2 == 4)
        { break;
        }
        
        i++;
      }
      if (counter_1 == 4)
      { return 1;
      } else
      { return 0;
      }
    }
    
    public static int ten_games(int chance , Random rand){ // This method tells who wins the playoff 10 more than the other team first
      int i = 1;
      int counter_1 = 0;
      int counter_2 = 0;
      System.out.println("The Score Board Shows the first team to win 10 playoff games more than the other team");
      while (i >= -10) {
        if (four_games(chance,rand)==1)
        { //System.out.println("Team 1 wins playoff");
          counter_1++;
          System.out.print("|1| ");
        } else
        { //System.out.println("Team 2 wins playoff");
          counter_2++;
          System.out.print("|2| ");
        }
        if (counter_1 == (counter_2+10))
        { break;
        }else if (counter_2 == (counter_1+10))
        { break;
        }
      }
      System.out.println();
      System.out.println("KEY (1 = Team 1 won) (2 = Team 2 won)");
      System.out.println();
      if (counter_1 == (counter_2+10))
      { return 1;
      } else
      { return 0;
      }
    }
    
    public static int percentage(int percent){ // This method loops the scanner until user types a valid percent that is between or equal to 0 and 100 without the percent sign
      System.out.println("What is the percent chance Team 1 will win a game? (make sure your value writen as a whole number and is between or equal to 0 and 100 and also don't put percent sign Ex 51)");
      while (!(percent <= 100 && percent >= 0)) {
        percent = CONSOLE.nextInt();
        if (percent <= 100 && percent >= 0)
        { break;
        }
        System.out.println("Try typing a whole number between or equal to 0 and 100 also don't put percent sign if you did(Ex 51)");
        }
      return percent;
    }      
}
      
      
      
