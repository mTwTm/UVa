// UVa 10924 Prime Words
// Current Status: Accepted
// Last Submitted: 2016-04-12 20:27:13
// Run Time: 0.030

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final int MAX_VALUE = 52 * 20;
	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			List<Integer> primes = new ArrayList<>();
			primes.add(2);
findprime:
			for(int i=3 ; i<=MAX_VALUE ; i+=2) {
				for(int nextPrime : primes) {
					if(i%nextPrime==0) {
						continue findprime;
					}
				}
				primes.add(i);
			}
			primes.add(0, 1);
			while( ( nextLine = r.readLine() ) != null ) {
				int sum = 0;
				for(int i=0 ; i<nextLine.length() ; i++) {
					int ascii = nextLine.charAt(i);
					if (ascii>='a'&&ascii<='z') {
						sum += ascii - 'a' + 1;
					} else if (ascii>='A'&&ascii<='Z') {
						sum += ascii - 'A' + 1 + 26;
					}
				}
				if( primes.contains(sum) ) {
					w.write("It is a prime word.\n");
				} else {
					w.write("It is not a prime word.\n");
				}
			}
			r.close();
			w.close();
		} catch(IOException ex) {
			//Nothing to do
		}
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
}
