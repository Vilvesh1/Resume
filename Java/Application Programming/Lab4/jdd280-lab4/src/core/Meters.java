package core;

public class Meters extends Length {

     public Meters(double l) {
          super(l);
     }
     
     public double cM() {
         return gL();
    }	
 

     public String add(Length obj) {
          double temp = this.gL() + obj.gL();
          sL(temp);
          return null;
     }

     public String gM() {
          if(gL() == 1.0) {
              return "meter";
          }
          
          else {
              return "meters";
          }
     }   

     
}