package trees;

public class KthLargestInBST {
	
	// The idea is to do reverse inorder traversal and count the nodes
	// Time complexity:O(h+k)
	static int count = 0;
	
	static void reverseInorder(Tnode root, int k)
	{
		if(root == null)
			return;
		reverseInorder(root.right,k);
		count++;
		if(count == k)
			System.out.println(root.data);
		reverseInorder(root.left,k);
	}
	
	static void kLargest(Tnode root, int k)
	{
		count = 0;
		reverseInorder(root, k);
	}

	public static void main(String[] args) {
		
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        for(int k = 1;k<=7;k++)
        	kLargest(bt.root, k);
        
        

	}

}
