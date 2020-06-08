
public class AVLNode<T> {
	private int key;
	private T data;
	private AVLNode<T> leftChild;
	private AVLNode<T> rightChild;
	private AVLNode<T> father;
	private int height;

	public AVLNode (int key,T data){
		this.key = key;
		this.data = data;
		leftChild = null;
		rightChild = null;
		father = this.getFather();

		height = 0;
	}


	public int getHeight() {
		return height;
	}

	public void setHeight(int nHeight) {
		this.height = nHeight;
	}

	public AVLNode<T> getLeftChild(){
		return leftChild;
	}
	public void setLeftChild(AVLNode<T> nLeftChild) {
		this.leftChild = nLeftChild;
	}

	public AVLNode<T> getRightChild(){
		return rightChild;
	}

	public void setRightChild(AVLNode<T> nRightChild) {
		this.rightChild = nRightChild;
	}

	public AVLNode<T> getFather() {
		return this.father;
	}

	public void setFather(AVLNode<T> father) {
		this.father = father;
	}

	public int getKey(){
		return this.key;
	}

	public T getData(){
		return this.data;
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

