package trees;

import java.util.Stack;

// state 1 : pre, s++, left
// state 2 : in, s++, right
// state 3 : post, pop

class OPair
{
	Tnode root;
	int state;
	public OPair(Tnode root,int state)
	{
		this.root = root;
		this.state = state;
	}
}

public class IterativePreInPostOrder {
	
	
	static void solve(Tnode root)
	{
		Stack<OPair> s= new Stack<>();
		s.push(new OPair(root, 1));
		String pre = "";
		String in = "";
		String post = "";
		
		while(!s.isEmpty())
		{
			OPair top = s.peek();
			if(top.state == 1)
			{
				pre += top.root.data +" ";
				top.state++;
				
				if(top.root.left != null)
					s.push(new OPair(top.root.left, 1));
			}
			else if(top.state == 2)
			{
				in += top.root.data + " ";
				top.state++;
				
				if(top.root.right != null)
					s.push(new OPair(top.root.right, 1));
			}
			else
			{
				post += top.root.data +" ";
				s.pop();
			}
		}
		
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
	}

	public static void main(String[] args) {
		BinaryTree bt=new BinaryTree();
        bt.root=bt.create();
        solve(bt.root);

	}

}
