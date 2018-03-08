package test;

/*
 * Vilvesh Srinivasan
 * CS 3443
 * Lab7
 * 4 JUnit test cases for each the following methods in your Grades class from Lab 2:
 * median
 * average
 * minimum
 */

import core.GradeBook;
import org.junit.Test;
import org.junit.Assert;


public class TestGradeBook {


	
	

@Test(expected=IndexOutOfBoundsException.class)

public void testMEDIANwithNoGradestoCOMPUTE(){

GradeBook testThisGradeingMethod = new GradeBook("Vil");

Assert.assertEquals(testThisGradeingMethod.median(), Double.NaN, 0);
}






@Test

public void testMEDIANwithONEGradetoCOMPUTE() {

GradeBook testThisGradeingMethod = new GradeBook("Vil");

testThisGradeingMethod.settheGrade(0);

Assert.assertEquals(testThisGradeingMethod.median(), 0, 0);
}





@Test

public void testMEDIANwithFEWGradestoCOMPUTE(){

GradeBook testThisGradeingMethod = new GradeBook("Vil");

testThisGradeingMethod.settheGrade(14);
testThisGradeingMethod.settheGrade(15);
testThisGradeingMethod.settheGrade(21);
testThisGradeingMethod.settheGrade(22);

Assert.assertEquals(testThisGradeingMethod.median(), 18, 0);
}





@Test

public void testMEDIANwithMOREthanaFEWGradestoCOMPUTE() {

GradeBook testThisGradeingMethod = new GradeBook("Vil");

testThisGradeingMethod.settheGrade(33);
testThisGradeingMethod.settheGrade(24);
testThisGradeingMethod.settheGrade(99);
testThisGradeingMethod.settheGrade(89);
testThisGradeingMethod.settheGrade(89);

Assert.assertEquals(testThisGradeingMethod.median(), 89, 0);
}






@Test

public void testAVGwithNOGradestoCOMPUTE(){
GradeBook testThisGradeingMethod = new GradeBook("Vil");

Assert.assertEquals(testThisGradeingMethod.average(), Double.NaN, 0);
}





@Test

public void testAVGwithONEGradetoCOMPUTE(){
GradeBook testThisGradeingMethod = new GradeBook("Vil");

testThisGradeingMethod.settheGrade(50);

Assert.assertEquals(testThisGradeingMethod.average(), 50, 0);
}





@Test

public void testAVGwithFEWGradestoCOMPUTE(){
GradeBook testThisGradeingMethod = new GradeBook("Vil");

testThisGradeingMethod.settheGrade(50);
testThisGradeingMethod.settheGrade(40);
testThisGradeingMethod.settheGrade(30);

Assert.assertEquals(testThisGradeingMethod.average(), 40, 0);
}





@Test

public void testAVGwithMOREthanaFEWGradestoCOMPUTE(){
GradeBook testThisGradeingMethod = new GradeBook("Vil");

testThisGradeingMethod.settheGrade(40);
testThisGradeingMethod.settheGrade(50);
testThisGradeingMethod.settheGrade(60);
testThisGradeingMethod.settheGrade(30);
testThisGradeingMethod.settheGrade(20);

Assert.assertEquals(testThisGradeingMethod.average(), 40, 0);

}




@Test(expected=IndexOutOfBoundsException.class)

public void testMINwithNOGradestoCOMPUTE(){
GradeBook testThisGradeingMethod = new GradeBook("Vil");

testThisGradeingMethod.minimum();

Assert.assertEquals(testThisGradeingMethod.minimum(), 0, 0);
}





@Test

public void testMINwithONEGradestoCOMPUTE() {
GradeBook testThisGradeingMethod = new GradeBook("Vil");

testThisGradeingMethod.settheGrade(33);

Assert.assertEquals(testThisGradeingMethod.minimum(), 33, 0);

}





@Test

public void testMINwithFEWGradestoCOMPUTE(){
GradeBook testThisGradeingMethod = new GradeBook("Vil");

testThisGradeingMethod.settheGrade(40);
testThisGradeingMethod.settheGrade(50);
testThisGradeingMethod.settheGrade(20);

Assert.assertEquals(testThisGradeingMethod.minimum(), 20, 0);
}





@Test

public void testMINwithMOREthanaFEWGradestoCOMPUTE(){

GradeBook testThisGradeingMethod = new GradeBook("Vil");

testThisGradeingMethod.settheGrade(42);
testThisGradeingMethod.settheGrade(55);
testThisGradeingMethod.settheGrade(62);
testThisGradeingMethod.settheGrade(31);
testThisGradeingMethod.settheGrade(23);

Assert.assertEquals(testThisGradeingMethod.minimum(), 23, 0);
}





}