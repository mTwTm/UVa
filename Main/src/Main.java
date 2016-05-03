// UVa 10424 Love Calculator
// Current Status: Accepted
// Last Submitted: 2016-05-03 14:03:39
// Run Time: 0.040

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private int sumDigits(int val) {
		int ret = 0;
		while(val>0) {
			ret += val %10;
			val /= 10;
		}
		return ret;
	}

	private int sum(String s) {
		int ret = 0;
		for(int i=0 ; i<s.length() ; i++) {
			char c = s.charAt(i);
			if(c>='a' && c<= 'z') {
				ret += c - 'a' + 1;
			} else if(c>='A' && c<= 'Z') {
				ret += c - 'A' + 1;
			}
		}
		return ret;
	}

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			while( ( nextLine = r.readLine() ) != null ) {
				String a = nextLine;
				String b = r.readLine();
				int aSum = sum(a);
				int bSum = sum(b);
				while(aSum>=10) {
					aSum = sumDigits(aSum);
				}
				while(bSum>=10) {
					bSum = sumDigits(bSum);
				}
				if(aSum >= bSum) {
					w.write(String.format("%.2f %%\n",(float)bSum/aSum*100));
				} else {
					w.write(String.format("%.2f %%\n",(float)aSum/bSum*100));
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
