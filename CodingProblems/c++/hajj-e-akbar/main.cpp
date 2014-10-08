// solution for http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=24&page=show_problem&problem=4022
#include <iostream>
#include <string>

using namespace std;

int main() {

	string input;
	int counter = 1;
	cin >> input;

	while (input != "*") {

		printf("Case %d: %s\n", 
			counter,
			( (input == "Hajj") ? "Hajj-e-Akbar" : "Hajj-e-Asghar" ) );

		counter++;
		cin >> input;
	}
	
	return 0;
}
