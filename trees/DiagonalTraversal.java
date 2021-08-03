package trees;

import java.util.*;

public class DiagonalTraversal {
	
	// one way is that we can assign d+1 to left side and d to right side and use map as in vertical 
	// order traversal
	
	// below is the method using queue
	static void diagonalTraversal(Tnode root)
	{
		Queue<Tnode> q=new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty())
		{
			Tnode temp=q.poll();
			if(temp==null)            // Means one level is completed
			{
				System.out.println();    
				q.add(null);          // To recognize next level
				if(q.peek()==null)
					break;
			}
			// traverse the diagonal
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
				// add left child in queue for another diagonal
				if(temp.left!=null)
					q.add(temp.left);
				temp=temp.right;
			}
		}
			
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=bt.create();
		diagonalTraversal(bt.root);

	}

}
