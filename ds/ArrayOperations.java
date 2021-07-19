package com.ds;

import java.util.*;

public class ArrayOperations {
	
	// Print all element one by one - O(n)
	static void traverse(int[] arr) {
		
		int len = arr.length;  // length of array
		
		//loop through array elements
		
		for(int i=0; i<len; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
		
	}
	
	//Update a element at index - O(1)
	static void update(int[] arr, int index, int newVal) {
		
		arr[index] = newVal;

		System.out.println(Arrays.toString(arr));
	}
	
	//remove target value from array - O(N)
	static void remove(int[] arr, int N, int index) {
		
		// moving array elements from index+1
		for(int i=index; i<N-1; i++)
			arr[i] = arr[i+1];
		
		// reduce size by one
		N--;
		
		for(int i=0; i<N; i++)
			System.out.print(arr[i]+" ");
	}
	
	// search array elements one by one and compare with target value - O(N)
	static void linearSearch(int[] arr, int N, int target) {
		
		for(int index=0; index<N; index++)
			
			if(arr[index] == target) {      //if found print index and return
				System.out.println(index);
				return;
			} 
		
		System.out.println(-1); // if not found print -1
	}
	
	// reverse array elements - O(n/2)
	static void reverse(int[] arr, int N) {
		
		int left = 0;
		int right = N-1;
		
		// loop unit left index lesser than right index and swap arr[left] and arr[right]
		while(left<right) {
			
			int temp = arr[left];
			arr[left++] = arr[right];
			arr[right--] = temp;
			
		}
		
		System.out.println(Arrays.toString(arr));
		
	}
	 
	// union of two sorted arrays - O(N+M)
	static void union(int[] arr1, int[] arr2) {
		
		int N = arr1.length, M = arr2.length;
		int i = 0, j = 0;
		
		LinkedList<Integer> res = new LinkedList<Integer>();
		
		while(i<N && j<M) {
			if(arr1[i] < arr2[j] ) {
				if(res.getLast() != arr1[i])	res.insert(arr1[i]);
				i++;
			}
			else if(arr2[j] < arr1[i] ) {
				if(res.getLast() != arr2[j])	res.insert(arr2[j]);
				j++;
			}
			else if(res.isEmpty()) {
				res.insert(arr1[i]);
				i++;
				j++;
			}
			else if(res.getLast() != arr1[i]){
				res.insert(arr1[i]);
				i++;
				j++;
			}
		}
		
		res.show();
		
	}
	
	// intersection of two sorted arrays - O(N+M)
	static void intersection(int[] arr1, int[] arr2) {
		
		int N = arr1.length, M = arr2.length;
		int i = 0, j = 0;
		
		LinkedList<Integer> res = new LinkedList<Integer>();
		
		while(i<N && j<M) {
			
			if(arr1[i] < arr2[j]) {
				i++;
			}
			else if(arr1[i] > arr2[j]) {
				j++;
			}
			else if(res.isEmpty()){
				res.insert(arr1[i]);
				i++;
				j++;
			}
			else if(res.getLast() != arr1[i]){
				res.insert(arr1[i]);
				i++;
				j++;
			}
			
		}
		
		res.show();
		
	}
	
	
	//Driver Function
	public static void main(String[] args) {
			
		int[] arr1 = new int[] {2, 4, 6, 6, 8};
		int[] arr2 = new int[] {2, 6, 7, 8};
		
		intersection(arr1, arr2);
				
	}
	
}
