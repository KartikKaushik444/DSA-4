package trees;

public class BTtoSumTree {
	static int btToSumTree(Tnode tree)
	{
		if(tree.left==null&&tree.right==null)
		{
			return tree.data;
		}
		else
		{
			int leftSum=0;
			int rightSum=0;
			if(tree.left!=null)
				leftSum=btToSumTree(tree.left);
			if(tree.right!=null)
                rightSum=btToSumTree(tree.right);
			int sum=tree.data+leftSum+rightSum;
			tree.data=leftSum+rightSum;
			return sum;
			
		}	
				
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree(1);
        bt.root=bt.create();
        
        btToSumTree(bt.root);
        
        BinaryTree.levelOrderTraversal(bt.root);

	}

}
