import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class LCATest {
	public void testEmptyTree(){//look for LCA between two non-existent nodes in empty tree
	@BeforeMethod
	public void beforeMethod(){
		BinarySearchTree emptyTree = new BinarySearchTree();
	}
	@Test(expected = null)
    	public Node testLCA{
		LCA(emptyTree, 1, 2);
	}
  }
	
  @Test(expected = IllegalArgumentException.class)
  public void testExceptionIsThrown() {        
    tester.divide(1000, 0);
  }
	

public void testOneElementTree{ //look for LCA when one element is in tree
	@BeforeMethod
	public void beforeMethod(){
		BinarySearchTree oneElementTree = new BinarySearchTree();
		oneElementTree.insert(1);
	}
	@Test(expected = null){
		LCA(oneElementTree, 1, 2);
	}
  }
  
  public void testBothElementsTree{ //look for LCA when both elements present in tree
	@BeforeMethod
	public void BeforeMethod(){
		BinarySearchTree bothElementsTree = new BinarySearchTree(); 
		bothElementsTree.insert(1);
		bothElementsTree.insert(2);
		bothElementsTree.insert(3);
		Node node1 = new Node (2);
	}
	@Test{
  		Node node2 = LCA(bothElementsTree, 1, 2);
		assertEquals(node1.data, node2.data);
	}
  }
	
  public void testWrongObjectTree{ //test tree with incorrect object types
	@BeforeMethod
	public void BeforeMethod(){
		BinarySearchTree wrongElementsTree = new BinarySearchTree(); 
		wrongElementsTree.insert(1);
		wrongElementsTree.insert(2);
	}
	@Test(expected = IllegalArgumentException.class){
		LCA(wrongElementsTree, a, b);
	}
}

