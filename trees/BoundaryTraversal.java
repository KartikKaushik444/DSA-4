package trees;

public class BoundaryTraversal {
	
	static void boundaryTraversal(Tnode root)
	{
		leftBoundary(root);
		leafNodes(root);
		rightBoundary(root.right);
	}
	
	static void leftBoundary(Tnode root)
	{
		if(root!=null)
		{
			if(root.left!=null)               // if and else if conditions are preventing leaf node printing
			{
				System.out.print(root.data+" ");
				leftBoundary(root.left);
			}
			else if(root.right!=null)
			{
				System.out.print(root.data+" ");
				leftBoundary(root.right);
			}
			// we  can use else condition to print leaf nodes as well
		}
	}
	static void rightBoundary(Tnode root)
	{
		if(root!=null)
		{
			if(root.right!=null)
			{
//				System.out.print(root.data+" ");
//				rightBoundary(root.right);
				
				// For printing in bottom Up manner first go to right than print
				rightBoundary(root.right);
				System.out.print(root.data+" ");
			}
			else if(root.left!=null)
			{
//				System.out.print(root.data+" ");
//				rightBoundary(root.left);
				
				rightBoundary(root.left);
				System.out.print(root.data+" ");
			}
		}
	}
	
	static void leafNodes(Tnode root)
	{
		if(root.left!=null)
			leafNodes(root.left);
		if(root.right!=null)
			leafNodes(root.right);
		if(root.left==null&&root.right==null)
			System.out.print(root.data+" ");
			
			
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=bt.create();
		boundaryTraversal(bt.root);

	}

}
