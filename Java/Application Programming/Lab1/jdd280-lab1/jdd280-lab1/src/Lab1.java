/*
 * Vilvesh Srinivasan
 * CS 3443
 * Lab1
 */

import java.util.Scanner;
import static java.lang.System.out;
import java.text.DecimalFormat;
import java.io.File;

public class Lab1 {

   public static void main(String[] args) {
	   
       //variables being declared
	   double total = 0.0;
       int counterA = 0;
       int counterB = 0;
       
       //Initializing Scanner 
       Scanner check = null;
      
       //Formating output using DecimalFormat object
       DecimalFormat deciformat = new DecimalFormat("#.##");
  
      
       /*
       * This code will open the file.
       * If the file is found then code in the try block will execute
       * if file not found,code inside the catch block will execute.
       * And throws exception if file not found
       */
       try {
       check = new Scanner(new File("C:\\Users\\vilve\\eclipse-workspace\\jdd280-lab1\\src\\data.txt"));
       }
       catch (Exception FileNotFoundException) {
       System.err.println("failed to open data.txt");
       System.exit(1);
       }
      
       //Reading Content for "data.txt" file
       while (check.hasNext()) {
       String token = check.next();
    
       /*
       * This section of the code checks whether the token is a number or not.
       * In the case the String is a number the code in the If statement is ran.
       * In the case the String is not a number the code in the else statement is ran.
       */
           if (new Scanner(token).hasNextDouble()) {
        	   
           //Converting the string into double
           double d = Double.parseDouble(token);
          
           //Counting the number of numbers
           counterA++;
          
           //Calculating the total sum of the numbers
           total = total + d;
           }
           else {
        	   
           //Counting the number of non-numbers in the file
           counterB++;
           }
       }
      
   //Printing the output which is total of numbers and non-numbers. Then total sum of the numbers
   out.println("1) Number of tokens that are numbers: "+counterA);
   out.println("2) Number of tokens that are not numbers: "+counterB);
   out.println("3) Total sum of the numbers: "+deciformat.format(total));
  
   // Closing Scanner
       check.close();
   }

}
