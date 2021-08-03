package stack;

import java.util.Stack;

// given a postfix expression output
// 1. its evaluation
// 2. convert it into infix
// 3. convert it into prefix
public class PostfixExpression {
	
	static int operation(int v1, int v2,char optor)
	{
		if(optor == '+')
			return v1+v2;
		else if(optor == '-')
			return v1 - v2;
		else if(optor == '*')
			return v1*v2;
		else 
			return v1/v2;
	}
	static void solve(String exp)
	{
		Stack<Integer> vs = new Stack<>();
		Stack<String> is = new Stack<>();
		Stack<String> ps = new Stack<>();
		
		for(int i=0;i<exp.length();i++)
		{
			char ch = exp.charAt(i);
			
			if(Character.isDigit(ch))
			{
				vs.push(ch - '0');
				is.push(ch+"");
				ps.push(ch + "");
			}
			else
			{
				int v2 = vs.pop();
				int v1 = vs.pop();
				int val = operation(v1, v2, ch);
				vs.push(val);
				
				String iv2 = is.pop();
				String iv1 = is.pop();
				String ival = "(" + iv1 + ch + iv2 + ")";
				is.push(ival);
				
				String pv2 = ps.pop();
				String pv1 = ps.pop();
				String pval = ch + pv1 + pv2;
				ps.push(pval);
							
			}
		}
		System.out.println(vs.pop());
		System.out.println(is.pop());
		System.out.println(ps.pop());
		
	}

	public static void main(String[] args) {
		String exp  = "264*8/+3-";
		solve(exp);
		
		solve("21+3*");
	}

}
