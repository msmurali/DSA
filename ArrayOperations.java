package dsa;

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
	
	//remove target value from array 
	static void remove(int[] arr, int N, int index) {
		
		// moving array elements from index+1
		for(int i=index; i<N-1; i++)
			arr[i] = arr[i+1];
		
		// reduce size by one
		N--;
		
		for(int i=0; i<N; i++)
			System.out.print(arr[i]+" ");
	}
	
	// search array elements one by one and compare with target value
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
	
	
	//Driver Function
	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
			
		int N = scan.nextInt();
			
		int[] arr = new int[N];  // array of length N
			
		for(int i=0; i<N; i++) 
			arr[i] = scan.nextInt();
			
		traverse(arr); // calling traverse method
			
		update(arr, 2, 10); // calling update method
			
		linearSearch(arr, N, 10); // calling linear search method
			
		reverse(arr, N); //calling reverse method
			
		remove(arr, N, 2); // calling remove method
				
	}
	
}
