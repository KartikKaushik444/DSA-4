package trees;

public class IsMirrror {
	
	static boolean IsMirror(Tnode root1, Tnode root2)
	{
		if(root1==null && root2==null)    // Base Case:If both are empty
			return true;
		if(root1==null || root2==null)   // If only one is empty
			return false;

//		if(!IsMirror(root1.left,root2.right))        
//				return false;
//		if(!IsMirror(root1.right,root2.left))
//				return false;
//		if(root1.data==root2.data)
//			return true;
//		else
//			return false;
		// Both are non-empty, compare them recursively
		return root1.data==root2.data && IsMirror(root1.left,root2.right) && IsMirror(root1.right, root2.left);
		
		
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        BinaryTree bt1=new BinaryTree();
        bt1.root=bt1.create();
      
        System.out.println(IsMirror(bt.root, bt1.root));
        

	}

}
//Iterative method is also possible for this question
//In that method we do inorder traversal of one tree and
//reverse inorder traversal of another and compare the values