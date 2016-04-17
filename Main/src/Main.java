// UVa 10469 To Carry or not to Carry
// Current Status: Accepted
// Last Submitted: 0.040
// Run Time: 2016-04-17 13:51:25

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
				long a = Long.parseLong(args[0]);
				long b = Long.parseLong(args[1]);
				w.write( (a^b) + "\n");
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
