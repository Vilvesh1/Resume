package core;

/*
 * Vilvesh Srinivasan
 * CS 3443
 * Lab3
 * The task is to read a file, which consists of one date on each line. 
 * Each date should be stored in a Date object. 
 * If the next date is later than the previous date, a DateRange object should be created from the two dates. 
 * All the Date and DateRange objects should be printed out.
 */
import java.io.*;
import java.util.*;

public class Lab3 {
	
	private static String l;
	private static String temp;
    private static Date d; 
    private static Date pD = null;
    
   public static void main(String[] args) {
	   
       Scanner check = null;
       
       try {
           check = new Scanner (new File("../jdd280-Extracredit_lab3/src/data.txt"));     
       }
       catch (Exception FileNotFoundExecption) {
           System.err.println ("failed to open data.txt");
           System.exit(1);
       }
      
       while (check.hasNextLine()) {
           l = check.nextLine();
           d = new Date(l); 
           System.out.print(d);
           System.out.println();
           temp = d.toString();
           if (!(temp.equals("Invalid Date"))) {
               if (pD != null) {
                   DateRange dateRange = new DateRange(pD, d); 
                   if (dateRange.cV < 0) {
                       System.out.println(dateRange); 
                   }
               }
               pD = d; 
           }
       }
       check.close(); 
   }
}

