package trees;

import java.util.*;

public class SpiralLevelOrderTraversal {
	
	static void spiralLevelOrderTraversal(Tnode root)
	{
		Tnode temp;
		Stack<Tnode> s1=new Stack<Tnode>();
		Stack<Tnode> s2=new Stack<Tnode>();
		s1.push(root);
	  
		do
		{			
			while(!s1.isEmpty())
			{				
				temp=s1.pop();
				System.out.print(temp.data+" ");
				if(temp.left!=null)
					s2.push(temp.left);
				if(temp.right!=null)
					s2.push(temp.right);
			}
			while(!s2.isEmpty())
			{
				temp=s2.pop();
				System.out.print(temp.data+" ");
				if(temp.right!=null)
					s1.push(temp.right);
				if(temp.left!=null)
					s1.push(temp.left);
			}
		}while(!s1.isEmpty() ||  !s2.isEmpty());
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=bt.create();
		spiralLevelOrderTraversal(bt.root);
	}

}
