/*#include<iostream>
#include<vector>
#include<map>
using namespace std;
int find(vector<int>& l,int node){
	if(l[node]!=node){
		l[node]=find(l,l[node]);
	}
	return l[node];
}
void join(vector<int>& l,int lt,int rt){
	l[find(l,lt)]=find(l,rt);
}
int main(){
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	int t;
	cin>>t;
	for(int k=0;k<t;k++){
		int n,q;
		cin>>n>>q;
		cout<<"Case "<<t<<":"<<endl;
		vector<int> a(n+1),l(n+1);
		map<int,int> vlm,lvm;
		for(int i=1;i<=n;i++){
			cin>>a[i];
			if(vlm.find(a[i])==vlm.end()){
				vlm[a[i]]=i;
				lvm[i]=a[i];
			}
			l[i]=vlm[a[i]];
		}
		while(q--){
			int qt;
			cin>>qt;
			if(qt==1){
				int x,y;
				cin>>x>>y;
				if(x==y) continue;
				if(vlm.find(x)==vlm.end()) continue;
				if(vlm.find(y)!=vlm.end()){ //both x and y are there, so join and merge
					join(l,vlm[x],vlm[y]);
					lvm.erase(vlm[x]);
					vlm.erase(x);
				}
				else{ // only x is there
					int xldr=vlm[x];
					lvm[xldr]=y;
					vlm.erase(x);
					vlm[y]=xldr;
				}
			}
			else{
				int id;
				cin>>id;
				int uldr=find(l,l[id]);
				cout<<lvm[uldr]<<endl;
			}
		}
	}
}
*/
#include<iostream>
#include<vector>
#include<map>
using namespace std;

int find(vector<int>& l,int node){
    if(l[node]!=node){
        l[node]=find(l,l[node]);
    }
    return l[node];
}

void join(vector<int>& l,int lt,int rt){
    l[find(l,lt)]=find(l,rt);
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin>>t;

    for(int tc=1;tc<=t;tc++){

        int n,q;
        cin>>n>>q;

        cout<<"Case "<<tc<<":\n";

        vector<int> a(n+1),l(n+1);
        map<int,int> vlm,lvm;

        for(int i=1;i<=n;i++){
            cin>>a[i];

            if(vlm.find(a[i])==vlm.end()){
                vlm[a[i]]=i;
                lvm[i]=a[i];
                l[i]=i;
            }
            else{
                l[i]=vlm[a[i]];
            }
        }

        while(q--){
            int qt;
            cin>>qt;

            if(qt==1){
                int x,y;
                cin>>x>>y;

                if(x==y) continue;

                if(vlm.find(x)==vlm.end()) continue;

                if(vlm.find(y)!=vlm.end()){      // both x and y exist
                    join(l,vlm[x],vlm[y]);
                    lvm.erase(vlm[x]);
                    vlm.erase(x);
                }
                else{                           // only x exists
                    int xldr=vlm[x];
                    lvm[xldr]=y;
                    vlm.erase(x);
                    vlm[y]=xldr;
                }
            }
            else{
                int id;
                cin>>id;
                int uldr=find(l,l[id]);
                cout<<lvm[uldr]<<"\n";
            }
        }
    }

    return 0;
}

