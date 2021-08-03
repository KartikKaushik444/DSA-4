package trees;
// find the size of the largest bst in bt. The bst have to contain leaf node, means can't take a middle part

// idea is to get the values from left subtree and right subtree and use that information to 
// get the result for that node
// each subtree will return isBST value, max value and min value for comparison and max size found
// till now

public class LargestBSTinBT {
	
	
	static class Info
	{
		int maxSize;
		boolean isBST;
		int min;
		int max;
		
		Info(int maxSize, boolean isBST, int min, int max)
		{
			this.maxSize = maxSize;
			this.isBST = isBST;
			this.min = min;
			this.max = max;
		}
	}
	
	static Info solve(Tnode root)
	{
		if(root == null)
		{
			return new Info(0, true, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		
		Info left = solve(root.left);
		Info right = solve(root.right);
		// IMP step to avoid wrong answer
		// update the values if it is the first node from left or right side
		if(right.max == Integer.MAX_VALUE)
		{
			right.max = root.data;
			right.min = root.data;
		}
		if(left.max == Integer.MAX_VALUE)
		{
			left.max = root.data;
			left.min = root.data;
		}
		
		// update the info than check what to return
		int maxSize = Math.max(left.maxSize, right.maxSize); 
		
		boolean isBST = false;
		
		int min = Math.min(left.min, Math.min(right.min, root.data));
		
		int max = Math.max(left.max, Math.max(right.max, root.data));
		
		Info i = new Info(maxSize, isBST, min, max);
		
		// if any of the side is not BST return false
		if(left.isBST == false || right.isBST == false)
		{
			return i;
		}
		
		// if doesn't satisfy bst properties, return false value
		if(root.data > right.min || root.data < left.max)
		{
			return i;
		}
		
		// since it is a bst, update the maxSize and isBST
		
		i.maxSize = left.maxSize + right.maxSize + 1;
		i.isBST = true;
		
		return i;
			
	}
	
	static void largestBST(Tnode root)
	{
		Info i = solve(root);
		System.out.println(i.maxSize);
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        largestBST(bt.root);

	}

}
