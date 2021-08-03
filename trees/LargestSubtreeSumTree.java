package trees;

public class LargestSubtreeSumTree {
// it will target the subtrees containing leaf nodes	
	static int maxSum = Integer.MIN_VALUE;
	
	static int largestSubtree(Tnode root)
	{			
		if(root == null)
			return 0;
		
		int leftSum = largestSubtree(root.left);
		int rightSum =  largestSubtree(root.right);
		
		int sum = leftSum + rightSum + root.data;
		if(sum > maxSum)
			maxSum = sum;
		return sum;
	}


	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        System.out.println(largestSubtree(bt.root));

	}

}
