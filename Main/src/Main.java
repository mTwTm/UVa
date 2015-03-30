// UVa 147 Dollars
// Current Status: Accepted
// Last Submitted: 2015-03-30 16:19:32
// Run Time: 1.885


import java.util.Scanner;


class Main {
	
	public static void main(String[] args) {		
		Scanner s;
		s = new Scanner(System.in);
		final int coinsGCD = 5;
		final int arraySize = 30000/coinsGCD;
		final int[] coins = {5,10,20,50,100,200,500,1000,2000,5000,10000};		
		long[][] ways = new long[arraySize+1][coins.length];		
		ways[0][0] = 1;
		ways[0][1] = 0;
		ways[0][2] = 0;
		ways[0][3] = 0;
		ways[0][4] = 0;
		ways[0][5] = 0;
		ways[0][6] = 0;
		ways[0][7] = 0;
		ways[0][8] = 0;
		ways[0][9] = 0;
		ways[0][10] = 0;
		for(int i=1;i<=arraySize;i++)
		{
			ways[i][0] = 1;
			for(int coinType=1;coinType<coins.length;coinType++)
			{
				for(int coinCount=1;coinCount*coins[coinType]<=i*5;coinCount++)
				{
					for(int l=0;l<coinType;l++)
					ways[i][coinType] += ways[i-coins[coinType]/5*coinCount][l];
				}	
			}			
		}
		while(s.hasNext())
		{
			String[] buff = s.nextLine().split("\\D");
			int next = Integer.valueOf(buff[0]+buff[1]); 
			long sum=0;
			for(int i=0;i<coins.length;i++)
			{
				sum+=ways[next/5][i];
			}
			if(next==0)
				break;
			long justificationBuff = next;
			int justification = 0;
			while(justificationBuff>=1000)
			{
				justificationBuff/=10;
				justification++;
			}
			justification = 2-justification;
			for(int i=0;i<justification;i++)
				System.out.print(" ");		
			System.out.print(next/100+".");
			if(next%100<10)
				System.out.print("0");
			System.out.print(next%100);
			justificationBuff = sum;
			justification = 0;
			while(justificationBuff>=10)
			{
				justificationBuff/=10;
				justification++;
			}
			justification = 16-justification;
			for(int i=0;i<justification;i++)
				System.out.print(" ");
			System.out.println(sum);
		}
		s.close();
	}

}