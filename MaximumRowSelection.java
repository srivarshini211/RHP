package com.rhp.java;
import java.util.*;
public class rhp2 {
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int c=sc.nextInt();
        int m[][]=new int[r][c];
        long dp[][]=new long[r+1][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                m[i][j]=sc.nextInt();
                if(i==0){
                    dp[i][j]=m[i][j];
                }
            }
        }
        for(int i=1;i<r;i++){
            long fsmax[]=FSMax(dp,i-1,c);
            for(int j=0;j<c;j++){
                dp[i][j]=m[i][j]+(dp[i-1][j]==fsmax[0] ? fsmax[1] : fsmax[0]);
            }
        }
        System.out.println(FSMax(dp,r-1,c)[0]);
	}
	private static long[] FSMax(long[][] dp,int i,int c){
	    long fmax=Math.max(dp[i][0],dp[i][1]);
	    long smax=Math.min(dp[i][0],dp[i][1]);
	    for(int j=2;j<c;j++){
	        if(dp[i][j]>fmax){
	            smax=fmax;
	            fmax=dp[i][j];
	        }
	        else if(dp[i][j]>smax){
	            smax=dp[i][j];
	        }
	    }
	    return new long[] {fmax,smax};
	}
}
