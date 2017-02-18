//This program controls when my music starts and stops playing on my Arduino UNO


#include "SD.h" // this calls infromation form the h file from my SD library
#include "TMRpcm.h" //this calls infromation form the h file from my TMRpcm library
#include "SPI.h"// this calls infromation form the h file from my SPI library

#define SD_ChipSelectPin 4

const int trigPin = 7; // this pin is on the distance sensor and calculates the distance useing triginometry it is also an output pin
const int echoPin = 6; // this pin is on the distance sensor and is incharge of the sound wave it is also an input pin
long duration, inches, cm; // three variables used to in the process of calculateing my distance and getting finall answer. Duration gives the number of microseconds it takes a sound wave to hit an object and come back. inches and cm are the resilt of my distance calculation


int i = 0; //counter 1
int j = 0; //check point variable

TMRpcm tmrpcm; // dedclareing a function from my TMRpcm library to make commands in code

void setup(){ // this method sets up all my pins which include my distance sensor pins and relay pins and sets up my serial monitor. This method also intializes my speaker through the TMRcpm library and plays the file on my mircoSDHC card that it also initializes

Serial.begin(9600);
  
pinMode(trigPin, OUTPUT);
pinMode(echoPin, INPUT);
tmrpcm.speakerPin = 9;
if (!SD.begin(SD_ChipSelectPin)) { // check wheter the microsdhc card can be initialized properly if not program exits 
Serial.println("SD Fail!"); 
exit(0);
}
else {
Serial.println("SD Sucess!");
}
tmrpcm.play("1.wav"); // plays the name of the file on the card
tmrpcm.setVolume(6); // sets the volume to six the range is between 0-7
}

void(* resetFunc) (void) = 0; // this is what I use to reset program aka the song once the song is done playing


void loop()
{

//lines 45 - 52 involve the distance sensor working to calculate the number of microseconds it takes a sound wave to hit an object and come back.
  digitalWrite(trigPin, LOW);
  delayMicroseconds(2);
  digitalWrite(trigPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(trigPin, LOW);


  duration = pulseIn(echoPin, HIGH);


  inches = microsecondsToInches(duration); // this is where method is called to return desired distance in inches. The parameter is the variable duration which is a long data type.
  cm = microsecondsToCentimeters(duration); // this is where method is called to return desired distance in centimeters. The parameter is the variable duration which is a long data type.

  if (inches <= 3) { // if statement condition checks whether distance measured in inches is less than or equal to three inches 
    i = 2; 
    j = 1;
  }

  if (inches > 3) { // if statement condition checks whether distance measured in inches is greater than three inches
    tmrpcm.stopPlayback();
  }

  if ((tmrpcm.isPlaying())== 0) { // if statement condition checks whether the music it is not playing
    i++; //increments i by 1
  }

  // lines 72 - 79 serial prints the distance data 
  Serial.print("(");
  Serial.print(i);
  Serial.print(") ");
  Serial.print(inches);
  Serial.print("in, ");
  Serial.print(cm);
  Serial.print("cm");
  Serial.println();

  if ((tmrpcm.isPlaying())== 0 && i == 3 && j == 1) {  // if statement condition checks whether the music it is not playing and has finish playing the song and needs to reset program to restart song
    i = 0;
    j = 0;
    delay(100);
    resetFunc(); // calls reset function to reset program
  }
  
  else if ((tmrpcm.isPlaying())== 0 && i == 100 && j == 0) {  // if statement condition checks whether the music it is not playing and has not finished playing the song and needs to exit the program so the user can decide later if he wants music again by using maunual reset button on arduino
    delay(100);
    while(true) { // program in infinite loop which can only break through a manual reset on arduino aka exit program
      ;
    }
  }
  
  delay(100); // program pauses for 100 microseconds
}


long microsecondsToInches(long microseconds){ // this method converts the number of microseconds into a dictance measured in inches
  return microseconds / 74 / 2;
}

long microsecondsToCentimeters(long microseconds){ // this method converts the number of microseconds into a dictance measured in inches
  return microseconds / 29 / 2;
}


