package trees;

import java.util.Stack;

public class IsBST {
	
//	static boolean isBST(Tnode root)
//	{
//		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//	}
//	
//	static boolean isBST(Tnode root, int min, int max)
//	{
//		if(root == null)
//			return true;
//		
//		if(root.data <= min || root.data >= max)
//			return false;
//		
//		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
//	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	// iterative inorder approach
	static boolean isValidBST(Tnode root) {
		   if (root == null) return true;
		   Stack<Tnode> stack = new Stack<>();
		   Tnode pre = null;
		   while (root != null || !stack.isEmpty()) {
		      while (root != null) {
		         stack.push(root);
		         root = root.left;
		      }
		      root = stack.pop();
		      if(pre != null && root.data <= pre.data) return false;
		      pre = root;
		      root = root.right;
		   }
		   return true;
		}
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Another method
	// THis method is giving wrong answer for now
	static boolean isBST(Tnode root)
	{
		int prev = Integer.MIN_VALUE;
		return isBST(root, prev);
	}
	
	static boolean isBST(Tnode root, int prev)
	{
		if(root == null)
			return true;
		
		if(!isBST(root.left, prev))
			return false;
		
		if(root.data <= prev)
			return false;
		
		prev = root.data;
		
		return isBST(root.right, prev);
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=bt.create();
		
		System.out.println(isBST(bt.root));

	}

}
