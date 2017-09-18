/*-----------------------------------------------------------*/
/*  Name:Vilvesh Srinivasan                                  */
/*                                                           */
/*	Description:	                                         */
/*  This program calculates the approxiamtion of             */
/*  (e^x) from the user inputed data then                    */
/*  compares it to the exact value of (e^x)	                 */
/*************************************************************/

#include <stdio.h>
#include <math.h>

double factorial(int n);
double exponent(double x, int n);

int main()
{
	int n, p;
	double x;
	printf("Enter n and x");
	printf("\n");
	scanf("%d %lf", &n, &x);
	printf("        i       Approximation");
	printf("\n");
	printf("--------------------------------");
	printf("\n");
	
	
	p = 0;
	while(p <= n) {
		printf("%9d \t%.10f \n", p, exponent(x,p));
		p++;
	
	}
	
	printf("\nExact value = %.10f \n", exp(x));
	
	return 0;
	
}

double exponent(double x, int n) {
	int k = 0;
	double sum = 0;
	
	while(k <= n) {
		double top = pow(x,k);
		double bottom = factorial(k);
		sum = sum + (top/ bottom);

		k++;
		
		
	}
	return sum;
}

double factorial(int n) {
	int j = 1;
	double fact_n = 1;
	
	while(j <= n) {
	
		fact_n = fact_n * j;
		
		j++;
	
	}
	
	return fact_n;
}










