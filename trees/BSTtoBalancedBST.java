package trees;

import java.util.ArrayList;

public class BSTtoBalancedBST {
	
	static ArrayList<Integer> arr=new ArrayList<Integer>();
	
	
	static Tnode balanceUtil( ArrayList<Integer> arr, int start, int end)
	{
		if(start > end)
			return null;
		Tnode root1 = new Tnode();
		int mid = (start + end)/2;
		
		root1.data = arr.get(mid);
		
		root1.left = balanceUtil( arr, start, mid - 1);
		root1.right = balanceUtil(arr, mid + 1, end);
		
		return root1;
		
	}
	
	
	
	static Tnode balance(Tnode root)
	{
		// storing inorder in arr
		inorder(root);
		
		System.out.println(arr);
		return balanceUtil(arr, 0, arr.size() - 1);
	}
	
	static void inorder(Tnode root)
	{
		if(root==null)
			return;
		inorder(root.left);
		
		arr.add(root.data);
		
		inorder(root.right);
		
	}

	public static void main(String[] args) {
		
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        bt.root=balance(bt.root);
        BinaryTree.levelOrderTraversal(bt.root);

	}

}
