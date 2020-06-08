public class test {
    public static void main(String[] args) {
        AVL<String> myAVL = new AVL<String>();

        myAVL.insert(10,"A");
        myAVL.insert(8,"B");
        myAVL.insert(7,"C");
        myAVL.insert(5,"D");

        myAVL.insert(4,"E");

        myAVL.insert(13,"F");

        myAVL.insert(15,"G");



        System.out.println(myAVL.getRoot());
        System.out.println(myAVL.getRoot().getLeftChild());
        System.out.println(myAVL.getRoot().getRightChild());
        System.out.println(myAVL.getRoot().getRightChild().getFather());
        System.out.println(myAVL.getRoot().getRightChild().getRightChild());
        System.out.println(myAVL.getRoot().getRightChild().getLeftChild());
        System.out.println(myAVL.getRoot().getRightChild().getLeftChild().getFather());
        System.out.println(myAVL.getRoot().getRightChild().getRightChild().getFather());


    }
}
