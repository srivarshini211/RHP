package com.rhp.java;
import java.util.*;
public class CTR {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int k = sc.nextInt();
	        int q = sc.nextInt();
	        int[] di = new int[200002];
	        for (int i = 0; i < n; i++) {
	            int l = sc.nextInt();
	            int r = sc.nextInt();
	            di[l]++;
	            di[r + 1]--;
	        }
	        for (int i = 1; i <= 200000; i++) {
	            di[i] += di[i - 1];
	        }
	        int[] pre = new int[200001];
	        for (int i = 1; i <= 200000; i++) {
	            pre[i] = pre[i - 1];
	            if (di[i] >= k) {
	                pre[i]++;
	            }
	        }
	        int[] ans = new int[q];
	        for (int i = 0; i < q; i++) {
	            int a = sc.nextInt();
	            int b = sc.nextInt();
	            ans[i] = pre[b] - pre[a - 1];
	        }
	        for (int i = 0; i < q; i++) {
	            System.out.println(ans[i]);
	        }
	    }
	}

