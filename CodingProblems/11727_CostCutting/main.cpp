#include <cstdio>
#include <iostream>

using namespace std;

int main() {
    int count, a, b, c, result;


    cin >> count;

    for(int i = 0; i < count; i++) {
        cin >> a;
        cin >> b;
        cin >> c;

        result =  max(min(a,b), min(max(a,b),c));

        printf ("Case %d: %d\n", (i+1), result);
    }

    return 0;
}