package Sorting;
//import Sorting.CountingSort;

public class RadixSort {
// we apply counting sort on every digit from lsb to msb
// TC: O(d*(n+k))  where d is the max number of digits in the max number in the array
	static void radixSort(int a[])
	{
		int n=a.length;
		int max=CountingSort.findMax(a);
		for(int pos=1;max/pos>0;pos*=10)
		{
			countSort(a,n,pos);
		}
		for(int i:a)
		{
			System.out.print (i+" ");
		}
	}
	static void countSort(int []a,int n,int pos)
	{
		// count array for digits(0..9)
		int []count=new int[10];
		int []b=new int[10];
		// =>3247/100=>32%10 = 2 which is 100th place value of the number
		// To find the place value p of n
		// (n/p)%10
		for(int i=0;i<n;i++)
		{
			count[(a[i]/pos)%10]++;
		}
		for(int i=1;i<10;i++)
		{
			count[i]+=count[i-1];
		}
		
		for(int i=9;i>=0;i--)
		{
			b[--count[(a[i]/pos)%10]]=a[i];
		}
		for(int i=0;i<n;i++)
		{
			a[i]=b[i];
		}
	}
	

	public static void main(String[] args) {
		int []a= {432,8,530,90,88,231,11,45,677,199};
		radixSort(a);
	}

}
