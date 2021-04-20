import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree
{
  public BinarySearchTree()
  {
  }
  public void loadSampleData(){
  //create nodes
  var root = new BinaryTreeNode(5);

  var treeNode3 = new BinaryTreeNode(3);
  var treeNode1 = new BinaryTreeNode(1);
  var treeNode7 = new BinaryTreeNode(7);
  var treeNode8 = new BinaryTreeNode(8);

  //add the nodes to the tree
  root.addLeftChild(treeNode1);
  root.addRightChild(treeNode7);

  treeNode1.addRightChild(treeNode3);

  treeNode7.addRightChild(treeNode8);

  this.setRoot(root);
}

  public void insert(int elementToInsert){
    insertToNode(elementToInsert, this.getRoot());
  }

  private void insertToNode(int elementToInsert, BinaryTreeNode treeNode){
    //case: element to insert is smaller than the current node
    if(elementToInsert < treeNode.getElement()){
      //case: left node is empty > just add it
      if(treeNode.getLeftChild() == null){
        treeNode.addLeftChild(new BinaryTreeNode(elementToInsert));
      }
      //case: left node is not empty > start the process again
      else{
        insertToNode(elementToInsert, treeNode.getLeftChild());
      }
    }
    //case: element to insert is bigger than the current node
    else if(elementToInsert > treeNode.getElement()){
      //case: right node is empty > just add it
      if(treeNode.getRightChild() == null){
        treeNode.addRightChild(new BinaryTreeNode(elementToInsert));
      }
      //case: right node is not empty > start the process again
      else{
        insertToNode(elementToInsert, treeNode.getRightChild());
      }
    }
    //case: element to insert has the same value than the current node
    else{
      //don't do anything, error could also be thrown here
    }
  }

  public int findMin(){
    return findMinFrom(getRoot(), getRoot()).getElement();
  }

  private BinaryTreeNode findMinFrom(BinaryTreeNode currentSmallestNode, BinaryTreeNode treeNode){
    if(currentSmallestNode.getElement() > treeNode.getElement())
      currentSmallestNode = treeNode;

    if(treeNode.getLeftChild() == null)
      return currentSmallestNode;

    return findMinFrom(currentSmallestNode, treeNode.getLeftChild());
  }

  public int findMax(){
    return findMaxFrom(getRoot(), getRoot()).getElement();
  }

  private BinaryTreeNode findMaxFrom(BinaryTreeNode currentLargestNode, BinaryTreeNode treeNode){
    if(currentLargestNode.getElement() < treeNode.getElement())
      currentLargestNode = treeNode;

    if(treeNode.getRightChild() == null)
      return currentLargestNode;

    return findMaxFrom(currentLargestNode, treeNode.getRightChild());
  }

  public void removeElement(int element){
    //first we need to finds the node by descending the tree from the root
    BinaryTreeNode nodeToDelete = find(element, getRoot());

    //if the node does not exist, exit the function
    if(nodeToDelete == null)
      return;

    removeNode(nodeToDelete);
  }

  private void removeNode(BinaryTreeNode nodeToDelete){
    //case: it's an internal node
    if(nodeToDelete.getLeftChild() != null && nodeToDelete.getRightChild() != null){
      if(nodeToDelete.isLeftChild()){
        BinaryTreeNode replacementNode = findMaxFrom(nodeToDelete.getLeftChild(), nodeToDelete.getLeftChild());
        //replace the values
        nodeToDelete.setElement(replacementNode.getElement());
        //remove the replacement from its previous location.
        removeNode(replacementNode);
      }
      else{
        BinaryTreeNode replacementNode = findMinFrom(nodeToDelete.getRightChild(), nodeToDelete.getRightChild());
        nodeToDelete.setElement(replacementNode.getElement());
        removeNode(replacementNode);
      }
    }

    //case: it's a half leaf with right node, just replace it
    if (nodeToDelete.getRightChild() != null){
      nodeToDelete.getParent().addRightChild(nodeToDelete.getRightChild());
      return;
    }

    //case: it's a half leaf with left node, just replace it
    if (nodeToDelete.getLeftChild() != null)
    {
      nodeToDelete.getParent().addLeftChild(nodeToDelete.getLeftChild());
      return;
    }

    //todo: make it easier by using isRightChild
    //case: it's a leaf, the node can be easily deleted
    BinaryTreeNode parent = nodeToDelete.getParent();
    if(parent.getLeftChild() == nodeToDelete)
      parent.removeLeftChild();
    else
      parent.removeRightChild();

    //todo: there will be error when the root node is deleted
  }

  public BinaryTreeNode find(int elementToFind){
    return find(elementToFind, getRoot());
  }

  private BinaryTreeNode find(int elementToFind, BinaryTreeNode treeNode){
    //case: the current node is a the elementToFind we were looking for
    if(treeNode.getElement() == elementToFind)
      return treeNode;

    //case: the current node is smaller than the element we are looking for, lets continue looking on the right side
    if(elementToFind > treeNode.getElement()){
      if(treeNode.getRightChild() != null)
        return find(elementToFind, treeNode.getRightChild());
      else return null;
    }

    //case: the current node is bigger than the elements we are looking for, lets continue looking on the right side.
    if(treeNode.getLeftChild() == null)
      return null;
    return find(elementToFind, treeNode.getLeftChild());
  }

  public void rebalance(){
    ArrayList<Integer> elements = inOrder();

    if(size() > 3){
      int mid = elements.size()/2;
      var low = elements.subList(0, mid);
      var high = elements.subList(mid+1, elements.size());

      System.out.println(elements);
      System.out.println(elements.get(mid));
      System.out.println(low);
      System.out.println(high);
    }
  }

  private void rebalanceSubtree(ArrayList<Integer> elements, BinaryTreeNode treeNode){
    int mid = elements.size()/2;
    var low = elements.subList(0, mid);
    var high = elements.subList(mid+1, elements.size());

    if(low.size() == 1)
      treeNode.addLeftChild(new BinaryTreeNode(low.get(0)));
  }

  public void print(){
    new BinaryTreePrint().printTree(this.getRoot());
  }
}
