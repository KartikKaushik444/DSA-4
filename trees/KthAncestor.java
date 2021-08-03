package trees;

// find kth ancestor of a node in binary tree
// one method is to create ancestor array of size n, say ances[], where ances[i] stores ancestor of ith
// node. So, the second ancestor of i'th node will be ances[ances[i]] and so on
// first we will have to create an ancestor array
// TC: O(n)
// SC: O(n)

// Another method could be backtracking which will not occupy extra space 
public class KthAncestor {
	
	static int solve(Tnode root, int node, int k)
	{
		if(root == null)
			return -2;        // return -2 if node is not found on this side
		
		if(root.data == node)   
		{
			if(k == 0)
			{
				System.out.println(root.data);
			}
			
			return k-1;	
		}
		int left = solve(root.left, node, k); 
		int right = solve(root.right, node, k);
		
		if(left == 0 || right == 0)        // this is the kth ancestor 
		{
			System.out.println(root.data);
			return -1;                      // return -1 to stop backtracking bcoz answer is found
		}
		
		if(left == -1 || right == -1)     // answer is already found 
			return -1;
		
		if(left == -2 && right == -2)    // node is not present in the subtree of this node
			return -2;                   // return -2 meaning node not found
		// means node is already found and decrement the k value and return k value
		if(left > 0)                
			return left - 1; 
		else
			return right -1;
		
			
	}
	

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        int node = 4;
        int k = 3;
        int value = solve(bt.root, node, k);
        if(value == -2)
        	System.out.println("Node not preent in the bt");
        else if(value >= 0)
        	System.out.println(-1);
      

	}

}
