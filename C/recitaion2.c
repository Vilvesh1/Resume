/*-----------------------------------------------------------*/
/*  Name:Vilvesh Srinivasan, Javier Faustino, Joseph Kolling */
/*                                                           */
/*	Description:	                                         */
/*  This program outputs the roman numerals form 1 - 1000	 */
/*************************************************************/



#include<stdio.h>
#include<stdlib.h>
#include<math.h>

int main() {
	int roman[8] = {1,5,10,50,100,500,1000,1001};
	int i = 0;
	int j = 0;
	int k = 0;
	int u = 0;
	int z = 0;
	int num = 0;
	int originalnum = 0;
	int checknum = 0;
	
	for (i = 1; i <= 1000; i++) {
		num = i;
		printf("%d ", num);
	for (j = 0; j <= 8; j++) {
		if (num < roman[j])
		{
		break;
		}
	}
	for (k = 1; k < 8; k++) {
		int romanum = roman[j-k];
		originalnum = num;
		num = num % romanum;
		
		if ((num == 0) && (originalnum == 4))
		{
			printf("IV");
		}
		else if ((num == 0) && (originalnum <= 3))
		{
		for (u = 1; u <= originalnum; u++) {
			printf("I");
		}
		}
		
		else if (originalnum == 1000)
		{
			printf("M");
		}
		else if ((originalnum == romanum) && (originalnum >= 5))
		{
			
		if(romanum == 500)
		{printf("D");
		}
		else if(romanum == 100)
		{printf("C");
		}
		else if(romanum == 50)
		{printf("L");
		}
		else if(romanum == 10)
		{printf("X");
		}
		else
		{printf("V");
		} 
			
		}
		
		else if (originalnum > 5 && romanum >= 5)
		{
		checknum = (originalnum/romanum);
		for (z = 1; z <= checknum; z++) {
			
		if(romanum == 500)
		{printf("D");
		}
		else if(romanum == 100)
		{printf("C");
		}
		else if(romanum == 50)
		{printf("L");
		}
		else if(romanum == 10)
		{printf("X");
		}
		else
		{printf("V");
		} 
			
		}
		}
		
		if (num == 0)
		{printf("\n");
		//system("pause");
		break;
		}
	}
}
}
		
		
