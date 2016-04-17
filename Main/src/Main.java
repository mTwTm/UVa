// UVa 10499 The Land of Justice
// Current Status: Accepted
// Last Submitted: 2016-04-17 13:42:55
// Run Time: 0.090

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
				long nextValue = Long.parseLong(nextLine);
				if(nextValue<0) {
					break;
				} else {
					long ans;
					if(nextValue == 1) {
						ans = 0;
					} else {
						ans = nextValue * 25;
					}
					w.write(ans+"%\n");
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
