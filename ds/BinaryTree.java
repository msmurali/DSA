package com.ds;

// node for binary tree
class TreeNode {
	
	int key;
	TreeNode left, right;
	
	public TreeNode(int data) {
		this.key = data;
		this.left =null;
		this.right = null;
	}
	
}

public class BinaryTree{
	
	TreeNode root;
	
	// insert new node recursively
	private TreeNode insert(TreeNode current, int value) {
		if (current == null) {
			return new TreeNode(value);
		}
		if (value <= current.key) {
			current.left = insert(current.left, value);
		} 
		else if (value > current.key) {
			current.right = insert(current.right, value);
		} 
			return current;
	}
	
	public void add(int value) {
		this.root = this.insert(this.root, value);
	}
	
	//driver function
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.add(13);
		tree.add(3);
		tree.add(4);
		tree.add(15);
		
		System.out.println(tree.root.key);
		System.out.println(tree.root.left.key);
		System.out.println(tree.root.right.key);	
		
	}
	
}