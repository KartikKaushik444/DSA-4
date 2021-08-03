package stack;


import java.util.*;

public class ReverseUsingRecursion {
	static Stack<Integer> s = new Stack<Integer>();
	
	static void reverseStack()
	{
		
		if(s.size() == 0)
			return;
		
		int x = s.pop();
		reverseStack();		
		insertAtBottom(x);
				
	}
	
	static void insertAtBottom(int x)
	{

		if(s.isEmpty())
			s.push(x);
		else
		{
			int a = s.pop();
			insertAtBottom(x);
			
			s.push(a);
		}
			
	}
	

	public static void main(String[] args) {
		
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		System.out.println(s);
		
		
		reverseStack();
		
		System.out.println(s);
		
		
		

	}

}
