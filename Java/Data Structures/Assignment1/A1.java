/*
 * Menu based options for Arrays
 * Vilvesh Srinivasan
 * COSC 2436
 */

import java.util.Scanner;
public class A1{
    public static int i = 1;
    public static String[] mainArray = null;
    public static int count = 0;
    public static int size = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(i == 1){
            if(mainArray == null){
              System.out.println("How big is the array?");
              size = input.nextInt();
              mainArray = new String[size];
            }
             System.out.println("Type the number from Menu");
             System.out.println("1. ADD (at the end of array)");
             System.out.println("2. INSERT (element at a given location)");
             System.out.println("3. DELETE (element from a given location)");
             System.out.println("4. SHOW (all array elements)");
             System.out.println("5. COUNT (total number of elements)");
             System.out.println("6. CLEAR (initialize array)");
             System.out.println("7. Exit");
             
         int choice = input.nextInt();
          switch(choice){
              case 1:
    
                  System.out.println("What do you want to add?");
                  Scanner input1 = new Scanner(System.in);
                  String valueAdd = input1.nextLine();
                  add(valueAdd);
                  break;
                  
              case 2:
                  Scanner input2 = new Scanner(System.in);
                  System.out.println("At what index do you want to insert?");
                  int index = input2.nextInt();
                  if(index >= 0 && index < count){
                  Scanner input3 = new Scanner(System.in);
                  System.out.println("What do you want to add?");
                  String valueInsert = input3.nextLine();
                  insert(index,valueInsert);
                  }
                  else{
                  System.out.println("index doesnt exist");
                  }
                  break;
                  
              case 3:
                  Scanner input4 = new Scanner(System.in);
                  System.out.println("At what index do you want to delete?");
                  int index1 = input4.nextInt();
                  if(index1 >= 0 && index1 < count){
                     delete(index1); 
                  }
                  else{
                  System.out.println("index doesnt exist");
                  }
                  break;
                  
              case 4:
                  show();
                  break;
                  
              case 5:
                  System.out.println(count());
                  break;
                  
              case 6:
                  clear();
                  break;
                  
              case 7:
                  i++;
                  break;
                  
              default:
                 System.out.println("Try Again. Thats not an option");
                 break;
                  
          }
             
        }
    }
    public static void add(String value){
      if (count == size) {
      System.out.println("You will exceed array size if you add anymore values");
      }
      else{
        mainArray[count] = value;
        count++;
      }
    }
    public static void insert(int index, String value){
        mainArray[index] = value; 
    }
    public static void delete(int index){
        mainArray[index] = null;
        count--;
    }
    public static void show(){
        for(int i= 0; i < count; i++){
             String valueAtHand = mainArray[i];
            if(valueAtHand != null){
         
          System.out.println(valueAtHand);
                  }
        }
    }
    public static int count(){
        return count;
    }
    public static void clear(){
        mainArray = null;
        count = 0;
    }
    
}
