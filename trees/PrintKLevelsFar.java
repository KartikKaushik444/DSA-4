package trees;

import java.util.ArrayList;

// print k levels away
public class PrintKLevelsFar {
	static ArrayList<Tnode> path = new ArrayList<>();
	static boolean nodeToRootPath(Tnode root, int node)
	{
		if(root == null)
			return  false;
		if(root.data == node)
		{

			path.add(root);
			return true;
		}
			
		
		boolean left = nodeToRootPath(root.left, node);
		boolean right = nodeToRootPath(root.right, node);
		
		if(left == true || right == true)
		{
			path.add(root);
			return true;
		}
		else
			return false;
		
	}
	
	static void klevelsDown(Tnode root, int k, Tnode blocker)
	{
		if(root == null || k<0 || root == blocker)
			return;
		if(k == 0)
			System.out.print(root.data+" ");
		klevelsDown(root.left, k-1, blocker);
		klevelsDown(root.right, k-1, blocker);
	}
	
	static void kLevelsAway(Tnode root, int x, int k)
	{
		nodeToRootPath(root, x);
		for(int i=0;i<path.size() && i<=k;i++)
		{
			klevelsDown(path.get(i), k-i, i==0? null:path.get(i-1));
		}
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
//        nodeToRootPath(bt.root, 37);
//        System.out.println(path);
        kLevelsAway(bt.root, 6, 2);
	}

}
