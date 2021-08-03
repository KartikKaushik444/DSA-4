package trees;

import java.util.ArrayList;

// merge two balanced binary search trees

// 1. Insert element of first tree to other 
// We can take smaller tree, and each node of that tree can be inserted into another self
// balancing bst

// 2. Merge Inorder Traversal
//    first, store inorder of both trees, merge them and create balanced bst using inorder
//    it is implemented below
// TC: O(m+n) which is better than first method   (m & n are sizes of trees)
// SC: O(m+n)

// 3. In place merging (no extra space)
//    1 - convert given BSTs into doubly linked list in place
//    2 - merge two sorted lists
//    3 - Build a balanced BST from the merged list created from step 2


public class Merge2BSTs {
	
	static void inorder(Tnode root,ArrayList<Integer> in)
	{
		if(root == null)
			return;
		inorder(root.left,in);
		in.add(root.data);
		inorder(root.right,in);
	}
	
	static void merge(ArrayList<Integer> in1, ArrayList<Integer> in2, ArrayList<Integer> a)
	{
		int i=0;
		int j=0;
		
		while(i < in1.size() && j < in2.size())
		{
			if(in1.get(i) < in2.get(j))
			{
				a.add(in1.get(i));
				i++;
			}
			else
			{
				a.add(in2.get(j));
				j++;
			}
			
		}
		while(i < in1.size())
		{
			a.add(in1.get(i));
			i++;
			
		}
		while(j < in2.size())
		{
			a.add(in2.get(j));
			j++;
			
		}
		
	
	}
	
	static Tnode solve(Tnode root1, Tnode root2)
	{
		ArrayList<Integer> in1 = new ArrayList<>();
		ArrayList<Integer> in2 = new ArrayList<>();
		
		inorder(root1, in1);
		inorder(root2, in2);
		
		ArrayList<Integer> mergeIn = new ArrayList<>();
		
		merge(in1, in2, mergeIn);
		
		System.out.println(mergeIn);
		
		Tnode root = BSTtoBalancedBST.balanceUtil(mergeIn, 0, mergeIn.size()-1);
		return root;
		
	}

	public static void main(String[] args) {
		BinaryTree bt1=new BinaryTree();
        bt1.root=bt1.create();
        
        BinaryTree bt2=new BinaryTree();
        bt2.root=bt2.create();
        
        bt1.root=solve(bt1.root, bt2.root);
        
        BinaryTree.levelOrderTraversal(bt1.root);


	}

}
