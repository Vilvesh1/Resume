/*
 * Program will implement Quick Sort and a slow sort, Bubble Sort. The program will generate a very large array (30,000 or more) of bytes and sort increasingly larger portions of the array (5000, 10000, ..., 30000) with both algorithms.
 * Vilvesh Srinivasan
 * COSC 2436
 */

import java.util.Random;
import java.util.Arrays;
public class A6{
  
      public static void main(String[] args) {
        
       int x;
       double bTime;
       double fTime;
       double cTime;
       byte[] a;
       byte[] qs;
       byte[] bs;
       int ctts = 1000;

        
       a = new byte[30000];
       new Random().nextBytes(a);
       
       x = 1;

       while(x <= 6){
           qs = Arrays.copyOfRange(a, 0, 5000*x);
           bs = Arrays.copyOfRange(a, 0, 5000*x);
           bTime = System.currentTimeMillis();
           qSortation(qs, 0, 5000*x-1);
           fTime   = System.currentTimeMillis();
           cTime = (fTime - bTime)/ ctts;
           System.out.println("Time to sort array for first "+5000*x+" elements using Quick Sort: "+cTime+" seconds.");
           bTime = System.currentTimeMillis();
           bSortation(bs);
           fTime   = System.currentTimeMillis();
           cTime = (fTime - bTime)/ctts;
           System.out.println("Time to sort array for first "+5000*x+" elements using Bubble Sort: "+cTime+" seconds.");
           x++;
       }
    }


    public static void qSortation(byte[] qarray, int s, int b) {
      
      int m;
      byte p;
      int n; 
      int t;
      byte st;
      
      if (qarray == null || qarray.length == 0){
           return;
      }

      else if (s >= b){
           return;
       }

       m = s + (b - s) / 2;
       p = qarray[m];

       n = s; 
       t = b;
       while (n <= t) {
           while (qarray[n] < p) {
               n++;
           }

           while (qarray[t] > p) {
               t--;
           }

           if (n <= t) {
               st = qarray[n];
               qarray[n] = qarray[t];
               qarray[t] = st;
               n++;
               t--;
           }
       }
       
       if (b > n){
           qSortation(qarray, n, b);
       }

       else if (s < t){
           qSortation(qarray, s, t);
       }

   }
    
    public static void bSortation(byte[] bArray) {

        int w;
        int k;
        int h;
        byte st;
        
        w = bArray.length;
        for(k = 0; k < w; k++){
            for(h = 1; h < (w-k); h++){
                if(bArray [h-1] > bArray [h]){
                     st = bArray [h-1];
                     bArray [h-1] = bArray [h];
                     bArray [h] = st;
                 }
             }
        }

    }
}