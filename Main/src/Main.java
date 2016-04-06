// UVa 11150 Cola
// Current Status: Accepted
// Last Submitted: 2016-04-06 15:02:56
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
			String nextLine;
			while( ( nextLine = r.readLine() ) != null ) {
				int full = Integer.parseInt(nextLine);
				int empty = 0;
				int sum=0;
				do {
					sum += full;
					empty += full % 3;
					full = full / 3;
					full += empty / 3;
					empty = empty % 3;
				} while(full!=0);
				if(empty==2) {
					sum++;
				}
				w.write(sum+"\n");
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
