//LCA
//for node X, Y, create string {H, a1, b1, c1...X}
//where X = given node, b = parent node of a, etc, and H = head node
//when string for X {a1, b1, c1...} and string for Y {a2, b2, c2...} converge
// ie when {f1...H} = {h2...H}
//then f1 = h2 = LCA

public Node LCA(Node root, Node node1, Node node2){

	if (root==null){
		return null;
	}
	
	if(root == node1){
		return node1;
	}
	
	if (root == node2){
		return node2;
	}
	
	Node left = LCA(root.left, node1, node2);
	Node right = LCA(root.right, node1, node2);
	
	if(left == null && right == null){
		return null;
	}else if( left != null && right != null){
		reutrn root;
	}else if(left == null){ //process of elimination: right is not null
		return right;
	}else{ //when right is null and left is not null
		return left;
	}

}
