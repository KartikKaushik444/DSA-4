package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// iterative inorder, preorder and postorder traversal
public class IterativeTreeTraversal {
	// in iterative approach we need to store the nodes so that we can use them later when required
	// according to the traversal approach
	
	// Left Root Right
	static List < Integer > inorderTraversal(Tnode root) {
        List < Integer > res = new ArrayList < > ();
        
        
        Stack < Tnode > stack = new Stack < > ();
        Tnode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.data);
            curr = curr.right;
        }
        System.out.println(res);
        return res;
    }
	
	// ROOT Left Right
	static List <Integer> preorderTraversal(Tnode root) {
        List <Integer> res = new ArrayList < > ();
  
        Stack <Tnode> stack = new Stack < > ();
        Tnode curr = root;
       
        while(curr != null || !stack.isEmpty())
        {
        	while(curr != null)
        	{
        		res.add(curr.data);
        		stack.push(curr);
        		curr = curr.left;
        	}
        	curr = stack.pop();
        	curr = curr.right;
        }
        System.out.println(res);
        return res;
    }

	//Left Right Root
	// postorder is used to delete the tree.
	// It is also used to get postfix expression of the tree
	
	// It is bit trickier than  inorder and preorder because we need to visit root node twice
	// first to get to right side and than after completing right side
	
	// Using two stacks
	// idea is to reverse postorder and store it in the stack and than print it
	// Reverse postorder - Root Right Left

	static List<Integer> postorder(Tnode root)
	{
		 List <Integer> res = new ArrayList <> ();
		  
	     Stack <Tnode> stack = new Stack <> ();
	     
	     Stack <Integer> rev = new Stack <> ();
	     Tnode curr = root;
	     while(curr != null || !stack.isEmpty())
	     {
	    	 while(curr != null)
	    	 {
	    		 rev.add(curr.data);
	    		 
	    		 stack.push(curr);
	    		 curr = curr.right;
	    	 }
	    	 curr = stack.pop();
	    	
	    	 curr = curr.left;
	     }
	     
	    
	     while(!rev.isEmpty())
	    	 res.add(rev.pop());
	     
	     System.out.println(res);
	     return res;
	}
	
	// Using one stack
	// This can be done by storing state of node
	
	static class Pair
	{
		Tnode root;
		int state;
		
		Pair(Tnode root, int state)
		{
			this.root = root;
			this.state = state;
		}
		
	}
	static List <Integer> postorderTraversal(Tnode root) {
        List <Integer> res = new ArrayList < > ();
  
        Stack <Pair> stack = new Stack < > ();
        Tnode curr = root;
       
        while(curr != null || !stack.isEmpty())
        {
        	while(curr != null)
        	{
        		stack.push(new Pair(curr, 1));
        		curr = curr.left;
        	}
        	Pair x = stack.pop();
        	if(x.state == 1)
        	{
        		stack.push(new Pair(x.root, 2));
        		curr = x.root.right;
        	}
        	else
        	{
        		res.add(x.root.data);
        	}
      
        }
        System.out.println(res);
        return res;
    }
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree(1);
        bt.root=bt.create();
        
        inorderTraversal(bt.root);
        preorderTraversal(bt.root);
        postorderTraversal(bt.root);
        postorder(bt.root);
	}

}
