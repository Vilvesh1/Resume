import java.awt.*;
import java.util.*;
public class RandomWalk { // This program creates a circle that produces a raandom walk till it hits the edge of the circle. It then calculates the number of steps it takes to get to the edge.
  public static final Scanner CONSOLE = new Scanner (System.in);
  public static void main (String[]args)
    throws InterruptedException {
    
    System.out.println("Lab 7 written by VILVESH SRINIVASAN");
    System.out.println();
    
    Random rand = new Random();
    
    int radius = 0;
    
    int confirmed_radius = radius_of_Circle(radius);
    int confirmed_diameter = (confirmed_radius*2);
    int dpsize = confirmed_diameter + 50; 
    int space = (dpsize/2);
    
    DrawingPanel panel = new DrawingPanel(dpsize, dpsize);
    Graphics h = panel.getGraphics();
    
    int the_center = (space - confirmed_radius);
    
    System.out.println("What color do you want the circle to be? Your choices are RED, GREEN, and BLUE.");
    String answer = CONSOLE.next();
    String choice1 = "RED";
    String choice2 = "GREEN";
    String choice3 = "BLUE";
    String colorchoice = "USERINPUT";
    
    while (matchesChoice(answer, choice1, choice2, choice3) == false) { // Reprompts the user for puting wrong input for the color of the circle
      System.out.println("You did not type in one of the available options.");
      System.out.println("What color do you want the circle to be? Your choices are RED, GREEN, and BLUE.");
      answer = CONSOLE.next();
      matchesChoice(answer, choice1, choice2, choice3);
    }
    
    if (answer.equals("RED")||answer.equals("Red")||answer.equals("red")||answer.equals("R")||answer.equals("r")) // Sets the color of the cirlce to red
    {h.setColor(Color.RED);
      colorchoice = "red";
    }else if (answer.equals("GREEN")||answer.equals("Green")||answer.equals("green")||answer.equals("G")||answer.equals("g")) // Sets the color of the cirlce to green
    {h.setColor(Color.GREEN);
      colorchoice = "green";
    }else if (answer.equals("BLUE")||answer.equals("Blue")||answer.equals("blue")||answer.equals("B")||answer.equals("b")) // Sets the color of the cirlce to blue
    {h.setColor(Color.BLUE);
      colorchoice = "blue";
    }
    
    h.drawOval(the_center, the_center, confirmed_diameter, confirmed_diameter);
    
    System.out.println("Enter the color your want your random walk to be. Your choices are RED, GREEN, and BLUE."); 
    String answer1 = CONSOLE.next();
    String choice4 = "RED";
    String choice5 = "GREEN";
    String choice6 = "BLUE";
    String colorchoice1 = "USERINPUT";
    
    while (matchesChoice1(answer1, choice4, choice5, choice5) == false) { // Reprompts the user for puting wrong input for the color of the random walk
      System.out.println("You did not type in one of the available options.");
      System.out.println("Enter the color your want your random walk to be. Your choices are RED, GREEN, and BLUE.");
      answer1 = CONSOLE.next();
      matchesChoice1(answer1, choice4, choice5, choice6);
    }
    
    if (answer1.equals("RED")||answer1.equals("Red")||answer1.equals("red")||answer1.equals("R")||answer1.equals("r")) // Sets the color of the random walk to be red
    {h.setColor(Color.RED);
      colorchoice1 = "red";
      int the_centerx1 = space;
      int the_centery1 = space;
      int the_centerx2 = the_centerx1;
      int the_centery2 = the_centery1;
      int counter1 = 0;
      while (inside_or_outside(the_centerx1, the_centerx2, the_centery1, the_centery2, confirmed_radius)){ // Creates the random walk
        h.drawLine(the_centerx2, the_centery2, the_centerx2, the_centery2);
        int num1 = rand.nextInt(4);
        if (num1 == 0) 
        {the_centery2 = (the_centery2 + 1);
        }else if (num1 == 1) 
        {the_centerx2 = (the_centerx2 - 1);
        }else if (num1 == 2)
        {the_centerx2 = (the_centerx2 + 1);
        }else
        {the_centery2 = (the_centery2 - 1);
        }
        Thread.sleep(1);
        counter1++;
      }
      System.out.println();
      System.out.println("The radius of your circle is "+confirmed_radius+" pixels!");
      System.out.println("The color of your cirlce is "+colorchoice+"!");
      System.out.println("The color of your random walk is "+colorchoice1+"!");
      System.out.println("It took "+counter1+" steps to get to the edge of the circle!");
      
    }else if (answer1.equals("GREEN")||answer1.equals("Green")||answer1.equals("green")||answer1.equals("G")||answer1.equals("g")) // Sets the color of the random walk to be green
    {h.setColor(Color.GREEN);
      colorchoice1 = "green";
      int the_centerx3 = space;
      int the_centery3 = space;
      int the_centerx4 = the_centerx3;
      int the_centery4 = the_centerx3;
      int counter2 = 0;
      while (inside_or_outside(the_centerx3, the_centerx4, the_centery3, the_centery4, confirmed_radius)){ // Creates the random walk
        h.drawLine(the_centerx4, the_centery4, the_centerx4, the_centery4);
        int num2 = rand.nextInt(4);
        if (num2 == 0) 
        {the_centery4 = (the_centery4 + 1);
        }else if (num2 == 1) 
        {the_centerx4 = (the_centerx4 - 1);
        }else if (num2 == 2)
        {the_centerx4 = (the_centerx4 + 1);
        }else
        {the_centerx4 = (the_centery4 - 1);
        }
        Thread.sleep(1);
        counter2++;
      }
      System.out.println();
      System.out.println("The radius of your circle is "+confirmed_radius+" pixels!");
      System.out.println("The color of your cirlce is "+colorchoice+"!");
      System.out.println("The color of your random walk is "+colorchoice1+"!");
      System.out.println("It took "+counter2+" steps to get to the edge of the circle!");
      
    } else if (answer1.equals("BLUE")||answer1.equals("Blue")||answer1.equals("blue")||answer1.equals("B")||answer1.equals("b")) // Sets the color of the random walk to be blue
    {h.setColor(Color.BLUE);
      colorchoice1 = "blue";
      int the_centerx5 = space;
      int the_centery5 = space;
      int the_centerx6 = the_centerx5;
      int the_centery6 = the_centerx5;
      int counter3 = 0;
      while (inside_or_outside(the_centerx5, the_centerx6, the_centery5, the_centery6, confirmed_radius)){ // Creates the random walk
        h.drawLine(the_centerx6, the_centery6, the_centerx6, the_centery6);
        int num3 = rand.nextInt(4);
        if (num3 == 0) 
        {the_centery6 = (the_centery6 + 1);
        }else if (num3 == 1) 
        {the_centerx6 = (the_centerx6 - 1);
        }else if (num3 == 2)
        {the_centerx6 = (the_centerx6 + 1);
        }else
        {the_centery6 = (the_centery6 - 1);
        }
        Thread.sleep(1);
        counter3++;
      }
      System.out.println();
      System.out.println("The radius of your circle is "+confirmed_radius+" pixels!");
      System.out.println("The color of your cirlce is "+colorchoice+"!");
      System.out.println("The color of your random walk is "+colorchoice1+"!");
      System.out.println("It took "+counter3+" steps to get to the edge of the circle!");
    }
  }
  
