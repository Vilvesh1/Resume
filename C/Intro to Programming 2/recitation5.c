/*--------------------------------------------------------------*/
/*  Name: Vilvesh Srinivasan, Javier Faustino, Joseph Kolling   */
/*                                                              */
/*	Description: This program program prints out the words in   */
/*	the sentence the user enters. Then prints the words that    */
/*	contain that character the user inputs, and if              */
/*	there is none the program lets the user know. 		        */ 
/*                                                              */
/****************************************************************/



#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
	int count = 0;
	int i = 0;
	int p = 0;
	char *ptrstr;
	char *ptrch;
	char *ptr;
	char string[100];
	char character[2];
	char temp[100];
	ptrstr = string;
	ptrch = character;
	ptr = temp;
	
	printf("Enter a sentence\n");
	gets(string);
	
	printf("Enter a character\n");
	scanf("%s", &character);
	
	printf("Words containing %c are:\n", *ptrch);
	
	
		while ( *ptrstr != '\0')
	{
		while ( *ptrstr != ' ' && *ptrstr != '\0')
		{
			temp[i] = *ptrstr;
			ptrstr++;
			count++;
			i++;
		}
		temp[i] = '\0';
		
			for(i = 0; i < count; i++)
		{
			if(temp[i] == *ptrch || temp[i] == toupper(*ptrch) || temp[i] == tolower(*ptrch))
			{
				printf("%s \n", temp);
				p = 1;
				break;
			}
		}

		
		count = 0;
		i = 0;
		ptrstr++;
		
	}
	
	if (p == 0) 
	{
		printf("\nnone of the words sorry!");
	}
	
	
	return 0;
}




