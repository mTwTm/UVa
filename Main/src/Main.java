// UVa 344 Roman Digititis 
// Current Status: Accepted
// Last Submitted: 2015-04-04 08:51:22 
// Run Time: 0.192

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	private static final int TYPES = 5;
	private static final int UPPERBOUND = 100;
	private int[][] page;
	private int[][] ans;
	private BufferedWriter w;
	
	private void print(int num) throws IOException{
		w.write(num+": "+ans[num-1][0]+" i, "+ans[num-1][1]+" v, "+ans[num-1][2]+" x, "+ans[num-1][3]+" l, "+ans[num-1][4]+" c");
		w.newLine();
	}
	
	private void cal(){
		page = new int[UPPERBOUND][];
		ans = new int[UPPERBOUND][];
		page[0] = new int[TYPES];
		page[0][0] = 1;
		ans[0] = new int[TYPES];
		ans[0][0] = 1;
		for(int i=1;i<UPPERBOUND;i++)
		{
			ans[i] = new int[TYPES];
			page[i] = new int[TYPES];
			for(int j=0;j<TYPES;j++)
			{
				page[i][j] = page[i-1][j];
			}
			page[i][0]++;
			if((i+1)%10==4)
			{
				page[i][0] -= 3;
				page[i][1] += 1;
			}
			if((i+1)%10==5)
			{
				page[i][0] -= 2;
			}
			if((i+1)%10==9)
			{
				page[i][0] -= 3;
				page[i][1] -= 1;
				page[i][2] += 1;
			}
			if((i+1)%10==0)
			{
				page[i][0] -= 2;
			}
			if((i+1)%100==40)
			{
				page[i][2] -= 3;
				page[i][3] += 1;
			}
			if((i+1)%100==50)
			{
				page[i][2] -= 2;
			}
			if((i+1)%100==90)
			{
				page[i][2] -= 3;
				page[i][3] -= 1;
				page[i][4] += 1;
			}
			if((i+1)%100==0)
			{
				page[i][2] -= 2;
			}
			for(int j=0;j<TYPES;j++)
			{
				ans[i][j] = ans[i-1][j] + page[i][j];
			}
		}
	}
	
	private void run(){
		
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
		w = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner s = new Scanner(r);		
		cal();
		try{
			while( s.hasNextInt() )
			{
				int num = s.nextInt();
				if(num==0)
					break;
				print(num);
			}
			r.close();
			w.close();
		}
		catch(IOException ex)
		{
			//Nothing to do
		}
		
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
