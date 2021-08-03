package trees;

// given a binary tree return a string of bracket representation

public class BTtoBracketRepresentation {
	// Cases
	// if leaf node than no brackets for children 
	// if only left child than no bracket for right child
	// if only right child than empty brackets for left child
	static String solve(Tnode root)
	{
		if(root == null)
			return "";
		
		String s = "";
		
		// put the root
		s += root.data + "";
		
		// if leaf node, then return
		if(root.left == null && root.right == null)
			return s;
		
		s += "(";
		String left = solve(root.left);
		s += left;
		s += ")";
		
		if(root.right == null)
			return s;
		
		s += "(";
		String right = solve(root.right);
		s += right;
		s += ")";
		
		return s;
				
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        System.out.println(solve(bt.root));
	}

}
