// UVa 10921 Find the Telephone
// Current Status: Accepted
// Last Submitted: 2016-04-12 20:35:40
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
			String nextLine;
			while( ( nextLine = r.readLine() ) != null ) {
				StringBuilder sb = new StringBuilder(nextLine);
				for(int i=0 ; i<sb.length() ; i++) {
					switch (sb.charAt(i)) {
						case 'A':
						case 'B':
						case 'C':
							sb.replace(i, i+1, "2");
							break;
						case 'D':
						case 'E':
						case 'F':
							sb.replace(i, i+1, "3");
							break;
						case 'G':
						case 'H':
						case 'I':
							sb.replace(i, i+1, "4");
							break;
						case 'J':
						case 'K':
						case 'L':
							sb.replace(i, i+1, "5");
							break;
						case 'M':
						case 'N':
						case 'O':
							sb.replace(i, i+1, "6");
							break;
						case 'P':
						case 'Q':
						case 'R':
						case 'S':
							sb.replace(i, i+1, "7");
							break;
						case 'T':
						case 'U':
						case 'V':
							sb.replace(i, i+1, "8");
							break;
						case 'W':
						case 'X':
						case 'Y':
						case 'Z':
							sb.replace(i, i+1, "9");
							break;
						default:
							break;
					}
				}
				w.write(sb.toString()+"\n");
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
