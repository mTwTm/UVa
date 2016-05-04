// UVa 10370 Above Average
// Current Status: Accepted
// Last Submitted: 2016-05-04 15:19:56
// Run Time: 0.070

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
				int[] scores = new int[Integer.parseInt(args[0])];
				int sum = 0;
				for(int j=0 ; j<args.length-1 ; j++) {
					scores[j] = Integer.parseInt(args[j+1]);
					sum+=scores[j];
				}
				int average = sum / scores.length;
				int count=0;
				for(int j=0 ; j<scores.length ; j++) {
					if(scores[j] > average) {
						count++;
					}
				}
				w.write(String.format("%.3f%%\n",100f*count/scores.length));
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
