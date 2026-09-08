#include<iostream>
using namespace std;
int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int odd=0,eoq=0,eeq=0;
        for(int i=1;i<=n;i++){
            int c;
            cin>>c;
            if(c&1) odd++;
            else{
                int q=c/2;
                if(q&1) eoq++;
                else eeq++;
            }
        }
        cout<<max(odd,max(eoq,eeq))<<endl;
    }
}
