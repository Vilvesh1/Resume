// This program prints the first verse of Mary Had a Little Lamb and the first three verses of This Old Man
public class Poems {
// This method puts the the verses and titles in order 
    public static void main(String[] args) {
      System.out.println("Lab 1 written by VILVESH SRINIVASAN");
      space1(); 
      printTitle(); 
      space2(); 
      firstVerse(); 
      space3(); 
      printTitle1(); 
      space4(); 
      firstVerse1();
      space5();
      secondVerse1();
      space6();
      thirdVerse1(); 
    }
    
    // This method puts a space between the first song title and the program title for the lab
    public static void space1() {
       System.out.println("");
    }
    // This method prints out first song title
    public static void printTitle() {
       System.out.println("Marry Had a Little Lamb");
    }
    // This method puts a space between the first song title and the first verse for Marry Had a Little Lamb
    public static void space2() {
       System.out.println("");
    }
    // This method puts the lines in order for the first verse for Marry Had a Little Lamb
    public static void firstVerse() {
      line1();
      line2();
      line1();
      line3();
    }
    // This method prints line1 for Marry Had a Little Lamb
    public static void line1() {
       System.out.println("Mary had a little lamb");
    }
    // This method prints line2 for Marry Had a Little Lamb
    public static void line2() {
       System.out.println("Little lamb, little lamb");
    }
    // This method prints line3 for Marry Had a Little Lamb
    public static void line3() {
       System.out.println("Its fleece was white as snow");
    }
    // This method puts a space between the first verse and the second song title
    public static void space3() {
       System.out.println("");
    }
    // This method prints out second song title
    public static void printTitle1() {
       System.out.println("This Old Man");
    }
    // This method puts a space between the second song title and the first verse for This Old Man
    public static void space4() {
       System.out.println("");
    }
    // This method puts the lines in order for the first verse for This Old Man
    public static void firstVerse1() {
      line11();
      line12();
      line13();
      line14();
    }
    // This method prints line11 for This Old Man
    public static void line11() {
       System.out.println("This old man, he played one");
    }
    // This method prints line12 for This Old Man
    public static void line12() {   
       System.out.println("He played knick-knack on my thumb");
    }
    // This method prints line13 for This Old Man
    public static void line13() {
       System.out.println("With a knick-knack patty-whack, give a dog a bone");
    }
    // This method prints line14 for This Old Man
    public static void line14() {
       System.out.println("This old man came rolling home");
    }
    // This method puts a space between firstVerse1 and secondVerse1 for This Old Man
    public static void space5() {
       System.out.println("");
    }
    // This method puts the lines in order for the second verse for This Old Man
    public static void secondVerse1() {
      line15();
      line16();
      line13();
      line14();
    }
    // This method prints line15 for This Old Man
    public static void line15() {  
       System.out.println("This old man, he played two");
    }
    // This method prints line16 for This Old Man
    public static void line16() {
       System.out.println("He played knick-knack on my shoe");
    }
    // This method puts a space between secondVerse1 and thirdVerse1 for This Old Man
    public static void space6() {
       System.out.println("");
    }
    // This method puts the lines in order for the third verse for This Old Man
    public static void thirdVerse1() {
      line19();
      line20();
      line13();
      line14();
    }
    // This method prints line19 for This Old Man  
    public static void line19() {   
      System.out.println("This old man, he played three");
    }
    // This method prints line20 for This Old Man
    public static void line20() {   
      System.out.println("He played knick-knack on my knee");
    }
}