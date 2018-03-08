package core;

public class Yard extends Length {

     public static double MY = 0.9144;

     public Yard(double l) {
          super(l);
     }
     
     public double cM() {
         return MY * gL();
    }
  
     public String add(Length obj) {
          double temp = this.gL() + obj.gL();
          sL(temp);
          return null;
     }

     public String gM() {
          if(gL() == 1.0) {
              return "yard";
          }
          
          else {
              return "yards";
          }
     }   
     
}