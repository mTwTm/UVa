// UVa <ID> <Name> 
// Current Status: Accepted|Pending|TooSlow
// Last Submitted: 
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
		System.out.printf("%.3f", num);
	}
	
	private void printSigned(double num)
	{
		if(num>0)
			System.out.print("- ");
		else
			System.out.print("+ ");
		if(num>0)
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
			printSigned(h);
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
			printSigned(k);
			System.out.print(")");
		}
			System.out.print("^2 = ");
			printfix3(r);
			System.out.println("^2");
		
		System.out.print("x^2 + y^2 ");
		if(!String.format("%.3f", Math.abs(h)).equals("0.000"))
		{
			printSigned(2*h);
			System.out.print("x ");
		}
		if(!String.format("%.3f", Math.abs(k)).equals("0.000"))
		{
			printSigned(2*k);
			System.out.print("y ");
		}
		if(!String.format("%.3f", Math.abs(-h*h-k*k+r*r)).equals("0.000"))
		{
			printSigned(-h*h-k*k+r*r);
			System.out.print(" ");
		}
		else
		{
			System.out.print("+ 0.000 ")
		}
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
			double[] pointsX = new double[count];
			double[] pointsY = new double[count];
			for(int i=0;i<count;i++)
			{
				pointsX[i] = s.nextDouble();
				pointsY[i] = s.nextDouble();
			}
			// 2(x1-x2)h+2(y1-y2)k = x1^2+y1^2-x2^2-y2^2
			// 2(x1-x3)h+2(y1-y3)k = x1^2+y1^2-x3^2-y3^2
			double a1 = pointsX[0]-pointsX[1];
			double b1 = pointsY[0]-pointsY[1];
			double s1 = Math.pow(pointsX[0], 2.0)+Math.pow(pointsY[0], 2.0)-Math.pow(pointsX[1], 2.0)-Math.pow(pointsY[1], 2.0);
			double a2 = pointsX[0]-pointsX[2];
			double b2 = pointsY[0]-pointsY[2];
			double s2 = Math.pow(pointsX[0], 2.0)+Math.pow(pointsY[0], 2.0)-Math.pow(pointsX[2], 2.0)-Math.pow(pointsY[2], 2.0);
			h = (s1*b2-s2*b1)/2/(a1*b2-a2*b1); 
			k = (s1*a2-s2*a1)/2/(a2*b1-a1*b2);
			r = Math.sqrt(Math.pow(pointsX[0]-h,2)+Math.pow(pointsY[0]-k,2));
			printResult();
		}
		s.close();
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
