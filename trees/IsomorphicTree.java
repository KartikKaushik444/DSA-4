package trees;
 // check if two trees are isomorphic or not
// two trees are called isomorphic if one of them can be obtained from other by series of flips,
// i.e by swapping left and right children of number of nodes
// any number of nodes at any level can have their children swapped
public class IsomorphicTree {
	
	static boolean solve(Tnode root1, Tnode root2)
	{
		if(root1 == null && root2 == null)
			return true;
		
		if(root1 == null || root2 == null)
			return false;
		
		if(root1.data != root2.data)
			return false;
		
		// if child not swapped
		boolean case1 = solve(root1.left, root2.left) && solve(root1.right, root2.right);
		// if swapped
		boolean case2 = solve(root1.left, root2.right) && solve(root1.right, root2.left);
		
		return case1 || case2;
	}

	public static void main(String[] args) {

		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        BinaryTree bt1=new BinaryTree();
        bt1.root=bt1.create();
        
        System.out.println(solve(bt.root, bt1.root));
        

	}

}
