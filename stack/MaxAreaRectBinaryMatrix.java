package stack;

import java.util.Stack;

public class MaxAreaRectBinaryMatrix {
	
	// variation of maximum area histogram
	
	static int MaxArea(int a[][])
	{
		int n = a.length;                  // rows
		int m = a[0].length;              // columns
		
		int max = LargestRectangularAreaInHistogram.mah(a[0]);
		int temp[] = a[0];
		for(int i = 1;i<n; i++)
		{
			for(int j =0 ;j<m;j++)
			{
				if(a[i][j] == 0)
					temp[j] = 0;
				else
					temp[j] += 1;
			}
			max = Math.max(max, LargestRectangularAreaInHistogram.mah(temp));
		}
		return max;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	// Another method
	
	static int solve(int[][] matrix) {
        final int C = matrix[0].length;   // total columns
        
        int[] dp = new int[C];           // this will store height of histogram at a particular level
        
        int res = 0;
        Stack<int[]> stack = new Stack<>();
        for (int[] row : matrix)
        {
            for (int c = 0; c != C; c++)
            {
                dp[c] = row[c] == 0 ? 0 : dp[c] + 1;
//            	for(int i=0;i<C;i++)
//            	{
//            		System.out.print(row[i]+" m hoo ");
//            	}
//            	System.out.println();
//            	if(row[c] == 0)
//            		dp[c] = 0;
//            	else
//            		dp[c] = dp[c]+1;
                System.out.println("dp[c] "+c+" "+dp[c] );
                int earliest = c;
                
                while (stack.isEmpty() == false && stack.peek()[1] >= dp[c])
                {
               
                    int[] prev = stack.pop();
                    earliest = prev[0];
                    //System.out.println(c+" "+res);
                    System.out.println(" PrevRes: "+c+" "+res+" "+prev[0]+" "+prev[1]  );
                    res = Math.max(res, (c - prev[0]) * prev[1]);
                    System.out.println("res "+c+" "+res);
                }
                System.out.println("Pushed "+c+" "+earliest+" "+dp[c]);
                stack.push(new int[] {earliest, dp[c]});
                
            }
            while (stack.isEmpty() == false)
            {
                int[] prev = stack.pop();
                res = Math.max(res, (C - prev[0]) * prev[1]);
            }
        }
        return res;
    }

	public static void main(String[] args) {
		int a[][] = {
				{0, 1, 1, 0},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 0, 0},
				
		};
		System.out.println(MaxArea(a));
		
		System.out.println(solve(a));
//final int C = a[0].length;   // total columns
//        
//        int[] dp = new int[C];           // this will store height of histogram at a particular level
//        
//        int res = 0;
//               for (int[] row :a)
//               {
//		            for (int c = 0; c != C; c++)
//		            {
//		            	
//		            	System.out.print(row[c]+" m hoo ");
//		            	
//		            }
//		            System.out.println();
//               }
		int a1[][] = {
				{0, 1, 1},
				{1, 1, 1},
				{0, 1, 1},
		};		
		System.out.println(MaxArea(a1));
		System.out.println(solve(a1));

	}

}
