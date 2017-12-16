import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class LCATest {
	public void testEmptyTree(){ //look for LCA between two non-existent nodes in empty tree
	BinarySearchTree emptyTree = new BinarySearchTree();
    	LCA(emptyTree, 1, 2);
	}

public void testOneElementTree{ //look for LCA when one element is in tree
    BinarySearchTree oneElementTree = new BinarySearchTree();
    oneElementTree.insert(1);
    LCA(oneElementTree, 1, 2);
  }
  
  public void testBothElementsTree{ //look for LCA when both elements present in tree
	BinarySearchTree bothElementsTree = new BinarySearchTree(); 
  	bothElementsTree.insert(1);
	bothElementsTree.insert(2);
	bothElementsTree.insert(3);
  	LCA(bothElementsTree, 1, 2);
  }
	
  public void testWrongObjectTree{ //test tree with incorrect object types
	BinarySearchTree wrongElementsTree = new BinarySearchTree(); 
	wrongElementsTree.insert(1);
	wrongElementsTree.insert(2);
	LCA(wrongElementsTree, a, b);
}

