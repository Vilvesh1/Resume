/*
 * This program will implement one of the hashing procedures in the following related functions:
 * INSERT (item)
 * DELETE (item)
 * FIND (item)
 * The program will also correctly handle collisions and full hash table!
 * 
 * Vilvesh Srinivasan
 * COSC 2436
 */

public class A8 {
  
    public static void main(String[] args) {
      
        MyHash studentGradeBook = new MyHash(12);
        Object[] student1 = {"Bob", 100};
        Object[] student2 = {"Fred", 90};
        Object[] student3 = {"Mike", 85};
        studentGradeBook.insert(2345, student1);
        studentGradeBook.insert(123, student2);
        
        Node stu_1 = studentGradeBook.find(2345);
        Node stu_2 = studentGradeBook.find(123);
        
        System.out.println(stu_1.name +"'s Grade is " + stu_1.grade);
        System.out.println(stu_2.name +"'s Grade is " + stu_2.grade);
         
        studentGradeBook.delete(123);
        studentGradeBook.insert(123, student3);
        stu_2 = studentGradeBook.find(123);
         
        System.out.println(stu_2.name +"'s Grade is " + stu_2.grade);
    }
    
static class Node{
    public int key;
    public String name;
    public int grade;
    private Node next;
    
     
}

static class MyHash{
    private Node[] records;
    int count, size;
    Node head; 
    public MyHash(int size){
        this.size = size;
        count = 0;
        records = new Node[size];
    }
    
    public int length(){
        return count;
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
     public void insert(int key, Object[] value) {
            
         int nextHashKey = hashAlgorithm(key); 
         Node current = records[nextHashKey]; 
         
         while (current != null) {
               
            if (current.key == key)
            break;
            current = current.next;
         }
         
         if (current != null) {
            
            current.name = (String) value[0];
            current.grade = (Integer) value[1];
         }
         else if (!isFull()){
             
            Node newNode = new Node();
            newNode.key = key;
            newNode.name = (String) value[0];
            newNode.grade = (Integer) value[1];
            newNode.next = records[nextHashKey];
            records[nextHashKey] = newNode;
            count++;  
         }
      }

      public Node find(int key) {
           
         int current = hashAlgorithm(key);  
         Node list = records[current];  
         while (list != null) {
                
            if (list.key == key)
               return list;
            list = list.next;  
         }
          
         return null;  
      }

      public void delete(int key) {  
            
         int current = hashAlgorithm(key);  
         if (records[current] == null) {
            return; 
         }
         if (records[current].key == key){
            records[current] = records[current].next;
            count--; 
            return;
         }
         
         Node prev = records[current];  
         Node curr = prev.next;  
         while (curr != null && curr.key != key){
            curr = curr.next;
            prev = curr;
         }

         if (curr != null) {
            prev.next = curr.next;
            count--;  
         }
      }
       private int hashAlgorithm(int key) {

         return key % records.length;
      }
}  
}

