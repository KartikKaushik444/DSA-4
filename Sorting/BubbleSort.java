package Sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int []a= {15,16,6,8,5};
		int n=a.length;
		for(int i=0;i<n-1;i++)          // n-1 because last position will sort automatically
		{
			int flag=0;
			for(int j=0;j<n-1-i;j++)
			{
				if(a[j]>a[j+1])
				{
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
					flag=1;
				}
			}
			if(flag!=1)
				break;
		}
		for(int i:a)
		{
			System.out.print(i+" ");
		}

	}

}
