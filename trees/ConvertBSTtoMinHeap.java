package trees;

import java.util.ArrayList;

public class ConvertBSTtoMinHeap {
// idea is to store inorder traversal of bst in array which will be sorted
	// than do preorder traversal of tree and fill the nodes while traversing according to
	// values
	
	// TC:O(n)
	// SC:O(n)
	
	// How to do it in place i.e SC: O(1) ????????????
	static void convert(Tnode root)
	{
		ArrayList<Integer> inorder = new ArrayList<>();
		inorder(root, inorder);
		System.out.println(inorder);
		preorder(root, inorder);
		
		travPre(root);
		System.out.println();
	}
	
	static void inorder(Tnode root, ArrayList<Integer> list)
	{
		if(root == null)
			return;
		inorder(root.left, list);
		list.add(root.data);
		inorder(root.right, list);
	}
	
	static void preorder(Tnode root, ArrayList<Integer> list)
	{
		if(root == null)
			return;
		
		root.data = list.get(0);
		list.remove(0);
		
		preorder(root.left, list);
		preorder(root.right, list);
	}
	
	static void travPre(Tnode root)
	{
		if(root == null)
			return;
		System.out.print(root.data+" ");
		travPre(root.left);
		travPre(root.right);
	}
	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree(1);
        bt.root=bt.create();
        
        convert(bt.root);

	}

}
