// UVa 105 The Skyline Problem
// Current Status: Accepted
// Last Submitted: 2015-03-23 07:07:46
// Run Time: 0.775
import java.util.Scanner;


class Main {
	
	public static void main(String[] args) {
		Scanner s;				
		s = new Scanner(System.in);
		int[] height = new int[10000];
		int rightMost = 0;
		int leftMost = 10000;
		while(s.hasNextInt())
		{
			int l = s.nextInt();
			int h = s.nextInt();
			int r = s.nextInt();
			if(r-1>rightMost)
				rightMost = r-1;
			if(l<leftMost)
				leftMost = l;
			for(int i=l;i<r;i++)
			{
				if(height[i]<h)
					height[i] = h;
			}
		}
		s.close();
		/*for(int i=leftMost;i<=rightMost;i++)
		{
			System.out.printf("%3d",i);
		}
		System.out.println();
		for(int i=leftMost;i<=rightMost;i++)
		{
			System.out.printf("%3d",height[i]);
		}
		System.out.println();*/
		
		int currHeight = -1;
		for(int i=leftMost;i<=rightMost;i++)
		{
			if(height[i]!=currHeight)
			{
				System.out.print(i);
				System.out.print(" ");
				System.out.print(height[i]);
				System.out.print(" ");
				currHeight = height[i];
			}
		}
		if(height[rightMost]!=0)
		{
			System.out.print(rightMost+1);
			System.out.print(" ");
			System.out.print(0);
		}
		System.out.println();
	}
}