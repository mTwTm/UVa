// UVa 10642 Can You Solve It?
// Current Status: Accepted
// Last Submitted: 2016-04-13 12:41:14
// Run Time: 0.080

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private long computeValue(long x, long y) {
		return (x+y+1)*(x+y)/2 + x;
	}

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			int caseNum = Integer.parseInt(r.readLine());
			for( int i = 0 ; i < caseNum ; i++ ) {
				String[] args = r.readLine().split("\\s+");
				long sourceX = Integer.parseInt(args[0]);
				long sourceY = Integer.parseInt(args[1]);
				long targetX = Integer.parseInt(args[2]);
				long targetY = Integer.parseInt(args[3]);
				long sourceValue = computeValue(sourceX, sourceY);
				long targetValue = computeValue(targetX, targetY);
				w.write("Case " + ( i+1 ) + ": " + (targetValue-sourceValue) + "\n" );
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
