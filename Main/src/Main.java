/*
 * Test case
 * 7.0 -5.0 -1.0 1.0 0.0 -6.0
1.0 7.0 8.0 6.0 7.0 -2.0
5 5 4 7 16 5
56 40 66 76 31 8
44 39 26 23 37 38
18 82 29 41 33 15
0 49 19 56 98 3
7 0 11 0 9 2
0 9 0 15 3 12
0.0 0.0 1.0 0.0 0.0 2.0
6.6 2.5 -4.0 -4.0 6.6 -8.0
3.7 -4.1 3.7 -1.5 1.0 1.0
9.0 -2.0 1.0 1.0 -5.0 -2.0
5.4 6.3 0.0 6.3 -7.8 -0.8
3.1 4.1 5.9 2.6 5.3 5.8
10.0 11.0 12.0 13.0 0.0 0.0
0.0 0.0 1.1 0.0 0.0 1.1
-34 23 -18 16 20 15
0 0 0 12 12 0
0 12 0 0 12 0
-143 200 -143 -100 200 200
0 0 0.0134 0.0325 0.0888 0.087787
0 0 0.00134 0.00325 0.0888 0.0087787
-42350 -800 0 0 4235 -800
7.0 -5.0 -1.0 1.0 0.0 -6.0
1.0 7.0 8.0 6.0 7.0 -2.0
5 5 4 7 16 5
56 40 66 76 31 8
44 39 26 23 37 38
18 82 29 41 33 15
0 49 19 56 98 3
7 0 11 0 9 2
0 9 0 15 3 12
0.0 0.0 1.0 0.0 0.0 2.0
6.6 2.5 -4.0 -4.0 6.6 -8.0
3.7 -4.1 3.7 -1.5 1.0 1.0
9.0 -2.0 1.0 1.0 -5.0 -2.0
5.4 6.3 0.0 6.3 -7.8 -0.8
3.1 4.1 5.9 2.6 5.3 5.8
10.0 11.0 12.0 13.0 0.0 0.0
0.0 0.0 1.1 0.0 0.0 1.1
7.0 -5.0 -1.0 1.0 0.0 -6.0
1.0 7.0 8.0 6.0 7.0 -2.0
5 5 4 7 16 5
56 40 66 76 31 8
44 39 26 23 37 38
18 82 29 41 33 15
0 49 19 56 98 3
7 0 11 0 9 2
0 9 0 15 3 12
0.0 0.0 1.0 0.0 0.0 2.0
6.6 2.5 -4.0 -4.0 6.6 -8.0
3.7 -4.1 3.7 -1.5 1.0 1.0
9.0 -2.0 1.0 1.0 -5.0 -2.0
5.4 6.3 0.0 6.3 -7.8 -0.8
3.1 4.1 5.9 2.6 5.3 5.8
10.0 11.0 12.0 13.0 0.0 0.0
0.0 0.0 1.1 0.0 0.0 1.1
-34 23 -18 16 20 15
0 0 0 12 12 0
0 12 0 0 12 0
-143 200 -143 -100 200 200
0 0 0.0134 0.0325 0.0888 0.087787
0 0 0.00134 0.00325 0.0888 0.0087787
-42350 -800 0 0 4235 -800
*/
// UVa 190 Circle Through Three Points
// Current Status: Pending: WA, I think the correct output for java is not set yet. 
// Last Submitted: 2015-04-01 17:45:22
// Run Time: 

import java.util.Scanner;

public class Main {

	private double[] pointsX;
	private double[] pointsY;
	private double h;
	private double k;
	private double r;
	private final int count = 3;
	
	private void printfix3(double num)
	{
		//Implement banker' s rounding
		if ( (num * 10000) % 10 == 5)
		{
			if ( (num * 1000) % 2 == 1)
				num = num + 0.0001;
			else
				num = num - 0.0001;
		}
		System.out.printf("%.3f", num);
	}
	
	private void printSigned(double num)
	{
		if(Math.signum(num)==1.0||Math.signum(num)==0.0)
			System.out.print("+ ");
		else
			System.out.print("- ");
		if(Math.signum(num)==1.0||Math.signum(num)==0.0)
			printfix3(num);
		else
			printfix3(num*-1);
	}
	
	private void printResult()
	{
		if(String.format("%.3f", Math.abs(h)).equals("0.000"))
		{
			System.out.print("x");
		}
		else
		{
			System.out.print("(x ");
			printSigned(-h);
			System.out.print(")");
		}
			System.out.print("^2 + ");
		if(String.format("%.3f", Math.abs(k)).equals("0.000"))
		{
			System.out.print("y");
		}
		else
		{
			System.out.print("(y ");
			printSigned(-k);
			System.out.print(")");
		}
			System.out.print("^2 = ");
			printfix3(r);
			System.out.println("^2");
		
		System.out.print("x^2 + y^2 ");
		if(!String.format("%.3f", Math.abs(h)).equals("0.000"))
		{
			printSigned(-2*h);
			System.out.print("x ");
		}
		if(!String.format("%.3f", Math.abs(k)).equals("0.000"))
		{
			printSigned(-2*k);
			System.out.print("y ");
		}
		/*if(!String.format("%.3f", Math.abs(-h*h-k*k+r*r)).equals("0.000"))
		{*/
			printSigned(h*h+k*k-((pointsX[0]-h)*(pointsX[0]-h)+(pointsY[0]-k)*(pointsY[0]-k)));
			System.out.print(" ");
		//}
		/*else
		{
			System.out.print("- 0.000 ");
		}*/
		System.out.println("= 0");
	}
	
	private void run(){
		//boolean first = true;
		Scanner s = new Scanner(System.in);
		while(s.hasNextDouble())
		{
			//if(!first)
				System.out.println();
			//first = false;
			pointsX = new double[count];
			pointsY = new double[count];
			for(int i=0;i<count;i++)
			{
				pointsX[i] = s.nextDouble();
				pointsY[i] = s.nextDouble();
			}
			// 2(x1-x2)h+2(y1-y2)k = x1^2+y1^2-x2^2-y2^2
			// 2(x1-x3)h+2(y1-y3)k = x1^2+y1^2-x3^2-y3^2
			double a1 = pointsX[0]-pointsX[1];
			double b1 = pointsY[0]-pointsY[1];
			//double s1 = pointsX[0]*pointsX[0]+pointsY[0]*pointsY[0]-pointsX[1]*pointsX[1]-pointsY[1]*pointsY[1];
			double a2 = pointsX[0]-pointsX[2];
			double b2 = pointsY[0]-pointsY[2];
			//double s2 = pointsX[0]*pointsX[0]+pointsY[0]*pointsY[0]-pointsX[2]*pointsX[2]-pointsY[2]*pointsY[2];
			double s1 = Math.pow(pointsX[0], 2.0)+Math.pow(pointsY[0], 2.0)-Math.pow(pointsX[1], 2.0)-Math.pow(pointsY[1], 2.0);
			double s2 = Math.pow(pointsX[0], 2.0)+Math.pow(pointsY[0], 2.0)-Math.pow(pointsX[2], 2.0)-Math.pow(pointsY[2], 2.0);
			h = (s1*b2-s2*b1)/2/(a1*b2-a2*b1); 
			k = (s1*a2-s2*a1)/2/(a2*b1-a1*b2);
			r = Math.sqrt((pointsX[0]-h)*(pointsX[0]-h)+(pointsY[0]-k)*(pointsY[0]-k));
			printResult();
		}
		s.close();
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
