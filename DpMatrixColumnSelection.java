package com.rhp.java;
import java.util.*;
public class rhp {
		public static void main(String[] args) {
	        Scanner sc=new Scanner(System.in);
	        int r=sc.nextInt();
	        int c=sc.nextInt();
	        int m[][]=new int[r][c];
	        long dp[][]=new long[r][c];
	        for(int i=0;i<r;i++){
	            for(int j=0;j<c;j++){
	                m[i][j]=sc.nextInt();
	                if(j==0){
	                    dp[i][j]=m[i][j];
	                }
	            }
	        }
	        for(int j=1;j<c;j++){
	            long fsmax[]=FSMax(dp,j-1,r);
	            for(int i=0;i<r;i++){
	                dp[i][j]=m[i][j]+(dp[i][j-1]==fsmax[0] ? fsmax[1] : fsmax[0]);
	            }
	        }
	        System.out.println(FSMax(dp,c-1,r)[0]);
		}
		private static long[] FSMax(long[][] dp,int j,int r){
		    long fmax=Math.max(dp[0][j],dp[1][j]);
		    long smax=Math.min(dp[0][j],dp[1][j]);
		    for(int i=2;i<r;i++){
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
