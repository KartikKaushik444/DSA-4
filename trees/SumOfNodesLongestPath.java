package trees;

public class SumOfNodesLongestPath {    // From root to leaf
	// if two or more path compete for the longest path, then path having max sum of nodes is considered
	// idea is to use backtracking
	static int sum=0;
    static int maxSum=Integer.MIN_VALUE;
    
    static int len = 0;
    static int maxLen = Integer.MIN_VALUE;

	static void sum(Tnode root)
	{
		if(root == null)
			return;
		
		sum += root.data;
		len++;
		
		if(root.left == null && root.right == null)
		{
			// now we can update maxLen and maxSum
			
			// for same maxLen the one with maxSum will be answer
			
			if(len == maxLen)
			{
				if(sum > maxSum)
					maxSum = sum;
			}
			else if(len > maxLen)
			{
				maxLen = len;
				maxSum = sum;
				
			}
		}
		
		sum(root.left);
		sum(root.right);
		
		sum -= root.data;
		len--;
	
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        //System.out.println(sumOfNodes(bt.root));
        sum(bt.root);
        System.out.println(maxSum);

	}

}
