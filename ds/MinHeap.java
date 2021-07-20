package com.ds;

public class MinHeap {
	
	private Integer[] arr;
	private int lastIndex = -1;
	private int capacity;
	
	//getter for array
	public Integer[] getArr() {
		return this.arr;
	}
	
	//setter for array
	public void setArr(Integer[] arr) {
		this.arr = arr;
	}
	
	//getter for last index
	public int getLastIndex() {
		return this.lastIndex;
	}
	
	//setter for last index
	public void setLastIndex(int index) {
		this.lastIndex = index;
	}
	
	//getter for capacity
	public int getCapacity() {
		return this.capacity;
	}
	
	//setter for capacity
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	// Empty Constructor
	public MinHeap() {
		this.setCapacity(2);
		this.setArr(new Integer[this.getCapacity()]);
	};
	
	// Constructor with initial capacity
	public MinHeap(int capacity) {
		this.setCapacity(capacity);
		this.setArr(new Integer[this.getCapacity()]);
	}
	
	// Constructor with array
	public MinHeap(Integer[] arr) {
		
		if(arr.length <= 1) {
			this.setCapacity(2);
		}
		else {
			int cap = nextPowerofTwo(arr.length); 
			this.setCapacity(cap);
		}
		
		Integer[] tempArr = new Integer[this.getCapacity()];
		
		for(int index=0; index<arr.length; index++) {
			tempArr[index] = arr[index];
		}
		
		this.setArr(tempArr);
		
	}

	// smaller power of two greater than the given number
	private int nextPowerofTwo(int Num) {
		
		int count = 0;
	    if (Num > 0 && (Num & (Num - 1)) == 0)	return Num;
	 
        while(Num != 0)
        {
            Num >>= 1;
            count += 1;
        }
	 
        return 1 << count;
		
	}
	
	// get parent node index
	public int parent(int index) {
		return Math.floorDiv(index-1, 2);
	}
	
	//get right child node index
	public int right(int index) {
		return (2*index) + 2;
	}
	
	//get left child node index
	public int left(int index) {
		return (2*index) + 1;
	}
	
	// get root of heap
	public Integer top() {
		return this.getArr()[0];
	}
	
	// swap elements in array
	public void swap(int i, int j) {
		Integer temp = this.arr[i];
		this.arr[i] = this.arr[j];
		this.arr[j] = temp;
	}
	
	// insert new element in heap
	public void insert(Integer element) {
		if(this.getLastIndex()+1 >= this.getCapacity()) {
			int newCapacity = this.getCapacity() * 2;
			this.increaseCapacity(newCapacity);
		}
		
		this.arr[this.getLastIndex()+1] = element;
		
		int currIndex = this.getLastIndex()+1;
		
		while(currIndex != 0 && (int)this.arr[this.parent(currIndex)] > (int)this.arr[currIndex]) {
			
			swap(currIndex, this.parent(currIndex));
			currIndex = parent(currIndex);			
		}
		
		this.setLastIndex(this.getLastIndex()+1);
		
	}
	
	// increase array capacity
	private void increaseCapacity(int newCapacity) {
		
		Integer[] arr = this.getArr();
		Integer[] newArr = new Integer[newCapacity];
		
		for(int index=0; index<=this.getLastIndex(); index++) {			
			newArr[index] = arr[index];			
		}
		
		this.setArr(newArr);
		this.setCapacity(newCapacity);
	}
	
	private boolean isValidIndex(int index) {
		
		if(index < 0)	return false;
		
		return (index <= this.getLastIndex());
		
	}
	
	public void heapify() {
		
		int curr = 0;
		int smallest = min(curr, this.parent(curr), this.left(curr));
		
		while(smallest != curr) {
			
			swap(curr, smallest);
			curr = smallest;
			smallest = min(curr, this.parent(curr), this.left(curr));
			
		}
	
	}
	
	public Integer extract() {
		
		if(this.getLastIndex() == -1) {
			return null;
		}
		else {
			Integer top = this.top();
			this.arr[0] = this.getArr()[this.getLastIndex()];
			heapify();
			return top;
		}
		
	}
	
	
	private int min(int A, int B, int C) {
		if(isValidIndex(B) && isValidIndex(C)) {
			if(this.arr[A] <= this.arr[B] && this.arr[A] <= this.arr[C] )
				return A;
			else if( this.arr[B] <= this.arr[C] )
				return B;
			else 
				return C;
		}
		else if(!isValidIndex(B) && isValidIndex(C)) {
			if(this.arr[A] <= this.arr[C]) {
				return A;
			}else {
				return C;
			}
		}
		else if(isValidIndex(B) && !isValidIndex(C)) {
			if(this.arr[A] <= this.arr[B]) {
				return A;
			}else {
				return B;
			}
		}
		else {
			return A;
		}
		
	}
	
	// print array
	public void show() {	
		
		System.out.print("[");
		for(int index=0; index<=this.getLastIndex(); index++)
			System.out.print(this.arr[index] + (index != this.getLastIndex() ? ", " : ""));
		System.out.println("]");		
		
	}
	
	public static void main(String[] args) {
		
		MinHeap heap = new MinHeap();
		
		heap.insert(2);
		heap.insert(6);
		heap.insert(12);
		heap.insert(34);
		heap.insert(1);
		heap.insert(10);
		heap.insert(3);
		
		heap.show();
		
		/*
		 *           1
		 *         /   \
		 *        2     3
		 *       / \   / \   
		 *      34  6 12 10    
		 */
		
		System.out.println(heap.extract());
		
	}
}
