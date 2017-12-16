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
  
  public boolean delete(int id){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data!=id){
			parent = current;
			if(current.data>id){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current ==null){
				return false;
			}
		}
		//if i am here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left==null && current.right==null){
			if(current==root){
				root = null;
			}
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}
		//Case 2 : if node to be deleted has only one child
		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}else if(current.left!=null && current.right!=null){
			
			//now we have found the minimum element in the right sub tree
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;		
}
  
  	public Node getSuccessor(Node deleteNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}
		//check if successor has the right child, it cannot have left child for sure
		// if it does have the right child, add it to the left of successorParent.
//		successsorParent
		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
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
