package trees;

import java.util.HashMap;

public class FindDuplicateSubtrees {
	
	static HashMap<String, Integer> m = new HashMap<>();
	
	static String inorder(Tnode root)
	{
		if(root == null)
			return "";
		String s = "(";

		s+=inorder(root.left);
		s+=Integer.toString(root.data);
		s+=inorder(root.right);
		s+=")";
		// using hashmap instead of hashset because we want to print multiple dulicates only once
		if(m.get(s) != null && m.get(s) == 1)   // duplicate found
		{
			System.out.print(root.data+" ");
		}
		
		if(m.containsKey(s))
		{
			m.put(s,  m.get(s) + 1);
		}
		else
			m.put(s, 1);
		
		return s;
	}

	public static void main(String[] args) {
		
		BinaryTree bt=new BinaryTree(1);
        bt.root=bt.create();
        inorder(bt.root);
//        for(String s: m.keySet())
//        {
//        	System.out.println(s + m.get(s));
//        }

	}

}
