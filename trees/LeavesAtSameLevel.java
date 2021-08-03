package trees;
// check if all leaves are at same level
public class LeavesAtSameLevel {
	
	static boolean check(Tnode tree)
	{
		if(checkUtil(tree)==-1)
			return false;
		else
			return true;
	}
	
	static int checkUtil(Tnode root)
	{
		int n1=0, n2=0;
		
		if(root.left==null&&root.right==null)
			return 1;               // for leaf node(basically return 1)
		if(root.left!=null)
			n1=checkUtil(root.left); // for calculating height of left subtree
		if(root.right!=null)
			n2=checkUtil(root.right);       // for calculating height of right subtree
		
		if(n1 == -1 || n2 == -1)
			return -1;
		
		if(n1==0)                            // if node has only right child
			return n2+1;
		else if(n2==0)                       // if node has only left child
			return n1+1;
		else if(n1==n2)            // the value of height of both left and right child should be same(if both child
			return n1+1;           // exists) 
		else
			return -1;             //else not at same level
			
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree(1);
        bt.root=bt.create();
        System.out.println(check(bt.root));

	}

}
