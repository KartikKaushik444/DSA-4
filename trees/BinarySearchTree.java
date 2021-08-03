package trees;
import trees.BinaryTree;

public class BinarySearchTree {
	
	 Tnode root;
	
	BinarySearchTree(int d)
	{
		root=new Tnode(d);
	}
	BinarySearchTree()
	{	}
	// This one is better
	public Tnode insert(Tnode root, int d)
	{
		if(root==null)
		{
			Tnode n=new Tnode(d);
			return n;
		}
			
	     if(d<root.data)
		{
		     root.left=insert(root.left, d);
		}
		
		else
		{
			 root.right=insert(root.right, d);	
		}
	     return root;
	}
	
	
//	public void insert(Tnode root,int d)
//	{
//		if(d<root.data&&root.left==null)
//		{
//			Tnode n=new Tnode(d);
//			root.left=n;
//			
//		}
//		else if(d>=root.data&&root.right==null)
//		{
//			Tnode n=new Tnode(d);
//			root.right=n;
//		}
//		else if(d<root.data)
//			insert(root.left,d);
//		else 
//			insert(root.right,d);
//		
//	}
	
	//deletion without using getParent function
//	void delete(Tnode root,int value)
//	{
//		if(root==null||root.left==null||root.right==null)
//			return;
//	
//		else
//		{
//			if(value<root.data&&root.left.data!=value)
//				delete(root.left,value);
//			else if(value>root.data&&root.right.data!=value)
//			{
//				delete(root.right,value);
//			}
//			else// if(root.left!=null&&root.left.data==value||root.right.data==value)
//			{
//				Tnode keyNode;
//				int flag;                       //0 for left,1 for right
//				if(root.left!=null&&root.left.data==value)
//				{
//				     keyNode=root.left;
//				     flag=0;
//				}
//				else
//				{
//					keyNode=root.right;
//					flag=1;
//				}
//				if(keyNode.left==null&&keyNode.right==null)      //it is a leaf node
//				{
//					if(flag==0)
//						root.left=null;
//					else
//						root.right=null;
//				}
//				
//				else if(keyNode.left==null&&keyNode.right!=null)      //node with only right child
//				{
//					if(flag==0)
//					{	
//						root.left=keyNode.right;
//						
//					}
//					else
//					{
//						root.right=keyNode.right;
//					}
//				}
//				else if(keyNode.right==null&&keyNode.left!=null)        //node with only left child
//				{
//					if(flag==0)
//					{
//						root.left=keyNode.left;
//					}
//					else
//						
//					{
//						root.right=keyNode.left;
//					}
//				}
//				
//				else                                      //node with 2 child
//				{
//					Tnode minvalue=inorderSuccessor(keyNode.right);
//					delete(keyNode.right,minvalue.data);
//					keyNode.data=minvalue.data;
//					
//				}
//				
//				
//					
//			}
//	
//		}
//	}
//	
	Tnode getParent(Tnode root,int value)
	{
		if(root==null||root.left==null&&root.right==null)
			return null;
		else if(value<root.data&&root.left.data!=value)
			return getParent(root.left,value);
		else if(value>root.data&&root.right.data!=value)
			return getParent(root.right,value);
		else
			return root;
		
			
	}
	
	void delete(Tnode root,int value)
	{
		if(root==null)
			return;
		else if(value<root.data)
			delete(root.left,value);
		else if(value>root.data)
		    delete(root.right,value);
		else 
		{
			if(root.left==null&&root.right==null)               //for leaf node
			{
				Tnode parent=getParent(this.root,value);
	
				if(parent.left!=null && value==parent.left.data)
					parent.left=null;
				else
					parent.right=null;
			}
			
			else if(root.left!=null&&root.right==null)         //for node with only left child
			{
				Tnode parent=getParent(this.root,value);
			    if(parent.left!=null&&value==parent.left.data)
			    	parent.left=root.left;
			    else
			    	parent.right=root.left;
			}
			

			else if(root.right!=null&&root.left==null)         //for node with only right child
			{
				Tnode parent=getParent(this.root,value);
			    if(parent.left!=null&&value==parent.left.data)
			    	parent.left=root.right;
			    else
			    	parent.right=root.right;
			}
			
			else                                              //for a node with two child
			{
				Tnode minvalue=inorderSuccessor(root.right);
				delete(root.right,minvalue.data);
				root.data=minvalue.data;

			}
		}
	}
	
	Tnode inorderSuccessor(Tnode root)
	{
		Tnode temp=root;
		while(temp.left!=null)
		{
			temp=temp.left;
		}
		return temp;
		
	}
	 void inorder(Tnode root)
	{
		
		if(root==null) { 
			return;}
		inorder(root.left);
		System.out.print(root.data+" ");
        inorder(root.right);		
		
	}
	

	public static void main(String[] args) {
		BinarySearchTree t=new BinarySearchTree(10);
		t.insert(t.root,5);
		t.insert(t.root,20);
		t.insert(t.root,2);
		t.insert(t.root, 11);
		t.insert(t.root, 23);
		t.insert(t.root, 25);
		
		BinaryTree.levelOrderTraversal(t.root);
		t.inorder(t.root);
		System.out.println();
		t.delete(t.root,10);
//		t.delete(t.root, 2);
//		t.delete(t.root, 20);
//		t.delete(t.root, 1);
//		System.out.println(t.getParent(t.root,25).data);
		
		BinaryTree.levelOrderTraversal(t.root);
		t.inorder(t.root);


}
}
