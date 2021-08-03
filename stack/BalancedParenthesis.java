 package stack;

import java.util.Stack;

public class BalancedParenthesis {
	
	static boolean isBalanced(String ex)
	{
		// if length of exp is odd than return false
		// This condition is very important because without this condition the code will give true for this
		// case: "({)})"
		if(ex.length() % 2 !=0)
			return false;
		Stack<Character> s = new Stack<>();
		int n = ex.length();
		int i = 0;
		
		while(i<n)
		{
			if(s.isEmpty())
			{
				if(ex.charAt(i) == ')' ||ex.charAt(i) == '}' ||ex.charAt(i) == ']')
					return false;
				else
				{
					s.push(ex.charAt(i));
				}
			}
			else
			{
				if(ex.charAt(i) == '(' ||ex.charAt(i) == '{' ||ex.charAt(i) == '[')
					s.push(ex.charAt(i));
				else
				{
					if(ex.charAt(i) == ')' && s.peek() == '(')
					{
						s.pop();
					}
					else if(ex.charAt(i) == '}' && s.peek() == '{')
					{
						s.pop();
					}
					else if(ex.charAt(i) == ']' && s.peek() == '[')
					{
						s.pop();
					}
					else 
						return false;
				}
			}
			i++;
			
		}
		
		if(s.isEmpty())
			return true;
		else
			return false;
	}
	
	

	public static void main(String[] args) {
		
//		String exp = "[()]{}{[()()]()}";
//		String exp1 = "({)})";
//		System.out.println(isBalanced(exp));
//		System.out.println(isBalanced(exp1));
		System.out.println(isBalanced("([}}])"));

	}

}
