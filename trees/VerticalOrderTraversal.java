package trees;

import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;
// the idea is to give hd-1 to left side and hd+1 to right side and print all nodes containing same
// hd as in same vertical order (hd -> horizontal distance)
public class VerticalOrderTraversal {
	
	static void printVerticalOrder(Tnode root)
	{
		TreeMap<Integer,Vector<Integer>> m=new TreeMap<>();
		int hd=0;
		getVerticalOrder(root,hd,m);
		
		for(Entry<Integer,Vector<Integer>> entry:m.entrySet())
		{
			System.out.println(entry.getValue());
		}
	}
	
	static void getVerticalOrder(Tnode root,int hd,TreeMap<Integer,Vector<Integer>> m)
	{
		if(root==null)
			return;
		Vector<Integer> get=m.get(hd);
		
		if(get==null)
		{
			get=new Vector<>();
			get.add(root.data);
		}
		else
			get.add(root.data);
		m.put(hd,get);
		
		getVerticalOrder(root.left,hd-1,m);
		getVerticalOrder(root.right,hd+1,m);
		
	}
	
//	static void printVerticalOrder(Tnode root)
//	{
//		HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
//		int hd = 0;
//		getVerticalOrder(root,hd,m);
//		
//		for(int key :m.keySet())
//		{
//			System.out.println(m.get(key));
//		}
//	}
//	
//	
//	
//	static void getVerticalOrder(Tnode root,int hd,HashMap<Integer,ArrayList<Integer>> m)
//	{
//		if(root==null)
//			return;
//		
//		if(m.containsKey(hd))
//		{
//			m.get(hd).add(root.data);
//		}
//		else
//		{
//			ArrayList<Integer> arr = new ArrayList<>();
//			arr.add(root.data);
//			m.put(hd, arr);
//		}
//		
//		getVerticalOrder(root.left,hd-1,m);
//		getVerticalOrder(root.right,hd+1,m);
//	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
		bt.root=bt.create();
		printVerticalOrder(bt.root);

	}

}
