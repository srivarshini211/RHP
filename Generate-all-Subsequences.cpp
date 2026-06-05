#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    cin >> s;

    int n = s.length();

    for (int mask = 1; mask < (1 << n); mask++) {
        string subseq = "";

        for (int i = 0; i < n; i++) {
            if (mask & (1 << i)) {
                subseq += s[i];
            }
        }

        cout << subseq << endl;
    }

    return 0;
}
