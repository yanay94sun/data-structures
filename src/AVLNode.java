
public class AVLNode<T> {
	protected   AVLNode<T> left, right, father;
	protected int height = 1;
	protected int key;
	protected T data;

	public AVLNode (int key, T data) {
		this.key = key;
	}

	public int getHeight() {
		return height;
	}

	public AVLNode<T> getLeftChild(){
		return left;
	}
	
	public AVLNode<T> getRightChild(){
		return right;
	}
	
	public AVLNode<T> getFather(){
		return father;
	}
	
	public int getKey(){
		return this.key;
	}
	
	public T getData(){
		return this.data;
	}

	public void setLeftChild(AVLNode<T> left) {
		this.left = left;
	}

	public void setRightChild(AVLNode<T> right) {
		this.right = right;
	}

	public void setFather(AVLNode<T> father) {
		this.father = father;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	@Override
	public String toString() {
		
		String s = "";
		
		if (getLeftChild() != null){
			s+="(";
			s+=getLeftChild().toString();
			s+=")";
		}
		s+=getKey();
		
		if (getRightChild() != null){
			s+="(";
			s+=getRightChild().toString();
			s+=")";
		}
		
		return s;
	}
}

