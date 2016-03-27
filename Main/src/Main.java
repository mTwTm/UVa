// UVa 11586 Train Tracks
// Current Status: Accepted
// Last Submitted: 2016-03-27 09:17:04
// Run Time: 0.042

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private int[] count = new int[4];
	private static final String[] types = {"FF", "FM", "MF", "MM"};

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			nextLine = r.readLine();
			int caseCount = Integer.parseInt(nextLine);
			for(int i=0 ; i<caseCount ; i++) {
				count = new int[4];
				nextLine = r.readLine();
				for(String s : nextLine.split("\\s+")) {
					for(int j=0 ; j<types.length ; j++) {
						if(types[j].equals(s)) {
							count[j]++;
						}
					}
				}
				int sum = count[0] + count[1] + count[2] + count[3];
				boolean isFFMMpaired = count[0] == count[3];
				if(sum==1 || !isFFMMpaired) {
					w.write("NO LOOP\n");
				} else {
					w.write("LOOP\n");
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
