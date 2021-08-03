package Sorting;

public class QuickSort {
	
	static int partition(int []a,int lb,int ub)
	{
		int pivot=a[lb];
		int start=lb;
		int end=ub;
		while(start<end)
		{
			while(start < ub && a[start]<=pivot) 
				start++;
			while(end > lb && a[end]>pivot)
				end--;
			if(start<end)
			{
				int temp=a[start];
				a[start]=a[end];
				a[end]=temp;
			} //  swap(a[start],a[end]);

		}
		
		
		{	int temp=a[lb];
			a[lb]=a[end];
			a[end]=temp;
		}//  swap(a[lb],a[end]);      basically swapping pivot with end
		  
		 
		return end;
	}
	
	static void quickSort(int []a,int lb,int ub)
	{
		int lock=partition(a,lb,ub);
		if(lock!=lb)
		quickSort(a,lb,lock-1);
		if(lock!=ub)
		quickSort(a,lock+1,ub);
		
	}

	public static void main(String[] args) {
		
        int []a= {100,90,80,70,60,40,50,30,20,10};
        int n= a.length;
        quickSort(a,0,n-1);
        for(int i:a)
        {
        	System.out.print(i+" ");
        }         
	}

}
