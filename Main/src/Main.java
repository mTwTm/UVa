// UVa 10050 Hartals
// Current Status: Accepted
// Last Submitted: 2016-09-19 14:56:40
// Run Time: 0.030

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
			// skip case count
			r.readLine();
			while( ( nextLine = r.readLine() ) != null ) {
				int hartalCount = 0;
				int simLength = Integer.valueOf(nextLine.trim());
				int partyCount = Integer.valueOf(r.readLine().trim());
				int[] partyHs = new int[partyCount];
				for(int j=0;j<partyCount;j++)
				{
					partyHs[j] = Integer.valueOf(r.readLine().trim());
				}
				Arrays.sort(partyHs);
				for(int j=1;j<=simLength;j++)
				{
					boolean hartal = false;
					if(j%7==6||j%7==0)
						continue;
					for(int k=0;k<partyCount;k++)
					{
						if(j%partyHs[k]==0)
						{
							hartal = true;
							break;
						}
					}
					if(hartal)
						hartalCount++;
				}
				w.write(hartalCount+"\n");
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
