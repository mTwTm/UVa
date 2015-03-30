// UVa 160 Factors and Factorials
// Current Status: Accepted
// Last Submitted: 2015-03-30 16:28:30 
// Run Time: 0.209

import java.util.ArrayList;
import java.util.Scanner;


class Main {
	
	public static void main(String[] args) {
		Scanner s;		
		s = new Scanner(System.in);
		ArrayList<Integer> primes = new ArrayList<Integer>();		
		boolean[] pr = new boolean[100];
		pr[2] = true;
		for(int i=3;i<pr.length;i+=2)
			pr[i] = true;
		for(int i=3;i<Math.sqrt(pr.length);i++)
		{
			for(int j=i*2;j<pr.length;j+=i)
				pr[j] = false;
		}			
		for(int i=0;i<pr.length;i++)
		{
			if(pr[i]==true)
				primes.add(i);
		}				
		int[][] factors = new int[100][];
		for(int i=0;i<100;i++)
			factors[i] = new int[25];
		factoring:
		for(int i=1;i<100;i++)
		{
			int thisNum = i;
			for(int j=0;j<25;j++)
				factors[i][j]+=factors[i-1][j];
			for(int j=0;j<25;j++)
			{				
				if(thisNum==0)
					continue factoring;
				while((thisNum+1)%primes.get(j)==0)
				{
					thisNum = (thisNum+1)/primes.get(j)-1;
					factors[i][j]++;
				}				
			}
			
		}
		while(s.hasNextInt())
		{
			int next = s.nextInt(); 
			if(next==0)
				break;
			printThree(next);
			System.out.print("! =");
			for(int i=0;i<15;i++)
				printThree(factors[next-1][i]);
			if(next>=53)
				System.out.print("\n      ");
			for(int i=15;i<25;i++)
				printThree(factors[next-1][i]);
			System.out.println();
		}
		s.close();
	}
	static void printThree(int i){
		if(i!=0)
		{
			if(i<10)
				System.out.print(" ");
			if(i<100)
				System.out.print(" ");
			System.out.print(i);
		}
	}

}