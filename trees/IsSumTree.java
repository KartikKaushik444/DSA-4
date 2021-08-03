package trees;

public class IsSumTree {
	
	static boolean isSumTree(Tnode root)
	{
		if(isSumTreeAsset(root)==-1)
			return false;
		else
			return true;
	}
	
	static int isSumTreeAsset(Tnode tree)
	{
		if(tree.left==null&& tree.right==null)
			return tree.data;
		else
		{
			int leftSum=0;
			int rightSum=0;
			if(tree.left!=null)
				leftSum=isSumTreeAsset(tree.left);
			if(tree.right!=null)
				rightSum=isSumTreeAsset(tree.right);
			if(leftSum==-1||rightSum==-1)
				return -1;
			if(leftSum+rightSum==tree.data)
				return leftSum+rightSum+tree.data;
			else
				return -1;
			
		}
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree(1);
        bt.root=bt.create();
        System.out.println(isSumTree(bt.root));

	}

}
