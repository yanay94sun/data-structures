import java.util.*;

public class AVL<T> {

	private AVLNode<T> root = null;
	private int size = 0;


	public AVL() {
		root = null;
		size = 0;


	}



	public void insert(int key, T data){
		root = insert(key, data, root);
	}

	private AVLNode<T> insert (int key, T data, AVLNode<T> node){
		if (node == null){
			node = new AVLNode<T> (key, data);
			size++;
			return node;
		}
		else{
			if (key < node.getKey()){
				node.setLeftChild (insert (key, data, node.getLeftChild ()));
				node.getLeftChild().setFather(node);
				if (height (node.getLeftChild ()) - height (node.getRightChild ()) == 2){
					if (key < ((node.getLeftChild ()).getKey ()))
						node = rotateWithLeft (node);
					else
						node = doubleWithLeft (node);
				}
			}
			else{
				if (key > (node.getKey ())){
					node.setRightChild (insert (key, data, node.getRightChild ()));
					node.getRightChild().setFather(node);
					if (height (node.getRightChild ()) - height (node.getLeftChild ()) == 2){
						if (key > ((node.getRightChild ()).getKey ()))
							node = rotateWithRight (node);
						else
							node = doubleWithRight (node);
					}
				}
			}
		}
		node.setHeight (max (height (node.getLeftChild ()), height (node.getRightChild ())) + 1);
		return node;
	}
	public int size (){
		return size;
	}

	public int height (){
		return height (root);
	}

	private int height (AVLNode<T> node){
		if (node == null)
			return -1;
		return node.getHeight ();
	}

	public boolean isEmpty (){
		return (size == 0);
	}

	private AVLNode<T> rotateWithLeft (AVLNode<T> node){
		AVLNode<T> newNode = node.getLeftChild ();
		node.setLeftChild (newNode.getRightChild ());
		newNode.setRightChild (node);
		node.setFather(newNode);
		node.setHeight (max (height (node.getLeftChild ()), height (node.getRightChild ())) + 1);
		newNode.setHeight (max (height (newNode.getLeftChild ()), node.getHeight ()) + 1);
		return newNode;
	}


	private AVLNode<T> rotateWithRight (AVLNode<T> node){
		AVLNode<T> newNode = node.getRightChild ();
		node.setRightChild (newNode.getLeftChild ());
		newNode.setLeftChild (node);
		node.setFather(newNode);
		node.setHeight (max (height (node.getLeftChild ()), height (node.getRightChild ())) + 1);
		newNode.setHeight (max (height (newNode.getRightChild ()), node.getHeight ()) + 1);
		return newNode;
	}

	private AVLNode<T> doubleWithLeft (AVLNode<T> node){
		AVLNode<T> a = rotateWithRight (node.getLeftChild ());
		node.setLeftChild (a);
		a.setFather(node);


		return rotateWithLeft (node);
	}


	private AVLNode<T> doubleWithRight (AVLNode<T> node){
		AVLNode<T> a = rotateWithLeft (node.getRightChild ());
		node.setRightChild (a);
		a.setFather(node);

		return rotateWithRight (node);
	}

	public static int max (int first, int second){
		if (first >= second)
			return first;
		else
			return second;
	}


	public T search (int key){
		return search (key, root);
	}

	private T search (int key, AVLNode<T> node){
		if (node == null)
			return null;

		if (key < (node.getKey()))
			return search (key, node.getLeftChild ());

		if (key > (node.getKey ()))
			return search (key, node.getRightChild ());
		return node.getData();
	}



	public AVLNode<T> getRoot(){
		return root;
	}

	public ArrayList<T> range(int a, int b){
//		int[] arr = new int [b-a];
//		int counter = 0;
		ArrayList<T> list = new ArrayList<T>();
		list = rangeRec(a, b, this.root, list);
		return list;
	}

	public ArrayList<T> rangeRec(int a, int b, AVLNode<T> curr, ArrayList<T> list){
		if (curr == null)
			return list;
		if (curr.getKey() < a)
			return rangeRec(a, b, curr.getRightChild(), list);
		if (curr.getKey() > b)
			return rangeRec(a, b, curr.getLeftChild(), list);
		if (curr.getKey() == a){
//			arr[counter] = curr.getKey();
			list.add(curr.getData());
			return rangeRec(a, b, curr.getRightChild(), list);
		}
		if (curr.getKey() == b) {
//			arr[counter] = curr.getKey();
			list.add(curr.getData());
			return rangeRec(a, b, curr.getLeftChild(), list);
		}
		else{
//		arr[counter] = curr.getKey();
//		counter += 1;
		list.add(curr.getData());
//			System.out.println(list);
		list = rangeRec(a, b, curr.getLeftChild(), list);
		list = rangeRec(a, b, curr.getRightChild(), list);
		return list;

		}

	}
}




