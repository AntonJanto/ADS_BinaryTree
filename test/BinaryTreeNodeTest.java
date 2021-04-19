import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeNodeTest
{
     @Test
     public void nodeSetElementNumber() {
          int element = 5;
          BinaryTreeNode node = new BinaryTreeNode(null);
          node.setElement(element);
          assertEquals(element, node.getElement());
     }

     @Test
     public void setLeftChild() {
          BinaryTreeNode node = new BinaryTreeNode(5);
          BinaryTreeNode left = new BinaryTreeNode(4);
          node.addLeftChild(left);

          assertEquals(left, node.getLeftChild());
          assertEquals(left.getElement(), node.getLeftChild().getElement());
     }

     @Test
     public void setRightChild() {
          BinaryTreeNode node = new BinaryTreeNode(5);
          BinaryTreeNode right = new BinaryTreeNode(4);
          node.addRightChild(right);

          assertEquals(right, node.getRightChild());
          assertEquals(right.getElement(), node.getRightChild().getElement());
     }

     @Test
     public void checkParent() {
          BinaryTreeNode root = new BinaryTreeNode(5);
          BinaryTreeNode right = new BinaryTreeNode(4);
          root.addRightChild(right);

          assertEquals(right.getParent(), root);
     }
}