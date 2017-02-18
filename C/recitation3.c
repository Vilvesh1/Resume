/*--------------------------------------------------------------*/
/*  Name: Javier Faustino, Vilvesh Srinivasan, Joseph Kolling   */
/*                                                              */
/*  This program makes a 2-dimensional array of 100 integers    */
/*  with 10 rows and 10 columns and inserts numbers from 0-98   */
/*  in order into the first 99 positions. It then shuffles      */
/*  the array and allows the user to input a number which then  */
/*  checks the array to find any duplicates within the array    */
/*  and outputs the indexes and values.                         */
/*                                                              */
/****************************************************************/

#include <stdio.h>
#include <stdlib.h>
#define MAX_SHUFFLE 1000

int shuffle(int[10][10], int , int);

int main() {
	int col = 0;
	int row = 0;
	int count = 0;
	int num =0;
	
	int array[10][10];
	
	for(col=0; col <= 9; col++) {
		for (row =0 ; row <= 9; row++) {
			array[row][col] = count;
			count = count + 1;
			
		}
	}	
	
	printf("Enter a number for last array location\n");
	scanf("%i", &num );
	array[9][9] = num;
		
	shuffle(array, row, col );
	
        if (num>=99)
		   printf("There are no duplicates\n");
	
        if (num<=98)
	{
        int check = 0;
		check = num;	
		for(row =0 ; row <= 9; row++) {
		for (col=0; col <= 9; col++) {
			if(check == array[row][col])
			{
	 		     printf("array [%d][%d] = %d \n", row, col, array[row][col]);
             }
          }
       }
    }
	
	return 0;
		
}

int shuffle(int array[10][10], int row , int col)
{
	int i=0;
	int randx = 0;
	int randy= 0;
	int randx1 = 0;
	int randy1 = 0;
	int temp = 0;
	
	for (i = 0; i<=MAX_SHUFFLE; i++)
	{
		int randx = rand()%10;
		int randy = rand()%10;
		int randx1 = rand()%10;
		int randy1 = rand()%10;
					
		temp = array[randx][randy];
		array[randx][randy] = array[randx1][randy1];
		array[randx1][randy1] = temp;
		
	}
	
	return 0;
	
}
