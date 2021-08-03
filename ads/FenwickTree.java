package ads;
// in fenwick array it is imortant to have one based indexing
public class FenwickTree {
	
	// TC : O(n)
	static int[] process(int a[])
	{
		int farr[] = new int[a.length];
		int prefix[] = new int[a.length];
		
		for(int i=1;i<a.length;i++)
		{
			prefix[i] = prefix[i-1] + a[i];
		}
		
		for(int i=1;i<a.length;i++)
		{
			int iprev = i - (i & -i);
			farr[i] = prefix[i] - prefix[iprev];
		}
		
		return farr;
	}
	
	
	// TC : O(nlogn)
	static int[] preprocess(int a[])
	{
		// here array has one based indexing
		int farr[] = new int[a.length];
		
		for(int i=1;i<farr.length;i++)
		{
			update(farr, i, a[i]);
		}
		
		return farr;
	}
	
	
	// TC : O(logn)
	static int prefixSum(int farr[], int idx)
	{
		int sum = 0;
		
		while(idx > 0)
		{
			sum += farr[idx];
			idx -= (idx & -idx);         // subtracting rsb from idx
		}
		return sum;
	}
	
	// O(logn)
	static void update(int farr[], int idx, int delta)      // here delta means change in original value
	{
		while(idx < farr.length)
		{
			farr[idx] += delta;
			idx += (idx & -idx);
		}
	}
	// O(logn)
	static int query( int farr[], int l, int r)
	{
		
		return prefixSum(farr, r) - prefixSum(farr, l-1);
	}

	public static void main(String[] args) {
		int a[] = {0, 4,6, 2, 56, 3,5};   // one based indexing
		int farr[] = preprocess(a);
		
		farr = process(a);
		
		for(int i=0;i<farr.length;i++) {
			System.out.print(farr[i]+" ");
		}
		System.out.println();
		
		System.out.println(query(farr, 2, 5));
		System.out.println(query(farr, 1, 6));
		System.out.println(query(farr, 6, 6));
		
		update(farr, 4, -50);
		

		System.out.println(query(farr, 2, 5));
		System.out.println(query(farr, 1, 6));
		System.out.println(query(farr, 6, 6));
		
		
	}

}
