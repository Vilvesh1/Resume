import java.util.Scanner;
import java.text.*;
import  static java.lang.System.out;
public class LoanPaymentCal { // Here is where I initialized the Scanner
  public static final Scanner CONSOLE = new Scanner (System.in);
  public static void main (String[]args) { // This is where I run the Loan Calculator table after getting the Loan Amount and Years 
    out.println("Project 2 written by VILVESH SRINIVASAN");
    out.println();
    
    double loan_amount; 
    int loan_period;
    out.println("User type in the format inside the parenthesis, (amount($): # years: #)");
    String inputCheck = CONSOLE.next();
    if(inputCheck.equals("amount($):"))
    {if (CONSOLE.hasNextDouble())
      {loan_amount = CONSOLE.nextDouble();
      inputCheck = CONSOLE.next();
      if(inputCheck.equals("years:"))
      {if (CONSOLE.hasNextInt())
        {loan_period = CONSOLE.nextInt();
      }else
      {out.println("You didn't type a proper number for number of years which should be a whole number");
        return;
      }
      }else
      {out.println("You didn't type in the format inside the parenthesis for (years:)");
        return;
      }
    }else
    {out.println("You didn't type a proper number for amount");
      return;
    }
    }else if(inputCheck.equals("years:"))
    {if (CONSOLE.hasNextInt())
      {loan_period = CONSOLE.nextInt();
      inputCheck = CONSOLE.next();
      if(inputCheck.equals("amount($):"))
      {if (CONSOLE.hasNextDouble())
        {loan_amount = CONSOLE.nextDouble();
      }else
      {out.println("You didn't type a proper number for amount");
        return;
      }
      }else
      {out.println("You didn't type in the format inside the parenthesis for (amount($):)");
        return;
      }
    }else
    {out.println("You didn't type a proper number for number of years which should be a whole number");
      return;
    }
    }else
    {out.println("You didn't type in the format inside the parenthesis for (amount($): or years:)");
      return;
    }
    
    double loan_rate = loanRate(loan_amount);
    double monthly_payment = loanMonthlyPayment(loan_amount, loan_period, loan_rate);
    out.println();
    
    out.println("Loan amount: $"+twoPlaces(loan_amount));
    out.println("Loan period: "+loan_period+" years");
    out.println("Loan rate: "+twoPlaces((loan_rate*100))+"%");
    String mp = "Monthly payment:";
    out.println(mp+" $"+twoPlaces(monthly_payment));
    out.println();
    out.println();
    
    System.out.println(padOnLeft("Month",0)+ padOnLeft("Balance",12) + padOnLeft("Payment",12) + padOnLeft("Remaining",12) + "\n");
    
    String tp = "Total payment amount:";
    double total = loanTotalPayment(monthly_payment,loan_period,loan_amount,loan_rate);
    out.println();
    out.println(tp+" $"+twoPlaces(total));
  }
  
  public static double loanRate(double loan1){ // This method tells me what rate the loan is getting
    if (loan1 >= 350000){
      return .04;
    }else if (loan1 >= 100000){
      return .035;
    }else
    {return .03;
    }
  }
  
  public static double loanMonthlyPayment(double la, int lpa, double lra){ // This calculates the monthly payment
    int
      lpm = (lpa*12);
    double lrm = ((lra)/12);
    double smallchunk1 =(la*lrm);
    double smallchunk2 = (1+lrm);
    double smallchunk3 = Math.pow(smallchunk2,((-1)*(lpm)));
    double smallchunk4 = (1-smallchunk3);
    double mp= (smallchunk1/smallchunk4);
    return mp; 
  }
  public static double loanTotalPayment(double mp, int lp, double la, double lr){ // This calculates the total payment
    int i = 1;
    while (i <= (lp*12)) { // This loop runs the Loan Calculator
      la = (la*(lr/12))+la;
      double loan_remaining = (la - mp);
      if (loan_remaining <= 0) 
      {loan_remaining = 0;
      }
      out.println(padOnLeft(""+i,4) + padOnLeft(""+twoPlaces(la),12) + padOnLeft(""+twoPlaces(mp),12)+ padOnLeft(""+twoPlaces(loan_remaining),12));
      la = loan_remaining;
      i++;
    } 
    double total = (mp*(lp*12));
    return total;
  }
  
  public static String twoPlaces(double d) { // This keeps all numerical values to have two decimal places
    DecimalFormat df = new DecimalFormat("0.00");
    return df.format(d);
  }
  public static String padOnLeft(String s, int n) { // This method does the columns for the Loan Calculator table
    if (s.length() >= n)
    {return s;
    }else
    {for(int i = s.length(); i<=n; i++){
      s = " "+s;
    }
    return s;
    }
  }
    
}
  
    