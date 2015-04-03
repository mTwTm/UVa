// UVa 299 Train Swapping 
// Current Status: Accepted
// Last Submitted: 2015-04-03 04:58:02
// Run Time: 0.275

import java.util.Scanner;

public class Main {
	
	private void run(){
		Scanner s = new Scanner(System.in);
		int caseCount = s.nextInt();
		for(int caseNum = 0 ; caseNum < caseCount ; caseNum++)
		{
			int trainCount = s.nextInt();
			int ans = 0;
			int[] train = new int[trainCount];
			for(int i=0;i<trainCount;i++)
			{
				train[i] = s.nextInt();
				for(int j=0;j<i;j++)
				{
					if(train[j]>train[i])
						ans++;
				}
			}
			System.out.println("Optimal train swapping takes "+ans+" swaps.");
		}		
		s.close();
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
