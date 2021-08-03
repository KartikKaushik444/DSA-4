package stack;

import java.util.Stack;

// the operator would be of only one digit
// for same precedence left one will be solved first
// +,- < *,/ 
public class InfixEvaluation {
	
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
		Stack<Integer> opnds = new Stack<>();
		Stack<Character> optors = new Stack<>();
		
		for(int i=0;i<exp.length();i++)
		{
			char ch = exp.charAt(i);
			if(ch == '(')
			{
				optors.push(ch);
			}
			else if(Character.isDigit(ch))
			{
				opnds.push(ch - '0');
			}
			else if(ch == ')')
			{
				while(optors.peek() != '(')
				{
					char optor = optors.pop();
					int v2 = opnds.pop();
					int v1 = opnds.pop();
					int opv = operation(v1, v2, optor); 
					opnds.push(opv);
				}
				optors.pop();
			
			}     // if operator
			else
			{
				while(!optors.isEmpty() && optors.peek() != '(' 
						&& precedence(ch) <= precedence(optors.peek()))
				{
					char optor = optors.pop();
					int v2 = opnds.pop();
					int v1 = opnds.pop();
					int opv = operation(v1, v2, optor); 
					opnds.push(opv);
				}				
				optors.push(ch);
			}
		}
		
		while(optors.size() != 0)
		{
			char optor = optors.pop();
			int v2 = opnds.pop();
			int v1 = opnds.pop();
			int opv = operation(v1, v2, optor); 
			opnds.push(opv);
		}
		
		System.out.println(opnds.peek());
		
	}

	public static void main(String[] args) {
		String exp= "2+3*6";
		solve(exp);
	}

}
