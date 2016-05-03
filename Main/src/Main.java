// UVa 10405 Longest Common Subsequence
// Current Status: Accepted
// Last Submitted: 0.060
// Run Time: 2016-05-03 15:52:53

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	private String a;
	private String b;
	private int[][] dpTable;
	private int lcs(int aIndex, int bIndex) {
		if(aIndex==a.length()||bIndex==b.length())
			return 0;
		if(dpTable[aIndex][bIndex]!=-1) {
			return dpTable[aIndex][bIndex];
		}
		boolean equal = a.charAt(aIndex) == b.charAt(bIndex);
		int val = 0;
		if (equal) {
			val = lcs(aIndex+1, bIndex+1) + 1;
		} else {
			val = Math.max(lcs(aIndex+1, bIndex), lcs(aIndex, bIndex+1));
		}
		dpTable[aIndex][bIndex] = val;
		return val;
	}

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			while( ( nextLine = r.readLine() ) != null ) {
				a = nextLine;
				b = r.readLine();
				dpTable = new int[a.length()][b.length()];
				for(int i=0 ; i<dpTable.length ; i++) {
					Arrays.fill(dpTable[i], -1);
				}
				w.write(lcs(0, 0)+"\n");
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
