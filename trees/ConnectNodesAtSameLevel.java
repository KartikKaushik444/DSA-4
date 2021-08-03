package trees;

import java.util.LinkedList;
import java.util.Queue;

class Nnode
{
	int data;
	Nnode left;
	Nnode right;
	Nnode next;
	
	Nnode(int data)
	{
		this.data = data;
	}
}

public class ConnectNodesAtSameLevel {
	// Using level Order Traversal
	// TC: O(n)
	// SC: O(n)
	// this is not giving right answer for now
	static void connectNodes(Nnode root)
	{
		Queue<Nnode> q = new LinkedList<>();
		q.add(root);
		
		while(q.isEmpty())
		{
			Nnode prev = null;
			int size = q.size();
			
			while(size > 0)          // This loop will execute for a particular level
			{
				Nnode x = q.remove();
				if(prev!=null)
				{
					prev.next = x;
				}
				
				prev = null;
				
				if(x.left!=null)
					q.add(x.left);
				if(x.right != null)
					q.add(x.right);
				
				size -- ;
			}
			
		}
		
	}
	
	// Using recursive preorder
	// TC : O(n * O(nodes in a level)
	// SC : O(1)
	
	static void connect1(Nnode node)
	{
		// if root is null or root is the only node in the tree
		if(node == null || (node.left == null && node.right == null))
				return ;
		
		// making next of root as null
		node.next = null;
		
		// here node is going to point at the leftmost node of the level whose next pointer is filled
	
		while(node != null)
		{
			// curr will traverse through the level and connect its next level child nodes
			Nnode curr = node;
			
			// loop until all the nodes of the level are traversed
			while(curr != null)
			{
				
				if(curr.left != null)
				{
					// if a node has both left and right child than directly connect them
					if(curr.right != null)
					{
						curr.left.next = curr.right;
					}
					else
					{
						curr.left.next = getNextRight(curr);
					}
				}
				
				if(curr.right != null)
					curr.right.next = getNextRight(curr);
				
				// move to the next node in the same level
				curr = curr.next;
				
			}
			
			// now choosing leftmost node of next level
			
			if(node.left != null)
				node = node.left;
			else if(node.right != null)
				node = node.right;
			else
				node = getNextRight(node);
			
		}
		
	}
	
	static Nnode getNextRight(Nnode node)
	{
		Nnode temp = node.next;
		
		while(temp!=null)
		{
			if(temp.left != null)
				return temp.left;
			else if(temp.right != null)
				return temp.right;
			temp = temp.next;
		}
		return null;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	

	public static void main(String[] args) {
		Nnode root = new Nnode(10); 
		root.left = new Nnode(8); 
        root.right = new Nnode(2); 
        root.left.left = new Nnode(3); 
        root.right.right = new Nnode(90); 
        
        
        connect1(root);
        
        int a = root.next != null ?  
                root.next.data : -1; 
int b = root.left.next != null ?  
            root.left.next.data : -1; 
int c = root.right.next != null ?  
           root.right.next.data : -1; 
int d = root.left.left.next != null ?  
             root.left.left.next.data : -1; 
int e = root.right.right.next != null ?  
              root.right.right.next.data : -1; 

// Now lets print the values 
System.out.println("Following are populated nextRight pointers in "
+ " the tree(-1 is printed if there is no nextRight)"); 
System.out.println("nextRight of " + root.data + " is " + a); 
System.out.println("nextRight of " + root.left.data  
                                  + " is " + b); 
System.out.println("nextRight of " + root.right.data +  
                                      " is " + c); 
System.out.println("nextRight of " + root.left.left.data +  
                                       " is " + d); 
System.out.println("nextRight of " + root.right.right.data +  
                                        " is " + e); 

	}

}
