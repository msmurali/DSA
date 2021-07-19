package com.ds;

public class MainClass {

	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		list.show();
		
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		list.insert(16);
		list.insert(17);
		list.insert(10);
		
		list.insertAt(7, 99);
		list.remove(7);
		
		list.show();
	}

}
