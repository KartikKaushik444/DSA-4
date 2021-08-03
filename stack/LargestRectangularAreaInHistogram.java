package stack;

import java.util.Stack;

public class LargestRectangularAreaInHistogram {
	
	static int maxArea(int []hist)
	{
		int max = 0;
		Stack <Integer> s = new Stack<Integer>();    // For storing indices
		if(hist.length == 0)
			return 0;
	
		for(int i=0;i<hist.length;i++)
		{
			if(s.empty() || hist[i] >= hist[s.peek()])
				s.push(i);
			
			else
			{
				
				int top = s.peek();
				//System.out.println(s);
				s.pop();
				//System.out.println(s);
				
				System.out.println("Max Index: "+ i);	
				System.out.println(s);
				//System.out.println(s.empty());
				
				//System.out.println((s.empty() ? i: i-s.peek() - 1));
				// For calculating area due to this bar
				int areaBar = hist[top] * (s.empty() ? i: i-s.peek() - 1);     // That's why storing indices and not value
				System.out.println("Max Area: "+ areaBar);	
				// Check for max area 
				if(max < areaBar) {
					max = areaBar;
					//System.out.println("Max Area: "+ max);	
					}
			}
			
		}
			
		System.out.println("Max Area: "+ max);	
			// Popping remaining bars from the stack and calculating area by individual bar
		
		int i = hist.length;
			while(!s.isEmpty())
			{
				int top = s.peek();
				s.pop();
				int areaBar = hist[top] * (s.empty() ? i: i-s.peek() - 1); 
				System.out.println("Max Area: "+ max);	
				if(max < areaBar) {
					max = areaBar;
					//System.out.println("Max Area: "+ max);		
				}
				
				
			}
			
		
		
		return max;
	}
	// Using nsl && nsr
	static int mah(int hist[])
	{
		int n = hist.length;
		int nsl[] = NSL(hist);             // stores indexes not value
		int nsr[] = NSR(hist);

		
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<n;i++)
		{
			
				int left = nsl[i];
				int right = nsr[i];

				if(nsr[i] == -1)
				{
					right = n;
				}

			int width = (right - left) - 1;
			int area = hist[i] * width;
			
			max = Math.max(max, area);
		}
		return max;
		
	}
	
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
				s.push(i);
			}
			
			else if(a[s.peek()] < a[i])
			{
				ans[i] = s.peek();
				s.push(i);
			}
			else
			{
				while(!s.isEmpty() && a[s.peek()] >= a[i])
				{
					s.pop();
				}
				if(s.isEmpty())
				{
					ans[i] = -1;
					s.push(i);
				}
				else
				{
					ans[i] = s.peek();
					s.push(i);
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
				s.push(i);
			}
			
			else if(a[s.peek()] < a[i])
			{
				ans[i] = s.peek();
				s.push(i);
			}
			else
			{
				while(!s.isEmpty() && a[s.peek()] >= a[i])
				{
					s.pop();
				}
				if(s.isEmpty())
				{
					ans[i] = -1;
					s.push(i);
				}
				else
				{
					ans[i] = s.peek();
					s.push(i);
				}
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		
		int hist[] = {6, 2, 5, 4, 5, 1, 6};
//		System.out.println(maxArea(hist));
		System.out.println(mah(hist));
		
		int a[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(mah(a));
		
	}

}
