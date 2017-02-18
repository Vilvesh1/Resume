import java.util.Scanner; 
import java.awt.*;
public class Circles {
  
  public static final Scanner CONSOLE = new Scanner (System.in);// This is where I created the scanner
  public static void main (String[]args) {// In this method I printed statements, created the circles, and used if statements that decided what to print based off user input
    System.out.println("Lab 5 written by VILVESH SRINIVASAN");
    System.out.println();
    DrawingPanel panel = new DrawingPanel(400, 300);// This is where I created the drwing pannel
    Graphics h = panel.getGraphics(); 
    
  int xdistance;
  int ydistance;
  int radius;
  int xdistance2;
  int ydistance2;
  int radius2;
  int xdistance3;
  int ydistance3;
  int radius3;
  int biggerorsmaller;
  int comparetocircle3;
  
    System.out.println("Enter the center x-coordinate for blue circle 1");
    xdistance = CONSOLE.nextInt();
    System.out.println("Enter the center y-coordinate for blue circle 1");
    ydistance = CONSOLE.nextInt();
    System.out.println("Enter the radius for blue circle 1");
    radius = CONSOLE.nextInt();
    System.out.println("Enter the center x-coordinate for red circle 2");
    xdistance2 = CONSOLE.nextInt();
    System.out.println("Enter the center y-coordinate for red circle 2");
    ydistance2 = CONSOLE.nextInt();
    System.out.println("Enter the radius for red circle 2");
    radius2 = CONSOLE.nextInt();
    System.out.println("Enter the center x-coordinate for green circle 3");
    xdistance3 = CONSOLE.nextInt();
    System.out.println("Enter the center y-coordinate for green circle 3");
    ydistance3 = CONSOLE.nextInt();
    System.out.println("Enter the radius for green circle 3");
    radius3 = CONSOLE.nextInt();
    System.out.println();
    
    h.setColor(Color. BLUE);
    h.fillOval( xdistance,  ydistance,  radius,  radius);
    h.setColor(Color. RED);
    h.fillOval( xdistance2, ydistance2,  radius2,  radius2);
    h.setColor(Color. GREEN);
    h.fillOval( xdistance3, ydistance3,  radius3,  radius3);
    
    biggerorsmaller = Circle(radius, radius2);
    if (biggerorsmaller == -1)
    {System.out.println("Blue circle 1 is smaller than  red circle 2");
    }else if(biggerorsmaller == 1)
    {System.out.println("Blue circle 1 is bigger than red circle 2"); 
    }else if(biggerorsmaller == 0)
    {System.out.println("Blue circle 1 is equal to red circle 2");
    }
    comparetocircle3 = Circle2(radius, radius2, radius3);
    if (comparetocircle3 == 3)
    {System.out.println();
      System.out.println("Green circle 3 is bigger than  red circle 2");
    }else if(comparetocircle3 == 4)
    {System.out.println();
      System.out.println("Green circle 3 is bigger than blue circle 1"); 
    }else if(comparetocircle3 == 5)
    {System.out.println();
      System.out.println("Green circle 3 is smaller than red circle 2");
    }else if(comparetocircle3 == 6)
    {System.out.println();
      System.out.println("Green circle 3 is smaller than blue circle 1");
    }else if(comparetocircle3 == 0)
    {System.out.println();
      System.out.println("Green circle 3 is equal to red circle 2 and blue circle 1");
    }
    
    if (intersectCalc(xdistance, xdistance2, ydistance, ydistance2, radius, radius2))
    {System.out.println();
      System.out.println("Blue circle 1 intersects red circle 2");
    }else 
    {System.out.println();
      System.out.println("Blue circle 1 doesn't intersect red circle 2");
    }
  
    if (intersectCalc( xdistance2, xdistance3, ydistance2, ydistance3, radius2, radius3))
    {System.out.println();
      System.out.println("Green circle 3 intersects red circle 2");
    }else 
    {System.out.println();
      System.out.println("Green circle 3 doesn't intersect red circle 2");
    }
    
    if (intersectCalc( xdistance, xdistance3, ydistance, ydistance3, radius, radius3))
    {System.out.println();
      System.out.println("Green circle 3 intersects blue circle 1");
    }else 
    {System.out.println();
      System.out.println("Green circle 3 doesn't intersect blue circle 1");
    }
  }
  
  public static int Circle(int r1, int r2) { // In this method I used if statements to decide what radius was bigger between cirlcle one and two
    if (r1 < r2)
    {return -1;
    }else if(r2 < r1)
    {return 1;
    }else
    {return 0;
    }
  }
  
  public static int Circle2(int r1, int r2, int r3) { // In this method I used if statements to decide what radius was bigger between cirlcle three, one and two
    if (r2 < r3)
    {return 3;
    }if (r1 < r3)
    {return 4;
    }if (r2 > r3)
    {return 5;
    }if (r1 > r3)
    {return 6;
    }else 
    {return 0;
    }
  }
  
   public static boolean intersectCalc(int x1,int x2 ,int y1 ,int y2 ,int r1 ,int r2){ // In this method I used boolean to decide if any of the cicrles intersected
     double bigChunk1 = (Math.pow((x1 - x2),2)) + (Math.pow((y1 - y2),2));
     double squareSum1 = Math.sqrt(bigChunk1);
     double radiusSum = (r1 + r2);
     return (squareSum1 <= radiusSum ); 
     }   
}


    

    
    
    