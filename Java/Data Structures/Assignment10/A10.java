/*
 * This program will have a menu driven program that implements the following doubly linked list operations :
 * INSERT (at the beginning)
 * INSERT_ALPHA (in alphabetical order)
 * DELETE (Identify by contents, i.e. "John", not #3)
 * COUNT
 * CLEAR
 * EXIT PROGRAM
 * 
 * Vilvesh Srinivasan
 * COSC 2436
 */

import static java.lang.System.out;
import java.util.Scanner;

public class A10 {

    public static final Scanner CONSOLE = new Scanner (System.in);
  
    public static void main(String[] args) {
      
    int i = 1;
    int x = 1;
    int choice;
    int sizeL;
    
    
    out.println("Please enter the size of this list:");
    sizeL = CONSOLE.nextInt();
    
    while(x == 1) {
      if (i == 3 ) {
        i = 1;
        out.println("Please enter the size of this new list:");
        sizeL = CONSOLE.nextInt();
      }
    
    DoublyLinkList list  = new DoublyLinkList(sizeL);
    while(i == 1) {
    out.println("***DOUBLY LINKED LIST OPERATIONS:****");
    out.println(" MENU ");
    out.println("---------------------------------------");
    out.println(" 1.INSERT (at the beginning) ");
    out.println(" 2.INSERT_ALPHA (in alphabetical order) ");
    out.println(" 3.DELETE (Identify by contents, i.e. \"John\", not #3) ");
    out.println(" 4.COUNT ");
    out.println(" 5.CLEAR ");
    out.println(" 6.EXIT PROGRAM ");
    out.println("--------------------------------------");
    out.println("Enter your choice:\t");
    
    choice = CONSOLE.nextInt();
    
    switch(choice) {

    case 1:
    Scanner CONSOLE1 = new Scanner (System.in);
    out.println("Please enter a name to insert.");
    String name = CONSOLE1.nextLine();
    list.insert(name);
    break;
    
    case 2:
    Scanner CONSOLE2 = new Scanner (System.in);
    out.println("Please enter a name to insert.");
    String name1 = CONSOLE2.nextLine();
    list.insert_Alpha(name1);
    break;
    
    case 3:
    Scanner CONSOLE3 = new Scanner (System.in);
    out.println("Please enter a name to delete.");
    String name2 = CONSOLE3.nextLine();
    list.delete(name2);
    break;

    case 4:
    out.println("Your Count is " +list.count());
    break;

    case 5:
    out.println("The list has been cleared");
    list.clear();
    i = 3;
    break;
    
    case 6:
    out.println("Bye!");
    i++;
    x++;
    break;
    
    default:
    out.println("Wrong choice try again please.");
    break;
  }
}
}
}
    
    
    static class Node{
    public String name;
    private Node next;
    private Node previous;
    }

    static class DoublyLinkList{
    int count, size;
    Node head, tail;
    public DoublyLinkList(int size){
        this.size = size;
        count = 0;
        head = null;
        tail = null;
    }
    
    public int count(){
        return count;
    }
    
    public void clear(){
        head = null;
        tail = null;
        count = 0;
    }
    
    public boolean isFull(){
        if(count < size)
        return false;
        else
        return true;
    }

    public boolean isEmpty(){
        if(count == 0)
        return true;
        else
        return false;
    } 
    
     public void insert(String name) {
         if(isEmpty()){
             head = new Node();
             head.name = name;
             count++;
             tail = head;
         }else if (!isFull()){
            Node current =  new Node();
            current.name = name;
            head.previous = current;
            current.next = head;
            head = current;
            count++;
        }
      }

      public void delete(String Name) {  
         if (isEmpty()) {
             out.println("LinkList is empty");
            return; 
         }else{
            Node prev = null;
            Node temp = null;
            Node current = head; 
         while(current != null){
         if (current.name.equals(Name)){
            if(prev == null){
              if(current.next != null){
            temp = current.next;
            temp.previous = null;
            }
            head = temp;
            }else{
              if(current.next != null){
                 temp = current.next;
                 temp.previous = prev;
                 prev.next = temp;
                 head = prev;
              }
              else{
                head = prev;
              }
              
            }
            count--;
            return; 
            }else{
             prev = current;
             current = current.next;
         }
         }
         }
      }
      
      
       public void insert_Alpha(String Name){
       Node previous = null;
       Node current = head;
       Node newNode = new Node();
       if(!isFull()) {
         newNode.name = Name;
         while(current != null && Name.compareTo(current.name)>0){
         previous = current;
         current = current.next;
         }
         if(previous == null){
           newNode.previous = null;
           newNode.next = current;
           head = newNode;
           count++;
         }
         else{
          newNode.previous = previous;
          newNode.next = current;
          previous.next = newNode;
          head = previous;
          count++;
         }
       }
       }      
       
}
}