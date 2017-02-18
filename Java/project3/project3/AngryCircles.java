import java.awt.*;
import java.util.*;
import java.text.*;

public class AngryCircles { // this program creates a game where you shoot a target 
  
  public static final int PANEL_WIDTH = 300;
  public static final int PANEL_HEIGHT = 300;
  public static DrawingPanel panel;
  public static Graphics g;
  public static int [] array = new int[11];
  
  public static int misses_since_last_hit = 0;
  public static int x1 = 0;
  public static int y1 = 300;
  public static int x2 = 21;
  public static int y2 = 279;
  public static int xspot = 280;
  public static int targetTop = 75;
  public static int y4 = 125;
  public static double radius = 30;
  public static double cannonAngle = 45;
  public static int cr = 10;
  public static int x_2 = (x2 - (cr/2));
  public static int y_2 = (y2 - (cr/2));
  public static int force = 10;
  public static double time = 0;
  public static int score = 0;
  public static int hit = 0;
  public static int run = 0;
  public static double miss = 0;
  public static double average = 0;
  public static boolean test = true; 
  public static boolean running = false; 
  public static boolean pressed = false;
  public static boolean gameover = false;
  public static int vx = DrawingUtility.getTriangleX(force,cannonAngle);
  public static int vy = DrawingUtility.getTriangleY(force,cannonAngle);
  public static double gforce = -.2;
  
  public static void main(String[] args) {
    panel = new DrawingPanel(PANEL_WIDTH,PANEL_HEIGHT);
    g = panel.getGraphics();
    new DrawingUtility(panel);
    
    while (true) { // this while loop controls the whole game and puts all the code to together 
      
      clear();
      g.setColor(Color.RED);
      g.drawString("Angry Circles written by VILVESH SRINIVASAN", 10, 15);
      g.drawString(""+"Run " + "               " + "  Misses  ", 10, 45);
      int i = 0;
      for (i = 0; i <= hit; i++) {
        if( i < 9)
        {g.drawString("0"+(i+1)+"                            "+array[i], 10, (60+15*i));
        }
        else
        {g.drawString(""+(i+1)+"                            "+array[i], 10, (60+15*i));
        }
        if (i == 9) 
        { break;
        }
      }
      double average = (miss/i);
      g.drawString("Average: "+ twoPlaces(average), 10, (60+17*i));
      
      while (pressed) { // this while loop is a stall when history button is pressed
        ;
      }
      test = true;
      System.out.println();
      if (gameover == true || hit == 10)
      {System.out.println();
        gameover = true;
        clear();
        drawData();
      }
      while(gameover) { // this while loop is a stall when the game is over
        System.out.println();
        ;
      }
      
      while(test) { // this while loop comtrol the main function of the game when in play
        
        if(running)
        {time++;
        }
        
        if (hit == 10)
        {gameover = true;
          drawData();
          System.out.println();
          
        }
        
        while (gameover) { // this while loop is a stall when the game is over
          System.out.println();
          ;
        }
        clear();
        drawData();
        panel.sleep(50);
        clear();
        
      }
      
    }
    
  }
  
  
  
  public static void clear() {
    g.setColor(Color.WHITE);
    g.fillRect(0,0,300,300);
  }
  
  
  public static void drawData() { // this method draws the cannon, cannonball, and target. It also prints the creator of the game and the title, the cannon angle, target position, amount of force, time in seconds, hits, and score.
    g.setColor(Color.RED);
    g.drawString("Angry Circles written by VILVESH SRINIVASAN", 10, 15);
    g.setColor(Color.BLACK);
    g.drawString("Connon angle: "+ cannonAngle, 10, 45);
    g.drawString("Target position: " + targetTop +" - "+ y4, 10, 60);
    g.drawString("Force: "+ force, 10, 75);
    g.drawString("Time: " + time + " seconds", 10, 90);
    g.drawString("Hits: "+ hit, 10, 105);
    if (!(hit == 10))
    {g.setColor(Color.GREEN);
      g.drawString("Score: "+ score, 10, 120);
    }else
    {g.setColor(Color.RED);
      g.drawString("Score: "+ score, 10, 120);
    }
    drawCannon(x1,y1,x2,y2,Color.BLACK);
    
    if(running == true) 
    {drawCannonball(x2,y2,Color.WHITE);
      
    }else 
    {drawCannonball(x2,y2,Color.RED);
      
    }
    drawTarget(xspot,targetTop,y4,Color.BLACK);
    drawCannonballAtTime(time,Color.RED);
  }
  
  public static void targetUp() { // this moves the target up with the up key
    
    targetTop = (targetTop - 1);
    y4 = (y4 - 1);
    if (targetTop == 0 || y4 == 50)
    {targetTop = 250;
      y4 = 300;
    }
  }
  
  public static void targetDown() { // this moves the target down with the downkey key
    
    targetTop = (targetTop + 1);
    y4 = (y4 + 1);
    if (targetTop == 250|| y4 == 300)
    {targetTop = 0;
      y4 = 50;
    }
  }
  
  public static void drawTarget(int xspot, int targetTop, int y4, Color c) { // this method draws the target
    g.setColor(c);
    g.drawLine(xspot,targetTop,xspot,y4);
  }
  
