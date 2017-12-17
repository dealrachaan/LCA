import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class DAG {
   Node root;

   public static class Node{
      List<Node> successors;
      int value; 
   }
}
