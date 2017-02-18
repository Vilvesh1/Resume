import java.util.Scanner;
public class StarWarsName { // This where I create the scanner
  public static final Scanner CONSOLE = new Scanner(System.in);
  public static void main (String[]args) { //This is where I prompt all the strings to and uses substrings to get the letters I need when i print the Star Wars name
    System.out.println("Lab 4 written by VILVESH SRINIVASAN");
    System.out.println();
    String fn = promptString("Enter your first name:");
    fn = fn.substring(0,2);
    String ln = promptString("Enter your last name:");
    ln.length();
    String ln2 = ln.substring(ln.length()-2,ln.length());
    ln = ln.substring(0,2) ;
    String mmn = promptString("Enter your mother's maiden name:");
    mmn = mmn.substring(0,3);
    String cb = promptString("Enter the city where you were born:");
    cb = cb.substring(0,4);
    String cd = promptString("Enter the first car your drove:");
    cd = ln2+cd;
    System.out.println("You are "+fn+ln+" "+mmn+cb+" of "+cd);
    
  }
  public static String promptString(String prompt) { //This prameter is what does the prompting of the string  
    System.out.println(prompt);
    return CONSOLE.nextLine().trim().toUpperCase();
  }   
}

    
    
    
    
    