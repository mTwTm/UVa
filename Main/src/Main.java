// UVa 11727 Cost Cutting
// Current Status: Accepted
// Last Submitted: 2016-03-27 07:10:42
// Run Time: 0.042

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			nextLine = r.readLine();
			int count = Integer.parseInt(nextLine);
			for(int i=0 ; i<count ; i++) {
				nextLine = r.readLine();
				String[] intStrings = nextLine.split("\\D+");
				int[] intValues = new int[3];
				for(int j = 0 ; j < 3 ; j++) {
					intValues[j] = Integer.parseInt(intStrings[j]);
				}
				Arrays.sort(intValues);
				w.write("Case " + (i+1) + ": "+intValues[1]+"\n");
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
