import java.util.ArrayList;
// BinaryTree.java
public class BinaryTree {
  
  private Node root; //root node
  
  private static class Node { //define nested class Node
    Node left;
    Node right;
    int data;
    List<Integer> Parents; //nodes which link to this node

    Node(int newData) { //given data for node + no links
      this.left = null;
      this.right = null;
      this.data = newData;
      this.Parents = new ArrayList<Integer>();
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
    Node childNode = getNode(data);
    Integer parentNodeValue = Integer.valueOf(node.data); 
    if (childNode.Parents.contains(parentNodeValue)){ //if edge exists return true
      return true;
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
  
  public Node getNode(int data){
    if(lookup(data)==false) return null;
    return getNode(root, data);
  }
  
  private Node getNode(Node node, int data){ //same as lookup but returns node rather than true/false value
    if(data==node.data){
      return node;
    }
    else if (data<node.data) { 
      return(getNode(node.left, data));
    }
    else { 
      return(getNode(node.right, data));
    }
  }
 
  public boolean isAncestorNode(int ancestor, int descendant){ //determines whether link exists between two nodes
    if(lookup(ancestor)==false || lookup(descendant)==false){
      return null;
    }
    Node ancestorNode = getNode(ancestor);
    return lookup(ancestorNode, data);
  }

  public void addEdge(int ancestor, int descendant){ //adds link between two nodes
    if(lookup(ancestor)==false || lookup(descendant==false){
      return;
    }
    getNode(descendant).Parents.add(Integer.valueOf(ancestor));
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
        node.left.Parents.add(Integer.valueOf(node));
      }
      else {
        node.right = insert(node.right, data);
        node.right.Parents.add(Integer.valueOf(node));
      }
    }

    return(node); // return the new pointer to the caller
  }
}
