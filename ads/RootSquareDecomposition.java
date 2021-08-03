package ads;

import java.util.Arrays;
import java.util.Scanner;
// if more update than queries than sqrt decomposition is superior than prefix sum
// to find minimum value in a range

// preprocessing -> O(n)
// to process q queries -> O(q sqrt(n))
// to update -> O(1)
// at most we will have to taverse first block or last block, other than that all answers
// will be stored in sqrt array
public class RootSquareDecomposition {
	
	static int[] preprocess(int a[])
	{
		int len = (int)Math.ceil(Math.sqrt(a.length));
		int []sqrt = new int[len];
		Arrays.fill(sqrt, Integer.MAX_VALUE);
		
		for(int i=0;i<a.length;i++)
		{
			int sqrtidx = i/len;   // to map index of original array with the sqrt array
			sqrt[sqrtidx] = Math.min(sqrt[sqrtidx], a[i]);
		}
		
		return sqrt;
	}
	
	
	static int getmin(int a[], int sqrt[], int l, int r)
	{
		int len = sqrt.length;
		int ans = Integer.MAX_VALUE;
		
		while(l <= r)
		{
			if(l % len == 0 && l + len-1 <= r)
			{
				// if it is the starting of the box and we will need all the values inside
				// the box than simply use sqrt array
				ans = Math.min(sqrt[l/len], ans);
				
				// now skip this box
				l = l + len;
			}
			else
			{
				// sqrt array can't be used, so use original array
				ans = Math.min(ans, a[l]);
				l++;
			}
			
			
		}
		
		return ans;
	}
	
	static void update(int a[], int[] sqrt, int i, int x)
	{
		int len = sqrt.length;
		a[i] = x;
		sqrt[i/len] = Math.min(a[i], sqrt[i/len]);
	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int a[]= new int[n];
//		for(int i=0;i<n;i++)
//		{
//			a[i] = sc.nextInt();
//		}
//		
//		int sqrt[] = preprocess(a);
//		// now take queries to find min in the array
//		int q = sc.nextInt();
//		while(q-- > 0)
//		{
//			int l = sc.nextInt();
//			int r = sc.nextInt();
//			
//			System.out.println(getmin(a, sqrt, l, r));
//		}
//
//		
//		sc.close();
		
		int a[] = {1, 4, 6, 2, -12, 9, 6};
		int sqrt[] = preprocess(a);
		
		System.out.println(getmin(a, sqrt, 2, 5));
		update(a, sqrt, 3, -15);
		System.out.println(getmin(a, sqrt, 2, 5));
		
	}

}
