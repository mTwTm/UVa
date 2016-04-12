// UVa 10812 Beat the Spread!
// Current Status: Accepted
// Last Submitted: 2016-04-12 20:48:51
// Run Time: 0.040

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
				int sum = Integer.parseInt(args[0]);
				int diff = Integer.parseInt(args[1]);
				if ( sum >= diff && sum %2 == diff % 2) {
					w.write("" + (sum/2+diff/2 + (sum % 2 ==0 ? 0 : 1 ) ) + " " + (sum/2-diff/2) + "\n");
				} else {
					w.write("impossible\n");
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
