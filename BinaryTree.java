// BinaryTree.java
public class BinaryTree {
  
  private Node root; //root node
  
  private static class Node { //define nested class Node
    Node left;
    Node right;
    int data;

    Node(int newData) { //given data for node + no links
      this.left = null;
      this.right = null;
      this.data = newData;
    }
  }

  public void BinaryTree() { //creates empty binary tree
    root = null;
  }
 
  public boolean lookup(int data) { //says if value is in tree
    return(lookup(root, data));
  }

  private boolean lookup(Node node, int data) { //recursive search for data
    if (node==null) { //return false if tree is empty
      return(false);
    }

    if (data==node.data) { //return true if this node's data = data
      return(true);
    }
    else if (data<node.data) { //search to left of tree if searched for data is smaller than this nodes data
      return(lookup(node.left, data));
    }
    else { //search to right of tree if searched for data is bigger than this nodes data
      return(lookup(node.right, data));
    }
  }					
 
  public void insert(int data) { //inserts value in tree using recursive function
    root = insert(root, data);
  }
 

  /*
   Recursive insert -- given a node pointer, recurs through existing tree data and inserts 
   new data into tree. Returns the new node pointer.
  */
  private Node insert(Node node, int data) {
    if (node==null) {
      node = new Node(data);
    }
    else {
      if (data <= node.data) {
        node.left = insert(node.left, data);
      }
      else {
        node.right = insert(node.right, data);
      }
    }

    return(node); // return the new pointer to the caller
  }
}
