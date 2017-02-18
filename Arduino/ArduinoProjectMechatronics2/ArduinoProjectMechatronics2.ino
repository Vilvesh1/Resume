#include <AFMotor.h> // file used to call functions, got this file from library made for this motor sheild

AF_DCMotor motor1(1); // defining variable for motor 1
AF_DCMotor motor2(2); // defining variable for motor 1
const int trigPin = 20; // defing variable for trigonometry pin for utrasoud distance sensor
const int echoPin = 21; // defing variable for echolocation pin for utrasoud distance sensor
const int irPin1 = 19; // defing variable for infared object detection sensor 
const int irPin2 = 14; // defing variable for infared line sensor
const int irPin3 = 16; // defing variable for infared object detection sensor 
const int b = 15; // defing variable for switch to turn bot and off
long duration; // defing variable for amount of time it takes sound to hit object and comeback to ultrasound sensor  
long inches; // defing variable for distance the object is away from ultrasound distance sensor
int sensorValue2; //  defing variable for IRPin1 either reads 0 or 1
int sensorValue3; //  defing variable for IRPin2 either reads 0 or 1
int sensorValue4; //  defing variable for switch either reads 0 or 1
int sensorValue5; //  defing variable for IRPin3 either reads 0 or 1
int i = 0; // is a counter variable used for line detection loop


void setup() { // runs once
  Serial.begin(9600);  // puts up serial monitor to check whats happenting in code for trouble shooting reasons
  Serial.println("Lets Rumble!");
  pinMode(trigPin, OUTPUT); // define this pin as an output
  pinMode(echoPin, INPUT); // define this pin as an input
  pinMode(irPin1, INPUT); // define this pin as an input
  pinMode(irPin2, INPUT); // define this pin as an input
  pinMode(irPin3, INPUT); // define this pin as an input
  sensorValue2 = digitalRead(irPin1); // this command returnns 0 or 1 
  sensorValue3 = digitalRead(irPin2);  // this command returnns 0 or 1
  sensorValue5 = digitalRead(irPin3);// this command returnns 0 or 1
  sensorValue4 = digitalRead(b); // this command returnns 0 or 1

}

