package Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int count = 0;
		int []a= {5,4,10,1,6,2};
		
		int n=a.length;
		for(int i=1;i<n;i++)
		{
			int temp=a[i];
			int j=i-1;
			while(j>=0&&a[j]>temp)
			{
				a[j+1]=a[j];
				count++;
				j--;
			}
			a[j+1]=temp;
		}
		for(int i:a)
		{
			System.out.print(i+" ");
		}
		System.out.println(count);

	}

}
