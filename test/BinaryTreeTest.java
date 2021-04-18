import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest
{
     private BinaryTree binaryTree;

     @BeforeEach
     public void beforeEach()
     {
          binaryTree = new BinaryTree();
     }

     @Test
     public void setBinaryTreeRoot()
     {
          var root = new BinaryTreeNode(5);
          binaryTree.setRoot(root);

          assertEquals(root, binaryTree.getRoot());
          assertEquals(root.getElement(), binaryTree.getRoot().getElement());
     }

     @Test
     public void isEmptyRootNull()
     {
          assertTrue(binaryTree.isEmpty());
     }

     @Test
     public void sizeEmptyTree()
     {
          assertEquals(0, binaryTree.size());
     }

     @Test
     public void sizeOneElementTree() {
          var treeNode = new BinaryTreeNode(1);
          binaryTree.setRoot(treeNode);

          assertEquals(1, binaryTree.size());
     }

     @Test
     public void sizeTwoElementOneLeafTree() {
          var treeNode = new BinaryTreeNode(1);
          var treeNode2 = new BinaryTreeNode(1);
          treeNode.addLeftChild(treeNode2);
          binaryTree.setRoot(treeNode);

          assertEquals(2, binaryTree.size());
     }

     @Test
     public void sizeThreeElementTwoLeafTree() {
          var treeNode = new BinaryTreeNode(1);
          var treeNode2 = new BinaryTreeNode(1);
          var treeNode3 = new BinaryTreeNode(1);

          treeNode.addLeftChild(treeNode2);
          treeNode.addRightChild(treeNode3);

          binaryTree.setRoot(treeNode);

          assertEquals(3, binaryTree.size());
     }
     
     @Test
     public void containsElementWhenContains()
     {
          var treeNode = new BinaryTreeNode(1);
          var treeNode2 = new BinaryTreeNode(2);
          var treeNode3 = new BinaryTreeNode(3);

          treeNode.addLeftChild(treeNode2);
          treeNode2.addLeftChild(treeNode3);

          binaryTree.setRoot(treeNode);

          assertTrue(binaryTree.contains(3));
     }

     @Test
     public void inOrderTest()
     {
          var treeNode = new BinaryTreeNode(1);
          var treeNode2 = new BinaryTreeNode(2);
          var treeNode3 = new BinaryTreeNode(3);

          treeNode.addLeftChild(treeNode2);
          treeNode2.addLeftChild(treeNode3);

          binaryTree.setRoot(treeNode);

          var list = binaryTree.inOrder();
          assertEquals(3, list.get(0));
          assertEquals(2, list.get(1));
          assertEquals(1, list.get(2));
     }

     @Test
     public void preOrderTest()
     {
          var treeNode = new BinaryTreeNode(1);
          var treeNode2 = new BinaryTreeNode(2);
          var treeNode3 = new BinaryTreeNode(3);

          treeNode.addLeftChild(treeNode2);
          treeNode2.addLeftChild(treeNode3);

          binaryTree.setRoot(treeNode);

          new BinaryTreePrint().printTree(binaryTree.getRoot());

          var list = binaryTree.preOrder();
          assertEquals(1, list.get(0));
          assertEquals(2, list.get(1));
          assertEquals(3, list.get(2));
     }

     @Test
     public void postOrderTest()
     {
          var treeNode = new BinaryTreeNode(1);
          var treeNode2 = new BinaryTreeNode(2);
          var treeNode3 = new BinaryTreeNode(3);
          var treeNode4 = new BinaryTreeNode(4);
          var treeNode5 = new BinaryTreeNode(5);

          treeNode.addLeftChild(treeNode2);
          treeNode.addRightChild(treeNode3);
          treeNode2.addLeftChild(treeNode4);
          treeNode2.addRightChild(treeNode5);

          binaryTree.setRoot(treeNode);

          new BinaryTreePrint().printTree(binaryTree.getRoot());

          var list = binaryTree.postOrder();
          assertEquals(4, list.get(0));
          assertEquals(5, list.get(1));
          assertEquals(2, list.get(2));
          assertEquals(3, list.get(3));
          assertEquals(1, list.get(4));
     }

     @Test
     public void levelOrderTest()
     {
          var treeNode = new BinaryTreeNode(1);
          var treeNode2 = new BinaryTreeNode(2);
          var treeNode3 = new BinaryTreeNode(3);
          var treeNode4 = new BinaryTreeNode(4);
          var treeNode5 = new BinaryTreeNode(5);

          treeNode.addLeftChild(treeNode2);
          treeNode.addRightChild(treeNode3);
          treeNode2.addLeftChild(treeNode4);
          treeNode2.addRightChild(treeNode5);

          binaryTree.setRoot(treeNode);

          new BinaryTreePrint().printTree(binaryTree.getRoot());

          var list = binaryTree.levelOrder();
          assertEquals(1, list.get(0));
          assertEquals(2, list.get(1));
          assertEquals(3, list.get(2));
          assertEquals(4, list.get(3));
          assertEquals(5, list.get(4));
     }

     @Test
     public void heightEmpty() {
          assertEquals(-1, binaryTree.height());
     }

     @Test
     public void heightOneE() {
          var treeNode = new BinaryTreeNode(1);

          binaryTree.setRoot(treeNode);

          assertEquals(1, binaryTree.height());
     }

     @Test
     public void heightTwoE() {
          var treeNode = new BinaryTreeNode(1);
          var treeNode2 = new BinaryTreeNode(2);

          treeNode.addLeftChild(treeNode2);
          binaryTree.setRoot(treeNode);

          assertEquals(2, binaryTree.height());
     }

     @Test
     public void heightThreeEUnbal() {
          var treeNode = new BinaryTreeNode(1);
          var treeNode2 = new BinaryTreeNode(2);
          var treeNode3 = new BinaryTreeNode(3);

          treeNode2.addLeftChild(treeNode3);
          treeNode.addLeftChild(treeNode2);

          binaryTree.setRoot(treeNode);

          assertEquals(3, binaryTree.height());
     }

     @Test
     public void heightThreeEBal() {
          var treeNode = new BinaryTreeNode(1);
          var treeNode2 = new BinaryTreeNode(2);
          var treeNode3 = new BinaryTreeNode(3);

          treeNode.addRightChild(treeNode3);
          treeNode.addLeftChild(treeNode2);

          binaryTree.setRoot(treeNode);

          assertEquals(2, binaryTree.height());
     }
}