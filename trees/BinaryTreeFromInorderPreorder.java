package trees;

public class BinaryTreeFromInorderPreorder {
//	static int preIndex=0;
//	static Tnode BTInorderPreorder(int[] pre,int[] in,int inStart,int inEnd,int preIndex)
//	{
//		if(inStart>inEnd)
//			return null;
//		Tnode n=new Tnode(pre[preIndex++]);
//		if(inStart==inEnd)
//			return n;
//		int inIndex=search(in,inStart,inEnd,n.data);
//		
//		n.left=BTInorderPreorder(pre,in,inStart,inIndex-1,preIndex);
//		n.right=BTInorderPreorder(pre,in,inIndex+1,inEnd,preIndex);
//		
//		return n;
//		
//	}
//	
//	static int search(int[] in,int start,int end,int data)
//	{
//		int i;
//		for( i=start;i<=end;i++)
//		{
//			if(in[i]==data)
//				return i;
//		}
//		return i;
//	}
	
	static Tnode BTfromInPre(int[] in, int pre[])
	{
		return BTAsset(in, pre , 0, in.length-1, 0, pre.length-1);
	}
	
	static Tnode BTAsset(int[] in, int[] pre, int inStart, int inEnd, int preStart, int preEnd )
	{
		if(inStart > inEnd)
			return null;
		
		Tnode root =new Tnode();
		root.data = pre[preStart];
		
		int index=-1;
		
		for(int i=inStart;i<=inEnd;i++)
		{
			if(in[i] == pre[preStart])
			{
				index = i;
				break;
			}
		}
		
		if(index == -1) {
			return null;
		}
		
		int leftInS = inStart;
		int leftInE = index-1;
		int leftPreS = preStart+1;
		int leftPreE = leftInE -leftInS + leftPreS;
		
		int rightInS = index+1;
		int rightInE = inEnd;
		int rightPreS = leftPreE+1;
		int rightPreE = preEnd;
		
		root.left = BTAsset(in, pre, leftInS, leftInE, leftPreS, leftPreE);
		root.right = BTAsset(in, pre, rightInS, rightInE, rightPreS, rightPreE);
		
		return root;
	}

	public static void main(String[] args) {
		int inOrder[]=  {9,8,4,2,10,5,10,1,6,3,13,12,7};//{4,2,5,1,6,3};{4,2,5,1,3,7}
		int preOrder[]= {1,2,4,8,9,5,10,10,3,6,7,12,13};//{1,2,4,5,3,6}; {1,2,4,5,3,7};
		
		//BinaryTree bt=new BinaryTree();
		
		Tnode root= BTfromInPre(inOrder,preOrder);
		BinaryTree.preorder(root);
		System.out.println();
		BinaryTree.inorder(root);
		System.out.println();
		BinaryTree.levelOrderTraversal(root);

	}

}
