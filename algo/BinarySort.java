package com.algo;

import java.util.*;

public class BinarySort {

	static int[] sort(int[] nums) {
		
		 if(nums.length == 0) {
			 return new int[] {};
		 }
		
		 int left = 0;
	     int right = nums.length - 1;
	        
	     while(left<right){
	    	 
	    	 if(nums[left]==1 && nums[right]==0) {
		    	 swap(nums, left++, right--);
		     }
		     
	    	 else if(nums[left]==0 && nums[right]==1) {
	    		 left++;
	    		 right--;
	    	 }
	    	 
	    	 else if(nums[left]==1 && nums[right]==1) {
	    		 right--;
	    	 }
	    	 
	    	 else {
	    		 left++;
	    	 }
	     }
	     
	     return nums;
		
	}
	
	
	
	static void swap(int[] nums, int left, int right) {
		
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
		
	}



	public static void main(String[] args) {
		
		int[] nums = new int[] {1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0};
		
		int[] sorted_nums = sort(nums);
		
		System.out.println(Arrays.toString(sorted_nums));

	}

}
