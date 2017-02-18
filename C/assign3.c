/*-----------------------------------------------------------*/
/*  Name:Vilvesh Srinivasan                                  */
/*                                                           */
/*	Description:	                                         */
/*  This program finds the first nonrepeatingnum             */
/*  and if there is no firstnonrepeating num                 */
/*  it tells the user                                        */
/*************************************************************/

#include<stdio.h>
#include<stdlib.h>

int main () {
	int array[7];
	int i = 0, j = 0, count = 0;
	
	
	printf("Enter 7 numbers\n");
	for(i = 0; i < 7; i++) {
		scanf("%d", &array[i]);
	}
	
	for (i = 0; i < 7; i++) {
		for (j = 0; j < 7; j++) {
			if (array[i] == array[j])
				count++;  
		}
		if (count == 1)
		{
			printf("First nonrepeating = %d \n", array[i]);
			return 0;
		}
		count = 0;
	}
	
	printf("\nNo first nonrepeating element");
	return 0;
}
	
