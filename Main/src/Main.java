// UVa 543 Goldbach's Conjecture
// Current Status: Accepted
// Last Submitted: 2015-06-01 12:52:56
// Run Time: 0.853

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	private Map<Integer, Boolean> primes;
	
	private void run(){

		try{

			r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			primes = new LinkedHashMap<>();
			primes.put(2, true);
primeAdd:
			for(int i=3;i<=1_000_000;i+=2) {
				for(int nextPrime : primes.keySet()) {
					if(nextPrime>Math.sqrt(i)) {
						primes.put(i, true);
						break;
					}
					if(i%nextPrime==0)
						continue primeAdd;
				}
			}

			while( ( nextLine = r.readLine() ) != null )
			{
				int next = Integer.parseInt(nextLine);
				if(next==0)
					break;
				for(int i : primes.keySet()) {
					if(primes.containsKey(next - i))
					{
						w.write(next + " = " + i + " + " + (next-i) + "\n");
						break;
					}
				}
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
