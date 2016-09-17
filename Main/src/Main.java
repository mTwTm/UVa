// UVa 10195 The Knights Of The Round Table
// Current Status: Accepted
// Last Submitted: 2016-09-17 15:19:12
// Run Time: 0.180

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
				String[] lengthStrings = nextLine.trim().split("\\s+");
				double a = Double.valueOf(lengthStrings[0]);
				double b = Double.valueOf(lengthStrings[1]);
				double c = Double.valueOf(lengthStrings[2]);
				double s = (a+b+c)/2;
				double radius;
				if(s!=0) {
					radius = Math.sqrt(s * (s - a) * (s - b) * (s - c)) / s;
				} else {
					radius = 0;
				}
				w.write(String.format("The radius of the round table is: %.3f\n", radius));
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