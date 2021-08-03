package trees;

import java.util.*;
// for top and bottom view we use vertical order traversal 
// for left and right view we use level order traversal
public class View {
	
	static class pair
	 {
	 	int data,height;
	 	
	 	public pair (int data,int height)
	 	{
	 		this.data=data;
	 		this.height=height;
	 	}
	 }
// here we also need to pass height along with hd because we want top and bottom element which can 
	// be determined using height

	static void topView(Tnode root)
	{
		TreeMap<Integer,pair> m=new TreeMap<>();
		int height=0;
		int hd=0;
		
		TopViewUtil(root,height,hd,m);
		
		for(Map.Entry<Integer,pair> entry:m.entrySet())
		{
			pair p=entry.getValue();
			System.out.print(p.data+" ");
		}		
	}
	
	static void bottomView(Tnode root)
	{
		TreeMap<Integer,pair> m=new TreeMap<>();
		int height=0;
		int hd=0;
		
		bottomViewUtil(root,height,hd,m);
		
		for(Map.Entry<Integer,pair> entry:m.entrySet())
		{
			pair p=entry.getValue();
			System.out.print(p.data+" ");
		}
	}
	
	static void TopViewUtil(Tnode root,int height,int hd,Map<Integer,pair> m)
	{
		if(root==null)
			return;
		
		if(!m.containsKey(hd))
		{
			m.put(hd,new pair(root.data,height));
		}
		
		else
		{
			pair p=m.get(hd);
			if(height<p.height)
			{
				m.remove(hd);
				m.put(hd,new pair(root.data,height));
			}
		}
		 TopViewUtil(root.left,height+1,hd-1,m);
		 TopViewUtil(root.right,height+1,hd+1,m);
	}
	static void bottomViewUtil(Tnode root,int height,int hd,Map<Integer,pair> m)
	{
		if(root==null)
			return;
		
		if(!m.containsKey(hd))
		{
			m.put(hd,new pair(root.data,height));
		}
		
		else
		{
			pair p=m.get(hd);
			if(height>=p.height)
			{
				m.remove(hd);
				m.put(hd,new pair(root.data,height));
			}
		}
		 bottomViewUtil(root.left,height+1,hd-1,m);
		 bottomViewUtil(root.right,height+1,hd+1,m);
	}
	
	// Level Order Traversal Can be used to print left and right view of bt
	
	static void levelOrderTraversal(Tnode root)
	{
		if(root == null)
		{
			System.out.println("Empty");
			return;
		}
		
		Queue<Tnode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int count = 0;
		while(!q.isEmpty())
		{
			if(q.peek() == null)
			{
				count++;
				if(count == 2)          // if this is second consecutive null than traversal is complete and break
					break;
				q.remove();
				System.out.println();
				q.add(null);
			}
			else {
				if(count == 1)
					count--;
				Tnode x = q.remove();
				System.out.print(x.data+" ");
				
				if(x.left != null)
					q.add(x.left);
				if(x.right != null)
					q.add(x.right);
			}
			
		}
		
	}
	
	// Left View
	
	static void leftView(Tnode root)
	{
		if(root == null)
		{
			System.out.println("Empty");
			return;
		}
		
		Queue<Tnode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		System.out.print(root.data+" ");
		int count = 0;
		while(!q.isEmpty())
		{
			if(q.peek() == null)
			{
				count++;
				if(count == 2)
					break;
				q.remove();
				q.add(null);
			}
			else {
				Tnode x = q.remove();
				if(count == 1)
				{	
					count--;
					System.out.print(x.data+" ");
				}
				if(x.left != null)
					q.add(x.left);
				if(x.right != null)
					q.add(x.right);
			}
		}
		System.out.println();
	}
	
	// Right View
	static void rightView(Tnode root)
	{
		if(root == null)
		{
			System.out.println("Empty");
			return;
		}
		
		Queue<Tnode> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int count = 0;
		while(!q.isEmpty())
		{
			if(q.peek() == null)
			{
				count++;
				if(count == 2)
					break;
				q.remove();
				q.add(null);
			}
			else {
				Tnode x = q.remove();
				if(count == 1)
					count--;
				if(q.peek() == null)
				{	
					System.out.print(x.data+" ");
				}
				if(x.left != null)
					q.add(x.left);
				if(x.right != null)
					q.add(x.right);
			}
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=bt.create();
//		VerticalOrderTraversal.printVerticalOrder(bt.root);
//
//		bottomView(bt.root);
//		levelOrderTraversal(bt.root);
		leftView(bt.root);
		rightView(bt.root);
		
	}

}
