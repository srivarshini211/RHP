#include <iostream>
#include <vector>
using namespace std;
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k, x;
        cin >> n >> k;
        vector<int> cnt(3 * n + 1, 0);
        for (int i = 0; i < n; i++) {
            cin >> x;
            cnt[x]++;
        }
        int ans = 0;
        for (int v = 1; v <= 2 * n; v++) {
            int x = v;
            while (cnt[x] > k) {
                cnt[x + 1] += cnt[x] - 1;
                cnt[x] = 1;
                x++;
            }
            ans = max(ans, x - v);
        }
        cout << ans << '\n';
    }
    return 0;
}
