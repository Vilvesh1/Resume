#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/*--------------------------------------------------------------*/
/*  Name: Javier Faustino, Joseph Kolling, Vilvesh Srinivasan   */
/*                                                              */
/*	Description: This program enumerates all the amounts that   */
/*  can be paid optimally (minimum number of coins) using a     */
/*	specified number of coins. It then outputs the result       */
/*	back to the user in tabular format.		                    */
/*                                                              */
/****************************************************************/

void find_coin(int *quarters, int *dime, int *nickels, int *pennies, int cents)
{
	//printf("cents: %d\n", cents);

  	*quarters = cents / 25;
    cents = cents % 25;

    *dime = cents / 10;
    cents = cents % 10;

    *nickels = cents / 5;
    cents = cents % 5;

    *pennies = cents;

}

int main() 
{
    int quarters = 0,dime = 0 ,nickels = 0,pennies = 0;
    int coins = 0;
    
    printf("Enter a number of coins \n");
    scanf("%d", &coins);
    
    int min = (coins * 1);
    int max = (coins * 25);
    
    int cents = min;
    
    
	for (cents = min ; cents <= max; cents++) 
	{
		find_coin(&quarters, &dime, &nickels, &pennies, cents);
		int optimal = quarters + dime + nickels + pennies;
		if (optimal == coins)
		{
	 	    printf("%5d cents:    ", cents);
	 	    printf("%d quarters    ",quarters);
	 	    printf("%d dimes    ",dime);
	 	    printf("%d nickels    ",nickels);
	 	    printf("%d pennies    \n",pennies);
		}
   }
}
			
		
		
