/*
 * Program will use a stack structure to calculate the value of arithmetic postfix expressions. 
 * Vilvesh Srinivasan
 * COSC 2436
 */

import java.util.Scanner;

import java.util.Stack;

public class A4{
     
      public static void main(String[] args) {

       Scanner input = new Scanner(System.in);
       Scanner input1 = new Scanner(System.in);
       
       while (true) {

       System.out.println("Please enter postfix expression in the correct and valid format: ");

       String postFix = input.nextLine();

       System.out.println(postfixEvaluation(postFix));
       
       System.out.println("Do you wish to continue? To exit enter 0 or to continue enter any integer");
       
       int i = input1.nextInt();
       
       if ( i == 0) {
        break;
       }
       
      }

   }

      
public static int postfixEvaluation(String poststring){
  
       Stack<Integer> stack = new Stack<Integer>();

       int x = 0;

       while (x < poststring.length()) { 
         
           char s = poststring.charAt(x);

          

           if (Character.isDigit(s)) { 
               stack.push(Character.getNumericValue(s));
               x++;
               continue;
           }


           int z = stack.pop();

           int y = stack.pop();
           
           
           if (s == '-') stack.push(y - z);

           else if (s == '+') stack.push(y + z);
           
           else if (s == '*') stack.push(y * z);
           
           else if (s == '%') stack.push(y % z);

           else if (s == '/') stack.push(y / z);

         
           x++;

       }

       return stack.pop();

   }

}



