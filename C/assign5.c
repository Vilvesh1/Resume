/*------------------------------------------------------------*/
/*  Name: Vilvesh Srinivasan                                  */
/*                                                            */
/*	Description:                                              */
/*  This program finds the largest palindrome a user enters   */
/*  in as a string then outputs the result                    */
/*                                                            */
/**************************************************************/



#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>


void palilen(int z, int x, char* ptr2)
{
	int p;
    for(p = z; p <= x; p++ ) {
        printf("%c", ptr2[p]);
    }    
}

int palidromechecker(char *ptr1)
{
    int d = strlen(ptr1); 
    int bIG = 1;
    int start = 0;
    bool b[d][d];
    int l = 0;
    int x = 0;
	int f = 3;
    int g = 0;
 
    while (l < d) {
        b[l][l] = true;
        l++;
    }
        
 
    l = 0;
    while (l < d-1)
    {
        if (ptr1[l] == ptr1[l+1])
        {
            b[l][l+1] = true;
            start = l;
            bIG = 2;
        }
        
        l++;
    }
 
    l = 0;
    while (f <= d)
    {
        while (l < d-f+1)
        {
            g = l + f - 1;
 
            if (b[l+1][g-1] && ptr1[l] == ptr1[g])
            {
                b[l][g] = true;
 
                if (f > bIG)
                {
                    start = l;
                    bIG = f;
                }
            }
            l++;
        }
        f++;
    }
 
 	if (b[l][l] == false)
 	{
		return -1;
	}
 	
    printf("Largest palindrome is ");
    
    x = (start + (bIG - 1));
    
    palilen(start, x, ptr1); 
    
    return 1;
	
}

int main()
{
    char palstr[100];
 	printf("Enter a string\n");
	scanf("%s", palstr);
	int i = 0;
	while(palstr[i] != '\0')
      {
         if (islower(palstr[i]))
		 {
              palstr[i] = toupper(palstr[i]);
		 }
		 i++;
       }
       
	if ((palidromechecker(palstr)) == -1)
    {
     printf("There are no palindromes in the string.\n");
 	}
    
	    
    return 0;
}
