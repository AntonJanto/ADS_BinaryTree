import java.security.InvalidParameterException;

public class BinaryTreeNode implements Comparable<Integer>
{
     private int element;
     private BinaryTreeNode leftChild;
     private BinaryTreeNode rightChild;

     public BinaryTreeNode()
     {
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

     public void addLeftChild(BinaryTreeNode left)
     {
          this.leftChild = left;
     }

     public BinaryTreeNode getLeftChild()
     {
          return leftChild;
     }

     public void addRightChild(BinaryTreeNode right)
     {
          this.rightChild = right;
     }

     public BinaryTreeNode getRightChild()
     {
          return rightChild;
     }

     @Override
     public int compareTo(Integer o)
     {
          return o - element;
     }
}
