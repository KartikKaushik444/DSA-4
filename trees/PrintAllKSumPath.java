package trees;


import java.util.Stack;
// This will print all path from root with a specified sum
public class PrintAllKSumPath {
	
	static int sum=0;
	static Stack<Integer> s=new Stack<Integer>();
	
	static void kSumPath(Tnode root,int k)
	{
		if(root==null)
			return;
		sum+=root.data;
		s.add(root.data);
		if(sum==k)
		{
			while(!s.isEmpty())
				System.out.print(s.pop()+" ");   // It is printing from top to bottom ,Hence path is towards root
		}                                        // To get path from root print from bottom to top OR
		kSumPath(root.left,k);                   // use vector OR deque because you have to remove from last
		kSumPath(root.right,k);
		sum=sum-root.data;
		if(!s.isEmpty())
			s.pop();
		
		
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree(1);
        bt.root=bt.create();
        kSumPath(bt.root,8);
	}

}
