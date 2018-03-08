package test;

/*
 * Vilvesh Srinivasan
 * CS 3443
 * Lab4
 * JUnit test cases for  methods in classes pertaining to Lab 4 assignment
 */

import core.Inch;
import core.Foot;
import core.Meters;
import core.Yard;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class Lab4test {
String line = null;


@Test(expected=NullPointerException.class)
public void addfCOMPUTE(){
Foot f = new Foot(0); 
assertEquals("Checking if object is null",f.add(null),null);
}

@Test
public void getmeasurefCOMPUTE(){
Foot f = new Foot(0); 
assertEquals("Checking if object is null",f.gM(),"feet");
}

@Test
public void convTometersfCOMPUTE(){
Foot f = new Foot(0); 
assertEquals("Checking if object is null",f.cM(),0.0,0);
}

@Test(expected=NullPointerException.class)
public void addiCOMPUTE(){
Inch f = new Inch(0); 
assertEquals("Checking if object is null",f.add(null),null);
}

@Test
public void getmeasureiCOMPUTE(){
Inch f = new Inch(0); 
assertEquals("Checking if object is null",f.gM(),"inches");
}

@Test
public void convTometersiCOMPUTE(){
Inch f = new Inch(0); 
assertEquals("Checking if object is null",f.cM(),0.0,0);
}

@Test(expected=NullPointerException.class)
public void addyCOMPUTE(){
Yard f = new Yard(0); 
assertEquals("Checking if object is null",f.add(null),null);
}

@Test
public void getmeasureyCOMPUTE(){
Yard f = new Yard(0); 
assertEquals("Checking if object is null",f.gM(),"yards");
}

@Test
public void convTometersyCOMPUTE(){
Yard f = new Yard(0); 
assertEquals("Checking if object is null",f.cM(),0.0,0);
}

@Test(expected=NullPointerException.class)
public void addmCOMPUTE(){
Meters f = new Meters(0); 
assertEquals("Checking if object is null",f.add(null),null);
}

@Test
public void getmeasuremCOMPUTE(){
Meters f = new Meters(0); 
assertEquals("Checking if object is null",f.gM(),"meters");
}

@Test
public void convTometersmCOMPUTE(){
Meters f = new Meters(0); 
assertEquals("Checking if object is null",f.cM(),0.0,0);
}

}