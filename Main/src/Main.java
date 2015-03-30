// UVa 151 Power Crisis 
// Current Status: Accepted
// Last Submitted: 2015-03-30 16:25:00
// Run Time: 0.212


import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		Scanner s;		
		s = new Scanner(System.in);				
		while(s.hasNextInt())
		{
			int n = s.nextInt();
			if(n==0)
				break;
			boolean[] shut = new boolean[n];
			int currentShut = 0;
			int testNum = 1;
			cal:
			while(true)
			{
				if(currentShut==12)
				{
					shut[currentShut]=true;
					for(int i=0;i<n;i++)
					{
						if(shut[i]==false)
						{
							testNum++;
							currentShut = 0;
							for(int j=0;j<n;j++)
								shut[j] = false;
							continue cal;
						}
					}
					System.out.println(testNum);
					break;
				}
				else
				{
					shut[currentShut]=true;
					for(int i=0;i<testNum;i++)
					{
						currentShut = (currentShut+1)%n;
						if(shut[currentShut]==true)
							i--;
					}
				}
			}
		}
		s.close();
	}

}