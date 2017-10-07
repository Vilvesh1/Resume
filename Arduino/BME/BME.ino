/*
 * This is the code behind the prototype for the control system for the db chroma vibrato glasses. 
 * Essentially in this code whatever the volume of the enviorment is the dbchommavibrato glasses will output a motor speed which will inflict vibrations to the operator to feel and a color
 * for the operator to see. The color this prtotype outputs are red, green, and blue. These color is the same order represent high volume enviorment, average volume enviorment, and low volume enviorment.  
 * By doing this the operator is getting a sense of how loud the enviorment is. This product would help those with impared hearing get a sense of security.
 */


#include <AFMotor.h> // file used to call functions, got this file from library made for this motor sheild
AF_DCMotor motor1(1); // defining variable for motor 1


const int sPin = A8; // Sound Senor pin
const int switchPin = 14; // Switch  pin
const int rledPin = 21; // RGB led Red pin
const int bledPin = 20; // RGB led blue pin
const int gledPin = 19; // RGB led green pin

int sensorValue1; // Souund sensor integer value holder
int sensorValue2; // Swich output integer value holder
int db; // data type int to hold converted decibel value from sensorValue1
String sensorValue; // string value holder



void setup() { // this is the inital setup
  Serial.begin(9600); // Start serial mmonitor turns on
    while (!Serial) { // Wait till serial mmonitor turns on
    ; 
  }
  pinMode(sPin, INPUT); // Setup sound sensor as an input
  pinMode(switchPin, OUTPUT); // Setup switch as an output
  pinMode(rledPin, OUTPUT); // Setup RGB led pin of the color red as an output 
  pinMode(bledPin, OUTPUT); // Setup RGB led pin of the color blue as an output 
  pinMode(gledPin, OUTPUT); //Setup RGB led pin of the color green as an output 
}


