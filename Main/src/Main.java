// UVa 10161 Ant on a Chessboard
// Current Status: Accepted
// Last Submitted: 2016-09-18 08:00:00
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
				int num = Integer.parseInt(nextLine.trim());
				if(num==0) {
					break;
				}
				int base = (int) Math.sqrt(num);
				int remainder = num - base * base;
				int x = 0;
				int y = 0;
				if(base%2==0) {
					x = base + (remainder == 0 ? 0 : 1) + (remainder > base + 1 ? (-1 * (remainder - base - 1)) : 0);
					y = 1 + (remainder > 1 ? (remainder > base+1 ? base : remainder - 1) : 0);
				} else {
					y = base + (remainder == 0 ? 0 : 1) + (remainder > base + 1 ? (-1 * (remainder - base - 1)) : 0);
					x = 1 + (remainder > 1 ? (remainder > base+1 ? base : remainder - 1) : 0);
				}
				w.write(String.format("%d %d\n", x, y));
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