  public static int radius_of_Circle(int r1) { // This method retrun raadius and check if it is within the bounds of being equal to or between 50 to 400 pixels
    System.out.println("Enter the size you want the radius of the circle to be. Make sure the radius is within the bounds of being equal to or between 50 to 400 pixels");
    r1 = CONSOLE.nextInt();
    while (!(r1 >= 50 && r1 <= 400)) {
      System.out.println("The radius size you entered was not within the bounds of being equal to or between 50 to 400 pixels.");
      r1 = CONSOLE.nextInt();
      if (r1 >= 50 && r1 <= 400)
      {break;
      }
    }
    return r1;
  }
  
  public static boolean matchesChoice(String a, String c1, String c2, String c3) { // This method return if he user input for the color was true or not for the circle color
    if (a.equals(c1)||a.equals("Red")||a.equals("red")||a.equals("R")||a.equals("r"))
    {return true;
    }else if (a.equals(c2)||a.equals("Green")||a.equals("green")||a.equals("G")||a.equals("g"))
    {return true;
    }else if (a.equals(c3)||a.equals("Blue")||a.equals("blue")||a.equals("B")||a.equals("b"))
    {return true;
    }else 
    {return false;
    }
  }
  
  public static boolean matchesChoice1(String a1, String c4, String c5, String c6) { // This method return if he user input for the color was true or not for the random walk color
    if(a1.equals(c4)||a1.equals("Red")||a1.equals("red")||a1.equals("R")||a1.equals("r"))
    {return true;
    }else if(a1.equals(c5)||a1.equals("Green")||a1.equals("green")||a1.equals("G")||a1.equals("g"))
    {return true;
    }else if(a1.equals(c6)||a1.equals("Blue")||a1.equals("blue")||a1.equals("B")||a1.equals("b"))
    {return true;
    }else
    {return false;
    } 
  }
  public static boolean inside_or_outside(int x1, int x2, int y1, int y2, int cr) { // This method returns if the random walk hits the edge of the circle or not
    if (Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)) <= cr)
    {return true;
    }else 
    {return false;
    }
  }
}
    
    