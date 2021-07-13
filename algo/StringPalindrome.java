package com.algo;

public class StringPalindrome {

	static boolean isPalindrome(String s) {
		
		int left = 0;
		int right = s.length()-1;
		
		while(left < right)
			if(s.charAt(left++) != s.charAt(right--))
				return false;
		
		return true;
	}
	
	public static void main(String[] args) {

		String s = "dvd";
		System.out.println(isPalindrome(s));
		
	}
	

}
