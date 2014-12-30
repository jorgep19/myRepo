#include <iostream>

using namespace std;

int main() {
    int count, a, b;

    cin >> count;

    for(int i = 0; i < count; i++) {
        cin >> a;
        cin >> b;

        if(a == b) {
            cout << "=\n";
        } else if(a > b) {
            cout << ">\n";
        } else {
            cout << "<\n";
        }
    }

    return 0;
}