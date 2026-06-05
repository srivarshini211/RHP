#include <iostream>
#include <string>
using namespace std;
int main() {
    string s;
    cin >> s;

    int m = 0;

    for(char ch : s) {
        if(ch >= '0' && ch <= '9')
            m |= (1 << (ch - '0'));
    }

    if(m == (1 << 10) - 1)
        cout << "Yes";
    else
        cout << "No";

    return 0;
}