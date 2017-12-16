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
	public void test() {
		fail("Not yet implemented");
	}

}



public static void main(String arg[]){
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(3);tree.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(root);
	}
}
