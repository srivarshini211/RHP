package com.rhp;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		Scanner sc=new Scanner(System.in);
		int R=sc.nextInt(); 
		int C=sc.nextInt();
		sc.nextLine();
		int fsr,fsc,ssr,ssc,soc=0;
		fsr=fsc=ssr=ssc=-1;
		char grid[][]=new char[R][C];
		Queue<Sofa> q=new LinkedList<>();
		for(int r=0;r<R;r++) {
			for(int c=0;c<C;c++) {
				char ch=sc.next().charAt(0);
				grid[r][c]=ch;
				if(ch=='s') {
					soc++;
					if(soc==1) {
						fsr=r;
						fsc=c;
					}
					else {
						ssr=r;
						ssc=c;
						Sofa s=new Sofa(fsr,fsc,ssr,ssc,(fsr==ssr)?'H':'V',0);
						q.add(s);
					}
				}
			}
		}
		Set<String> vis=new HashSet<>();
		while(!q.isEmpty()) {
			Sofa s=q.poll();
			if(grid[s.fsr][s.fsc]=='S' && grid[s.ssr][s.ssc]=='S') {
				System.out.println(s.m);
				return;
			}
			if(s.dir=='H') {
				//dragging right
				if(s.ssc<C-1 && grid[s.ssr][s.ssc+1]!='H') {
					if(canAdd(s.ssr,s.ssc,s.ssr,s.ssc+1,vis)) {
						q.add(new Sofa(s.ssr,s.ssc,s.ssr,s.ssc+1,'H',s.m+1));
					}
				}
				//dragging left
				if(s.fsc>0 && grid[s.fsr][s.fsc-1]!='H') {
					if(canAdd(s.fsr,s.fsc-1,s.fsr,s.fsc,vis)) {
						q.add(new Sofa(s.fsr,s.fsc-1,s.fsr,s.fsc,'H',s.m+1));
					}
				}
				//dragging up
				if(s.fsr>0 && grid[s.fsr-1][s.fsc]!='H' && grid[s.ssr-1][s.ssc]!='H') {
					if(canAdd(s.fsr-1,s.fsc,s.ssr-1,s.ssc,vis)) {
						q.add(new Sofa(s.fsr-1,s.fsc,s.ssr-1,s.ssc,'H',s.m+1));
					}
				}
				//dragging down
				if(s.fsr<R-1 && grid[s.fsr+1][s.fsc]!='H' && grid[s.ssr+1][s.ssc]!='H') {
					if(canAdd(s.fsr+1,s.fsc,s.ssr+1,s.ssc,vis)) {
						q.add(new Sofa(s.fsr+1,s.fsc,s.ssr+1,s.ssc,'H',s.m+1));
					}
				}
				//rotation clockwise f up
				if(s.fsr>0 && grid[s.fsr-1][s.fsc]!='H' && grid[s.ssr-1][s.ssc]!='H') {
					if(canAdd(s.ssr-1,s.ssc,s.ssr,s.ssc,vis)) {
						q.add(new Sofa(s.ssr-1,s.ssc,s.ssr,s.ssc,'V',s.m+1));
					}
				//rotation anticlockwise s up
					if(canAdd(s.fsr,s.fsc,s.fsr-1,s.fsc,vis)) {
						q.add(new Sofa(s.fsr,s.fsc,s.fsr-1,s.fsc,'V',s.m+1));
					}
				}
				//rotation anticlockwise f down
				if(s.fsr<R-1 && grid[s.fsr+1][s.fsc]!='H' && grid[s.ssr+1][s.ssc]!='H') {
					if(canAdd(s.ssr+1,s.ssc,s.ssr,s.ssc,vis)) {
						q.add(new Sofa(s.ssr+1,s.ssc,s.ssr,s.ssc,'V',s.m+1));
					}
				//rotation clockwise s down
					if(canAdd(s.fsr,s.fsc,s.fsr+1,s.fsc,vis)) {
						q.add(new Sofa(s.fsr,s.fsc,s.fsr+1,s.fsc,'V',s.m+1));
					}
				}
			}
			if(s.dir=='V') {
			    // dragging right
			    if(s.fsc<C-1 && grid[s.fsr][s.fsc+1]!='H' && grid[s.ssr][s.ssc+1]!='H') {
			    	if(canAdd(s.fsr,s.fsc+1,s.ssr,s.ssc+1,vis)) {
			            q.add(new Sofa(s.fsr,s.fsc+1,s.ssr,s.ssc+1,'V',s.m+1));
			        }
			    }
			    // dragging left
			    if(s.fsc>0 && grid[s.fsr][s.fsc-1]!='H' && grid[s.ssr][s.ssc-1]!='H') {
			    	if(canAdd(s.fsr,s.fsc-1,s.ssr,s.ssc-1,vis)) {
			            q.add(new Sofa(s.fsr,s.fsc-1, s.ssr,s.ssc-1,'V',s.m+1));
			        }
			    }
			    // dragging up
			    if(s.fsr>0 && grid[s.fsr-1][s.fsc]!='H') {
			        if(canAdd(s.fsr-1,s.fsc,s.fsr,s.fsc,vis)) {
			            q.add(new Sofa(s.fsr-1,s.fsc,s.fsr,s.fsc,'V',s.m+1));
			        }
			    }
			    // dragging down
			    if(s.ssr<R-1 && grid[s.ssr+1][s.ssc]!='H') {
			        if(canAdd(s.ssr,s.ssc,s.ssr+1,s.ssc,vis)) {
			            q.add(new Sofa(s.ssr,s.ssc,s.ssr+1,s.ssc,'V',s.m+1));
			        }
			    }
			    // rotation to horizontal - left side
			    if(s.fsc>0 && grid[s.fsr][s.fsc-1]!='H'&& grid[s.ssr][s.ssc-1]!='H') {
			        if(canAdd(s.fsr,s.fsc-1,s.fsr,s.fsc,vis)) {
			            q.add(new Sofa(s.fsr,s.fsc-1,s.fsr,s.fsc,'H',s.m+1));
			        }
			        if(canAdd(s.ssr,s.ssc-1,s.ssr,s.ssc,vis)) {
			            q.add(new Sofa(s.ssr,s.ssc-1, s.ssr,s.ssc,'H',s.m+1));
			        }
			    }
			    // rotation to horizontal - right side
			    if(s.fsc<C-1 && grid[s.fsr][s.fsc+1]!='H'&& grid[s.ssr][s.ssc+1]!='H') {
			        if(canAdd(s.fsr,s.fsc,s.fsr,s.fsc+1,vis)) {
			            q.add(new Sofa(s.fsr,s.fsc,s.fsr,s.fsc+1,'H',s.m+1));
			        }
			        if(canAdd(s.ssr,s.ssc, s.ssr,s.ssc+1,vis)) {
			            q.add(new Sofa(s.ssr,s.ssc,s.ssr,s.ssc+1,'H',s.m+1));
			        }
			    }
			}
		}
		System.out.println("Impossible");
	}
	static final String DELIM="-";
	private static boolean canAdd(int fsr,int fsc,int ssr,int ssc,Set<String> vis) {
		StringBuilder sb=new StringBuilder();
		sb.append(fsr).append(DELIM).append(fsc).append(DELIM);
		sb.append(ssr).append(DELIM).append(ssc);
		String k=sb.toString();
		if(vis.contains(k)) {
			return false;
		}
		vis.add(k);
		return true;
	}
}
