package Sorting;

public class MergeSort {
	
	static void merge(int []a, int start, int end)
	{
		int mid = (start+end)/2;
		
		int p[] = new int[a.length];
		
		int i = start;
		int j = mid+1;
		int k = start;
		
		while(i <= mid && j<=end)
		{
			if(a[i] < a[j])
			{
				p[k] = a[i];
				i++;
				k++;
			}
			else
			{
				p[k] = a[j];
				j++;
				k++;
			}
		}
		
		while(i<=mid)
		{
			p[k] = a[i];
			i++;
			k++;
		}
		
		while(j<=end)
		{
			p[k] = a[j];
			j++;
			k++;
		}
		
		
		for(int s=start; s<=end;s++)
		{
			a[s] = p[s];
		}
	}
	
	static void mergeSort(int []a, int start, int end)
	{
		if(start >= end)                // Imp: >= for handling boundary conditions 
			return;
		
		int mid = (start + end)/2;
	
		mergeSort(a, start, mid);
		mergeSort(a, mid+1, end);
		
		merge(a, start, end);

		
	}
	public static void main(String[] args) {
	//	int []a1= {38, 27, 43, 3, 9, 82, 10};
		int a1[] = {11, 3, 16, 356,29, 84, -47};

		mergeSort(a1, 0, a1.length - 1);
		for(int i:a1)
		{
			System.out.print(i+" ");
		}

	}

}
