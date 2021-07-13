package com.algo;

public class ReverseString {

	static String reverse(String s) {
		
		char[] arr = s.toCharArray();
		
		int left = 0;
		int right = s.length()-1;
		
		while(left<right)
			swap(arr, left++, right--);
		
		return new String(arr);
	}
	
	static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp; 
	}
	
	public static void main(String[] args) {

		String s = "abcdefgh";
		System.out.println(reverse(s));
		
	}
	

}
