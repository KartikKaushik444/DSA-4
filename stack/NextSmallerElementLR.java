package stack;

import java.util.Stack;

public class NextSmallerElementLR {
	
	static int[] NSR(int a[])
	{
		int n = a.length;
		Stack<Integer> s = new Stack<>();
		int ans[] = new int[n];
		
		for(int i = n-1; i>=0; i--)
		{
			if(s.isEmpty())
			{
				ans[i] = -1;
				s.push(a[i]);
			}
			
			else if(s.peek() < a[i])
			{
				ans[i] = s.peek();
				s.push(a[i]);
			}
			else
			{
				while(!s.isEmpty() && s.peek() >= a[i])
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
	
	static int[] NSL(int a[])
	{
		int n = a.length;
		Stack<Integer> s = new Stack<>();
		int ans[] = new int[n];
		
		for(int i = 0; i<n; i++)
		{
			if(s.isEmpty())
			{
				ans[i] = -1;
				s.push(a[i]);
			}
			
			else if(s.peek() < a[i])
			{
				ans[i] = s.peek();
				s.push(a[i]);
			}
			else
			{
				while(!s.isEmpty() && s.peek() >= a[i])
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
		
//int ans[] = NSR(arr2);
		int ans[] = NSL(arr2);
		
		for(int i :ans)
			System.out.print(i+" ");
		


	}

}
