package trees;
// return true if the given linked list is present in the binary tree.
// List will always be present in vertically downward direction moving either to left or right side
// of a node

class LNode{
	int data;
	LNode next;
	LNode(int d)
	{
		data=d;
		next=null;
	}
	LNode()
	{ }
	
}
public class LinkedListInBT {

	static boolean solve(LNode curr, LNode head, Tnode root)
	{
		if(root == null)
			return false;
		System.out.println(curr.data + " "+head.data + " "+root.data  );
		
		if(root.data == curr.data)
		{
			if(curr.next == null)  // if last node of list is found than return true
				return true;
			if(solve(curr.next, head, root.left) || solve(curr.next, head, root.right))
				return true;
		}
		
		
		
		if(root.data == head.data && curr != head)  // might be starting of required path
		{
			if(head.next == null)
				return true;
			if(solve(head.next, head, root.left) || solve(head.next, head, root.right));
				return true;
		}
		
		else
		{
			return solve(head, head, root.left) || solve(head, head, root.right);
		}
	}
	
	static boolean isPresent(LNode head, Tnode root)
	{
		return solve(head, head, root);
	}
	
	public static void main(String[] args) {
		
		LNode l1 = new LNode(1);
		l1.next = new LNode(3);
		l1.next.next = new LNode(3);
		l1.next.next.next = new LNode(4);
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        
        System.out.println( isPresent(l1, bt.root));
	}

}
