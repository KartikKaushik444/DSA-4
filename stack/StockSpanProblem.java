package stack;

import java.util.Stack;

public class StockSpanProblem {
	// variation of NGL
	static int[] SSP(int a[])
	{
		int n = a.length;
		Stack<Integer> s = new Stack<>();
		int ans[] = new int[n];
		
		for(int i = 0;i<n;i++)
		{
			if(s.isEmpty())
			{
				ans[i] = 1;
				s.push(i);               // storing indexes in stack
			}
			else if(a[s.peek()] > a[i])
			{
				ans[i] = 1;
				s.push(i);
			}
			else
			{
				while(!s.isEmpty() && a[s.peek()] <= a[i])
				{
					s.pop();
					
				}
				if(s.isEmpty())
				{
					ans[i] = i+1;
					s.push(i);
				}
				else
				{
					ans[i] = i - s.peek();
					s.push(i);
				}
				
			}
		}

		
		return ans;
	}
	

	public static void main(String[] args) {
	    int price1[] = {100, 80, 60, 70, 60, 75, 85};
	    int price2[] = {10, 4, 5, 90, 120, 80};
        int ans[] = SSP(price2);
		
		for(int i :ans)
			System.out.print(i+" ");

	}

}
// can be solved without using stack as well (solution present on gfg)
