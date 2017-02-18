import java.util.*;
public class Binary {
  public static void main (String[]args) {
    System.out.println("Lab 8 written by VILVESH SRINIVASAN");
    System.out.println();
    
    Scanner console = new Scanner(System.in);
    boolean test = true;
    while (test) { // this loop checks if the decimal entered is a positive whole number
     
    int decimal = getInt(console, "What positive whole number would you like to convert to binary?");
    if (decimal <= 0)
    {System.out.println("Not a positive whole number; try again.");
      decimal = getInt(console, "What whole number would you like to convert to binary?");
    }
    int[] array =  convertToBinary(decimal);
    printBinaryArray(array);
    
    System.out.println("Do you want to enter another number to convert to decimal.  Your choices are yes or no.");
    String answer = console.next();
    
    // this loop checks if the user wants to enter another decimal number
    while (!(answer.equals("Y")||answer.equals("y")||answer.equals("YES")||answer.equals("Yes")||answer.equals("yes")||answer.equals("N")||answer.equals("n")||answer.equals("NO")||answer.equals("No")||answer.equals("no"))){
      System.out.println("Not an answer choice. Your choices are yes or no, try again");
      System.out.println("Do you want to enter another number to convert to decimal");
      answer = console.next();
    }
    
    if (answer.equals("Y")||answer.equals("y")||answer.equals("YES")||answer.equals("Yes")||answer.equals("yes")) 
    {System.out.println();
      test = true;
    }else
    {test = false;
    }
    }    
  }
  
  public static int[] convertToBinary(int decimal) { // this loop converts the decimal to binary
    int decimalcopy = decimal;
    int len = 0;
    while(!(decimal == 0)) {
      decimal = decimal / 2;
      len++;
    }
    int[] array = new int[len];
    for (int i = (len-1); i >= 0; i--) {
     int decimal_1 = decimalcopy % 2;
      if ((decimal_1) == 0)
      {array[i] = 0;
      }else 
      {array[i] = 1;
      }
      decimalcopy = decimalcopy / 2;
    }
    return array;
  }
  
  public static void printBinaryArray(int[] array) { // this prints out the binary number
     System.out.print("Your decimal number converted to binary is ");
    for (int i = (array.length+1) - array.length; i <= array.length; i++) {
      System.out.print(array[i-1]);
    }
    System.out.println();
    System.out.println();
  }
    
  public static int getInt( Scanner console, String q) { // this checks if the decimal number entered is a whole number
    System.out.println(q);
    while (!console.hasNextInt()) {
      System.out.println();
      console.next();
      System.out.println("Not a whole number; try again.");
      System.out.println(q);
      
    }
    return console.nextInt();
  }
}
    