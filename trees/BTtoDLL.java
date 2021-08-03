package trees;

// A version of this question is to convert binary tree to circular linked list
// Another is to create a sorted list from bst either in increasing order or decreasing order
public class BTtoDLL {
	
	static Tnode prev;
	static Tnode head;
	
	static Tnode conversion(Tnode root)
	{
		conversionAsset(root);
		return head;
	}
  // conversion in inorder
	static void conversionAsset(Tnode tree)
	{
		if(tree==null)
		{
			return ;
		}
		
		conversionAsset(tree.left);
		
		if(prev==null)
			head=tree;
		else
		{
			prev.right=tree;
			tree.left=prev;
		}
		prev=tree;
		
		conversionAsset(tree.right);
		
	}
	
	static void traverseHead(Tnode head)
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			Tnode temp=head;
			while(temp!=null)
			{
			    System.out.print(temp.data+" ");
				temp=temp.right;
			}
		}
		System.out.println();
	}
	
	// convert bst into sorted list
	// Space complexity allowed : O(h) where h is the height of tree
	
	static void solve(Tnode root)
	{
		if(root == null)
			return;
		
		solve(root.left);
		
		// process here
		if(prev == null)
			head = root;
		else
		{
			prev.right = root;
			root.left = null;
		}
		
		prev = root;
		
		solve(root.right);
	}
	
	static void traverseLL(Tnode node)
	{
		Tnode temp = node;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp = temp.right;
		}
	}
	
	public static void main(String[] args) {
//		BinaryTree bt=new BinaryTree(1);
//        bt.root=bt.create();
//        Tnode head=conversion(bt.root);
//        traverseHead(head);
        
        prev = null;
        head = null;
        
    	BinaryTree bt1=new BinaryTree(1);
        bt1.root=bt1.create();
        solve(bt1.root);
        traverseLL(head);
        
        

	}

}
