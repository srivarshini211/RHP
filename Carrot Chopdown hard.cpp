#include <iostream>
#include <vector>
#define ll long long int
using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<int> cnt(m + 1, 0);
        for (int i = 0; i < n; i++) {
            int x;
            cin >> x;
            cnt[x]++;
        }
        vector<int> ps(m + 1, 0);
        for (int i = 1; i <= m; i++) {
            ps[i] = ps[i - 1] + cnt[i];
        }
        vector<ll> ans(19, 0);
        for (int k = 1; k <= 18; k++) {
            ll mx = 0;
            for (int x = 1; x <= m; x++) {
                ll cur = 0;
                for (int mul = 1; mul * x <= m; mul++) {
                    int l = mul * x;
                    int r = l + x - 1;

                    cur += 1LL * min(mul, (1 << k) - 1)
                         * (ps[min(r, m)] - ps[l - 1]);
                }
                if ((1LL << k) * x <= m) {
                    cur += cnt[(1LL << k) * x];
                }
                mx = max(mx, cur);
            }
            ans[k] = mx;
        }
        for (int k = 1; k <= m; k++) {
            cout << ans[min(k, 18)] << " ";
        }
        cout << '\n';
    }
    return 0;
}
