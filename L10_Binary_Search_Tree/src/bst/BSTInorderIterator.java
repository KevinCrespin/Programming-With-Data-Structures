package bst;

import bst.BST.TreeNode;

public class BSTInorderIterator <E extends Comparable<E>> implements java.util.Iterator<E> {
	// to do: make all these methods work.  You will need to add some instance variables.
	
	private TreeNode<E> root;
	
	public BSTInorderIterator(TreeNode<E> root) {
	}

	/** Inorder traversal from the root */
	private void inorder() {
	}

	/** Inorder traversal from a subtree */
	private void inorder(TreeNode<E> root) {
	}

	@Override
	/** More elements for traversing? */
	public boolean hasNext() {
		
	// I set this to always return true so that the project builds.  To do: make it work correctly
		return true;
	}

	@Override
	/** Get the current element and move to the next */
	public E next() {
		//I set this to return null so that the project builds.  To do: delete return null, uncomment the following line, and make it work correctly
		return null;
		//return list.get(current++);
	}

	@Override
	/** Remove the current element */
	public void remove() { 
		// to do: make this work correctly
	}
}