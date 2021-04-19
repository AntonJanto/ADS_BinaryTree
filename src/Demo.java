public class Demo
{
  public static void main(String[] args)
  {
    BinarySearchTree BST = new BinarySearchTree();
    //BST.loadSampleData();

    BST.setRoot(new BinaryTreeNode(5));
    BST.insert(2);
    BST.insert(7);
    BST.insert(3);
    BST.insert(4);
    BST.insert(9);
    BST.insert(1);
    BST.insert(8);


//    System.out.println(BST.findMin());
//    System.out.println(BST.findMax());]
//    System.out.println(BST.find(2).getElement());

    //print the tree
    BST.print();
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");
    System.out.println("");


    BST.removeElement(7);


//    //print the tree
    BST.print();
    System.out.println("");
  }
}
