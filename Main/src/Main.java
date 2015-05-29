// UVa 530 Binomial Showdown
// Current Status: Accepted
// Last Submitted: 2015-05-29 05:17:43
// Run Time: 0.178

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	private BufferedReader r;
	private BufferedWriter w;

	private void run(){

		r = new BufferedReader(new InputStreamReader(System.in));
		w = new BufferedWriter(new OutputStreamWriter(System.out));

		try{
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				String[] args = nextLine.trim().split("\\s+");
				int N = Integer.parseInt(args[0]);
				int M = Integer.parseInt(args[1]);
				if(N==0&&M==0)
					break;
				int smallerM = N-M<M ? N-M : M;
				BigInteger count = BigInteger.ONE;
				for(int i=0;i<smallerM;i++)
					count = count.multiply(BigInteger.valueOf(N-i));
				for(int i=0;i<smallerM;i++)
					count = count.divide(BigInteger.valueOf(i + 1));
				w.write(count.toString() + "\n");
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