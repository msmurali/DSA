package com.algo;

import java.util.*;

public class ReverseArray {
	
	static int[] reverse(int[] nums) {
		
		if(nums.length == 0) return new int[] {};
		
		int left = 0;
		int right = nums.length - 1;
		
		/* swap elements in index left and right
		 * and move towards center 
		 */
		while(left < right) 
			swap(nums, left++, right--);
		
		return nums;
		
	}
	
	static void swap(int[] nums, int left, int right) {
		
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] nums = new int[] {2, 4, 5, 9, 3, 6, 29, 42, 2, 39};
		
		int[] reversed_nums = reverse(nums);
		
		System.out.println(Arrays.toString(reversed_nums));
		
	}
	
}
