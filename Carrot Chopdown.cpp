#include<iostream>
#include<vector>
using namespace std;
int main(){
    int t;
    cin>>t;
    while(t--){
        int n,m;
        cin>>n>>m;
        vector<int> cnt(m+1,0);
        for(int ctr=1;ctr<=n;ctr++){
            int curr;
            cin>>curr;
            cnt[curr]++;
        }
        vector<int> psum(m+1,0);
        for(int i=1;i<=m;i++){
            psum[i]=psum[i-1]+cnt[i];
        }
        int ans=0;
        for(int x=1;x<=m;x++){
            int cc=psum[m]-psum[x-1];
            if(2*x<=m){
                cc+=cnt[2*x];
            }
            ans=max(ans,cc);
        }
        cout<<ans<<endl;
    }
}
