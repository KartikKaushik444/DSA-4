package stack;

public class MyStack {
	static int top=-1;
	
	static void push(int []stack,int d)
	{
		int n=stack.length;
		if(top==n-1)
			System.out.println("Stack is overflowed");
		else
		{
			stack[++top]=d;
		}
			
			
	}
	
	
	static int pop(int []stack)
	{
		if(top==-1) {
			System.out.println("Stack is underflow");
			return Integer.MIN_VALUE;
		}
		else
		{
			System.out.println("Popped element is "+stack[top]);
			top--;
			return stack[top+1];
		}
	}
	
	static int peek(int []stack)
	{
		System.out.println(stack[top]);
		return stack[top];
	}
	
	static void traverse(int []stack)
	{
		for(int i=top;i>=0;i--)
		{
			System.out.print(stack[i]+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int []stack=new int[5];
		
		push(stack,1);
		push(stack,2);
		push(stack,3);
		push(stack,4);
		push(stack,5);
		push(stack,6);
		traverse(stack);
        pop(stack);
        pop(stack);
        pop(stack);
        pop(stack);
        pop(stack);
        pop(stack);
	}

}
