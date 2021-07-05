package com.ds;

import java.util.*;
import com.ds.LinkedList;

public class LinkedListOperations {
	
	
	// get nth node from last
	// print in reverse order
	// reverse the list
	
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
		
		while(fast.getNext()!=null && fast.getNext().getNext() != null) {
			
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
	
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int  num=1; num<24; num++)
			list.insert(num);
		
		list.show();
				
	}
	
	
}
