/*---------------------------------------------------------------*/
/*  Name:Vilvesh Srinivasan                                      */
/*                                                               */
/*	Description:	                                             */
/*  This program outputs a another program that converts degrees */
/*  radians from  dregrees in the range of 0 to 360 in           */
/*  increments of 10 degrees.                                     */
/*****************************************************************/
#include <stdio.h>

int main() {
	
	int i;
	
	printf("#include <stdio.h>\n");
	printf("#define PI 3.141593\n");
	printf("\n");
	printf("int main() \n");
	printf("{\n");
	printf("\tint degrees = 0;\n");
	printf("\tdouble radians;\n");
	printf("\n");
	printf("\tprintf(\"Degrees to Radians \\n\");\n");
	printf("\n");
	for(i = 0; i<=360; i = i+10){
	printf("\tdegrees = ");
	printf("%d", i);
	printf(";");
	printf("\n");
	printf("\tradians = degrees*PI/180;");
	printf("\n");
	printf("\tprintf(\"%%6i %%9.6f \\n\", degrees, radians);");
	printf("\n");
	printf("\n");
	}
	printf("}");

	return 0;

	
	
}

