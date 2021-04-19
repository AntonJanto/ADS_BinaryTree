import java.security.InvalidParameterException;

public class BinaryTreeNode implements Comparable<Integer>
{
     private boolean isRightChild;
     private int element;
     private BinaryTreeNode leftChild;
     private BinaryTreeNode rightChild;
     private BinaryTreeNode parent;

     public BinaryTreeNode()
     { }

     public BinaryTreeNode(BinaryTreeNode parent)
     {
          this.parent = parent;
     }

     public BinaryTreeNode getParent()
     {
          return parent;
     }

     private void setParent(BinaryTreeNode parent)
     {
          this.parent = parent;
     }

     public BinaryTreeNode(int element)
     {
          this.element = element;
     }

     public void setElement(int element)
     {
//          if (element == null)
//               throw new InvalidParameterException("Element cannot be null");
          this.element = element;
     }

     public int getElement()
     {
          return element;
     }

     public void addLeftChild(BinaryTreeNode child)
     {
          this.leftChild = child;
          child.setParent(this);
          child.setRightChild(false);
     }

     public BinaryTreeNode getLeftChild()
     {
          return leftChild;
     }

     public void addRightChild(BinaryTreeNode child)
     {
          this.rightChild = child;
          child.setParent(this);
          child.setRightChild(true);
     }

     public boolean isRightChild()
     {
          return isRightChild;
     }

     public boolean isLeftChild(){
          return !isRightChild;
     }

     private void setRightChild(boolean rightChild)
     {
          isRightChild = rightChild;
     }

     public BinaryTreeNode getRightChild()
     {
          return rightChild;
     }

     public void removeRightChild()
     {
          rightChild = null;
     }

     public void removeLeftChild()
     {
          leftChild = null;
     }

     @Override
     public int compareTo(Integer o)
     {
          return o - element;
     }
}
