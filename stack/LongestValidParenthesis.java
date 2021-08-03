package stack;

import java.util.Stack;

//output the length of longest valid parenthesis substring
public class LongestValidParenthesis {
	// TC : O(n)
	// SC : O(n)
	static void solve(String s)
	{
		int n = s.length();
		Stack<Integer> st = new Stack<>();
		// stack will store the index of last faulty bracket
		st.push(-1);           //IMP to calculate if complete string is valid
		int result = 0;
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i) == '(')
				st.push(i);          // this might be faulty if no close bracket ahead
			// if closing bracket
			else
			{
				if(!st.isEmpty())    // first remove open bracket if present
					st.pop();
				// update length 
				if(!st.isEmpty())
					result = Math.max(result, i - st.peek());
				else          // if stack is empty now than this is now a faulty bracket and stack can't be empty
					st.push(i);
			}
		}
		System.out.println(result);
		
	}
	
	// SC :O(1)
	static void solve1(String s)
	{
		int n = s.length();
		int open = 0;
		int close = 0;
		int result = 0;
		
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i) == '(')
				open++;
			else
				close++;
			
			if(open > close)
				open = close = 0;
			if(open == close)
			{
				result = Math.max(result, 2*close);
			}
			
		}
		System.out.println(result);
	}
                 
	public static void main(String[] args) {
		String s = "((()()()()(((())";
		String s1 = "()";
		
		solve(s1);
		solve(s);
		solve1(s);
		solve("))()()))");
		solve(")()");

	}

}
