package com.algo;

public class MaxSumSubarray {
	
	static int naive(int[] nums) {
		
		int max_sum = Integer.MIN_VALUE;
		
		/* loop through every sub-array and
		 * calculate the sum of every sub-array
		 * compare with max_sum
		 */
		for(int i=0; i<nums.length; i++) {
			int curr_sum = nums[i];
			for(int j=i+1; j<nums.length; j++) {
				curr_sum += nums[j];
				max_sum = Math.max(curr_sum, max_sum);
			}
		}
		 
		return max_sum;
		
	}
	
	/* kadane algorithm */
	static int efficient(int[] nums) {
		
		int max_sum = nums[0];
		int max_ending = nums[0];
		
		for(int i=1; i<nums.length; i++) {	
			max_ending = Math.max(max_ending + nums[i], nums[i]);
			max_sum = Math.max(max_ending, max_sum);
		}
		
		return max_sum;
	}
	
	public static void main(String[] args) {
		
		int[] nums = new int[] {-3, 8, -2, 4, -5, 6};
		
		System.out.println(naive(nums));
		System.out.println(efficient(nums));
		
	}
	
}
