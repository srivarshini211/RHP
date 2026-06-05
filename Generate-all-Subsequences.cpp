#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;

    int n = s.length();

    for (int m = 1; m < (1 << n); m++) {
        string subseq = "";

        for (int i = 0; i < n; i++) {
            if (m & (1 << i)) {
                subseq += s[i];
            }
        }

        cout << subseq << endl;
    }

    return 0;
}