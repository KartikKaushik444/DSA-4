package trees;

import java.util.Stack;

public class BTfromBracketRepresentation {
	
	static int findBrack(String s, int i, int j)
	{
		if(i >  j)
			return -1;
		Stack<Character> st = new Stack<>();
		for(int p = i;p<=j;p++)
		{
			if(s.charAt(p) == '(')
				st.push(s.charAt(p));
			else if(s.charAt(p) == ')')
			{
				if(st.peek() == '(')
				{
					st.pop();
					if(st.isEmpty())
						return p;
				}
				
			}
		}
		return -1;
		
	}
	
	static Tnode solve(String s, int i, int j)
	{
		if(i > j)
			return null;
		Tnode root = new Tnode(s.charAt(i) - '0');
		int index = -1;
		// if next char is '(' than find the complimentary  ')'
		if(i+1 <= j && s.charAt(i+1) == '(')
			index = findBrack(s, i+1, j);
		
		
		if(index == -1)    // means it is leaf node (IMP)
			return root;
		
		root.left = solve(s, i+2, index - 1);
		root.right = solve(s, index + 2, j-1);
		
		return root;
		
		
	}

	public static void main(String[] args) {
		String s = "4(2(3)(1))(6(5))";
		Tnode root = solve(s, 0, s.length()-1);
		BinaryTree.preorder(root);
		System.out.println();
		String s1 = "1(2)(3)";
		Tnode root1 = solve(s1, 0, s1.length()-1);
		BinaryTree.preorder(root1);

	}

}
