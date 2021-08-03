package stack;

public class RainWaterTrapping {
	
	static int solve(int a[])
	{
		int n = a.length;
		
		int maxl[] = new int[n];
		int maxr[] = new int[n];
		
		int max = a[0];
		maxl[0] = a[0];
		for(int i = 1;i<n;i++)
		{
			max = Math.max(max, a[i]);
			maxl[i] = max;
		}
		max = a[n-1];
		maxr[n-1] = a[n-1];
		for(int i = n-2; i>=0; i--)
		{
			max = Math.max(max, a[i]);
			maxr[i] = max;
		}
		
		int water = 0;
		for(int i = 0; i<n;i++)
		{
			water += Math.min(maxl[i], maxr[i]) - a[i];
		}
		
		return water;
	}

	public static void main(String[] args) {
		int a[] = {3, 0, 0, 2, 0, 4};
		int a1[] = {2, 0, 2};
		int a2[] = {3, 0, 2, 0, 4};
		int a3[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int a4[] = { 3, 5};
		int a5[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(solve(a4));
System.out.println(solve(a5));
	}

}

// refer gfg for other approaches
