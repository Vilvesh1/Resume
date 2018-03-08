package core;

public class GradeBook {
		  
	int l;
	int score[];
	String studentname;


	public GradeBook(String studentname) {
	score = new int[100];
	this.studentname = studentname;
	}

	public String gettheName() {
	return this.studentname;
	}

	public void settheGrade(int q) {
	score[l] = q;
	l++;
	}

	public int length() {
	return this.l;
	}

	public int maximum() {
	int maximum = score[0];
	int p;

	p = 1;
	while (p < l) {
	if (score[p] > maximum)
	maximum = score[p];
	p++;
	}
	return maximum;
	}

	public int minimum() {
	
	int minimum = score[0];
	int r;
	r = 1;

	while (r < l){
	if (score[r] < minimum)
	minimum = score[r];
	r++;
	}
	return minimum;
	}

	public double average() {
	double average, sum = 0.0f;
	int s;

	s = 0;
	while (s <= l) {
	sum = sum + score[s];
	s++;
	}
	average = sum / (double) l;
	return average;
	}


	public double median() {
	double median = 0;
	int d;
	int e;
	int middlen;

	for (d = 0; d < l; d++) {
	for (e = d + 1; e < l; e++) {
	int temporary = 0;
	if (score[d] > score[e]) {
	temporary = score[d];
	score[d] = score[e];
	score[e] = temporary;
	}
	}
	}

	middlen = (l / 2);
	if (l % 2 == 0) {
	int median1 = score[middlen];
	int median2 = score[middlen - 1];
	median = (double) (median1 + median2) / 2.0f;
	} 
	else {
	median = score[middlen + 1];
	}
	return median;
	}


	@Override

	public String toString() {
	String number = "";
	int y;

	y = 0;
	while (y < l) {
	number = number + score[y] + ", ";
	y++;
	}
	return "[" + number + "]";
	}

	}


