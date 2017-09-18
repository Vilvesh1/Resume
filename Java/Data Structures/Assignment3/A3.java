/*
 * Program will use a stack structure to check for correct placement of parentheses in an algebraic expression
 * Vilvesh Srinivasan
 * COSC 2436
 */

import java.util.Scanner;
import java.util.Stack;

public class A3 {

    public static String error = "";
    public static void main(String[] args) {
      
      int i = 1;
      
      while (i== 1) {
        Scanner inputEquation = new Scanner(System.in);
        System.out.println("Enter your algebric equation");
        String input=inputEquation.nextLine();
        if(equationCheck(input)){
            System.out.println("Balanced");
        }else{
            System.out.println(error);
        }
       Scanner inputAnswer = new Scanner(System.in);
       System.out.println("To exit  enter 0 or to continue checking algebraic equations enter any integer");
       int input1 = inputAnswer.nextInt();
       if (input1 == 0) {
         i++;
       }
      }
    }
    public static boolean equationCheck(String equation) {
    
    Stack<Character> stack = new Stack<Character>();

    char variable;
    for(int x=0; x < equation.length(); x++) {
        variable = equation.charAt(x);
       String parentError1 = "Too many right Parentheses.";
       String parentError2 = "Too many left Parentheses.";
       String curlyError1 = "Too many right Curlies.";
       String curlyError2 = "Too many left Curlies.";
       String squareError1 = "Too many right Squares.";
       String squareError2 = "Too many left Squares.";
        if (variable == '{' || variable == '(' || variable == '[')
        {
            stack.push(variable);
        }else if(variable == ')')
            if(stack.empty()){
                error = parentError1;
                return false;
            }
            else if(stack.peek() == '(')
                stack.pop();
            else{
               error = parentError2; 
                return false;
            }
        else if(variable == '}')
            if(stack.empty()){
                error = curlyError1;
                return false;
            }
            else if(stack.peek() == '{')
                stack.pop();
            else{
                error = curlyError2;
                return false;
            }
        else if(variable == ']')
            if(stack.empty()){
                error = squareError2;
                return false;
            }
            else if(stack.peek() == '[')
                stack.pop();
            else{
                error = squareError2;
                return false;
            }
    }
    return stack.empty();
}
    
}
