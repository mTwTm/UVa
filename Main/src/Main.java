// UVa 10929 You can say 11
// Current Status: Accepted
// Last Submitted: 2016-04-12 20:07:27
// Run Time: 0.190

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			while(true) {
				String nextLine = r.readLine().trim();
				BigInteger b = new BigInteger(nextLine);
				if(b.equals(BigInteger.ZERO)) {
					break;
				}
				if(b.mod(BigInteger.valueOf(11)).equals(BigInteger.ZERO)) {
					w.write(nextLine + " is a multiple of 11.\n");
				} else {
					w.write(nextLine + " is not a multiple of 11.\n");
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
