package trees;

public class BTfromInorderPostorder {
	
	static Tnode BTfromInPost(int []in, int []post)
	{ 
		
		Tnode root = btAsset(in, post, 0, in.length-1, 0, post.length-1);
		return root;
	}
	
	static Tnode btAsset(int []in, int post[], int inStart, int inEnd,int postStart, int postEnd)
	{
		if(inStart > inEnd)
			return null;
		Tnode root = new Tnode();
		root.data = post[postEnd];
		
		
		int index = -1;
		
		
		for(int i=inStart;i<=inEnd;i++)
		{
			if(in[i] == post[postEnd])
				index = i; 
		}
		if(index == -1)
			return null;
		
		int leftInS = inStart;
		int leftInE = index - 1;
		int leftPostS = postStart;
		int leftPostE = leftInE - leftInS + leftPostS;
		// Here leftInE - leftInS is length of the next postrorder array which is equal to inorder array
		int rightInS = index+1;
		int rightInE = inEnd;
		int rightPostS = leftPostE+1;                //postEnd -(inEnd - index);
		int rightPostE = postEnd-1;
		
		
		
		root.left = btAsset(in, post, leftInS, leftInE, leftPostS, leftPostE);
		
		root.right = btAsset(in, post, rightInS, rightInE, rightPostS , rightPostE);
		
		return root;
	}

	public static void main(String[] args) {
		int in[] = {4,8,2,5,1,6,3,7};;
		int post[]= {8,4,5,2,6,7,3,1};
		Tnode root = BTfromInPost(in, post);
		
		BinaryTree.levelOrderTraversal(root);
		
		BinaryTree.inorder(root);
		System.out.println();
		BinaryTree.postorder(root);

	}

}
