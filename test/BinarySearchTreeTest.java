import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}