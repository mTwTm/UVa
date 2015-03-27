// UVa 111 History Grading 
// Current Status: Accepted|Pending|TooSlow
// Last Submitted: 2015-03-27
// Run Time: 0.775
// Obviously LCS
import java.util.Scanner;

public class Main {
	private int[] ans;
	private int[] student;
	private int[][] dp;
	private int calLCS(int a, int b)
	{
		if(dp[a][b]!=-1)
			return dp[a][b];
		else
		{
			if(ans[a]==student[b])
			{				
				if(a-1>=0&&b-1>=0)
				{
					dp[a][b] = 1 + calLCS(a-1, b-1);
					return 1 + calLCS(a-1, b-1);
				}					
				else
				{
					dp[a][b] = 1;
					return 1;
				}
			}
			else
			{
				int ans1;
				int ans2;
				if(a-1>=0)
					ans1 = calLCS(a-1,b);
				else
					ans1 = 0;
				if(b-1>=0)
					ans2 = calLCS(a,b-1);
				else
					ans2 = 0;
				if(ans1>ans2)
				{
					dp[a][b] = ans1;
					return ans1;
				}
				else
				{
					dp[a][b] = ans2;
					return ans2;
				}
			}		
		}
	}
	
	public static void main(String[] args) {
		Main me = new Main();
		me.run();
	}
	
	private void run() {
		Scanner s = new Scanner(System.in);
		int length = s.nextInt();
		ans = new int [length];
		for(int i=0;i<length;i++)
			ans[s.nextInt()-1] = i;
		while(s.hasNextInt())
		{
			student = new int [length];
			for(int i=0;i<length;i++)
				student[s.nextInt()-1] = i;
			dp = new int[length][];
			for(int i=0;i<length;i++)
			{
				dp[i] = new int[length];
				for(int j=0;j<length;j++)
				{
					dp[i][j] = -1;
				}
				if(student[0]==ans[0])
					dp[0][0] = 1;
				else
					dp[0][0] = 0;
			}
			System.out.println(calLCS(length-1, length-1));
		}
		s.close();
	}
	
}
