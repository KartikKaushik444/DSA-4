package Sorting;
import java.util.*;
//import javafx.util.Pair;     


// idea is to first sort the array and than converting sorted array to input array by swapping
public class MinSwapsToSort {
	static class Pair
	{
		int val;
		int in;
		Pair(int val, int in)
		{
			this.val = val;
			this.in = in;
		}
	}
	static void solve(int a[])
	{
		int n = a.length;
		ArrayList<Pair> arr = new ArrayList<>();
		for(int i=0;i<n;i++)
		{
			arr.add(new Pair(a[i],i));
		}
		
		arr.sort(new Comparator<Pair>()
				{
					@Override
					public int compare(Pair o1, Pair o2) {
						
						return o1.val - o2.val;
					}
			
				}
				);
		// converting the sorted array to the array provided
		int swaps = 0;
		for(int i=0;i<n;i++)
		{
			if(arr.get(i).in == i)       // if element is at right place
				continue;
			else
			{
				// swap
				int index = arr.get(i).in;
				Pair temp = arr.get(i);
				arr.set(i, arr.get(index));
				arr.set(index, temp);
				
				swaps++;
				// check this index again
				i--;
				 
				
			}
		}
		System.out.println(swaps);
	}

	public static void main(String[] args) {
		int a[] = {1, 5, 4, 3, 2};
		solve(a);
		
		int a1[] = {4, 3, 2,1};
		solve(a1);
		
		int a2[] = {1, 2, 3, 4, 5};
		solve(a2);
		
		int a3[] = {5, 4, 2, 3, 1};
		solve(a3);

	}

}
