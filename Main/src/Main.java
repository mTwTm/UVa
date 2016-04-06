// UVa 11172 Relational Operator
// Current Status: Accepted
// Last Submitted: 0.040
// Run Time: 2016-04-06 14:25:29

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
			int caseNum = Integer.parseInt(r.readLine());
			for(int i=0 ; i<caseNum ; i++) {
				String[] args = r.readLine().split("\\s+");
				int first = Integer.parseInt(args[0]);
				int second = Integer.parseInt(args[1]);
				String answer = first>second ? ">" : (first<second ? "<" : "=");
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
