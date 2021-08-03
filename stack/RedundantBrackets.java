package stack;

import java.util.Stack;

public class RedundantBrackets {
	
	static boolean solve(String s)
	{
		int n = s.length();
		Stack<Character> st = new Stack<>();
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i) == ')')
			{
				// direct open bracket (duplicate brackets) 
				if(st.peek() == '(')
					return true;
				boolean isOperand = false;
				while(st.peek() != '(')
				{					
					// if pop doesn't hit an operand than unwanted brackets are present
					char top = st.peek();
					if(top =='+' || top == '-' || top == '/'|| top == '*')
					{
						isOperand = true;
					}
					st.pop();
				}
				if(isOperand == false)
					return true;
				st.pop();
			}
			else
				st.push(s.charAt(i));
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(solve("((a+b))"));
		System.out.println(solve("(a+(b)/c)"));
		System.out.println(solve("(a+b*(c-d))"));

	}

}
