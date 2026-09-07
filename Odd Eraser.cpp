#include<iostream>
using namespace std;
int hcf(int a,int b){
    return b==0?a:hcf(b,a%b);
}
int main(){
    int n;
    cin>>n;
    while(n--){
        int s;
        cin>>s;
        int a[s];
        for(int i=0;i<s;i++){
            cin>>a[i];
        }
        cout<<hcf(a[0],a[s-1])<<endl;
    }
    return 0;
}
