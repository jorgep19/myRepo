// Solution to http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=1282
#include <cstdio>
#include <iostream>
#include <cmath>

using namespace std;

#define PI 3.14159265
double acceptableError = 0.00001;
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

double searchForSolution() {
	bool found = false;
	double x0 = -1.0;
	double middle, y;

	y = solveAt(a);
	if (( -acceptableError <= y ) && ( y <= acceptableError ) ) {
		return a;
	}
	y = solveAt(a);
	if(( -acceptableError <= y ) && ( y <= acceptableError ) ) {
		return b;
	}

	while( a < b && !found) {
		middle = a + ( ( b - a ) / 2 );
		y = solveAt(middle);
		// printf("x: %1.4f y: %1.4f lower: %1.4f upper: %1.4f\n", middle, y, a, b);

		y = std::abs(y);
		if ( y <= acceptableError ) { // got lucky
			x0 = middle;
			found = true;
		} else if(y > 0) { // check upper
			a = middle;
		} else { // check lower
			b = middle;
		}
	}

	return x0;
}

int main() {

	while(scanf("%lf %lf %lf %lf %lf %lf",&p, &q, &r, &s, &t, &u) == 6){

		answer = -1.0;
		a = 0.0;
		b = 1.0;

		answer = searchForSolution();
		if(answer == -1.0 || answer > 1.0 || answer < 0.0 ) {
			cout << "No solution\n";
		} else {
			printf("%1.4f \n", answer);
		}
	}

	return 0;
}
