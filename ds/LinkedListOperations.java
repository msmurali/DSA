package com.ds;

public class LinkedListOperations {
	
	/* Recursive function for print list */
	static void print(Node<Integer> head) {
		
		/* if head node is null return */
		if(head == null) 	return;
		
		System.out.print(head.getData()+" ");
		
		/* call next node recursively */
		print(head.getNext());
		
	}
	
	/* Recursive function for print list in reverse order */ 
	static void printReverse(Node<Integer> head) {
		
		/* if head node is null return */
		if(head == null) 	return;
		
		/* else move to next node */
		printReverse(head.getNext());
		
		System.out.print(head.getData()+" ");
		
	}
	
	/* Reverse list */
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

	/* Helper - Reverse list recursively */
	static Node<Integer> reverseRecursive(Node<Integer> head){	
		
		return reverseRecursive(head, null);
		
	}
	
	/* Reverse list recursively */
	static Node<Integer> reverseRecursive(Node<Integer> curr, Node<Integer> prev){
		
		if(curr == null)   return prev;
		
		Node<Integer> next = curr.getNext();
		curr.setNext(prev);
		return reverseRecursive(next, curr);
		
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
	
	/* get a node at given index */
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
	
	/* detect any loop in the list */
	static boolean hasLoop(Node<Integer> head) {
		
		Node<Integer> slow = head, fast = head;
		
		while(fast != null && fast.getNext() != null) {
			fast = fast.getNext().getNext(); // moves two node at a time
			slow = slow.getNext();           // moves one node at a time
			
			/* when there is a loop, fast and slow points to same node */
			if(fast == slow) 	return true;
		}
		
		
		return false;
	}
	
	/* remove duplicates from sorted list */
	static void rmDuplicates(Node<Integer> head) {
		
		Node<Integer> curr = head;
		
		while(curr != null && curr.getNext() != null) {
			
			/* if current node and next node are equal
			 * change current next to current's next's next
			 */
			if(curr.getData() == curr.getNext().getData()) {
				curr.setNext(curr.getNext().getNext());
			}
			/* if not equal move to next node */
			else {
				curr = curr.getNext();
			}
			
		}
		
	}
	
	/* merge sorted lists */
	static Node<Integer> mergeSorted(LinkedList<Integer> list1, LinkedList<Integer> list2){
		
		// result initialized with dummy node
		Node<Integer> mergedList = new Node<Integer>(0); 
		Node<Integer> tail = mergedList;
		
		Node<Integer> curr1 = list1.getHead();
		Node<Integer> curr2 = list2.getHead();
		
		/* traverse node one by one until
		 * one or both list gets empty
		 */
		while(curr1 != null && curr2 != null) {
			
			if(curr1.getData() <= curr2.getData()) {
				tail.setNext(curr1);
				curr1 = curr1.getNext();
			}
			else if(curr1.getData() > curr2.getData()) {
				tail.setNext(curr2);
				curr2 = curr2.getNext();
			}
			tail = tail.getNext();
		}
		
		/* remaining nodes in list1 (if any) */
		if(curr1 != null) {
			tail.setNext(curr1);
		}
		
		/* remaining nodes in list2 (if any) */
		if(curr2 != null) {
			tail.setNext(curr2);
		}

		return mergedList.getNext();
		
	}
	
	
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list1 = new LinkedList<Integer>();
				
		list1.insert(2);
		list1.insert(5);
		list1.insert(7);
		list1.insert(8);
		list1.insert(11);
		
		list1.show();
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		
		list2.insert(1);
		list2.insert(2);
		list2.insert(5);
		list2.insert(12);
		
		print(mergeSorted(list1, list2));
			
	}
	
}
