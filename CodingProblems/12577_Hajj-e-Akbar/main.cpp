#include <iostream>
#include <cstdio>
#include <string>

using namespace std;

int main() {
    int counter = 0;
    string end = "*";
    string hajj = "Hajj";
    string line;
    while(getline(cin,line) && line.compare(end) != 0) {
        counter++;

        if(line.compare(hajj) == 0) {
            printf("Case %d: Hajj-e-Akbar\n", counter);
        } else {
            printf("Case %d: Hajj-e-Asghar\n", counter);
        }
    }
}