// UVa 10340 All in All
// Current Status: Accepted
// Last Submitted: 2016-05-04 15:44:04
// Run Time: 0.080

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
			String nextLine;
			while( ( nextLine = r.readLine() ) != null ) {
				String[] args = nextLine.split("\\s+");
				int index0 = 0;
				for(int index1 = 0 ; index1< args[1].length() ; index1++ ) {
					if(args[1].charAt(index1) == args[0].charAt(index0)) {
						index0++;
					}
					if(index0 == args[0].length()) {
						break;
					}
				}
				if(index0 == args[0].length()) {
					w.write("Yes\n");
				} else {
					w.write("No\n");
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
