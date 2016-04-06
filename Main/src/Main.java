// UVa 11332 Summing Digits
// Current Status: Accepted
// Last Submitted: 2016-04-06 13:48:58
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
			while(true) {
				String nextLine = r.readLine();
				if(nextLine.equals("0")) {
					break;
				} else {
					int num = Integer.parseInt(nextLine);
					while(num>=10) {
						int digitSum = 0;
						while( num> 0) {
							digitSum += num % 10;
							num /= 10;
						}
						num = digitSum;
					}
					w.write("" + num + "\n");
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
