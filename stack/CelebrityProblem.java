package stack;

import java.util.Stack;

public class CelebrityProblem {
	
	static int mat[][]= {
			{0,1,1,1},
			{0,0,0,0},
			{0,1,0,1},
			{0,1,0,0}
	};
	
	static boolean knows(int a, int b)
	{
		if(mat[a][b]==1)
			return true;
		else
			return false;
	}
	
	static int findCelebrityStack(int n)
	{
		
		Stack<Integer> s= new Stack<>();
		for(int i=0;i<n;i++)
		{
			s.push(i);
		}
		
		while(s.size()>1)
		{
			int a=s.pop();
			int b=s.pop();
			
			if(knows(a,b) && !knows(b,a))
			{
				// if a knows b and b doesn't know a than b might be celebrity		
				s.push(b);
			}
			
			else if(knows(b,a) && !knows(a,b))
			{
				s.push(a);
			}
			
		}
		
		int c=s.pop();
		// finally checking if c is celebrity or not
	
		int c1=0, c2=0;
		for(int i=0;i<n;i++)
		{
			if(knows(c,i))
				c1+=1;
			else if(knows(i,c))
				c2+=1;
		}
		
		if(c1 != 0 || c2!=n-1)               // means c is not celebrity
			return -1;
		else
			return c;
		
		
	}
	
	static int findCelebrity2pointer(int n)
	{
		int i=0;
		int j=n-1;
		while(i<j)
		{
			if(knows(i,j))
				i++;
			else
				j--;
		}
		int c=i;
		
		int c1=0, c2=0;
		for(int k=0;k<n;k++)
		{
			if(knows(c,k))
				c1+=1;
			else if(knows(k,c))
				c2+=1;
		}
		
		if(c1 != 0 || c2!=n-1)               // means c is not celebrity
			return -1;
		else
			return c;
		
	}

	public static void main(String[] args) {
		
		System.out.println(findCelebrityStack(4));
		System.out.println(findCelebrity2pointer(4));
		

	}

}
