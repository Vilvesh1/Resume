package core;
/*
 * Vilvesh Srinivasan
 * CS 3443
 * Lab2
 * 
 * The task is to read a file, store the data into objects, and process the objects. 
 * The file is formatted as pairs of lines: 
 * the first line of each pair is the name of a student, and the second line is a list of grades. 
 * This data will be stored in a Grades object. The Grades class will have several methods for processing the data.
 */


import java.util.Scanner;
import java.io.File;

public class Lab2 {
public static void main(String[] args) {
  
int x;
String studentname;
String score;

Scanner scanner = null;

try {

scanner = new Scanner(new File("C:\\Users\\vilve\\eclipse-workspace\\jdd280-lab2\\src\\data.txt"));

while (scanner.hasNext()) {

studentname = scanner.nextLine();
score = scanner.nextLine();

GradeBook grades = new GradeBook(studentname);
String seperateG[] = score.split(" ");

x = 0;
while (x < seperateG.length) {
grades.settheGrade(Integer.parseInt(seperateG[x]));
x++;
}

testGrades(grades);
}
} 
catch (Exception e) {
} 
finally {
scanner.close();

}
}

public static void testGrades(GradeBook grades) {
    System.out.println(grades.toString()); 
    System.out.printf("\tName:    %s\n", grades.gettheName());
    System.out.printf("\tLength:  %d\n", grades.length());
    System.out.printf("\tAverage: %.2f\n", grades.average());
    System.out.printf("\tMedian:  %.1f\n", grades.median());
    System.out.printf("\tMaximum: %d\n", grades.maximum());
    System.out.printf("\tMininum: %d\n", grades.minimum());
}
}