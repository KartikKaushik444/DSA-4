package trees;
import java.util.*;


 class Tnode
{
	int data;
	Tnode left;
	Tnode right;	
	
	Tnode()
	{}
	
	Tnode(int data)
	{
		this.data=data;
		left=null;
		right=null;
	}
}

public class BinaryTree {
    Tnode root;
	
	BinaryTree()
	{}
	
	BinaryTree(int d)
	{
		root=new Tnode(d);
	}
	
	static void insert(Tnode root, int value)
	{
		Tnode n=new Tnode(value);
		if(root==null)
			root=n;
		else
		{
			Queue<Tnode> q=new LinkedList<Tnode>();
			q.add(root);
			while(!q.isEmpty())
			{
				Tnode temp=q.poll();
				if(temp.left==null) {
					temp.left=n;
					return;
				}
				else
					q.add(temp.left);
				if(temp.right==null) {
					temp.right=n;
					return;
				}
				else
					q.add(temp.right);
				
			}
		}
	}
	
	public static void levelOrderTraversal(Tnode root)
	{
		if(root==null) {
			System.out.println("Tree is empty");}
		else {
		Tnode temp;
		Queue<Tnode> q=new LinkedList<Tnode>();
		q.add(root);
		while(!q.isEmpty())
		{
		    temp=q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				q.add(temp.left);

			if(temp.right!=null)
				q.add(temp.right);
			
		}
		System.out.println();
		}
	}
	
	static void reverseLevelOrder(Tnode root)
	{
		if(root==null)
			System.out.println("Tree is empty");
		else
		{
			Tnode temp;
			Queue<Tnode> q=new LinkedList<Tnode>();
			Stack<Tnode> s=new Stack<Tnode>();
			q.add(root);
			while(!q.isEmpty())
			{
				temp=q.poll();
				s.push(temp);
				
				if(temp.right!=null)
					q.add(temp.right);
				
				if(temp.left!=null)
					q.add(temp.left);
				
			}
			
			while(!s.isEmpty())
			{
				temp=s.pop();
				System.out.print(temp.data+" ");
				
			}
		}
		System.out.println();
	}
	
	
	static void delete(Tnode root,int value)
	{
		if(root==null)
			System.out.println("Tree is empty");
		else if(root.left==null&&root.right==null)
		{
			if(value==root.data)
				root=null;
		}
		else {
		Tnode temp=null,keyNode=null,prevLast=null;
		int flag=0;                                //0 for left   ,   1 for right
		Queue<Tnode> q=new LinkedList<Tnode>();
		q.add(root);
		while(!q.isEmpty())
		{
			temp=q.poll();
			
			if(temp.data==value) 
				keyNode=temp;
			
			if(temp.left!=null) {
				q.add(temp.left);
				if(temp.left.left==null&&temp.left.right==null)
				{
					prevLast=temp;
					flag=0;
				}
			}	
			if(temp.right!=null) {
				q.add(temp.right);
				if(temp.right.left==null&&temp.right.right==null)
				{
					prevLast=temp;
					flag=1;
				}
			}
		}
		keyNode.data=temp.data;
		if(flag==0)
			prevLast.left=null;
		else
			prevLast.right=null;
		
		}
	}
	
	static void mirror(Tnode tree)
	{
		if(tree==null)
			return;
		else
		{
			// swapping left and right
			Tnode temp=tree.left;
			tree.left=tree.right;
			tree.right=temp;
			// doing same for left and right
			mirror(tree.left);
			mirror(tree.right);
		}
	}

	int height(Tnode tree)
	{
		if(tree==null)
			return 0;
//		else
//		{
//			int lDepth=maxDepth(tree.left);
//			int rDepth=maxDepth(tree.right);
//			
//			if(lDepth>rDepth)
//				return lDepth+1;
//			else
//				return rDepth+1;
//		}
		
		else
		{
			 return Math.max(height(tree.left),height(tree.right))+1;
		}
	}
	static boolean isBalanced(Tnode root)
	{
		int h=BalancedHeight(root);
		if(h>=0)
			return true;
		else
			return false;
	}
	
	static private int BalancedHeight(Tnode tree)
	{
		if(tree==null)
			return 0;
		else
		{
			int balanceFactor;
			int lheight=BalancedHeight(tree.left);
			int rheight=BalancedHeight(tree.right);
			balanceFactor=Math.abs((lheight-rheight));
			if(lheight==-1||rheight==-1||balanceFactor>=2)
				return -1;
			else
				return Math.max(lheight,rheight)+1;
		}
	}
	
	Tnode create()
	{
		Tnode newnode=new Tnode();
		System.out.println("Enter the elment(-1 for no node)");
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		
		if(x==-1)
			return null;
		newnode.data=x;
		System.out.println(" left child of "+x);
		newnode.left=create();
		System.out.println(" right child of "+x);
		newnode.right=create();
		
		return newnode;
	}
	
	static void inorder(Tnode root)
	{
		if(root==null) 
			return;
		inorder(root.left);
		System.out.print(root.data+" ");
        inorder(root.right);		
		
	}
	
	static void preorder(Tnode root)
	{
		if(root==null) 
			return;
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
	
	static void postorder(Tnode root)
	{
		if(root==null) 
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
//        mirror(bt.root);
//        for(int i=2;i<=8;i++)
//        {
//        	insert(bt.root,i);
//        }
//        inorder(bt.root);
//        System.out.println();
//        preorder(bt.root);
//        System.out.println();
//        postorder(bt.root);
//        System.out.println();
//        insert(bt.root,6);
//        insert(bt.root,7);
//        delete(bt.root,1);
        levelOrderTraversal(bt.root);
        
        reverseLevelOrder(bt.root);
//        System.out.println(bt.maxDepth(bt.root));
        //delete(bt.root,2);
//        levelOrderTraversal(bt.root);
        System.out.println(isBalanced(bt.root));

	}

}
