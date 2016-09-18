// UVa 10110 Light, more light
// Current Status: Accepted
// Last Submitted: 2016-09-18 08:51:42
// Run Time: 0.110

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private final static int LARGEST_PRIME_NEEDED = 1<<16;

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			while( ( nextLine = r.readLine() ) != null ) {
				long num = Long.valueOf(nextLine.trim());
				if(num==0) {
					break;
				}
				long root = (long)Math.sqrt(num);
				w.write(root*root==num ? "yes\n" : "no\n");
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
