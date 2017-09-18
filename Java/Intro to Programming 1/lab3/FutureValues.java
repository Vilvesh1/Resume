import java.util.Scanner;
public class FutureValues {
  public static final Scanner CONSOLE = new Scanner (System.in);
  public static void main (String[]args) { // The main method in this program prompts the user for infomation and prints statements
    
    System.out.println("Lab 3 written by VILVESH SRINIVASAN");
    System.out.println();
    
    System.out.println("Enter values to calculate compound interest");
    System.out.println();
    System.out.println("Enter your Present Value ($):");
    double presentValue = CONSOLE.nextDouble();
    System.out.println("Enter your Interest rate (%):");
    double interestrate = CONSOLE.nextDouble();
    System.out.println("Enter the number of years:"); 
    int years = CONSOLE.nextInt();
    String fV = "The future value of your account:";
    double fVCPI = futureValueCPI(presentValue, interestrate, years); 
    System.out.printf("%-18s $%5.2f %n",fV,fVCPI);
    
    System.out.println();
    System.out.println();
    
    System.out.println("Enter values to calculate the future value of an annuity");
    System.out.println();
    System.out.println("Enter your yearly payment ($):");
    double yearlypayment = CONSOLE.nextDouble();
    System.out.println("Enter your Interest rate (%):");
    double interestrate2 = CONSOLE.nextDouble();
    System.out.println("Enter the number of years:");
    int years1 = CONSOLE.nextInt();
    String fVA = "The future value of the annuity:";
    double fVA1 = futureValueAnnuity(yearlypayment, interestrate2, years1);
    System.out.printf("%-18s $%5.2f %n",fVA,fVA1);
  }
  
  public static double futureValueCPI(double presentValue, double interestrate, int years) { // This method has my three parameters that are used to caculate my future value with compounded interest
    double fVone = (presentValue*(Math.pow((1+(interestrate/100)),years)));
    return fVone;
  }
  public static double futureValueAnnuity(double yearlypayment, double interestrate2, int years1) { // This method has my three parameters that are used to caculate my future value of the annuity
    double fVtwo = (yearlypayment*((Math.pow((1+(interestrate2/100)),years1)-1))/(interestrate2/100));
    return fVtwo;
  }
}






