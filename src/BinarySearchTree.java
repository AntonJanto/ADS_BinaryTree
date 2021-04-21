import java.util.ArrayList;

public class BinarySearchTree extends BinaryTree
{
  public void insert(int elementToInsert){
    if (isEmpty())
      setRoot(new BinaryTreeNode(elementToInsert));
    else
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

    //todo: could be made easier by using isRightChild
    //case: it's a leaf, the node can be easily deleted
    BinaryTreeNode parent = nodeToDelete.getParent();
    if(parent.getLeftChild() == nodeToDelete)
      parent.removeLeftChild();
    else
      parent.removeRightChild();

    //todo: there might be error when the root node is deleted
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
      setRoot(balancedTree(inOrder(), 0, size()));
  }

  private BinaryTreeNode balancedTree(ArrayList<Integer> elements, int lowIndex, int highIndex){
    int midIndex = lowIndex+(highIndex-lowIndex)/2;
//    System.out.println("elements:" + elements.subList(lowIndex, highIndex));
//    System.out.println("low:" + lowIndex + " mid:" + midIndex + " high:" + highIndex);
    BinaryTreeNode node = new BinaryTreeNode(elements.get(midIndex));
//    System.out.println("adding:" + elements.get(midIndex));
    if(lowIndex<midIndex){
//    System.out.println("continue left");
      node.addLeftChild(balancedTree(elements, lowIndex, midIndex));
    }
    if(highIndex-1>midIndex)
    {
//    System.out.println("continue right");
      node.addRightChild(balancedTree(elements, midIndex+1, highIndex));
    }
    return node;
  }

  public void print(){
    new BinaryTreePrint().printTree(this.getRoot());
  }
}
