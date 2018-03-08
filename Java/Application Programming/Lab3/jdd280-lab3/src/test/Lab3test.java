package test;

/*
 * Vilvesh Srinivasan
 * CS 3443
 * Lab3
 * JUnit test cases for  methods in classes pertaining to Lab3 assignment
 */
import core.Date;
import core.DateRange;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class Lab3test {
Date start = null;
Date end = null;
String line = null;


@Test(expected=NullPointerException.class)
public void toStringDRCOMPUTE(){
DateRange dr = new DateRange(start, end); 
assertEquals("Checking if object is null",dr.toString(),null);
}

@Test(expected=NullPointerException.class)
public void toStringDCOMPUTE(){
Date d = new Date (line); 
assertEquals("Checking if object is null",d.toString(),null);
}

@Test(expected=NullPointerException.class)
public void setmonthCOMPUTE(){
Date d = new Date (line); 
assertEquals("Checking if object is null",d.setm(null),null);
}

@Test(expected=NullPointerException.class)
public void comparetoCOMPUTE(){
Date d = new Date (line); 
assertEquals("Checking if object is null",d.compareTo(null),null);
}

}