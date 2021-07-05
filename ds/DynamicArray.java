package dsa;

public class DynamicArray<T> {
	
	private int size = -1;	// index of last element (initially there is no element)
	private int capacity;	// capacity of the array
	private int length = size + 1; // length of the array
	
	Object[] arr;
	
	public DynamicArray() {
		
		// if capacity is not given initially, set it as two
		this.capacity = 2;
		
		// creating array with capacity
		arr = new Object[capacity];	
	}
	
	public DynamicArray(int initialCapacity) {
		
		// if capacity is given initially,
		this.capacity = initialCapacity;
				
		// creating array with given initial capacity
		arr = new Object[capacity];
	}
	
	//getter for size
	public int getSize() {
		return this.size;
	}
	
	//setter for size
	public void setSize(int newSize) {
		this.size = newSize;
	}
	
	//getter for capacity
	public int getCapacity() {
		return this.capacity; 
	}
	
	//setter for capacity
	public void setCapacity(int newCapacity) {
		this.capacity = newCapacity;
	}
	
	//getter for length
	public int getLength() {
		return this.length;
	}
	
	// adding new element at the end of the array
	public void add(Object element) {
		
		// first increment size by 1
		this.setSize(this.getSize() + 1);
		
		// checking size lesser than capacity
		if( this.getSize() >= this.getCapacity() ) {
			this.increaseCapacity();
		}
		
		// adding new element
		arr[this.getSize()] = element;
		
	}
	
	public void insert(int elementIndex, Object element) {
		
		// if index out of bound throw exception
		if( elementIndex < 0 || elementIndex > size ) {
			throw new ArrayIndexOutOfBoundsException("Array Index Out of Bound");
		}		
		else {
			// increment size by one
			this.setSize(this.getSize() + 1);
			
			// checking size if lesser than capacity
			if( this.getSize() >= this.getCapacity() ) {
				this.increaseCapacity();
			}
			
			// moving elements at position form index to size by one position
			for(int index=size; index>=elementIndex; index--) {
				
				arr[index+1] = arr[index];
				
			}
			
			//inserting new element
			arr[elementIndex] = element;
		}
		
	}
	
	//update element at a index
	public void update(int index, Object element) {
		
		// if index out of bound throw exception
		if( index < 0 || index > size ) {
			throw new ArrayIndexOutOfBoundsException("Array Index Out of Bound");
		}
		else{
			arr[index] = element;
		}
	
	}

	// getting a element at a index
	public T get(int index) throws ArrayIndexOutOfBoundsException{

		// if index out of bound throw exception
		if( index < 0 || index > size ) {
			throw new ArrayIndexOutOfBoundsException("Array Index Out of Bound");
		}
		
		// else return element at index
		else {
			return (T) arr[index]; 
		}
	
	}
	
	
	// removing a element at a index
	public void remove(int elementIndex) {
		
		// if index out of bound throw exception
		if( elementIndex < 0 || elementIndex > size ) {
			throw new ArrayIndexOutOfBoundsException("Array Index Out of Bound");
		}		
		else {
			//moving elements from index+1 to size by one position front
			for(int index = elementIndex+1; index<=size; index++)
				arr[index-1] = arr[index];
				
			// decrement size by one
			--size;
		}
		
	}
	
	// increasing capacity of the array
	public void increaseCapacity() {
		
		//doubling capacity
		this.setCapacity( this.getCapacity()*2 );
		
		// creating array 'newArr' with new capacity 
		Object[] newArr = new Object[this.getCapacity()];
		
		// copying all elements from 'arr' to 'newArr'
		for(int index=0; index<this.getSize(); index++)
			newArr[index] = arr[index];
		
		arr = newArr;
		
	}
	
	// print arr elements one by one
	public void print() {
		
		for(int index=0; index<=this.getSize(); index++) {
			if(index==0){
				System.out.print("["+this.arr[index]+", ");
			}			
			else if(index == this.getSize()) {
				System.out.print(this.arr[index]+"]");
			}	
			else {
				System.out.print(this.arr[index]+", ");
			}
		}
		System.out.println();
		
	}
	
}