void loop() { // this loop runs forever 


  sensorValue1 = analogRead(sPin); // read and save analog sensor value of the soud sensor as an integer variable
  db = (int)(16.801 * log (((double)sensorValue1)/1023) + 9.872); // converts sensorValue1 to db
  sensorValue = db; // turn integer into a string
  Serial.println("a " + sensorValue); // print string which displays what section of the code your in and also displays the db value of the sound sensor
  
  while (db <= -25 && sensorValue2 != 1) { // Sets condition of the loop incopratesing Sound sensor db value and switch value. This loop is for a low volume enviorment
  motor1.run(FORWARD); // turns motor colockwise
  motor1.setSpeed(0); // puts motor at 0 speed
  
  sensorValue1 = analogRead(sPin); // read and save analog sensor value of the soud sensor as an integer variable
  db = (int)(16.801 * log (((double)sensorValue1)/1023) + 9.872); // converts sensorValue1 to db
  sensorValue = db; // turn integer into a string
  Serial.println("b " + sensorValue); // print string which displays what section of the code your in and also displays the db value of the sound sensor
  
  digitalWrite(rledPin, LOW); // turns red light off for RGB led
  digitalWrite(gledPin, LOW); // turns green light off for RGB led
  digitalWrite(bledPin, HIGH); // turns blue light on for RGB led
  
  sensorValue2 = digitalRead(switchPin); // read and save analog sensor value of the switch as an integer variable
  }
  digitalWrite(rledPin, LOW); // turns red light off for RGB led
  digitalWrite(gledPin, LOW); // turns green light off for RGB led
  digitalWrite(bledPin, LOW); // turns blue light off for RGB led
  motor1.run(FORWARD); // turns motor colockwise
  motor1.setSpeed(0);  // puts motor at 0 speed

  db = (int)(16.801 * log (((double)sensorValue1)/1023) + 9.872); // converts sensorValue1 to db
  sensorValue = db; // turn integer into a string
  Serial.println("c " + sensorValue); // print string which displays what section of the code your in and also displays the db value of the sound sensor

  sensorValue1 = analogRead(sPin); // read and save analog sensor value of the soud sensor as an integer variable
  
  db = (int)(16.801 * log (((double)sensorValue1)/1023) + 9.872); // converts sensorValue1 to db
  sensorValue = db; // turn integer into a string
  Serial.println("d " + sensorValue); // print string which displays what section of the code your in and also displays the db value of the sound sensor
  
  
  while (db <= -9 && db > -25 && sensorValue2 != 1){ // Sets condition of the loop incopratesing Sound sensor db value and switch value. This loop is for average volume enviorment
  motor1.run(FORWARD); // turns motor colockwise
  motor1.setSpeed(150); // puts motor at 150 speed
  
  sensorValue1 = analogRead(sPin); // read and save analog sensor value of the soud sensor as an integer variable
  db = (int)(16.801 * log (((double)sensorValue1)/1023) + 9.872); // converts sensorValue1 to db
  sensorValue = db; // turn integer into a string
  Serial.println("e " + sensorValue); // print string which displays what section of the code your in and also displays the db value of the sound sensor
  
  digitalWrite(rledPin, LOW); // turns red light off for RGB led
  digitalWrite(gledPin, HIGH); // turns green light on for RGB led
  digitalWrite(bledPin, LOW); // turns blue light off for RGB led
  
  sensorValue2 = digitalRead(switchPin); // read and save analog sensor value of the switch as an integer variable
  }
  digitalWrite(rledPin, LOW); // turns red light off for RGB led
  digitalWrite(gledPin, LOW); // turns green light off for RGB led
  digitalWrite(bledPin, LOW); // turns blue light off for RGB led
  motor1.run(FORWARD); // turns motor colockwise
  motor1.setSpeed(0);  // puts motor at 0 speed

  db = (int)(16.801 * log (((double)sensorValue1)/1023) + 9.872); // converts sensorValue1 to db
  sensorValue = db; // turn integer into a string
  Serial.println("f " + sensorValue); // print string which displays what section of the code your in and also displays the db value of the sound sensor

  sensorValue1 = analogRead(sPin); // read and save analog sensor value of the soud sensor as an integer variable

  db = (int)(16.801 * log (((double)sensorValue1)/1023) + 9.872); // converts sensorValue1 to db
  sensorValue = db; // turn integer into a string
  Serial.println("g " + sensorValue); // print string which displays what section of the code your in and also displays the db value of the sound sensor

  
  while (db <= 10 && db > -9 && sensorValue2 != 1){ // Sets condition of the loop incopratesing Sound sensor db value and switch value. This loop is for a high volume enviorment
  motor1.run(FORWARD); // turns motor colockwise
  motor1.setSpeed(255); // puts motor at 255 speed
  
  sensorValue1 = analogRead(sPin); // read and save analog sensor value of the soud sensor as an integer variable
  db = (int)(16.801 * log (((double)sensorValue1)/1023) + 9.872); // converts sensorValue1 to db
  sensorValue = db; // turn integer into a string
  Serial.println("h " + sensorValue); // print string which displays what section of the code your in and also displays the db value of the sound sensor
  
  digitalWrite(rledPin, HIGH); // turns red light on for RGB led
  digitalWrite(gledPin, LOW); // turns green light off for RGB led
  digitalWrite(bledPin, LOW); // turns blue light off for RGB led
  
  sensorValue2 = digitalRead(switchPin); // read and save analog sensor value of the switch as an integer variable
  }
  digitalWrite(rledPin, LOW); // turns red light off for RGB led
  digitalWrite(gledPin, LOW); // turns green light off for RGB led
  digitalWrite(bledPin, LOW); // turns blue light off for RGB led
  motor1.run(FORWARD); // turns motor colockwise
  motor1.setSpeed(0); // puts motor at 0 speed

  
  
  sensorValue2 = digitalRead(switchPin); // read and save analog sensor value of the switch as an integer variable
  sensorValue = sensorValue2;  // read and save analog sensor value of the switch as an integer variable
  Serial.println("i " + sensorValue); // print string which displays what section of the code your in and also displays the sensor value of the switch
  while (sensorValue2 == 1) {
    sensorValue2 = digitalRead(switchPin); // read and save analog sensor value of the switch as an integer variable
    sensorValue = sensorValue2;  // read and save analog sensor value of the switch as an integer variable
    Serial.println("j " + sensorValue); // print string which displays what section of the code your in and also displays the sensor value of the switch
  }
  sensorValue = sensorValue2; // read and save analog sensor value of the switch as an integer variable
  Serial.println("k " + sensorValue); // print string which displays what section of the code your in and also displays the sensor value of the switch
  

}



