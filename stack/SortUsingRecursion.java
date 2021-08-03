package stack;

import java.util.Stack;

public class SortUsingRecursion {
	
static Stack<Integer> s = new Stack<Integer>();
	
	static void SortStack()
	{
		
		if(s.size() == 0)
			return;
		
		int x = s.pop();
		SortStack();
		
		insertAtBottom(x);
				
	}
	
	static void insertAtBottom(int x)
	{

		if(s.isEmpty())
			s.push(x);
		else
		{
			if(s.peek() > x )	   // If stack top element is bigger than element to be inserted
			{
				int a = s.pop();    // than check recursively until it is bigger than the top element
				insertAtBottom(x);
				
				s.push(a);
			}
			else
			{
				s.push(x);
			}
		}
			
	}
	

	public static void main(String[] args) {
		
		s.push(30);
		s.push(-5);
		s.push(18);
		s.push(14);
		s.push(-3);
		System.out.println(s);
		
		
		SortStack();
		
		System.out.println(s);
		
		
		

	}

}

