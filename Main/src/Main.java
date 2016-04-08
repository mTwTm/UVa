// UVa 10970 Big Chocolate
// Current Status: Accepted
// Last Submitted: 2016-04-08 14:29:49
// Run Time: 0.500

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
				String[] nums = nextLine.split("\\s+");
				int a = Integer.parseInt(nums[0]);
				int b = Integer.parseInt(nums[1]);
				w.write( (a*b - 1) + "\n" );
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
