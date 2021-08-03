package trees;

import java.util.ArrayList;
import java.util.Collections;


public class BTtoBST {
	
	
	static ArrayList<Integer> arr=new ArrayList<Integer>(); 
	
	static int index = 0;
	
	static Tnode bTtoBST(Tnode root)
	{
		// first store the inorder of bt into arr
		inorder(root);
		// now sort the arr
		Collections.sort(arr);
		// do inorder traversal and replace each node's value with its inorder position
		inorder2(root);
		return root;
	}
	static void inorder(Tnode root)
	{
		if(root==null)
			return;
		inorder(root.left);
		
		arr.add(root.data);
		
		inorder(root.right);
		
	}
	
	static void inorder2(Tnode root)
	{
		if(root == null)
			return;
		inorder2(root.left);
		
		root.data = arr.get(index++);
		
		inorder2(root.right);
	}

	public static void main(String[] args) {

		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        
      bt.root=bTtoBST(bt.root);
      BinaryTree.levelOrderTraversal(bt.root);
	}

}