void loop() { // loops indefinitely
 
  digitalWrite(trigPin, LOW);  // lines 37-44 calculate distance for utrasound sensor
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  inches = microsecondsToInches(duration);
  delay(100); 

  sensorValue4 = digitalRead(b); 
  while (sensorValue4 == 0) { // this loop puts the bot in a infinite loop which puts the bot in a inactive state (off).
        motor1.setSpeed(0); // motor 1 turns off
        motor2.setSpeed(0); // motor 2 turns off
        sensorValue4 = digitalRead(b);
  }

  
  

    while ((inches <= 5 || sensorValue2 == 0 || sensorValue5 == 0) && sensorValue3 == 0) { // this loop makes the bot charge other bots motors (motors move forward)
         motor1.run(FORWARD); // motor 1 moves forward
         motor2.run(FORWARD); // motor 2 moves forward
         motor1.setSpeed(255); // motor 1 moveing at full speed
         motor2.setSpeed(255); // motor 2 moveing at full speed
         digitalWrite(trigPin, LOW);  // lines 61-70 calculate distance for utrasound sensor
         delayMicroseconds(2);
         digitalWrite(trigPin, HIGH);
         delayMicroseconds(10);
         digitalWrite(trigPin, LOW);
         duration = pulseIn(echoPin, HIGH);
         inches = microsecondsToInches(duration);
         Serial.print(inches);
         Serial.println("in F");
         delay(100); 

         sensorValue2 = digitalRead(irPin1);
         Serial.print(sensorValue2);
         Serial.println("F");
         sensorValue5 = digitalRead(irPin3);
         Serial.print(sensorValue5);
         Serial.println("F");
         
         if (inches > 5 && sensorValue2 == 1 && sensorValue5 == 1 ) // causes the bot to break out of loop due to IR object detection senors and and Ultrasound senor
         { 
          motor1.setSpeed(0); // motor 1 turns off
          motor2.setSpeed(0); // motor 2 turns off
          delay(100); 
          break;
         }
         
         sensorValue3 = digitalRead(irPin2); 
          if (sensorValue3 == 1) // causes the bot to break out of loop due to line senor
         { 
         motor1.setSpeed(0); // motor 1 turns off
         motor2.setSpeed(0); // motor 2 turns off
         break;
         } 
         
         
        sensorValue4 = digitalRead(b); 
        while (sensorValue4 == 0) { // this loop puts the bot in a infinite loop which puts the bot in a inactive state (off).
                motor1.setSpeed(0); // motor 1 turns off
                motor2.setSpeed(0); // motor 2 turns off
                sensorValue4 = digitalRead(b);
                }
                
  }




    while ((inches > 5 || sensorValue2 == 1 || sensorValue5 == 1) && sensorValue3 == 0) { // this loop makes the bot spin to locate other bots (motors cause bot to rotate counterclockwise)
         motor1.run(FORWARD); // motor 1 moves forward
         motor2.run(BACKWARD); // motor 2 moves backwards
         motor1.setSpeed(150); // motor 1 moveing at a moderate speed
         motor2.setSpeed(150); // motor 2 moveing at a moderate speed
         digitalWrite(trigPin, LOW);  // lines 113-122 calculate distance for utrasound sensor 
         delayMicroseconds(2);
         digitalWrite(trigPin, HIGH);
         delayMicroseconds(10);
         digitalWrite(trigPin, LOW);
         duration = pulseIn(echoPin, HIGH);
         inches = microsecondsToInches(duration);
         Serial.print(inches);
         Serial.println("in R");
         delay(100); 
         
         sensorValue2 = digitalRead(irPin1);
         Serial.print(sensorValue2);
         Serial.println("R");
         sensorValue5 = digitalRead(irPin3);
         Serial.print(sensorValue5);
         Serial.println("R");
         
         if (inches <= 5) // breaks out of loop due to ultrasound sensor
         { 
          motor1.setSpeed(0); // motor 1 turns off
          motor2.setSpeed(0); // motor 2 turns off
          delay(100); 
          break;
         }
         else if (sensorValue2 == 0) // breaks out of loop due to object detection sensor
         { 
          motor1.setSpeed(0); // motor 1 turns off
          motor2.setSpeed(0); // motor 2 turns off
          delay(100); 
          break;
         }
         else if (sensorValue5 == 0) // breaks out of loop due to object detection sensor
         { 
          motor1.setSpeed(0); // motor 1 turns off
          motor2.setSpeed(0); // motor 2 turns off
          delay(100); 
          break;
         }  

         sensorValue3 = digitalRead(irPin2);
          if (sensorValue3 == 1) // causes the bot to break out of loop due to line senor
         { 
          motor1.setSpeed(0); // motor 1 turns off
          motor2.setSpeed(0); // motor 2 turns off
          break;
         } 
         
        sensorValue4 = digitalRead(b);
        while (sensorValue4 == 0) {  // this loop puts the bot in a infinite loop which puts the bot in a inactive state (off).
                motor1.setSpeed(0); //motor 1 turns off
                motor2.setSpeed(0); // motor 2 turns off
                sensorValue4 = digitalRead(b);
                }
                
  }



  
    while (sensorValue3 == 1 ) { // this loop makes the bot move backwards (line sensor sees white line) 
      if (i == 0) {
        delay(200);
        i++;
      }
         motor1.run(BACKWARD); // motor 1 moves backwards
         motor2.run(BACKWARD); // motor 2 moves backwards
         motor1.setSpeed(255); // motor 1 moves full speed
         motor2.setSpeed(255); // motor 2 moves full speed
         delay(500);
         sensorValue3 = digitalRead(irPin2);
         Serial.print(sensorValue3);
         Serial.println("B");
         sensorValue4 = digitalRead(b);
         while (sensorValue4 == 0) { // this loop puts the bot in a infinite loop which puts the bot in a inactive state (off).
                motor1.setSpeed(0); // motor 1 turns off
                motor2.setSpeed(0); // motor 2 turns off
                sensorValue4 = digitalRead(b);
                
                }

    }


  i = 0;
  
}
 

long microsecondsToInches(long microseconds){ // the method returns the distance in inches due to the duration variable 
  return microseconds / 74 / 2;
}




