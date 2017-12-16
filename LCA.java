//LCA
//for node X, Y
//check if nodes in tree, if not add them to tree
//if root = either node, return root
//otherwise recur down left + right
//returns highest node with paths that lead to node X and node Y

public Node LCA(Node root, int data1, int data2){
	
	if(lookup(data1)==false){ //if node1 or node2 data not in tree, add to tree
		System.out.print(data1+" not found in tree.");
		return null;
	}

	if(lookup(data2)==false){
		System.out.print(data2+" not found in tree.");
		return null;
	}
	
	if (root==null){
		return null;
	}
	
	if(root.data == data1 || root.data == data2){
		return root;
	}
	
	Node left = LCA(root.left, data1, data2);
	Node right = LCA(root.right, data1, data);
	
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
