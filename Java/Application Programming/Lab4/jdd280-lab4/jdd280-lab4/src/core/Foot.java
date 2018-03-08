package core;

public class Foot extends Length {

     public static double MF = 0.3048;

     public Foot(double l) {
          super(l);
     }
     
     public double cM() {
         return MF * gL();
    }
   
     public String add(Length object) {
          double temp = this.gL()+ object.gL();
          sL(temp);
          return null;
     }

     public String gM() {
          if(gL() == 1.0) {
              return "foot";
          }
          
          else {
              return "feet";
          }
     }   
	 
}