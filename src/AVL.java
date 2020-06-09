import java.util.*;

public class AVL<T extends ObjectWithCoordinates<T>> {

	private AVLNode<T> root = null;
	private int size = 0;
	private AVLx<T> AVLx;
	private AVLy<T> AVLy;


	public AVL() {
		root = null;
		size = 0;
	}
	public void insert(int key, T data){
		AVLx.insert(data.getX(), data);
		AVLy.insert(data.getY() , data);
	}

	public T search(int key){
		//NEED TO CHEACK WHAT ARE THEY SEARCHING!!!!!! X OR Y.
		T x = AVLx.search(key);
		if (x != null)
			return x;
		return AVLy.search(key);
	}

	public AVLNode<T> getRoot(){
		return AVLx.getRoot();
	}
}




