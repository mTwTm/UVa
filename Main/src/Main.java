// UVa 10696 f91
// Current Status: Accepted
// Last Submitted: 2016-04-13 03:27:57
// Run Time: 0.180

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			while(true) {
				int next = Integer.parseInt(r.readLine());
				if( next == 0 ) {
					break;
				} else {
					if( next >= 101 ) {
						w.write("f91(" + next + ") = " + (next-10) + "\n");
					} else {
						w.write("f91(" + next + ") = " + 91 + "\n");
					}
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
