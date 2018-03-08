package core;

public class DateRange
{
    private Date e; 
	private Date s; 
	
   public int cV; 

   public DateRange (Date startDate, Date endDate)
   {
	   e = endDate;
	   s = startDate;
       cV = s.compareTo(e);
   }
  
   public String toString()
   {
       return ("DateRange: " + s.toString() + " - " + e.toString()); 
   }
  
}
