/*--------------------------------------------------------------*/
/*  Name: Vilvesh Srinivasan, Javier Faustino, Joseph Kolling   */
/*                                                              */
/*	Description: This program prints the common words           */
/*  that are found between two sentences		                */ 
/*                                                              */
/****************************************************************/



#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	int tempv = 100;
	int count = 0;
	int i = 0;
	int p = 0;
	char *ptrstr1;
	char *ptrstr2;
	char *ptr;
	char string1[100];
	char string2[100];
	char temp1[100];
	char temp2[100];
	ptrstr1 = string1;
	ptrstr2 = string2;
	
	printf("Enter first sentence: ");
	gets(string1);
	
	printf("Enter second sentence: ");
	gets(string2);
	
	printf("Common Words: ");
	
	
		while ( *ptrstr1 != '\0')
	{
		while ( *ptrstr1 != ' ' && *ptrstr1 != '\0')
		{
			temp1[i] = *ptrstr1;
			ptrstr1++;
			count++;
			i++;
		}
		
		temp1[i] = '\0';
		
		
		i = 0;
		count = 0;
		
		while ( *ptrstr2 != '\0')
	{
		while ( *ptrstr2 != ' ' && *ptrstr2 != '\0')
		{
			temp2[i] = *ptrstr2;
			ptrstr2++;
			count++;
			i++;
		}
		
		temp2[i] = '\0';
		
		
		tempv = strcmp(temp1,temp2);
		
		if (tempv == 0) 
		{
			printf("%s ", temp1);
			p = 1;
		}

		count = 0;
		i = 0;
		ptrstr2++;	
	}
		
		count = 0;
		i = 0;
		ptrstr2 = string2;
		ptrstr1++;

		
	}
	
	if (p == 0) 
	{
		printf("\nnone of the words sorry!");
	}
	
	
	return 0;
}




