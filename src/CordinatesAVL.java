public class CordinatesAVL<T extends ObjectWithCoordinates> extends AVL<T>{
    private AVL<T> Avlx;
    private AVL<T> Avly;
    private AVLNode<T> root = null;
    private int size = 0;

    public CordinatesAVL(){
        this.Avlx = new AVL<>();
        this.Avly = new AVL<>();
        root = null;
        size = 0;

    }

    public AVL<T> getAvlx() {
        return Avlx;
    }

    public AVL<T> getAvly() {
        return Avly;
    }

    public void insert(T data){
        getAvlx().insert(data.getX(), data);
        getAvly().insert(data.getY(), data);

    }

    public T searchX(int keyX){
        return this.Avlx.search(keyX);
    }

    public T searchY(int keyY){
        return this.Avly.search(keyY);
    }

    public AVLNode<T> getRootX(){
        return this.Avlx.getRoot();
    }

    public AVLNode<T> getRootY(){
        return this.Avly.getRoot();
    }

}