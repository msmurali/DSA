package com.ds;


public class LinkedListOperations {
	
	/* Recursive function for print list in reverse order */ 
	static void printReverse(Node<Integer> head) {
		
		/* if head node is null return */
		if(head == null) 	return;
		
		/* else move to next node */
		printReverse(head.getNext());
		
		System.out.print(head.getData()+" ");
		
	}
	
	static Node<Integer> reverse(Node<Integer> head) {
		
		Node<Integer> prev = null, curr = head, next;
		
		/* loop until last node */
		while(curr != null) {
			//backup next node of curr
			next = curr.getNext();
			
			curr.setNext(prev);
			
			prev = curr;
			
			curr = next;
		}
		
		return prev; //head node of reversed list
		
	}
	
	
	/* Get middle node of linked list using loop */
	static void getMiddleUsingLoop(LinkedList<Integer> list) {
		
		/* if head node is null return */
		if(list.getHead() == null) {
			return;
		}
		
		/* Approach is to find the length 
		 * divide length by 2 to get mid index
		 * loop through list to get mid index element 
		 */
		int len = 0;
		
		Node<Integer> node = list.getHead();
		
		/* finding length of list */
		while(node.getNext() != null) {
			len++;
			node = node.getNext();
		}
		
		int mid = len/2;
		
		Node<Integer> midNode = list.getHead();
		
		/* finding middle node */
		while(mid-->0)
			midNode = midNode.getNext();
			
		System.out.println(midNode.getData());
	}
	
	/* Get middle node of linked list using pointer variables */
	static void getMiddleUsingPointer(LinkedList<Integer> list) {
		
		/* if head node is null return */
		if(list.getHead() == null) {
			return;
		}
		
		/* initialize to pointers slow, fast as head node
		 * fast moves two nodes at a time
		 * slow moves one node at a time(i.e., fast moves 2x faster than slow)
		 * then if fast at the end node slow points the middle node
		 */
		Node<Integer> slow, fast;
		
		slow = fast = list.getHead();
		
		while(fast.getNext() != null && fast.getNext().getNext() != null) {
			
			fast = fast.getNext().getNext();
			slow = slow.getNext();
		}
		
		System.out.println(slow.getData());
		
	}
	
	static void get(LinkedList<Integer> list, int index) {
		
		/* if head node is null return */
		if(list.getHead() == null) {
			return;
		}
		
		Node<Integer> node = list.getHead();
		
		/* traverse the list until index greater than zero */
		while(index-->0)
			node = node.getNext();
		
			
		System.out.println(node.getData());
		
	}
	
	static boolean hasLoop(Node<Integer> head) {
		
		Node<Integer> slow = head, fast = head;
		
		while(fast.getNext() != null && fast != null) {
			fast = fast.getNext().getNext(); // moves two node at a time
			slow = slow.getNext();           // moves one node at a time
			
			/* when there is a loop fast and slow points to same node */
			if(fast == slow) 	return true;
		}
		
		
		return false;
	}
	
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
				
		for(int  num=1; num<24; num++)
			list.insert(num);
		
		System.out.println(hasLoop(list.getHead()));
		
	}
	
	
}
