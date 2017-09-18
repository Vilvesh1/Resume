#include<stdio.h>
#include<math.h>
#include<stdlib.h>


/*----------------------------------------------------------------*/
/*  Name: Vilvesh Srinivasan                                      */
/*                                                                */
/*	Description: This program finds the smallest positive integer */
/*    that does not appear in the array and can not be formed by  */ 
/*	the sum of two numbers in an array.	                          */
/*                                                                */
/******************************************************************/

int issumof2(int data[], int size, int number) {
	
	int i = 0;
	for (i = 0; i < size; i++) {
		if (number == data[i])
		return 1;
	   	
	  }
	  return 0;
	
}

int inarray(int data[], int size, int number) {
	
	int i = 0;
	for (i = 0; i < size; i++) {
		if (number == data[i])
		return 1;
	   	
	  }
	  return 0;
	
}

int main () {
	
	printf("Enter 7 numbers\n");
	
	int size = 7;
	int size2 = 49;
	
	int data[size];
	int sumdigit[size2];
	
	int i = 0;
	int j = 0;
	int k = 0;
	int min = 0;
	int max = 0;
	int number = 0;
	int swapped = 0;
	int temp = 0;
	int check = 0;
	int check2 = 0;
	
	
	for (i = 0; i <= 6; i++) {
		scanf("%d", &data[i]);
	}
	
	min = data[0]; 
	
	for (i = 0; i <= 6; i++) {
		if (data[i] < min)
		min = data[i];
	}
	
	if(min > 1){
       printf("\n\nSmallest Positive Integer = 1");
       return 0;
	}
	   
	
	max = data[0];
	
	for (i = 0; i <= 6; i++) {
		if (data[i] > max)
		max = data[i];
	}
	
	int specsize = (max-min);
	int array[specsize];	
	
	for (i = min ; i <= max; i++) {
		array[k] = i;
		k++;
	}
	int counter = 0;
	int matchOne[specsize];
	for(i = 0; i < specsize; i++){
		for(j = 0; j < 7; j++){
			if(array[i] == data[j]){
				matchOne[i] = 1;
			}
		}
		if(matchOne[i] != 1)
		   counter++;
	}
	
	int missing[counter];
	
	j = 0;
	for(i = 0; i < specsize; i++){
		if(matchOne[i] != 1){
		   missing[j] = array[i];
		   j++;
        }
	}

	
	i = 0;
	
    for (j = 0; j <= 6; j++ ) {
     for (k = 0; k <= 6;  k++) {
   		sumdigit[i] = (data[j] + data[k]);
   		i++;
	}
   }
    number = 0;
    printf("\n");
    
    while(1) {
    	
    	swapped = 0;
    	
    	for (i = 0; i < 49-1; i++ ) {
    		if (sumdigit[i] > sumdigit[i+1]) {
    			temp = sumdigit[i];
    			sumdigit[i] = sumdigit[i+1];
    			sumdigit[i+1] = temp;
    			swapped = 1;
			}
		}
		
		if (swapped == 0) {
			break;
		}
	}
      
    int match[counter];
	for (j = 0; j < counter; j++) {
	   for (i = 0; i <= 48; i++) {
	   	if (missing[j] == sumdigit[i])
	   	{
	   		match[j] = 1;
		} 
	   }
	 
     }
    
	for(j = 0; j < counter; j++){
		if(match[j] != 1){
			number = missing[j];
		}
	}  
	  check2 = inarray(data,size,number);
	  
	  if (issumof2(data,size,number) == 0 && check2 == 0)
	  printf("\n\nSmallest Positive Integer = %d", number);
	  	
	  
	  
	  return 0;
}
	
    
    
	
	
