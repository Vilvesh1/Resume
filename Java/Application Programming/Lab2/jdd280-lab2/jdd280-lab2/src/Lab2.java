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

scanner = new Scanner(new File("data.txt"));

while (scanner.hasNext()) {

studentname = scanner.nextLine();
score = scanner.nextLine();

Grades grades = new Grades(studentname);
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

public static void testGrades(Grades grades) {
    System.out.println(grades.toString()); 
    System.out.printf("\tName:    %s\n", grades.gettheName());
    System.out.printf("\tLength:  %d\n", grades.length());
    System.out.printf("\tAverage: %.2f\n", grades.average());
    System.out.printf("\tMedian:  %.1f\n", grades.median());
    System.out.printf("\tMaximum: %d\n", grades.maximum());
    System.out.printf("\tMininum: %d\n", grades.minimum());
}
}




class Grades {
  
int l;
int score[];
String studentname;


public Grades(String studentname) {
score = new int[100];
this.studentname = studentname;
}

public String gettheName() {
return this.studentname;
}

public void settheGrade(int q) {
score[l] = q;
l++;
}

public int length() {
return this.l;
}

public int maximum() {
int maximum = score[0];
int p;

p = 1;
while (p < l) {
if (score[p] > maximum)
maximum = score[p];
p++;
}
return maximum;
}

public int minimum() {
int minimum = score[0];
int r;
r = 1;

while (r < l){
if (score[r] < minimum)
minimum = score[r];
r++;
}
return minimum;
}

public double average() {
double average, sum = 0.0f;
int s;

s = 0;
while (s <= l) {
sum = sum + score[s];
s++;
}
average = sum / (double) l;
return average;
}


public double median() {
double median = 0;
int d;
int e;
int middlen;

for (d = 0; d < l; d++) {
for (e = d + 1; e < l; e++) {
int temporary = 0;
if (score[d] > score[e]) {
temporary = score[d];
score[d] = score[e];
score[e] = temporary;
}
}
}

middlen = (l / 2);
if (l % 2 == 0) {
int median1 = score[middlen];
int median2 = score[middlen - 1];
median = (double) (median1 + median2) / 2.0f;
} 
else {
median = score[middlen + 1];
}
return median;
}


@Override

public String toString() {
String number = "";
int y;

y = 0;
while (y < l) {
number = number + score[y] + ", ";
y++;
}
return "[" + number + "]";
}

}

