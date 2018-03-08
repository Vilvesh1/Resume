package core;

public abstract class Length implements Comparable<Length> {	
	
     private double l;


     public Length (double l) {
          this.l = l;
     }

     public abstract String add(Length obj);

     public abstract String gM();
     
     public abstract double cM();
    
     public double gL() {
          return l;
     }
     
     public void sL(double l) {
          this.l = l;
     }

     public int compareTo(Length other) {
          if(this.cM() > other.cM()) {
              return 1;
          }
          else if(this.cM() < other.cM()) {
              return -1;
          }
          else {
              return 0;
          }
      }

     public String toString() {
          return this.getClass() + ": " + gL() + " " + gM();
     }
 }