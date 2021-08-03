package trees;

import java.util.ArrayList;

public class CountBSTNodesInRange {
	
	static int count = 0;
	static ArrayList<Integer> arr= new ArrayList<>();
	
	static void countNodes(Tnode root, int start, int end)
	{
		if(root == null)
			return;
		
		if(root.data >= start && root.data <= end)
		{
			arr.add(root.data);
			count++;
			countNodes(root.left, start, end);
			countNodes(root.right, start, end);
		}
		
		if(root.data < start)
		{
			countNodes(root.right, start, end);
		}
		
		if(root.data > end)
		{
			countNodes(root.left, start, end);
		}
			
	}

	public static void main(String[] args) {

		
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        countNodes(bt.root, 5, 45);
        System.out.println(count);
        System.out.println(arr);

	}

}
