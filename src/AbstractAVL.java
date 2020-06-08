import java.util.*;
public abstract class AbstractAVL<T> {
    



    private AVLNode<T> root = null;
    private int size = 0;

    public AbstractAVL (){
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
        rotateWithRight (node.getLeftChild ());
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
    }



