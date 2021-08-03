package stack;

import java.util.Stack;

// given a prefix expression convert it into infix and postfix and evaluate its value as well

public class PrefixExpression {
	
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
		
		for(int i=exp.length()-1;i>=0;i--)        //imp
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
				int v1 = vs.pop();     //IMP
				int v2 = vs.pop();
				int val = operation(v1, v2, ch);
				vs.push(val);
				
				String iv1 = is.pop();
				String iv2 = is.pop();
				String ival = "(" + iv1 + ch + iv2 + ")";
				is.push(ival);
				
				String pv1 = ps.pop();
				String pv2 = ps.pop();
				String pval =  pv1 + pv2 + ch;
				ps.push(pval);
							
			}
		}
		System.out.println(vs.pop());
		System.out.println(is.pop());
		System.out.println(ps.pop());
		
	}


	public static void main(String[] args) {
		String exp  = "-+2/*6483";
		solve(exp);


	}

}
