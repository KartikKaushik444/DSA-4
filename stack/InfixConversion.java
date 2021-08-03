package stack;

import java.util.Stack;

// convert infix to postfix and prefix

public class InfixConversion {
	
	static int precedence(char optor)
	{
		if(optor == '+')
			return 1;
		else if(optor == '-')
			return 1;
		else if(optor == '*')
			return 2;
		else 
			return 2;
	}
	
	static void solve(String exp)
	{
		Stack<String> post = new Stack<>();
		Stack<String> pre = new Stack<>();
		Stack<Character> ops = new Stack<>();
		
		for(int i=0;i<exp.length();i++)
		{
			char ch = exp.charAt(i);
			if(ch == '(')
			{
				ops.push(ch);
			}
			else if(Character.isDigit(ch))
			{
				post.push(ch + "");
				pre.push(ch + "");
			}
			else if(ch == ')')
			{
				while(ops.peek() != '(')
				{
					char op = ops.pop();
					String postv2 = post.pop();
					String postv1 = post.pop();
					String postv = postv1 + postv2 + op;
					post.push(postv);
					
					String prev2 = pre.pop();
					String prev1 = pre.pop();
					String prev = op + prev1 + prev2;
					pre.push(prev);
					
				}
				ops.pop();
			
			}    
			else   // if operator
			{
				while(!ops.isEmpty() && ops.peek() != '(' 
						&& precedence(ch) <= precedence(ops.peek()))
				{
					char op = ops.pop();
					String postv2 = post.pop();
					String postv1 = post.pop();
					String postv = postv1 + postv2 + op;
					post.push(postv);
					
					String prev2 = pre.pop();
					String prev1 = pre.pop();
					String prev = op + prev1 + prev2;
					pre.push(prev);
					
				}
				
				ops.push(ch);
			}
			
		}
		
		while(!ops.isEmpty())
		{
			char op = ops.pop();
			String postv2 = post.pop();
			String postv1 = post.pop();
			String postv = postv1 + postv2 + op;
			post.push(postv);
			
			String prev2 = pre.pop();
			String prev1 = pre.pop();
			String prev = op + prev1 + prev2;
			pre.push(prev);
			
		}
		
		System.out.println(post.pop());
		System.out.println(pre.pop());
 	}

	public static void main(String[] args) {
		String s= "2*(1-5)/3+4";
		solve(s);
		solve("1*4-(2+3)");
		

	}

}
