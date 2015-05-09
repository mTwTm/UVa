// UVa 424 Integer Inquiry
// Current Status: Accepted
// Last Submitted: 2015-05-09 13:32:15
// Run Time: 0.238

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
			BigInteger sum = BigInteger.ZERO;
			while( ( nextLine = r.readLine() ) != null )
			{
				BigInteger next = new BigInteger(nextLine);
				if(next.equals(BigInteger.ZERO))
					break;
				sum = sum.add(next);
			}
			w.write(sum + "\n");
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
