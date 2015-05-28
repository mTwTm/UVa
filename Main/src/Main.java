// UVa 495 Fibonacci Freeze
// Current Status: Accepted
// Last Submitted: 2015-05-28 07:53:21
// Run Time: 1.466

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	private List<BigInteger> freeze = new ArrayList<>(5000);
	
	private void run(){
		
		r = new BufferedReader(new InputStreamReader(System.in)); 
		w = new BufferedWriter(new OutputStreamWriter(System.out));
	
		try{
			String nextLine;
			freeze.add(BigInteger.ZERO);
			freeze.add(BigInteger.ONE);
			int count = 2;
			while(count<=5000) {
				freeze.add(freeze.get(count-1).add(freeze.get(count-2)));
				count++;
			}
			while( ( nextLine = r.readLine() ) != null )
			{
				int next = Integer.parseInt(nextLine);
				w.write("The Fibonacci number for " + next  + " is " + freeze.get(next)+"\n");
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
