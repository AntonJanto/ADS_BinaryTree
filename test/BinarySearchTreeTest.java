import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest
{
     private BinarySearchTree binarySearchTree;

     @BeforeEach
     public void createTree()
     {
          binarySearchTree = new BinarySearchTree();
     }

     @Test
     public void addElementToTree() {
          binarySearchTree.insert(0);

          assertEquals(0, binarySearchTree.levelOrder().get(0));
     }

     @Test
     public void addTwoElementsToTreeLowHigh() {
          binarySearchTree.insert(0);
          binarySearchTree.insert(1);

          var levelOrderList = binarySearchTree.levelOrder();

          assertEquals(0, levelOrderList.get(0));
          assertEquals(1, levelOrderList.get(1));
     }

     @Test
     public void addTwoElementsToTreeHighLow() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(0);

          var levelOrderList = binarySearchTree.levelOrder();

          assertEquals(1, levelOrderList.get(0));
          assertEquals(0, levelOrderList.get(1));
     }

     @Test
     public void addThreeElementsToTreeLowMediumHigh() {
          binarySearchTree.insert(0);
          binarySearchTree.insert(1);
          binarySearchTree.insert(2);

          var levelOrderList = binarySearchTree.levelOrder();

          assertEquals(0, levelOrderList.get(0));
          assertEquals(1, levelOrderList.get(1));
          assertEquals(2, levelOrderList.get(2));
     }

     @Test
     public void addThreeElementsToTreeMediumLowHigh() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(0);
          binarySearchTree.insert(2);

          var levelOrderList = binarySearchTree.levelOrder();

          assertEquals(1, levelOrderList.get(0));
          assertEquals(0, levelOrderList.get(1));
          assertEquals(2, levelOrderList.get(2));
     }

     @Test
     public void addFourElementsToTreeMediumLowHighHigher() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(0);
          binarySearchTree.insert(2);
          binarySearchTree.insert(3);

          var levelOrderList = binarySearchTree.levelOrder();

          assertEquals(1, levelOrderList.get(0));
          assertEquals(0, levelOrderList.get(1));
          assertEquals(2, levelOrderList.get(2));
          assertEquals(3, levelOrderList.get(3));
     }

     @Test
     public void addFourElementsToTreeMediumLowHigherHigh() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(0);
          binarySearchTree.insert(3);
          binarySearchTree.insert(2);

          var levelOrderList = binarySearchTree.levelOrder();

          assertEquals(1, levelOrderList.get(0));
          assertEquals(0, levelOrderList.get(1));
          assertEquals(3, levelOrderList.get(2));
          assertEquals(2, levelOrderList.get(3));
     }

     @Test
     public void findMinElement() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(0);
          binarySearchTree.insert(3);
          binarySearchTree.insert(2);
          binarySearchTree.insert(9);
          binarySearchTree.insert(-5);
          binarySearchTree.insert(-20);
          binarySearchTree.insert(3);

          assertEquals(-20, binarySearchTree.findMin());
     }

     @Test
     public void findMaxElement() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(0);
          binarySearchTree.insert(3);
          binarySearchTree.insert(2);
          binarySearchTree.insert(9);
          binarySearchTree.insert(-5);
          binarySearchTree.insert(-20);
          binarySearchTree.insert(3);

          assertEquals(9, binarySearchTree.findMax());
     }

     @Test
     public void rebalanceWithThreeNodes() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(2);
          binarySearchTree.insert(3);
          binarySearchTree.print();
          binarySearchTree.rebalance();
          binarySearchTree.print();
          assertEquals(2,binarySearchTree.height());
     }

     @Test
     public void rebalanceWithFourNodes() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(2);
          binarySearchTree.insert(3);
          binarySearchTree.insert(4);
          binarySearchTree.print();
          binarySearchTree.rebalance();
          binarySearchTree.print();
          assertEquals(3,binarySearchTree.height());
     }

     @Test
     public void rebalanceWithSevenNodes() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(2);
          binarySearchTree.insert(3);
          binarySearchTree.insert(4);
          binarySearchTree.insert(5);
          binarySearchTree.insert(6);
          binarySearchTree.insert(7);
          binarySearchTree.print();
          binarySearchTree.rebalance();
          binarySearchTree.print();
          assertEquals(3,binarySearchTree.height());
     }

     @Test
     public void rebalanceWithFifteenNodes() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(2);
          binarySearchTree.insert(3);
          binarySearchTree.insert(4);
          binarySearchTree.insert(5);
          binarySearchTree.insert(6);
          binarySearchTree.insert(7);
          binarySearchTree.insert(8);
          binarySearchTree.insert(9);
          binarySearchTree.insert(10);
          binarySearchTree.insert(11);
          binarySearchTree.insert(12);
          binarySearchTree.insert(13);
          binarySearchTree.insert(14);
          binarySearchTree.insert(15);
          binarySearchTree.print();
          binarySearchTree.rebalance();
          binarySearchTree.print();
          assertEquals(4,binarySearchTree.height());
     }

     @Test
     public void rebalanceWithSixteenNodes() {
          binarySearchTree.insert(1);
          binarySearchTree.insert(2);
          binarySearchTree.insert(3);
          binarySearchTree.insert(4);
          binarySearchTree.insert(5);
          binarySearchTree.insert(6);
          binarySearchTree.insert(7);
          binarySearchTree.insert(8);
          binarySearchTree.insert(9);
          binarySearchTree.insert(10);
          binarySearchTree.insert(11);
          binarySearchTree.insert(12);
          binarySearchTree.insert(13);
          binarySearchTree.insert(14);
          binarySearchTree.insert(15);
          binarySearchTree.insert(16);
          binarySearchTree.print();
          binarySearchTree.rebalance();
          binarySearchTree.print();
          assertEquals(5,binarySearchTree.height());
     }

     @Test
     public void removeOneElement(){
          binarySearchTree.insert(3);
          binarySearchTree.insert(2);
          binarySearchTree.insert(1);
          binarySearchTree.rebalance();
          assertEquals(3, binarySearchTree.findMax());
          binarySearchTree.removeElement(3);
          assertEquals(2, binarySearchTree.findMax());
     }

     @Test
     public void removeMultipleElements(){
          binarySearchTree.insert(3);
          binarySearchTree.insert(2);
          binarySearchTree.insert(1);
          binarySearchTree.rebalance();
          binarySearchTree.removeElement(3);
          binarySearchTree.removeElement(1);
          assertEquals(2, binarySearchTree.findMin());
          assertEquals(1, binarySearchTree.size());
     }

     @Test
     public void removeNonExistingElement(){
          binarySearchTree.insert(3);
          binarySearchTree.insert(2);
          binarySearchTree.insert(1);
          ArrayList<Integer> beforeDelete = binarySearchTree.inOrder();
          binarySearchTree.removeElement(4);
          ArrayList<Integer> afterDelete = binarySearchTree.inOrder();
          for (int i = 0; i < beforeDelete.size(); i++)
               assertEquals(beforeDelete.get(i), afterDelete.get(i));
     }
}