package Sorting;

public class CountingSort {  //it is non-comparison sort
	static int findMax(int []a)
	{
		int max=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>max)
				max=a[i];
		}
		
		return max;
	}
	// TC: O(n + k)  where k is the max element in the array
	// SC: O(n + k)
	// performs best when k -> O(n)
	// Not efficient for n = 100 and k = 10000
	
	// to make it work for array containing negative values we must first normalize the array
	// To normalize the array we can add the minimum value of the array to each and every element 
	// in the array. That will make the all elements positive.
	// Than after sorting we can again subtract min value to get original values
	// In case of float values, when you multiply decimal part to make full integers the range
	// may be huge,in that case n may be small but k may be huge
	static void countSort(int a[])
	{
		int n = a.length;
		
		int []b=new int[n];
		int k=findMax(a);
		// create a count array which stores frequency of each element
		int []count=new int[k+1];
		for(int i=0;i<n;i++)
		{
			count[a[i]]++;
		}
		// convert it into prefix array where each index i stores the position of the last 
		// element value of i in sorted array
		for(int i=1;i<k+1;i++)
		{
			count[i]+=count[i-1];
		}
		// starting from last position to maintain stability 
		for(int i=n-1;i>=0;i--)
		{	
			b[--count[a[i]]]=a[i];
		}
		// copy into original array
		for(int i=0;i<n;i++)
		{
			a[i]=b[i];
		}
		for(int i:a)
		{
			System.out.print(i+" ");		
		}
		
	}

	public static void main(String[] args) {
		int []a= {2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
		countSort(a);
	}

}
