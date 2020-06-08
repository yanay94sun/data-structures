import java.io.*;
import java.util.*;

public class AVL<T> {

	private int height (AVLNode<T> N) {
		if (N == null)
			return 0;
		return N.getHeight();
	}




	public void insert(int key, T data) {

		AVLNode<T> node = new AVLNode<T>(key, data);
		insertRec(node, key);
	}

	private AVLNode<T> insertRec(AVLNode<T> node, int key){
		/* 1.  Perform the normal BST rotation */


		if (key < node.key)
			node.left  = insertRec(node.left, key);
		else
			node.right = insertRec(node.right, key);

		/* 2. Update height of this ancestor node */
		node.height = Math.max(height(node.left), height(node.right)) + 1;

	/* 3. Get the balance factor of this ancestor node to check whether
	   this node became unbalanced */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there are 4 cases

		// Left Left Case
		if (balance > 1 && key < node.left.key)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && key > node.right.key)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && key > node.left.key)
		{
			node.left =  leftRotate(node.left);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && key < node.right.key)
		{
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	private AVLNode<T> rightRotate(AVLNode<T> y) {
		AVLNode<T> x = y.left;
		AVLNode<T> T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = Math.max(height(y.left), height(y.right))+1;
		x.height = Math.max(height(x.left), height(x.right))+1;

		// Return new root
		return x;
	}

	private AVLNode<T> leftRotate(AVLNode<T> x) {
		AVLNode<T> y = x.right;
		AVLNode<T> T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		//  Update heights
		x.height = Math.max(height(x.left), height(x.right))+1;
		y.height = Math.max(height(y.left), height(y.right))+1;

		// Return new root
		return y;
	}

	// Get Balance factor of node N
	private int getBalance(AVLNode<T> N) {
		if (N == null)
			return 0;
		return height(N.left) - height(N.right);
	}


	public T search(int key){
		//TODO
		return null;
	}

	public AVLNode<T> getRoot(){
		//TODO
		return null;
	}
}

