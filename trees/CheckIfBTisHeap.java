package trees;

// given a binary tree check whether it is a heap or not
public class CheckIfBTisHeap {
	
	static boolean isHeap(Tnode root)
	{
		if(root == null)
			return true;
		
		int nodeCount = countNodes(root);
		
		if(isComplete(root, 0, nodeCount) == true && isHeapUtil(root) == true)
			return true;
		
		return false;
			
	}
	
	static int countNodes(Tnode root)
	{
		if(root == null)
			return 0;
		
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	static boolean isComplete(Tnode root, int index, int noNodes)
	{
		if(root == null)
			return true;
		
		// if index assigned to current node is more than number of nodes in the tree,
		// than tree is not complete
		if(index >= noNodes)
			return false;
		
		// recur for left and right subtree
		return isComplete(root.left, 2*index +1, noNodes)  &&
				isComplete(root.right, 2*index + 2, noNodes);
	}
	
	static boolean isHeapUtil(Tnode root)  // for complete tree
	{
		if(root.left == null && root.right == null)
			return true;
		
		// since it is a complete tree, node will be in the second last level
		if(root.right == null)
		{
			// check heap property
			// no need for recursive calls because no need to check for last level
			return root.data >= root.left.data;
		}
		else
		{
			// check property of this node and
			
			if(root.data >= root.left.data && root.data >= root.right.data)
			{
				//check recursively property for left and right child nodes
				return isHeapUtil(root.left) && isHeapUtil(root.right);
			}
			else
				return false;
		}
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        System.out.println(isHeap(bt.root));

	}

}
