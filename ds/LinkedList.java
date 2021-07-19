package com.ds;

class Node<T>{
	
	private T data;			
	private Node<T> next;	//reference to next node
	
	public Node(T data) {	
		
		this.setData(data);
		this.setNext(null);
	
	}
	
	//getter for data
	public T getData() {
		return this.data;
	}
	
	//setter for data
	public void setData(T data) {
		this.data = data;
	}
	
	//getter for next node reference
	public Node<T> getNext() {
		return this.next;
	}
	
	//setter for next node reference
	public void setNext(Node<T> next) {
		this.next = next;
	}
		
}



public class LinkedList<T> {
	
	private Node<T> head;
	private int size = -1;	// keep track of index of last node
	
	//getter for head
	public Node<T> getHead() {
		return this.head;
	}
	
	//setter for head
	public void setHead(Node<T> node) {
		this.head = node;
	}
	
	//getter for size
	public int getSize() {
		return this.size;
	}
	
	//setter for size
	public void setSize(int newSize) {
		this.size = newSize; 
	}
	
	//number of elements in the list
	public int size() {
		return this.getSize() + 1;
	}
	
	//returns true if number of elements is zero
	public boolean isEmpty() {
		return (this.size() == 0);
	}
	
	//insert element at last
	public void insert(T data) {
		
		// creating a new node
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(null);
		
		// if head node is null then set new node to head
		if(this.getHead() == null) {
			this.setHead(newNode);
			return;
		}
		
		// else loop through list unit find a node with next == null
		Node<T> node = this.getHead();
		while(node.getNext() != null) {
			
			node = node.getNext();
			
		}
		
		//then set the new node at that next
		node.setNext(newNode);
		
		//increment the size
		this.setSize(this.getSize() + 1);
		
	}
	
	// insert a element at specific index
	public void insertAt(int index, T data) {

		//creating a new node
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(null);
		
		//if given index is zero then set new node to head
		if(index == 0) {
			newNode.setNext(this.getHead());
			
			this.setHead(newNode);
			
			return;
		}
		
		// else loop through the list from head to index-1
		Node<T> node = this.getHead();

		for(int i=0; i<index-1; i++) {
			node = node.getNext();
		}
		
		newNode.setNext(node.getNext());
		node.setNext(newNode);
		
		this.setSize(this.getSize() + 1);
		
	}
	
	// get node by index
	public T get(int index) {
		
		Node<T> node = this.getHead();
		
		while(index-->0) {
			node = node.getNext();
		}
		
		return node.getData();
	}
	
	// getting head node
	public T getFirst() {
		return this.getHead().getData();
	}
	
	// getting last node
	public T getLast() {
		Node<T> node = this.getHead();
		
		//loop through the list to find node with next is null
		while(node.getNext() != null) {
			node = node.getNext();
		}
		
		// return that node
		return node.getData();
	}
	
	// remove a node at given index
	public void remove(int index) {
		
		Node<T> node = this.getHead();
		
		//if index is zero remove head
		if(index==0) {
			this.setHead(node.getNext());
		}
		
		// else loop until index-1 and remove node
		for(int i=0; i<index-1; i++) {
			node = node.getNext();
		}
		
		node.setNext(node.getNext().getNext());
		
	}
	
	// print all elements in the list
	public void show() {
		// if head is null then print empty list
		if(this.getHead() == null) System.out.println("[]");
		
		// else loop through the list and all nodes one by one
		else {
			Node<T> node = this.getHead();
			
			System.out.print("[");
			
			while(node.getNext() != null) {
				System.out.print(node.getData()+", ");
				node = node.getNext();
			}
			
			System.out.println(node.getData() + "]");
			
		}
		
	}
	
}
