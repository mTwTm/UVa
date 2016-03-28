// UVa 11547 Automatic Answer
// Current Status: Accepted
// Last Submitted: 2016-03-28 14:03:06
// Run Time: 0.042

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
			int caseCount = Integer.parseInt(r.readLine());
			for(int c=0 ; c<caseCount ; c++) {
				int num = Integer.parseInt(r.readLine());
				int ans = ( num * 567 / 9 + 7492 ) * 235 / 47 - 498;
				w.write(Math.abs(ans/10)%10+"\n");
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
