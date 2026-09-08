#include<iostream>
#include<vector>
using namespace std;
int main(){
    int t;
    cin>>t;
    while(t--){
        int n; cin>>n;
        vector<int> arr(n);
        for(int i=0;i<n;i++){
            cin>>arr[i];
        }
        int lt=0,rt=n-1;
        while(lt<n && arr[lt]==0) lt++;
        while(rt>=0 && arr[rt]==0) rt--;
        if(lt<=rt){
            for(int i=lt+1;i<rt;i++){
                if(arr[i]==-1) arr[i]=0;
            }
            arr[lt]=arr[rt]=1;
        }
        for(int i=0;i<n;i++){
            cout<<arr[i]<<(i==n-1 ? "\n":" ");
        }
    }
    return 0;
}
