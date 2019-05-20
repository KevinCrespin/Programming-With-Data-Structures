import java.util.Random;

public class BinarySearchTreeDemo {

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    
    for (int i = 0; i < 10; i++) {
    	bst.insert(new Random().nextInt(100));
    }

    System.out.println("Inorder traversal");
    bst.printInorder();

    System.out.println("Preorder Traversal");
    bst.printPreorder();

    System.out.println("Postorder Traversal");
    bst.printPostorder();

    System.out.println("The minimum value in the BST: " + bst.findMinimum());
    System.out.println("The maximum value in the BST: " + bst.findMaximum());

  }
}