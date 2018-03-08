package core;

public class Inch extends Length {

     public static double MI = 0.0254;

     public Inch(double l) {
          super(l);
     }
     
     public double cM() {
    	 
 	 	return MI * gL();
  }
     
     public String add(Length obj) {
          double temp =  this.gL() + obj.gL() ;
          sL(temp);
          return null;
     }

     public String gM() {
          if(gL() == 1.0) {
              return "inch";
          }
          
          else {
              return "inches";
          }
     }   
	
}