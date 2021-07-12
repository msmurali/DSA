package com.algo;

public class Subsequence {

	public static void main(String[] args) {
	
		System.out.println(isSubsequence("ababc", "abc"));

	}

	public static boolean isSubsequence(String s1, String s2) {
	
		int i=0, j=0;
		
		while(i<s1.length() && j<s2.length()) {
			if(s1.charAt(i) == s1.charAt(j)) {
				j++;
			}
			i++;
		}
		
		return j==s2.length();
		
	}
}
