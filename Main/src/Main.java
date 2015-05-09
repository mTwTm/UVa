// UVa 406 Prime Cuts
// Current Status: Accepted
// Last Submitted: 2015-05-09 01:36:02
// Run Time: 1.025

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private BufferedReader r;
	private BufferedWriter w;
	private List<Integer> primes;

	private int searchSize(int N) {
		for(int i=0;i<primes.size();i++) {
			if(primes.get(i)>N)
				return i-1 + 1;
			else if(primes.get(i)==N)
				return i + 1;
		}
		return primes.size();
	}

	private void run(){

		r = new BufferedReader(new InputStreamReader(System.in));
		w = new BufferedWriter(new OutputStreamWriter(System.out));
		primes = new ArrayList<>();
		search:
		for(int i=2;i<=1000;i++) {
			for(int nextPrime : primes) {
				if(i%nextPrime == 0)
					continue search;
			}
			primes.add(i);
		}
		primes.add(0, 1);

		try{
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				String[] args = nextLine.trim().split("\\s+");
				int N = Integer.parseInt(args[0]);
				int C = Integer.parseInt(args[1]);
				int size = searchSize(N);
				int start = size - 2 * C;
				if(size%2==1)
					start += 1;
				start /= 2;
				if(start < 0)
					start = 0;
				w.write(N + " " + C + ":");
				for(int i=start ; i<=size-start-1; i++) {
					w.write(" "+primes.get(i));
				}
				w.write("\n\n");
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
