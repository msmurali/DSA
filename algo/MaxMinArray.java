package com.algo;

public class MaxMinArray {
	
	static int[] arrayMinMax(int[] nums) {
		
		/* if input array is empty 
		 * return empty array
		 */
		if(nums.length == 0) return new int[] {};
		
		/* if input array length is one 
		 * return max and min as same element
		 */
		if(nums.length == 1) return new int[] {nums[0], nums[0]};
		
		/*
		 *initialize max_so_far and min_so_far
		 */
		int min_so_far = Math.min(nums[0], nums[1]);
		int max_so_far = Math.max(nums[0], nums[1]);
		
		// traverse from index 2 to n-1
		for(int index=2; index<nums.length; index++) {
			
			/* if current element is minimum than min_so_far
			 * then change min_so_far to current element
			 */
			min_so_far = Math.min(min_so_far, nums[index]);
			
			/* if current element is maximum than max_so_far
			 * then change max_so_far to current element
			 */
			max_so_far = Math.max(max_so_far, nums[index]);
			
		}
		
		return new int[] {min_so_far, max_so_far};
		
	}

	public static void main(String[] args) {

		int[] nums = new int[] {-19, -19, 200, 8, 10, 1,-6, 100};
		
		int[] sol = arrayMinMax(nums);
		
		if(sol.length == 0) {
			System.out.println("Empty array");
		}
		else {
			System.out.println("Minimum element : "+sol[0]);
			System.out.println("Maximum element : "+sol[1]);
		}
		
	}

}
