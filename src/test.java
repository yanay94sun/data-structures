public class test {
    public static void main(String[] args) {
        AVL<String> myAVL = new AVL<String>();
        AVLNode<String> node1 = new AVLNode<String>(4,"A");
        AVLNode<String> node2 = new AVLNode<String>(6,"B");
        AVLNode<String> node3 = new AVLNode<String>(2,"C");
        myAVL.insert(4,"A");
        myAVL.insert(6,"B");
        myAVL.insert(2,"C");

        System.out.println(node3.getFather());

    }
}
