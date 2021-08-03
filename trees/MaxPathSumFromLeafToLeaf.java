package trees;

public class MaxPathSumFromLeafToLeaf {
	
	static int res = Integer.MIN_VALUE;
	
	static int MaxPath(Tnode root)
	{
		if(root == null)
			return 0;
		
		
		int left = MaxPath(root.left);
	
		int right = MaxPath(root.right);
		
	    if(root.left!=null && root.right!=null)       // means it is not a leaf node
	    {
	    	int temp = root.data + Math.max(left, right);
	    	
	    	res = Math.max(res, left + right + root.data);
	    	
	    	return temp;
	    }
	    // if a node contains only one child than it will not be a leaf node and hence can
	    //not update the result
	    return (root.left == null)? right + root.data : left + root.data;
		
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        MaxPath(bt.root);
        System.out.println(res);

	}

}
