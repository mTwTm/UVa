// UVa 10783 Odd Sum
// Current Status: Accepted
// Last Submitted: 2016-04-12 21:05:31
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
			int caseNum = Integer.parseInt(r.readLine());
			for(int i=0 ; i<caseNum ; i++) {
				int start = Integer.parseInt(r.readLine());
				int end = Integer.parseInt(r.readLine());
				if(start%2==0) {
					start++;
				}
				if(end%2==0) {
					end--;
				}
				int ans = start > end ? 0 : (start+end)/2 * ((end-start)/2+1);
				w.write("Case " + (i+1) + ": " + ans + "\n");
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
