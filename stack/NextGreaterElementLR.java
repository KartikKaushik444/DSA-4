package stack;

import java.util.Stack;

public class NextGreaterElementLR {
	
	static int[] NGR(int a[])
	{
		int n = a.length;
		
		int ans[] = new int[n];
		
		Stack<Integer> s = new Stack<Integer>();

		
		for(int i = n-1; i>=0;i--)
		{
			if(s.empty())             // if there is no element to right of i
			{
				ans[i] = -1;
				s.push(a[i]);
			}
			else if(s.peek()> a[i])    // if the right element is greater than i element than it is NGR
			{
				ans[i]  = s.peek();
				s.push(a[i]);
				
			}
			else         // if not than pop until you find NGR
			{
				while(!s.isEmpty() && s.peek() <= a[i])
				{
					s.pop();
				}
				
				if(s.isEmpty())      // if while popping stack gets empty, then there is no NGR
				{
					ans[i] = -1;
					s.push(a[i]);
				}
				else
				{
					ans[i] = s.peek();
					s.push(a[i]);
				}
					
			}
		}
		
		return ans;
		
		
	}
	
	
	static int[] NGL(int a[])
	{
		int n= a.length;
		Stack<Integer> s = new Stack<Integer>();
		
		int ans[] = new int[n];
		
		for(int i = 0;i < n;i++)
		{
			if(s.empty())
			{
				ans[i] = -1;
				s.push(a[i]);
			}
			
			else if(s.peek() > a[i])
			{
				ans[i] = s.peek();
				s.push(a[i]);
			}
			
			else
			{
				while(!s.isEmpty() && s.peek() <= a[i])
				{
					s.pop();
				}
				
				if(s.isEmpty())
				{
					ans[i] = -1;
					s.push(a[i]);
				}
				else
				{
					ans[i] = s.peek();
					s.push(a[i]);
				}
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = {4, 5, 2 ,25};
		int arr1[] = {13, 7, 6, 12};
		int arr2[] = {1, 3, 0, 0, 2, 4};
//		int ans[] = NGR(arr2);
		int ans[] = NGL(arr2);
		
		for(int i :ans)
			System.out.print(i+" ");

	}

}
