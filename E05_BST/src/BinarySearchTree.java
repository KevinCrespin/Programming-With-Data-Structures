public class BinarySearchTree {
  public Node root;

  public void insert(int value){
    Node node = new Node(value);

    if ( root == null ) {
      root = node;
      return;
    }

    insertRec(root, node);

  }

  private void insertRec(Node latestRoot, Node node){

    if ( latestRoot.value > node.value){

      if ( latestRoot.left == null ){
        latestRoot.left = node;
        return;
      }
      else{
        insertRec(latestRoot.left, node);
      }
    }
    else{
      if (latestRoot.right == null){
        latestRoot.right = node;
        return;
      }
      else{
        insertRec(latestRoot.right, node);
      }
    }
  }
  
  public int findMinimum(){
	  if ( root == null ){
	    return 0;
	  }
	  Node currNode = root;
	  while(currNode.left != null){
	    currNode = currNode.left;
	  }
	  return currNode.value;
	}

  
	public int findMaximum(){
	  if ( root == null){
	    return 0;
	  }

	  Node currNode = root;
	  while(currNode.right != null){
	    currNode = currNode.right;
	  }
	  return currNode.value;
	}
	
	public void print() {
		printRec(root);
		System.out.print("");
	}
	
	public void printRec(Node currRoot) {
		if(currRoot == null) {
			return;
		}
		else if (currRoot.left != null) {
			printRec(currRoot.left);
		}
	}

	public void printInorder(){
	  printInOrderRec(root);
	  System.out.println("");
	}

	private void printInOrderRec(Node currRoot){
	  if ( currRoot == null ){
	    return;
	  }
	  printInOrderRec(currRoot.left);
	  System.out.print(currRoot.value+", ");
	  printInOrderRec(currRoot.right);
	}

	public void printPreorder() {
	  printPreOrderRec(root);
	  System.out.println("");
	}

	private void printPreOrderRec(Node currRoot) {
	  if (currRoot == null) {
	    return;
	  }
	  System.out.print(currRoot.value + ", ");
	  printPreOrderRec(currRoot.left);
	  printPreOrderRec(currRoot.right);
	}

	public void printPostorder() {
	  printPostOrderRec(root);
	  System.out.println("");
	}

	private void printPostOrderRec(Node currRoot) {
	  if (currRoot == null) {
	    return;
	  }
	  printPostOrderRec(currRoot.left);
	  printPostOrderRec(currRoot.right);
	  System.out.print(currRoot.value + ", ");

	}
}