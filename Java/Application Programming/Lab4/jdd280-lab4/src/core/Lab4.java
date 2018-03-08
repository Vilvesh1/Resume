package core;

/*
 * Vilvesh Srinivasan
 * CS 3443
 * Lab4
 * The task is to read a file data.txt, which consists of one length on each line. 
 * Each length should be stored in an appropriate Length object. All the Length objects should be stored in an ArrayList<Length>. 
 * Each Length object should be printed out. The minimum and maximum length should be printed out.
 * Then, the sum of the Lengths should be printed out in different ways as shown below.
 * 
 * 
*/
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Lab4 {
	     
	     public static double sAR(ArrayList<Length> aL) {
	          double s = 0.0;
	          int i = 0;
	          for(i = aL.size()-1; i >= 0 ;i--) {
	              s += aL.get(i).cM();
	          }
	          return s;
	     }
	     
	     public static Length mXL(ArrayList<Length> aL) {
	          Length temp1 = aL.get(0);
	          int k = 0;
	          for(k = 0; k < aL.size(); k++) {
	              if((temp1.compareTo(aL.get(k))) < 0) {
	                   temp1 = aL.get(k);
	              }
	          }
	          return temp1;
	     }
	     
	     
	     public static Length mL(ArrayList<Length> aL) {
	          Length temp1 = aL.get(0);
	          int j = 0;
	          for(j = 0; j < aL.size(); j++) {
	              if((temp1.compareTo(aL.get(j))) > 0)
	                   temp1 = aL.get(j);
	          }
	          return temp1;
	     }
	     
	     
	     public static double sA(ArrayList<Length> aL) {
	          double s = 0.0;
	          int h = 0;
	          for(h = 0; h < aL.size(); h++) {
	              s += aL.get(h).cM();
	          }
	          return s;
	     }
	     
	     
	     public static void main(String args[]) {
				
	          ArrayList<Length> aL = new ArrayList<Length>();
	          Length l;
	          
	          Scanner check = null;
	          
	          try {
	  			check = new Scanner(new File("../jdd280-Extracredit_lab4/src/data.txt"));        
	          }
	          
	          catch (Exception FileNotFoundException) {
	              System.err.println("failed to open data.txt");
	              System.exit(1);
	              }
	         
	          while(check.hasNextDouble()) {
	        	  
	              double v = check.nextDouble();
	              String u = check.next();
	              
	              if(u.equalsIgnoreCase("meter")|| u.equalsIgnoreCase("meters")) {
	                   l = new Meters(v);
	              }
	              else if(u.equalsIgnoreCase("foot")||u.equalsIgnoreCase("feet")) {
	                   l = new Foot(v);
	              }
	              else if(u.equalsIgnoreCase("inch")||u.equalsIgnoreCase("inches")) {
	                   l = new Inch((v));
	              }
	              else if(u.equalsIgnoreCase("yard")||u.equalsIgnoreCase("yards")) {
	                   l = new Yard(v);
	              }
	              else {
	                   l = null;
	              }
	              
	              aL.add(l);
	              System.out.println(l);
	          }       

	          check.close();	         

	          System.out.println();

	          Length mL = mL(aL);
	          Length mXL = mXL(aL);
	          
	          System.out.println("Minimum is " + mL);          
	          System.out.println("Maximum is " + mXL);
	          System.out.println();

	          System.out.println("Sum of Lengths Adding from First to Last");
	          
	          double sum = sA(aL);
	          Length sumOrder = new Meters(sum); 
	          System.out.println(sumOrder);
	          
	          sumOrder = new Inch(sum/Inch.MI);          
	          System.out.println(sumOrder);
	          
	          
	          
	          
	          sumOrder = new Foot(sum/Foot.MF);
	          System.out.println(sumOrder);
	          
	          sumOrder = new Yard(sum/Yard.MY);
	          System.out.println(sumOrder);         
	          System.out.println();

	        
	          System.out.println("Sum of Lengths Adding from Last to First");
	          
	          double s2 = sAR(aL);
	          Length sOR = new Meters(s2);
	          System.out.println(sOR);
	          
	          sOR = new Inch(s2/Inch.MI);      	          
	          System.out.println(sOR);
	          
	          sOR = new Foot(s2/Foot.MF);
	          System.out.println(sOR);
	          
	          sOR = new Yard(s2/Yard.MY);
	          System.out.println(sOR);

	     }

}