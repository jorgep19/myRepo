// Solution to http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1282
#include <cstdio>
#include <iostream>
#include <math.h>

using namespace std;
#define PI 3.14159265

double answer, a, b;
double p, q, r, s, t, u;

double solveAt(double x) {
	return ( p * exp(-x) ) +
		   ( q * sin(x) ) +
		   ( r * cos(x) ) +
		   ( s * tan(x) ) +
		   ( t * x * x ) +
		   u;
}

void findLimits() {
	bool aFound = false;
	bool bFound = false;
	double y;

	for(double x = 0.0; x <= 1; x += 0.00001) {
		if(aFound && bFound) {
			break;
		}

		y = solveAt(x);
		// printf("x: %1.4f y: %1.4f\n", x, y);

		if (y == 0) { // got lucky
			answer = x;
			break;
		} else if (y > 0) { // positive limit
			// cout << "found positive!";
			a = x;
			aFound = true;
		} else { // negative limit
			// cout << "found negative!";
			b = x;
			bFound = true;
		}
	}
}

double searchForSolution() {
	double x0 = -1.0;
	double acceptableError = 0.00001;
	double lower, upper, middle, y;
	bool found = false;
	if(a > b) {
		lower = b;
		upper = a;
	} else {
		lower = a;
		upper = b;
	}

	while( ( lower <= upper ) && !found ) {
		middle = lower + ( ( upper - lower ) / 2 );

		y = solveAt(middle);
		// printf("x: %1.4f y: %1.4f lower: %1.4f upper: %1.4f\n", middle, y, a, b);

		if ( ( -acceptableError <= y ) && ( y <= acceptableError ) ) { // got lucky
			x0 = middle;
			break;
		} else if(y > 0) { // check upper
			lower = middle;
		} else { // check lower
			upper = middle;
		}
	}

	return x0;
}

int main() {

	while(scanf("%lf %lf %lf %lf %lf %lf",&p, &q, &r, &s, &t, &u) == 6){
		// printf("p: %1.4f, q: %1.4f, r: %1.4f, s: %1.4f, t: %1.4f, u: %1.4f \n",
		// 		p, q, r, s, t, u);

		answer = -1.0;
		a = -1.0;
		b = -1.0;

		findLimits();
		if(a == -1.0 || b == -1.0) {
			cout << "No solution\n";
			continue;
		}

		answer = answer == -1.0 ? searchForSolution() : answer;
		if(answer == -1.0) {
			cout << "No solution\n";
		} else {
			printf("%1.4f \n", answer);
		}
	}

	return 0;
}
