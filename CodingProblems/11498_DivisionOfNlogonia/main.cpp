#include <string>
#include <iostream>

using namespace std;

int main() {
    string NOLabel = "NO\n";
    string NELabel = "NE\n";
    string SELabel = "SE\n";
    string SOLabel = "SO\n";
    string borderLabel = "divisa\n";
    int x0, y0, count, x, y;

    cin >> count;

    while(count != 0) {
        cin >> x0;
        cin >> y0;

        for(int i = 0; i < count; i++) {
            cin >> x;
            cin >> y;

            if(x == x0 || y == y0) {
                cout << borderLabel;
            } else if ( x > x0) {
                if(y > y0) {
                    cout << NELabel;
                } else {
                    cout << SELabel;
                }
            } else {
                if(y > y0) {
                    cout << NOLabel;
                } else {
                    cout << SOLabel;
                }
            }

        }

        cin >> count;
    }

    return 0;
}