/*-----------------------------------------------------------*/
/*  Name:Vilvesh Srinivasan, Javier Faustino, Joseph Kolling */
/*                                                           */
/*	Description:	                                         */
/*  This program takes a user inputted value	             */
/*  for the perimeter, and then outputs the possible side    */
/*  combinations that the traingle can have.                 */
/*                                                           */
/*************************************************************/


#include <stdio.h>
#include <math.h>


double main ()

{
	
	int perimeter;
	int a=1;
	int b=1;
	int c=1;
	
	printf("Enter Perimeter of Triangle: \n");
	scanf("%d", &perimeter);
	printf("Triangles with a perimeter of ");
	printf("%d", perimeter);
	printf("\n");
	
	for(a = 1; a <= perimeter; a++) {
		
		for(b = a; b <= perimeter; b++) {
			
			for(c = 1; c <= perimeter; c++) {
				
				if( (a + b + c == perimeter)&&(a+b>c)&&(a+c>b)&&(b+c>a)&&(b<=c)&&(a<=c)){ 
				
				
				
				printf("%d %d %d \n", a, b, c);
				
				
				
			    }
			    
		    }
				
		}
			
	}

	return 0;
	
}
