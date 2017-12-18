//LCA
//for node X, Y
//check if nodes in tree
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
	
	//currently root.Children will contain both data1 and data2
	//find LCA
	//bottom up method
	
	List<Integer> data1List = Path(data1);
	List <Integer> data2List = Path(data2);
	List<Integer> intersection = data1List.retainAll(data2List); //whatever node comes last in intersection of these lists will be LCA
	int lcaData = intersection.get(intersection.size()-1).intValue(); //convert Integer to int
	return getNode(lcaData); //return node with this data (which could still be root)
	}
}
