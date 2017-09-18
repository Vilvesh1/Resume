/*
 * Program will implement Heap Sort and a slow sort, Bubble Sort. The program will generate a very large array (30,000 or more) of bytes and sort increasingly larger portions of the array (5000, 10000, ..., 30000) with both algorithms.
 * Vilvesh Srinivasan
 * COSC 2436
 */

import java.util.Random;
import java.util.Arrays;

public class A7 {
  
      public static int q;
      
      public static void main(String[] args) {
        
       int x;
       double bTime;
       double fTime;
       double cTime;
       byte[] a;
       byte[] hs;
       byte[] bs;
       int ctts = 1000;
        
        
       a = new byte[30000];
       new Random().nextBytes(a);
       
       x = 1; 
       
       while(x <= 6){
           hs = Arrays.copyOfRange(a, 0, 5000*x);
           bs = Arrays.copyOfRange(a, 0, 5000*x);
           bTime = System.currentTimeMillis();
           hsortation(hs);
           fTime   = System.currentTimeMillis();
           cTime = (fTime - bTime)/ctts;
           System.out.println("Time to sort array for first "+5000*x+" elements using Heap Sort: "+cTime+" seconds.");
           bTime = System.currentTimeMillis();
           bSortation(bs);
           fTime   = System.currentTimeMillis();
           cTime = (fTime - bTime)/ ctts;
           System.out.println("Time to sort array for first "+5000*x+" elements using Bubble Sort: "+cTime+" seconds.");
           x++;
       }
    }
    
    public static void hsortation(byte harray[]) {  
      
        heaper(harray);
        int i;
        
        i = q;
        
        while(i > 0) {
            heapswap(harray,0, i);
            q = q-1;
            bigh(harray, 0);
            i--;
        }
    } 
       
    public static void heaper(byte harray[]) {
      
        int d;
        
        q = harray.length-1;
        d = q/2;
          
        while(d >= 0){
        bigh(harray, d); 
        d--;
        
        
       }
    }   
    
    public static void heapswap(byte harray[], int k, int x) {
      
        byte st = harray[k];
        harray[k] = harray[x];
        harray[x] = st; 
        
    }
    
    public static void bigh(byte harray[], int v) { 
      
        int l;
        int r;
        int big;
        
        r = 2*v + 1;
        l = 2*v ;
        big = v;
        
        if (l <= q && harray[l] > harray[v]) {
            big = l;
        }
        
        else if (big != v) {
            heapswap(harray, v, big);
            bigh(harray, big);
        }
        
        else if (r <= q && harray[r] > harray[big]) {        
            big = r;
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



