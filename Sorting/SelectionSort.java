package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int []a= {7,4,10,8,3,1};
		int n=a.length;
		for(int i=0;i<n-1;i++)            // n-1 because last place will be sorted automatically
		{
			int min=i;              //min is the index of minimum number 
			for(int j=i;j<n;j++)
			{
				if(a[j]<a[min])
				{
					min=j;
				}
			}
			
			if(min!=i)
			{
				int temp=a[i];
				a[i]=a[min];
				a[min]=temp;
			}
			
		}
		for(int i:a)
		{
			System.out.print(i+" ");
		}

	}

}
