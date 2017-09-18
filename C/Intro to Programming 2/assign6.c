/*------------------------------------------------------------*/
/*  Name: Vilvesh Srinivasan                                  */
/*                                                            */
/*	Description:                                              */
/*  This program counts the repetition of a word              */
/*  in a txt file                                             */
/*                                                            */
/**************************************************************/



#include <stdio.h>
#include <stdlib.h>
#include <string.h> 

 struct wordfreq 
{
 int count; 
char word[1024];
 };
 
typedef struct wordfreq wordfreq;

wordfreq* allocateWord(char* string){
	wordfreq* wq  = malloc (sizeof (wordfreq));
	wq -> count = 1;
	strcpy(wq -> word, string);
	
	return wq;
}
int main(int argc, char *argv[]) 
{ 
	wordfreq **wordarray; 
	FILE *input; 
	FILE *output;
	char str1[100];
	int size_ofa = 1; 
	int same = 0;
	int v = 0; 
	int k = 0;
	

	if (argc != 3){
			perror("input not valid");
			return 1;
	}

	input = fopen(argv[1], "r");
	output = fopen(argv[2], "w");

	 if(input == NULL ||output == NULL ) {
	   perror("there is a problem opening one or both of the files");
	   return(1);
	 }
	
	wordarray = malloc (sizeof (wordfreq*));
	if (fgets (str1, 100, input)!=NULL)
		wordarray[0] = allocateWord(str1);	
	
	while( fgets (str1, 100, input)!=NULL )
	 {
		same = 0; 
		v = 0;
		 while (v < size_ofa)
		 {
			 if (strcmp (str1, wordarray[v]->word) == 0)
			 {
				 wordarray[v]->count = wordarray[v]->count + 1;
				 same = 1;
				 break;
			 }
			 
			 v++;
		 }
		 
		 if (!same)
		 {
			size_ofa ++;
			wordarray = realloc(wordarray, size_ofa* sizeof (wordfreq*));
			 wordarray[v]=allocateWord(str1);	
		 }
	 }
	 
	 k = 0;
	 while (k < size_ofa)
	 {
	 	fprintf(output,"%d  %s\n", wordarray[k]->count,wordarray[k]->word);
	 	k++;
	 }
	 
	free(wordarray);
	fclose(input);
	fclose(output);
	return(0);

}
