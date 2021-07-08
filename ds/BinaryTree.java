package com.ds;

import java.util.*;

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
	
	public void levelOrder() {
		this.levelOrder(this.root);
	}
	
	private void levelOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(node);
		 
		while(!queue.isEmpty()) {
			
			TreeNode current = queue.poll(); 
			System.out.print(current.key+" ");
			if(current.left != null)	queue.add(current.left);
			if(current.right != null)	queue.add(current.right);
			
		}		
		
	}
	
	public void preOrder() {
		this.preOrder(this.root);
		System.out.println();
	}
	
	private void preOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		System.out.print(node.key + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void preOrderIter() {
		this.preOrderIter(this.root);
		System.out.println();
	}
	
	private void preOrderIter(TreeNode node) {
		
		if(node == null) {
			return;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		
		while(!stack.isEmpty()) {
			TreeNode current = stack.pop();
			System.out.print(current.key+" ");
			if(current.right != null)	stack.push(current.right);
			if(current.left != null)	stack.push(current.left);
		}
	}
	
	public void inOrder() {
		this.inOrder(this.root);
		System.out.println();
	}
	
	private void inOrder(TreeNode node) {
		if(node == null)		return;
		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);	
	}
	
	public void postOrder() {
		this.postOrder(this.root);
		System.out.println();
	}
	
	private void postOrder(TreeNode node) {
		if(node == null)		return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.key + " ");
	}
	
	// driver
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.add(13);
		tree.add(3);
		tree.add(4);
		tree.add(15);
		tree.add(12);
		tree.add(23);
		
		tree.preOrder();
		tree.inOrder();
		tree.postOrder();
		
	}
	
}