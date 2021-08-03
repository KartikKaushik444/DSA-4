package trees;

import java.util.HashMap;

// Use dp(memoization)
public class MaxSumNoTwoAdjacent {
	
	static int solve(Tnode root)
	{
		HashMap<Tnode, Integer> dp = new HashMap<>();
		
		return solve(root, dp);
	}
	
	static int solve(Tnode root, HashMap<Tnode, Integer> dp)
	{
		if(root == null)
			return 0;
		
		if(dp.containsKey(root))
			return dp.get(root);
		
		// if we include this node
		int inc = root.data;
		
		if(root.left != null)
		{
			inc += solve(root.left.left, dp);
			inc += solve(root.left.right, dp);
		}
		if(root.right != null)
		{
			inc += solve(root.right.left, dp);
			inc += solve(root.right.right, dp);
		}
		int exc = solve(root.left) + solve(root.right);
		int sum = Math.max(inc, exc);
		dp.put(root, sum);
		return sum;
	}
	
	public static void main(String[] args) {
		
	}

}
