package com.ds;

public class MinHeap<T> {
	
	private Object[] arr;
	private int lastIndex = -1;
	private int capacity;
	
	//getter for array
	public Object[] getArr() {
		return this.arr;
	}
	
	//setter for array
	public void setArr(Object[] arr) {
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
		this.setArr(new Object[this.getCapacity()]);
	};
	
	// Constructor with initial capacity
	public MinHeap(int capacity) {
		this.setCapacity(capacity);
		this.setArr(new Object[this.getCapacity()]);
	}
	
	// Constructor with array
	public MinHeap(T[] arr) {
		
		if(arr.length <= 1) {
			this.setCapacity(2);
		}
		else {
			int cap = nextPowerofTwo(arr.length); 
			this.setCapacity(cap);
		}
		
		Object[] tempArr = new Object[this.getCapacity()];
		
		for(int index=0; index<arr.length; index++) {
			tempArr[index] = (Object)arr[index];
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
	public T top() {
		return (T) this.getArr()[0];
	}
	
	// swap elements in array
	public void swap(int i, int j) {
		Object temp = this.arr[i];
		this.arr[i] = this.arr[j];
		this.arr[j] = temp;
	}
	
	// insert new element in heap
	public void insert(T element) {
		if(this.getLastIndex()+1 >= this.getCapacity()) {
			int newCapacity = this.getCapacity() * 2;
			this.increaseCapacity(newCapacity);
		}
		
		this.arr[this.getLastIndex()+1] = (Object)element;
		
		int currIndex = this.getLastIndex()+1;
		
		while(currIndex != 0 && (int)this.arr[this.parent(currIndex)] > (int)this.arr[currIndex]) {
			
			swap(currIndex, this.parent(currIndex));
			currIndex = parent(currIndex);			
		}
		
		this.setLastIndex(this.getLastIndex()+1);
		
	}
	
	// increase array capacity
	private void increaseCapacity(int newCapacity) {
		
		Object[] arr = this.getArr();
		Object[] newArr = new Object[newCapacity];
		
		for(int index=0; index<=this.getLastIndex(); index++) {			
			newArr[index] = arr[index];			
		}
		
		this.setArr(newArr);
		this.setCapacity(newCapacity);
	}
	
	// print array
	public void show() {	
		
		System.out.print("[");
		for(int index=0; index<=this.getLastIndex(); index++)
			System.out.print(this.arr[index] + (index != this.getLastIndex() ? ", " : ""));
		System.out.println("]");		
		
	}
	
	public static void main(String[] args) {
		
		MinHeap<Integer> heap = new MinHeap<Integer>();
		
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
		
		
	}
}
