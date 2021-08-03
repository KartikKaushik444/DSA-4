package trees;

import java.util.ArrayList;

public class PairWithSumInDiffBST {
	
	static ArrayList<Integer> arr1 = new ArrayList<>();
	static ArrayList<Integer> arr2 = new ArrayList<>();
	
	
	static void inorder(Tnode root, ArrayList<Integer> arr)
	{
		if(root == null)
			return;
		inorder(root.left, arr);
		arr.add(root.data);
		inorder(root.right, arr);	
		
	}
	
	static void  pairs(Tnode n1, Tnode n2, int sum)
	{
		inorder(n1, arr1);
		inorder(n2, arr2);
		
		int i = 0;         // will point to first index of first array
		int j = arr2.size() - 1;
		
		while(i < arr1.size() && j >= 0)
		{
			if(arr1.get(i) + arr2.get(j) < sum)
				i++;
			else if(arr1.get(i) + arr2.get(j) > sum)
				j--;
			else
			{
				System.out.println(arr1.get(i)+" "+arr2.get(j));
				i++;
				j--;
			}
		}
	}

	public static void main(String[] args) {
		
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        BinaryTree bt1=new BinaryTree();
        bt1.root=bt1.create();
        
        int sum = 10;
        
        pairs(bt.root, bt1.root, sum);

	}

}
