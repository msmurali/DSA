package com.ds;

import java.util.*;

class TreeNode {
	
	int key;
	TreeNode left, right;
	
	public TreeNode(int data) {
		this.key = data;
		this.left =null;
		this.right = null;
	}
	
}

class Pair<S, T>{
	
	S key;
	T val;
	
	
	Pair(){};
	
	Pair(S key, T val){
		this.key = key;
		this.val = val;
	}
	
}

public class BinaryTree{
	
	TreeNode root;
	
	private TreeNode insertRecursive(TreeNode current, int value) {
		if (current == null) {
			return new TreeNode(value);
		}
		if (value < current.key) {
			current.left = insertRecursive(current.left, value);
		} 
		else if (value > current.key) {
			current.right = insertRecursive(current.right, value);
		} 
		return current;
	}
	
	public void add(int value) {
		this.root = this.insertIterative(this.root, value);
	}
	
	private TreeNode insertIterative(TreeNode root, int value) {
		
		if(root == null) {
			return new TreeNode(value);
		}
		
		TreeNode parent = null;
		TreeNode curr = root;
		
		while(curr != null) {
			
			if(value < curr.key) {
				parent = curr;
				curr =curr.left;
			}
			else if(value > curr.key) {
				parent = curr;
				curr = curr.right;
			}
			else {
				return root;
			}		
		}
		
		if(value < parent.key) {
			parent.left = new TreeNode(value);
		}
		else{
			parent.right = new TreeNode(value);
		}
		
		return root;
		
	}
		
	public void levelOrder() {
		this.levelOrder(this.root);
	}
	
	private void levelOrder(TreeNode node) {
		if(node == null) {
			return;
		}
		
		Queue<TreeNode> queue = new java.util.LinkedList<TreeNode>();
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
	
	public void topView() {
		this.topView(this.root);
	}
	
	private void topView(TreeNode node) {
		
		if(node == null)		return;
		
		int dist_from_root = 0;
		
		HashMap<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
		
		Queue<Pair<Integer, TreeNode>> queue = new java.util.LinkedList<Pair<Integer, TreeNode>>();
		queue.add(new Pair<Integer, TreeNode>(dist_from_root, node));
	
		while(!queue.isEmpty()) {
			Pair<Integer, TreeNode> current = queue.poll();
			dist_from_root = current.key;
			
			if(!map.containsKey(current.key)) {
				map.put(current.key, current.val);
			}
			
			if(current.val.left != null) {
				queue.add(new Pair<Integer, TreeNode>(dist_from_root - 1, current.val.left));
			}
			if(current.val.right != null) {
				queue.add(new Pair<Integer, TreeNode>(dist_from_root + 1, current.val.right));
			}	
			
		}
		for (Integer dist: map.keySet()) {
		    System.out.println(dist +" "+ map.get(dist).key);
		}	 
		
	}
	
	public boolean contains(int target) {
		
//		return searchRecursive(this.root, target);
		return searchIterative(this.root, target);
		
	}
	
	private boolean searchRecursive(TreeNode root, int target) {
		
		if(root == null) {
			return false;
		}
		if(root.key == target) {
			return true;
		}
		else if(target < root.key) {
			return searchRecursive(root.left, target);
		}
		else if(target > root.key) {
			return searchRecursive(root.right, target);
		}
		return false;
	}
	
	private boolean searchIterative(TreeNode root, int target) {
		
		TreeNode curr = root;
		
		while(curr != null) {
			if( curr.key == target ) {
				return true;
			}
			else if( target < curr.key) {
				curr = curr.left;
			}
			else {
				curr = curr.right;
			}
		}
		
		return false;
		
	}
	
	public void verticalTraversal() {
		this.verticalTraversal(this.root);
	}
	
	private void verticalTraversal(TreeNode root) {
		
		if(root == null)	return;
		
		Queue<Pair<Integer,TreeNode>> q = new java.util.LinkedList<Pair<Integer,TreeNode>>();
		
		Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		
		q.add(new Pair<Integer,TreeNode>(0, root));
		
		while(!q.isEmpty()) {
			
			Pair<Integer,TreeNode> pair = q.poll();
			int dist = pair.key;
			TreeNode node = pair.val;
			
			if(map.containsKey(dist)) {
				ArrayList<Integer> list = map.get(dist);
				list.add(node.key);
				map.put(dist, list);
			}
			else {
				ArrayList<Integer> list = new ArrayList<Integer>();
				list.add(node.key);
				map.put(dist,list);
			}
			
			if(node.left != null) {
				q.add(new Pair<Integer,TreeNode>(dist-1, node.left));
			}
			if(node.right != null) {
				q.add(new Pair<Integer,TreeNode>(dist+1, node.right));
			}
			
		}
		
		for(Integer dist: map.keySet()) {
			for(Integer node_val: map.get(dist)) {
				System.out.print(node_val+" ");
			}
			System.out.println();
		}
		
	}
	
	// driver
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.add(8);
		tree.add(2);
		tree.add(9);
		tree.add(1);
		tree.add(10);
		tree.add(7);
		tree.add(22);
		tree.add(166);
		tree.add(36);
		
		tree.verticalTraversal();
	}
	
}