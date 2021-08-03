package stack;
import java.util.*;

public class stackUsingQueue {
	
	Queue<Integer> q1=new LinkedList();
	Queue<Integer> q2=new LinkedList();
	int capacity;
	stackUsingQueue()
	{
		capacity=0;
	}
	

	 void push(int d)
	{
		 q1.add(d);
		 System.out.println(d+" is pushed ionto  the stack");
		 capacity++;
	}
	 
	 void pop()
	 {
		 if (capacity==0)
			 System.out.println("Queue is underflow");
		 else 
		 {		while(q1.size()!=1)
			 {
				 q2.add(q1.remove());
			 }
			 
			 System.out.println("Popped element is "+q1.remove());
			 
			 Queue<Integer> q=new LinkedList();
			 q=q1;                   // swapping q1 and q2
			 q1=q2;
			 q2=q;
			 capacity--;
		 }
	 }

	public static void main(String[] args) {
		
		stackUsingQueue q=new stackUsingQueue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		q.push(5);
		
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.pop();
		q.pop();

	}

}
