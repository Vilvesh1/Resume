/*
 * This program finds the max binary tree height.
 * Vilvesh Srinivasan
 * COSC 2436
 */

import static java.lang.System.out;

public class A12 {

   public static void main(String[] args){
     
       A12 heightofTreeCalc = new A12();
       N base;
       
       base = new N(2);
       base.l = new N(12);
       base.r = new N(16);
       base.l.l = new N(23);
       base.l.r = new N(27);
       base.l.l.l = new N(34);
       base.l.r.l = new N(39);
       base.l.r.l.l = new N(44);
       out.println(" The max height of the binary tree is "+ heightofTreeCalc.th(base));
   }
   
      public int th(N base) {
        if (base == null){
           return 0;
        }
        return (1 + Math.max(th(base.l), th(base.r)));
   }
      
}

class N {
   N r;
   N l;
   int infoval;

   public N(int infoval) {
       this.r = null;
       this.l = null;
       this.infoval = infoval;
   }
}