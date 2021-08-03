package stack;

public class GetMinStack {
	
	int stack[];
	int top = -1;
	int min = Integer.MAX_VALUE;
	
	GetMinStack(int size)
	{
		stack = new int[size];		
	}
	
	public void push(int x)
	{
		if(top == -1)
		{
			stack[++top] = x;
			min = x;
		}
		else if(top == stack.length-1)
		{
			System.out.println("Stack is overflowed");
		}
		
		else
		{
			if(x >= min)
				stack[++top] = x;
			else
			{
				stack[++top] = 2*x - min;
				min = x;
			}
		}
		
		
	}

	public void pop()
	{
		if(top == -1)
			System.out.println("Stack is underflow");
		
		else
		{
			if(stack[top] > min)
				top--;
			else
			{
				min = 2*min - stack[top];

				top--;
			}
		}
	}
	
	public int getMin()
	{
		return min;
	}
	
	public void traverse()
	{
		//System.out.println();
		for(int i = top ;i>= 0;i--)
		{
			System.out.print(stack[i]+" ");
		}
	}

	public static void main(String[] args) {
		GetMinStack s = new GetMinStack(6);
		s.push(-2147483648);
		System.out.println("Min:"+s.getMin());
		s.traverse();
//		s.push(3);
//		System.out.println("Min:"+s.getMin());
//		s.traverse();
//		System.out.println();
//		s.push(5);
//		System.out.println("Min:"+s.getMin());
//		s.traverse();
//		System.out.println();
//		s.push(2);
//		System.out.println("Min:"+s.getMin());
//		s.traverse();
//		System.out.println();
//		s.push(1);
//		System.out.println("Min:"+s.getMin());
//		s.traverse();
//		System.out.println();
//		s.push(1);
//		System.out.println("Min:"+s.getMin());
//		s.traverse();
//		System.out.println();
//		s.push(-1);
//		System.out.println("Min:"+s.getMin());
//		s.traverse();
//		System.out.println();
//		s.push(38);
//		System.out.println("Min:"+s.getMin());
//		s.traverse();
//		System.out.println();
//		s.pop();
//		System.out.println("Min:"+s.getMin());
//		s.pop();
//		System.out.println("Min:"+s.getMin());
//		s.pop();
//		System.out.println("Min:"+s.getMin());
//		s.pop();
//		System.out.println("Min:"+s.getMin());
//		s.pop();
//		System.out.println("Min:"+s.getMin());
//		s.pop();
//		System.out.println("Min:"+s.getMin());
//		s.pop();
//		System.out.println("Min:"+s.getMin());
		
	}

}
