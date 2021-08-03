package trees;

// morris inorder traversal

// Application or variation
// Find the median of BST in O(n) time and O(1) space
// For odd nodes, median = (n+1)/2 th node
// For even nodes, median = (n/2 th node + (n+1)/2th node) /2 
// simple idea can be to use inorder traversal and use idea of kth smallest node in bst using O(1) space
// not allowed to use recursion bcoz of stack size
// so morris inorder traversal can be used

// Implementation
// count no of nodes in bst using mit
// perform mit again by taking count
// if even nodes are present than take a prev pointer as well for another node


public class MorrisTraversal {
	
	static void morrisInorder(Tnode root) 
    { 
        Tnode current, pre; 
  
        if (root == null) 
            return; 
  
        current = root; 
        while (current != null) { 
            if (current.left == null) { 
                System.out.print(current.data + " "); 
                current = current.right; 
            } 
            else { 
                /* Find the inorder predecessor of current */
                pre = current.left; 
                while (pre.right != null && pre.right != current) 
                    pre = pre.right; 
  
                /* Make current as right child of its inorder predecessor */
                // means we are visiting this node first time
                if (pre.right == null) { 
                    pre.right = current; 
                    current = current.left; 
                } 
  
                /* Revert the changes made in the 'if' part to restore the  
                    original tree i.e., fix the right child of predecessor*/
                else { 
                    pre.right = null; 
                    System.out.print(current.data + " "); 
                    current = current.right; 
                } /* End of if condition pre->right == NULL */
  
            } /* End of if condition current->left == NULL*/
  
        } /* End of while */
    } 
	
	public static void main(String args[]) 
	{
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        morrisInorder(bt.root);        
		
	}

}
