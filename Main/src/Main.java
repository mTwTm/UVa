// UVa 10300 Ecological Premium
// Current Status: Accepted
// Last Submitted: 2016-09-16 15:52:52
// Run Time: 0.030

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
			r.readLine();
			while( ( nextLine = r.readLine() ) != null ) {
				int count = Integer.valueOf(nextLine.trim());
				long answer = 0;
				for(int i=0 ; i<count ; i++) {
					nextLine = r.readLine();
					String[] farm = nextLine.split("\\D+");
					answer += Long.valueOf(farm[0]) * Long.valueOf(farm[2]);
				}
				w.write(answer+"\n");
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
