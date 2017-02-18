//this program controls my desk lamp through a distance sensor useing Arduino Mega


const int trigPin = 21; // this pin is on the distance sensor and calculates the distance useing triginometry it is also an output pin
const int echoPin = 20; // this pin is on the distance sensor and is incharge of the sound wave it is also an input pin
const int ledPin1 = 13; // this pin controls 3 leds through one of my channels on my 8 channel relay in total I used two relay channels
const int ledPin2 = 12; // this pin controls 3 leds through one of my channels on my 8 channel relay in total I used two relay channels

long duration, inches, cm; // three variables used to in the process of calculateing my distance and getting finall answer. Duration gives the number of microseconds it takes a sound wave to hit an object and come back. inches and cm are the resilt of my distance calculation

void setup() { // this method sets up all my pins which include my distance sensor pins and relay pins and sets up my serial monitor 

  
}

void loop(){// this mmethod controls when the lamp turns off and on when an object is within three inches of distance between the distance sensor and object in three inch vicinity

//lines 25 - 32 involve the distance sensor working to calculate the number of microseconds it takes a sound wave to hit an object and come back.
  Serial.begin(9600);

  pinMode(ledPin1,OUTPUT);
  pinMode(ledPin2,OUTPUT);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
 
  digitalWrite(trigPin, LOW);  
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);


  duration = pulseIn(echoPin, HIGH);


  inches = microsecondsToInches(duration); // this is where method is called to return desired distance in inches. The parameter is the variable duration which is a long data type.
  cm = microsecondsToCentimeters(duration); // this is where method is called to return desired distance in centimeters. The parameter is the variable duration which is a long data type.

  if (inches <= 3) { // if statement condition checks whether distance measured in inches is less than or equal to three inches
    digitalWrite(ledPin1,HIGH); // leds turn on
    digitalWrite(ledPin2,HIGH); // leds turn on
  }

  if (inches > 3) { // if statement condition checks whether distance measured in inches is greater than three inches
    digitalWrite(ledPin1,LOW); // leds turn off
    digitalWrite(ledPin2,LOW); // leds turn off
  }
  // lines 48 - 52 serial prints the distance data 
  Serial.print(inches);
  Serial.print("in, ");
  Serial.print(cm);
  Serial.print("cm");
  Serial.println();

  delay(100); // program pauses for 100 microseconds
}

long microsecondsToInches(long microseconds){ // this method converts the number of microseconds into a dictance measured in inches
  return microseconds / 74 / 2;
}

long microsecondsToCentimeters(long microseconds) {// this method converts the number of microseconds into a dictance measured in centimeters
  return microseconds / 29 / 2;
}
