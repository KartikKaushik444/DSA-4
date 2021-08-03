package trees;
// same as, In BST next pointer should point to next big value

// a variation :-
// given an array, replace every element with the least greater element on its right
// a tricky solution could be to use bst
// insert element in bst from right to left
// for each inserted element we replace it in its array by its inorder successor in BST
// worst case TC :O(n^2) can be reduced to O(nlogn)
class Node  
{ 
    int data; 
    Node left, right, next; 
   
    Node(int item)  
    { 
        data = item; 
        left = right = next = null; 
    } 
} 
   

public class PopulateInorderSuccessor {
	
	static Node next = null;
	
//	 static void populateNext(Node node)  
//	    { 
//	        // The first visited node will be the rightmost node 
//	        // next of the rightmost node will be NULL 
//	        if (node != null)  
//	        { 
//	            // First set the next pointer in right subtree 
//	            populateNext(node.right); 
//	   
//	            // Set the next as previously visited node in reverse Inorder 
//	            node.next = next; 
//	   
//	            // Change the prev for subsequent node 
//	            next = node; 
//	   
//	            // Finally, set the next pointer in left subtree 
//	            populateNext(node.left); 
//	        } 
//	    } 
	 
	 //We can avoid the use of static variables by passing reference to next as a parameter.
	 
	// A wrapper over populateNextRecur 
	    static void populateNext(Node node) { 
	  
	        // The first visited node will be the rightmost node 
	        // next of the rightmost node will be NULL 
	        populateNextRecur(node, next); 
	    } 
	  
	    /* Set next of all descendants of p by traversing them in reverse Inorder */
	    static void populateNextRecur(Node p, Node next_ref) { 
	        if (p != null) { 
	              
	           // First set the next pointer in right subtree 
	            populateNextRecur(p.right, next_ref); 
	  
	            // Set the next as previously visited node in reverse Inorder 
	            p.next = next_ref; 
	  
	            // Change the prev for subsequent node 
	            next_ref = p; 
	  
	            // Finally, set the next pointer in right subtree 
	            populateNextRecur(p.left, next_ref); 
	        } 
	    } 
	    
	    // Another way
	    static Node prev = null;
	    static void connect(Node root)
	    {
	    	if(root == null)
	    		return;
	    	
	    	connect(root.left);
	    	
	    	if(prev != null)
	    		prev.next = root;
	    	
	    	prev = root;
	    	
	    	connect(root.right);
	    	
	    }

	public static void main(String[] args) {
		 Node root = new Node(10); 
	       root.left = new Node(8); 
	        root.right = new Node(12); 
	        root.left.left = new Node(3); 
	   
	        // Populates nextRight pointer in all nodes 
	        //populateNext(root); 
	        connect(root);
	        // Let us see the populated values 
	        Node ptr = root.left.left; 
	        while (ptr != null)  
	        { 
	            // -1 is printed if there is no successor 
	            int print = ptr.next != null ? ptr.next.data : -1; 
	            System.out.println("Next of " + ptr.data + " is: " + print); 
	            ptr = ptr.next; 
	        } 

	}

}
