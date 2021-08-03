package trees;

public class LowestCommonAncestor {
	
	static Tnode LCA(Tnode root, int a, int b)
	{
		if(root == null)
			return null;
		if(root.data == a || root.data == b)
			return root;
		
		Tnode left =LCA(root.left, a, b);
		Tnode right = LCA(root.right, a, b);
		 
		if(left!=null && right!=null)   // this root is the LCA
			return root;      
		if(left!=null)
			return left;
		else
			return right;
			
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        System.out.println(LCA(bt.root, 4, 5).data);
        System.out.println(LCA(bt.root, 4, 6).data);
        System.out.println(LCA(bt.root, 3, 4).data);
        System.out.println(LCA(bt.root, 2, 4).data);

	}

}

//Method 1: By storing root to n1 and root to n2 paths
//This will take extra space
//
//Method 2: Implemented above
//If one key is present and other is not, then it returns present key as LCA(Ideally should have given null)
//This can be solved by passing two booleans , one is set true when one key is present and other when other is present
