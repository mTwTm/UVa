// UVa 674 Coin Change
// Current Status: Accepted
// Last Submitted: 2015-06-02 12:23:49
// Run Time: 2.292

import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner s;
		s = new Scanner(System.in);
		final int maxInput = 7489/5;
		final int[] coins = {1,5,10,25,50};
		int[][] ways = new int[maxInput+1][coins.length];
		ways[0][0] = 1;
		ways[0][1] = 0;
		ways[0][2] = 0;
		ways[0][3] = 0;
		ways[0][4] = 0;
		for(int i=1;i<=maxInput;i++)
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
			int next = s.nextInt();
			int sum=0;
			for(int i=0;i<coins.length;i++)
			{
				sum+=ways[next/5][i];
			}
			System.out.println(sum);
		}
		s.close();
	}

}