package trees;

// MAximum Path sum from any node to any node

public class MaximumPathSumFromAnyNode {
	
	static int res = Integer.MIN_VALUE;
	// it is almost same as max sum path from leaf to leaf 
	// here we only have the option to remove the sum of path from the subtree whose sum is negative
	// because if added it is only going reduce the overall sum
	static int solve(Tnode root)
	{
		if(root == null)
			return 0;
		
		int left = solve(root.left); // max sum path from left
		int right = solve(root.right);
		
		// if root is included in the path
		int subtree_sum = root.data + left + right;
		// update result if possible
		res = Math.max(res, subtree_sum);
		
		int temp = root.data + Math.max(left, right);
		
		if(temp >= 0)
			return temp;
		else                  // if negative than return 0 
			return 0;
	}
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        solve(bt.root);
        System.out.println(res);

	}

}
