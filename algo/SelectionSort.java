package com.algo;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr = new int[] {23, 45, 12, 9, -30, 1, 34};
		sort(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	public static void sort(int[] nums) {
		
		int size = nums.length;
		
		for(int i=0; i<size-1; i++) 
			for(int j=i+1; j<size; j++) 
				if(nums[i] > nums[j])
					swap(nums, i, j);
		
	}
	
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
