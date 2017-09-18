import java.util.*; 
// This program calculates Loan payments.
public class LoanPayment {
  public static final Scanner CONSOLE = new Scanner (System.in);
  private static double annual_interest_rate;
  private static int number_of_payments = 12;
  public static void main (String []args){ //This method states two methods it will call when runing.
  
  
    System.out.println("Project 1 written by VILIVESH SRINIVASAN");
    
    
    
    simple_loan_payment_table_for_12_months();
    detailed_payment_table();
    

  }
  

  public static void simple_loan_payment_table_for_12_months() { //This mthod is a lot simpler loan payment which only requires the users interest rate.
  
    System.out.println("The initial loan is $1000.0.");
    System.out.println("The monthly payment is $50.0");
    double initial_balance = 1000;
    System.out.println("Enter the annual interest rate percentage");
    annual_interest_rate = CONSOLE.nextDouble()/100;  
    double monthly_interest_rate = annual_interest_rate/12; 
    
    String heading_1 = "Months";
    String heading_2 = "Balance";
    System.out.printf("%-25s %-25s %n", heading_1, heading_2);
    
    int i = 1;
    double new_balance = initial_balance;  
    while (i <= number_of_payments) { // This method creates a loop that prints the new balance for each month.
      new_balance = ((new_balance) + (new_balance * monthly_interest_rate)) - 50;
      System.out.printf("%-25s $%-25.2f %n", i, new_balance);
      i++;
    }

}

  public static void detailed_payment_table() { ////This method is a lot more complex. The user has full control over all values and can see all data in a nice format.
    
    System.out.println("Enter the initial balance:");
    double initial_balance = CONSOLE.nextDouble();
    System.out.println("Enter the annual interest rate percentage");
    annual_interest_rate = CONSOLE.nextDouble()/100;  
    double monthly_interest_rate = annual_interest_rate/12;
    System.out.println("Enter the monthly payment:");
    double monthly_payment = CONSOLE.nextDouble();
    System.out.println("Enter the number of months:");
    double the_number_of_payments = CONSOLE.nextDouble();
    double remaining = 0;
    
    
    
    String heading_1 = "Months";
    String heading_2 = "Balance";
    String heading_3 = "Payment";
    String heading_4 = "Remaining";
    System.out.printf("%-25s %-25s %-50s %-75s  %n", heading_1, heading_2, heading_3, heading_4);
    
    int i = 1;
    double new_balance = initial_balance;
    new_balance = ((new_balance) + (new_balance * monthly_interest_rate));
    remaining = new_balance - monthly_payment;
    System.out.printf("%-25s $%-25.2f $%-50.2f $%-75.2f  %n", i, new_balance, monthly_payment, remaining);
    new_balance = remaining;
    i++;
    
    while (i <= the_number_of_payments) {  
      // This method creates a loop that prints the new balance, payment, and remaining for each month.
      new_balance = ((new_balance) + (new_balance * monthly_interest_rate));
      remaining = new_balance - monthly_payment;
      System.out.printf("%-25s $%-25.2f $%-50.2f $%-75.2f  %n", i, new_balance, monthly_payment, remaining);
      new_balance = remaining;
      i++;
      
    }
    
  }
}
