package trees;

import java.util.Stack;
// Iterates in inorder fashion
class BSTit
{
	private Stack<Tnode> st = new Stack<>() ;
	
	BSTit(Tnode root)
	{
		Tnode curr = root;
		while(curr!=null)
		{
			st.push(curr);
			curr = curr.left;
		}
	}
	
	// Function to return current element iterator is  pointing to
	Tnode curr()
	{
		return st.peek();
	}
	
	// Function to iterate to next element of bst
	void next()
	{
		Tnode curr = st.peek().right;
		st.pop();
		while(curr!=null)
		{
			st.push(curr);
			curr = curr.left;
		}
		
	}
	
	// Function to check if stack is empty
	boolean isEnd()
	{
		return st.isEmpty();
	}
	
	// function to iterate to every element using iterator
	void iterator(BSTit it)
	{
		while(!it.isEnd())
		{
			System.out.print(it.curr().data + " ");
			it.next();
		}
	}
}
public class BSTIterator {

	public static void main(String[] args) {
		Tnode root = new Tnode(5); 
	    root.left = new Tnode(3); 
	    root.right = new Tnode(7); 
	    root.left.left = new Tnode(2); 
	    root.left.right = new Tnode(4); 
	    root.right.left = new Tnode(6); 
	    root.right.right = new Tnode(8); 
	  
	    // Iterator to BST 
	    BSTit it = new BSTit(root); 
	  
	    // Function to test iterator 
	   it.iterator(it);
	  

	}

}
