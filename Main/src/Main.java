// UVa 256 Quirksome Squares
// Current Status: Accepted
// Last Submitted: 2015-04-02 08:29:59
// Run Time: 0.715

import java.util.Scanner;

public class Main {
	
	StringBuilder answ[];
	
	private void run(){
		answ = new StringBuilder[4];
		for(int i=0;i<4;i++)
		{
			answ[i] = new StringBuilder();
			int num = (i+1)*2;
			int upperbound = 1;
			for(int j=0;j<num/2;j++)
				upperbound *= 10;
			for(int j=0;j<upperbound;j++)
			{
				for(int k=0;k<upperbound;k++)
				{
					if((j+k)*(j+k)==j*upperbound+k)
					{
						if(num==2)
							answ[i].append(String.format("%02d", j*upperbound+k)+"\n");
						if(num==4)
							answ[i].append(String.format("%04d", j*upperbound+k)+"\n");
						if(num==6)
							answ[i].append(String.format("%06d", j*upperbound+k)+"\n");
						if(num==8)
							answ[i].append(String.format("%08d", j*upperbound+k)+"\n");
					}						
				}
			}
		}
		Scanner s = new Scanner(System.in);		
		while(s.hasNextInt())
		{			
			System.out.print(answ[s.nextInt()/2-1]);
		}
		s.close();
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
