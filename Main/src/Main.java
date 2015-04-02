// UVa 264 Count on Cantor
// Current Status: Accepted
// Last Submitted: 2015-04-02 08:34:12
// Run Time: 0.615


import java.util.Scanner;


class Main {
	
	public static void main(String[] args) {
		int[] dividend;
		int[] divisor;
		final int maxTerm = 10_000_000;		
		Scanner s;
		s = new Scanner(System.in);
		dividend = new int[maxTerm+1];
		divisor = new int[maxTerm+1];
		int i = 1;
		int j = 1;
		for(int k=1;k<maxTerm+1;k++)
		{
			dividend[k]=i;
			divisor[k]=j;
			if(2*k == (i+j-1) * (i+j))
			{
				if(i>j)
					i++;
				else
					j++;
			}
			else
			{
				if((i+j)%2==1)
				{
					i+=1;
					j-=1;
				}
				else
				{
					i-=1;
					j+=1;
				}
			}
		}
		while(s.hasNextInt())
		{
			int next = s.nextInt();
			System.out.println("TERM "+next+" IS "+dividend[next]+"/"+divisor[next]);
		}
		s.close();
	}

}