  public static void angleDown() { // this method angles the cannon down and prevents cannon exiting drwing pannel
    
    cannonAngle--;
    
    x2 = getTriangleX(radius,cannonAngle);
    
    y2 = getTriangleY(radius,cannonAngle);
    
    
    if(x2 == 30 && y2 == 300)
    {x2 = 0;
      y2 = 270;
      cannonAngle = 90;
    }
    
  }
  
  
  public static void angleUp() { // this method angles the cannon up and prevents cannon exiting drwing pannel
    
    cannonAngle++;
    
    x2 = getTriangleX(radius,cannonAngle);
    
    y2 = getTriangleY(radius,cannonAngle);
    
    
    if(x2 == 1 && y2 == 270)
    {x2 = 30;
      y2 = 300;
      cannonAngle = 0;
    }
    
  }
  
  public static int getTriangleX(double radius, double cannonAngle) { //This method does the trig involved in calculating the cannons next position for the x vaule
    double angle_rad1 = Math.toRadians(cannonAngle);
    double x2_1 = (radius*(Math.cos(angle_rad1)));
    int new_x = (int)Math.ceil(x2_1);
    
    return new_x;
  }
  
  public static int getTriangleY(double length, double cannonAngle) { //This method does the trig involved in calculating the cannons next position for the y value
    double angle_rad2 = Math.toRadians(cannonAngle);
    double y2_1 = PANEL_HEIGHT - (radius*(Math.sin(angle_rad2)));
    int new_y = (int)Math.ceil(y2_1);
    
    return new_y;
  }
  
  
  public static void drawCannon(int x1, int y1, int x2, int y2, Color c) {
    g.setColor(c);
    g.drawLine(x1,y1,x2,y2);
  }
  
  
  
  public static void forceLarger() { // This method increses the force by pressing the + key
    force++;
  }
  
  public static void forceSmaller() { // This method decreases the force by pressing the - key, but also prevents force from becoming 0
    force--;
    if (force < 1)
    {force = 1;
    }
  }
  
  public static void drawCannonball(int x2, int y2, Color c) { // This method does the math to get the cannon ball postion and also draws the cannon ball
    x_2 = (x2 - (cr/2));
    y_2 = (y2 - (cr/2));
    
    g.setColor(c);
    g.fillOval(x_2,y_2,cr,cr);
  }
  
  public static void drawCannonballAtTime(double time, Color c) { // This method draws the cannon ball at the specific time
    Random rand = new Random();
    if (running)
    {int x6 = getCircleX(time);
      int y6 = getCircleY(time);
      
      g.setColor(Color.RED);
      g.fillOval(x6,y6,cr,cr);
      
      int hit_miss = checkForHitOrMiss(x6,y6,cr);
      
      if (hit_miss == 1) 
      {targetTop = rand.nextInt(250);
        y4 = (targetTop + 50);
        score = score + 5;
        hit++;
        run++;
        misses_since_last_hit = 0;
        
      } else if (hit_miss == -1) 
      {score = score - 1;
        miss++;
        misses_since_last_hit++;
        array[hit] = misses_since_last_hit;
      }
    }
  }
  
  public static int checkForHitOrMiss(int x6, int y6, int cr) { // This method checks if the cannon hit of missed the target
    if (x6 > 300 || y6 > 300 || x6 == 0 || y6 == 0 || (x6 >= 269 && y6 >= targetTop && y6 <= y4))
    {
      if ((x6 >= 269 && y6 >= targetTop && y6 <= y4))
      {x6 = x_2;
        y6 = y_2;
        g.setColor(Color.RED);
        g.fillOval(x6,y6,cr,cr);
        running = false;
        time = 0; 
        return 1;
        
      }else if (x6 > 300 || y6 > 300 || x6 == 0 || y6 == 0)
      {x6 = x_2;
        y6 = y_2;
        g.setColor(Color.RED);
        g.fillOval(x6,y6,cr,cr);
        running = false;
        time = 0; 
        return -1;
        
      }else 
      {return 0;
        
      }
      
    }else
    {return 0;
      
    }
    
  }
  public static int getCircleX(double time){ // this method does the math to calculate the position the circle is at a specific time for the x  value
    
    double x = (x_2 + (vx*time));
    int x0 = (int)(Math.ceil(x));
    
    return x0;
  }
  public static int getCircleY(double time){ // this method does the math to calculate the position the circle is at a specific time for the y  value
    
    double small_chunk = Math.ceil((.5)*gforce*(time*time));
    double y = ((y_2) + (vy*time) - (small_chunk));
    int y0 = (int)(Math.ceil(y));
    
    return y0;
    
  }
  
  public static void fire() { // this method fires the cannon from the cannon ball by pressing the enter key it also restarts the game if the game is over
    if (gameover == false)
    {running = true;
      vx = DrawingUtility.getTriangleX(force,cannonAngle);
      vy = -DrawingUtility.getTriangleY(force,cannonAngle);
    
    }else if (gameover)
    {gameover = false;
      force =10;
      x1 = 0;
      y1 = 300;
      x2 = 21;
      y2 = 279;
      xspot = 280;
      targetTop = 75;
      y4 = 125;
      cannonAngle = 45;
      hit = 0;
      time = 0;
      score = 0;
      miss = 0;
      misses_since_last_hit = 0;    
    }
    
  }
  
  public static void keyDown(char c) { // this method shows the history by pressing the h key
    
    if (c == 'h')
    {clear();
      if (running)
      {running = false;
      }
      if (gameover)
      {gameover = false;
      }
      test = false;
      pressed = true;
    }
    
  }
  
  public static void keyUp(char c) { // this method takes the user back to the game after viewing the history by relesing the h key
    if(c == 'h')
    {clear();
      time = 0;
      pressed = false;
    }
    
  }
  
  public static String twoPlaces(double d) { // this method  keeps the numerical value to have two decimal places
    DecimalFormat df = new DecimalFormat("0.00");
    return df.format(d);
    
  }
  
}
