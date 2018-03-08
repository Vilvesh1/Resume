package core;
import java.util.Scanner;

public class Date implements Comparable<Date>
{
   private Integer m; 
   private Integer d;
   private Integer y;
   private String mS; 
   private String i = "i";
  
   public Date (String line)
   {  
       Scanner tokens = new Scanner(line); 
       String temp; 
       temp = tokens.next(); 
       setm(temp); 
      
       temp = tokens.next(); 
       temp = temp.substring(0, (temp.length() - 1)); 
       d = Integer.parseInt(temp); 
       y = tokens.nextInt(); 
      
       tokens.close();  
   }
   
   public String toString() {
	   
       if (d > 31 || ((m == 4 || m == 6 || m == 9 || m == 11) && (d > 30)) || (m == 2 && d > 28)) {
           return ("Invalid Date");
       }
       return ("Date: " + mS + " " + d +", " + y); 
   }
   
   public String setm(String mToken) {
	   String temp = mToken.substring(0, 3).toLowerCase();
	   
       if (temp.compareTo("jan") == 0) 
       {
           m = 1; 
           mS = "January"; 
           return i;
       }      
       else if (temp.compareTo("feb") == 0)
       {
           m = 2;
           mS = "February";
           return i;
       }
       else if (temp.compareTo("mar") == 0)
       {
           m = 3;
           mS = "March";
           return i;
       }
       else if (temp.compareTo("apr") == 0)
       {
           m = 4;
           mS = "April";
           return i;
       }
       else if (temp.compareTo("may") == 0)
       {
           m = 5;
           mS = "May";
           return i;
       }
       else if (temp.compareTo("jun") == 0)
       {
           m = 6;
           mS = "June";
           return i;
       }
       else if (temp.compareTo("jul") == 0)
       {
           m = 7;
           mS = "July";
           return i;
       }
       else if (temp.compareTo("aug") == 0)
       {
           m = 8;
           mS = "August";
           return i;
       }
       else if (temp.compareTo("sep") == 0)
       {
           m = 9;
           mS = "September";
       }
       else if (temp.compareTo("oct") == 0)
       {
           m = 10;
           mS = "October";
           return i;
       }
       else if (temp.compareTo("nov") == 0)
       {
           m = 11;
           mS = "November";
           return i;
       }
       else if (temp.compareTo("dec") == 0)
       {
           m = 12;
           mS = "December";
           return i;
       }
       
       return null;
   }
  
   public int compareTo(Date o) {
	   
       if (this.y.compareTo(o.y) != 0) 
       {
           return this.y.compareTo(o.y); 
       }
      
       else if (this.m.compareTo(o.m) != 0) 
       {
           return this.m.compareTo(o.m); 
       }
      
       return this.d.compareTo(o.d); 
   }
  
}
