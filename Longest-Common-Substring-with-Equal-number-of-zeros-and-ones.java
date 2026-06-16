package com.rhp;
import java.util.*;
public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        HashMap<Integer, Integer> m = new HashMap<>();
        int sum = 0;
        int maxL = 0;
        m.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0')
                sum--;
            else
                sum++;
            if (m.containsKey(sum)) {
                maxL = Math.max(maxL, i - m.get(sum));
            } else {
                m.put(sum, i);
            }
        }
        System.out.println(maxL);
	}
}
