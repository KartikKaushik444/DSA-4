package trees;

import java.util.Vector;

public class PrintAllRootToLeafPath {
	
	static Vector<Integer> v=new Vector<Integer>();
	
	static void AllPaths(Tnode root)
	{
		if(root==null)
			return;
		v.add(root.data);
		
		if(root.left==null && root.right ==null)         // if it is a leaf node than print
		{	
			for(int i=0;i<v.size();i++)
			{
				System.out.print(v.get(i)+" ");
			}
			System.out.println();
		}
		
		AllPaths(root.left);
		AllPaths(root.right);
		if(v.size()!=0)
			v.remove((v.size()-1));
		
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        AllPaths(bt.root);

	}

}
