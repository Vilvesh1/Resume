import java.awt.*;
public class Hyperbola { //This where the constants are
    private static final int drawingPannel = 512;
    private static final int lefthandcorner = 32;
    private static final int righthandcorner = 8;
  public static void main (String[]args) { //This is where tell the size of my drwing pannel and have my loops that create the hyperbolas
    System.out.println("Lab 4 written by VILVESH SRINIVASAN");
    DrawingPanel panel = new DrawingPanel(drawingPannel, drawingPannel);
    Graphics h = panel.getGraphics();
    int i = 0;
    while (i<=drawingPannel) { //This creates a hyperbola in the Left hand corner
      h.drawLine(0,i,i,drawingPannel);
      i=i+lefthandcorner;
    }
    i = drawingPannel;
    while (i>=0) { // This creates a hyperbola in the right hand corner
      h.drawLine(drawingPannel,i,i,0);
      i=i-righthandcorner;
    }   
  }
}
      
    
    
    