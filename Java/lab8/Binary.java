import java.util.*;
public class Binary {
  public static void main (String[]args) {
    Scanner console = new Scanner(System.in);
    int decimal = getInt(console, "What whole number would yo like to covert to binary?");
    if (decimal < 0)
    {System.out.println("Not a positive whole number; try again.");
      decimal = getInt(console, "What whole number would yo like to covert to binary?");
    }
    
    int start_index = 0;
    double value = 0;
    double decimal_1 = decimal;
      
    for (int increment = 0; increment >= -1; increment++) {
      value = Math.pow(2, increment);
      if (value > decimal)
      {value = Math.pow(2, (increment-1));
        start_index = increment - 1;
        break;
      }
    }
    
    int array_length = (start_index + 1);
    int[] array = new int[array_length];
    
    for (int i = start_index; i >= 0; i--) {
      if ((decimal_1 - (Math.pow(2, i))) >= 0)
      {decimal_1 = decimal_1 - (Math.pow(2, i));
        array[i] = 1;
      }else 
      {array[i] = 0;
      }
      
    }
    System.out.print("Your decimal number converted to binary is ");
    for (int i = array_length -1; i >= 0; i--) {
      System.out.print(array[i]);
    }
  }
  public static int getInt( Scanner console, String q) {
    System.out.print(q);
    while (!console.hasNextInt()) {
      console.next();
      System.out.println("Not a whole number; try again.");
      System.out.print(q);
    }
    return console.nextInt();
  }
}
    