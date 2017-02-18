/*-------------------------------------------------------------------------

16Mhz 
ATmega8 or ATmega128 or ATmega328

-------------------------------------------------------------------------*/

#include "NS_Rainbow_avr.h"


#define USELED	64						// Using LED Value


int main(void)
{	
	/****************************************************************************************************
	*
	* NS_Rainbow_init( Parameter1, Parameter2, Parameter3 )
	*
	* Parameter 1 = UseLED Value	
	* Parameter 2 = Port name ( ATmega8		: PB, PC, PD )
	*                         ( ATmega128	: PA, PB, PC, PD, PE, PF, PG )
	*                         ( ATmega328	: PB, PC, PD )
	* Parameter 3 = Port number ( 0 ~ 7 Integer ) 
	*
	*                         ex) LED Value = 8EA, OUTPUT Pin = PB2
	*			                  -> NS-Rainbow_init(8, PB, 2);
	*
	****************************************************************************************************/

	_delay_ms(10);
	NS_Rainbow_init(USELED, PB, 0);


	setBrightness(50); 	// 0,1(OFF) ~ 255

	
	unsigned char line = 0;

	while(1)
	{
		/* Example Program */
		/* This example is for Rainbow Matrix */

		for(int i = 0; i < 8; i++)
		{
			line = i * 8;
			setColor(0 + line, 255, 0, 0);				// RED
			setColor(1 + line, 255, 94, 0);				// Orange
			setColor(2 + line, 255, 228, 0);			// Yellow
			setColor(3 + line, 29, 219, 22);			// Green
			setColor(4 + line, 0, 0, 255);				// Blue
			setColor(5 + line, 1, 0, 255);				// Dark Blue
			setColor(6 + line, 63, 0, 153);				// Purple
			setColor(7 + line, 255, 0, 221);			// Pink

			show();
			_delay_ms(100);
		}		
		_delay_ms(500);


		for(int i = USELED; i >= 0; i--)
		{
			cell_clear(i);
			_delay_ms(30);
		}

		for(int i = 7; i >= 0; i--)
		{
			line = i * 8;
			setColor_RGB(0 + line, 0xFF0000);			// RED
			setColor_RGB(1 + line, 0xFF5E00);			// Orange
			setColor_RGB(2 + line, 0xFFE400);			// Yellow
			setColor_RGB(3 + line, 0x1DDB16);			// Green
			setColor_RGB(4 + line, 0x0000FF);			// Blue
			setColor_RGB(5 + line, 0x0100FF);			// Dark Blue
			setColor_RGB(6 + line, 0x3F0099);			// Purple
			setColor_RGB(7 + line, 0xFF00DD);			// Pink
		
			show();
			_delay_ms(100);
		}	
		_delay_ms(500);

	
		for(int i = 0; i <= USELED; i++)
		{
			cell_clear(i);
			_delay_ms(30);
		}


		for(int i = 0; i < 2; i++)
			rainbow(10);

		

		clear();
		_delay_ms(1000);


	}
	return 0;
}


