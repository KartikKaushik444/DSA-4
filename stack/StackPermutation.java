package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackPermutation {
	
	static boolean solve(int in[],int o[])
	{
		int n = in.length;
		Queue<Integer> inp = new LinkedList<>();
		for(int i=0;i<n;i++)
		{
			inp.add(in[i]);
		}
		Queue<Integer> out = new LinkedList<>();
		for(int i=0;i<n;i++)
		{
			out.add(o[i]);
		}
		Stack<Integer> st= new Stack<>();
		
		
		while(!inp.isEmpty())
		{
			int e = inp.poll();
			if(e == out.peek())
			{
				out.poll();
				while(!st.isEmpty())
				{
					if(st.peek() == out.peek())
					{
						st.pop();
						out.poll();
					}
					else
						break;
				}
			}
			else
				st.push(e);	
		}
		// if after processing both input and stack are empty than return true else false
		return inp.isEmpty() && st.isEmpty();
		
		
		
	}

	public static void main(String[] args) {
		int a1[] = {1, 2, 3};
		int a2[] = {2, 1, 3};
		System.out.println(solve(a1, a2));
		
		int a3[] = {1, 2, 3};
		int a4[] = {3, 1, 2};
		System.out.println(solve(a3, a4));

	}

}
