import java.util.ArrayList;

public class BinaryTree
{
     private BinaryTreeNode root;

     public void setRoot(BinaryTreeNode root)
     {
          this.root = root;
     }

     public BinaryTreeNode getRoot()
     {
          return root;
     }

     public boolean isEmpty()
     {
          return root == null;
     }

     public int size()
     {
          if (isEmpty())
               return 0;
          else
               return size(root);
     }

     private int size(BinaryTreeNode node)
     {
          int size = 1;
          if (node.getLeftChild() != null)
               size += size(node.getLeftChild());
          if (node.getRightChild() != null)
               size += size(node.getRightChild());
          return size;
     }

     public boolean contains(int element)
     {
          return inOrder().contains(element);
     }

     public ArrayList<Integer> inOrder()
     {
          var inOrderList = new ArrayList<Integer>();
          if (isEmpty())
               return null;
          inOrder(root, inOrderList);
          return inOrderList;
     }

     private void inOrder(BinaryTreeNode node, ArrayList<Integer> list)
     {
          if (node == null)
               return;
          inOrder(node.getLeftChild(), list);
          list.add(node.getElement());
          inOrder(node.getRightChild(), list);
     }

     public ArrayList<Integer> preOrder()
     {
          var preOrderList = new ArrayList<Integer>();
          if (isEmpty())
               return null;
          preOrder(root, preOrderList);
          return preOrderList;
     }

     private void preOrder(BinaryTreeNode node, ArrayList<Integer> list)
     {
          if (node == null)
               return;
          list.add(node.getElement());
          preOrder(node.getLeftChild(), list);
          preOrder(node.getRightChild(), list);
     }

     public ArrayList<Integer> postOrder()
     {
          var postOrderList = new ArrayList<Integer>();
          if (isEmpty())
               return null;
          postOrder(root, postOrderList);
          return postOrderList;
     }

     private void postOrder(BinaryTreeNode node, ArrayList<Integer> list)
     {
          if (node == null)
               return;
          postOrder(node.getLeftChild(), list);
          postOrder(node.getRightChild(), list);
          list.add(node.getElement());
     }

     public int height()
     {
          if (isEmpty())
               return -1;
          return height(root);
     }

     private int height(BinaryTreeNode node)
     {
          if (node == null)
               return 0;

          int leftHeight = height(node.getLeftChild());
          int rightHeight = height(node.getRightChild());

          if (leftHeight > rightHeight)
               return 1 + leftHeight;
          else
               return 1 + rightHeight;
     }

     public ArrayList<Integer> levelOrder()
     {
          var levelOrderList = new ArrayList<Integer>();
          int height = height(root);
          for (int i=0; i < height; i++)
               addLevel(root, i, levelOrderList);
          return levelOrderList;
     }

     private void addLevel(BinaryTreeNode root, int level, ArrayList<Integer> levelOrderList)
     {
          if (root == null)
               return;

          if (level == 0)
               levelOrderList.add(root.getElement());
          else if (level > 0)
          {
               addLevel(root.getLeftChild(), level-1, levelOrderList);
               addLevel(root.getRightChild(), level-1, levelOrderList);
          }
     }
     public void print(){
          new BinaryTreePrint().printTree(getRoot());
     }
}
