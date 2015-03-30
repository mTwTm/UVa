// UVa 136 Ugly Numbers
// Current Status: Accepted
// Last Submitted: 2015-03-30 15:53:35
// Run Time: 0.175

import java.util.Scanner;


class Main {
	public static void main(String[] args) {
		int[] un;
		int first = 0;
		un = new int[1500];
		un[0] = 1;
		for(int i=1;i<1500;i++)
		{
			while(un[first]*5<=un[i-1])
			{
				first++;
			}
			int next = Integer.MAX_VALUE;
			for(int j=first;j<i;j++)
			{
				int factor = 0;
				if(un[j]*2>un[i-1])
					factor = 2;
				else if(un[j]*3>un[i-1])
					factor = 3;
				else if(un[j]*5>un[i-1])
					factor = 5;
				if(un[j]*factor<next)
					next = un[j]*factor; 
			}
			un[i]=next;
		}
		System.out.println("The 1500'th ugly number is "+un[1499]+".");
	}
}
