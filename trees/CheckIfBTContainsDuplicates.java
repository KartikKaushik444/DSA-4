package trees;

import java.util.HashMap;
import java.util.HashSet;
// a variation of check if a binary tree is a subtree of another binary tree

// check if binary tree contains  duplicate binary tree of size 2 or more
public class CheckIfBTContainsDuplicates {
	// based on serialization and hashing
	static char Marker = 'X';
	static HashSet<String> subtrees = new HashSet<>();
	
	static String duplic(Tnode root)
	{
		String s = "";
		
		if(root == null)
			return s+Marker;
		
		// if left subtree has a duplicate subtree
		String lstr = duplic(root.left);
		if(lstr.equals(s))         // if lstr is empty means duplicate is already found
			return s;
		// similarly for right
		
		String rstr = duplic(root.right);
		if(rstr.equals(s))          // if rstr is empty
			return s;
		
		// serialise current subtree
		s = s + Integer.toString(root.data) + lstr + rstr;
		
		// if current subtree already exists in hash table than return empty string
		// IMP: size of serialized subtree with single node has length 3
		
		if(s.length() > 3 && subtrees.contains(s))
			return "";
		
		subtrees.add(s);
		return s;
	}
	
	static boolean dupSub(Tnode root)
	{
		String s = duplic(root);
		if(s.equals(""))
			return true;
		else
			return false;
	}
	
	
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
		
		if(m.get(s) != null && m.get(s) == 1)
		{
			if(root.left != null || root.right != null)
			System.out.println(root.data+" ");
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
		
		System.out.println(dupSub(bt.root));
		inorder(bt.root);
		

	}

}
