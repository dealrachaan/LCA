import java.util.ArrayList;
// BinaryTree.java
public class BinaryTree {
  
  private Node root; //root node
  
  private static class Node { //define nested class Node
    Node left;
    Node right;
    int data;
    List<Integer> parents; //nodes which link to this node

    Node(int newData) { //given data for node + no links
      this.left = null;
      this.right = null;
      this.data = newData;
      this.parents = new ArrayList<Integer>();
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
    if (childNode.parents.contains(parentNodeValue)){ //if edge exists return true
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
  
  public List<Integer> path(int data){
    List<Integer> path = new ArrayList();
    return(Path(root, data, Path);
  }
  
  
  private List<Integer> path(Node node, int data, List<Integer> thisPath) { //recursive search for path from node to root
    if (node==null) { //return false if tree is empty
      return(false);
    }
    Node childNode = getNode(data);
    Integer parentNodeValue = Integer.valueOf(node.data); 
    if (childNode.Parents.contains(parentNodeValue)){ //if edge exists return true
      thisPath.add(Integer.valueOf(data)); //add node and root to path list
      thisPath.add(parentNodeValue);
      return (thisPath);
    }
    if (data==node.data) { //add node/root to list if root = node
      thisPath.add(Integer.valueOf(data));
      return(thisPath);
    }
    else if (data<node.data) { //search to left of tree if searched for data is smaller than this nodes data
      return(path(node.left, data));
    }
    else { //search to right of tree if searched for data is bigger than this nodes data
      return(path(node.right, data));
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
    if(isAncestorNode(descendant, ancestor){
      System.err.println("As node "+descendant+" is an ancestor of node "+ascendant", this edge cannot be added);
      return;
    }
    if(getNode(descendant).parents.contains(Integer.valueOf(ancestor){
      return; //edge already exists
    }
    getNode(descendant).parents.add(Integer.valueOf(ancestor));
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
        node.left.parents.add(Integer.valueOf(node));
      }
      else {
        node.right = insert(node.right, data);
        node.right.parents.add(Integer.valueOf(node));
      }
    }

    return(node); // return the new pointer to the caller
  }
}
