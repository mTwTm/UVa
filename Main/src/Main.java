// UVa 10954 Add All
// Current Status: Accepted
// Last Submitted: 2016-04-08 15:03:27
// Run Time: 0.180

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			while( ( nextLine = r.readLine() ) != null ) {
				int length = Integer.parseInt(nextLine);
				if(length==0) {
					break;
				}
				String[] nums = r.readLine().split("\\s+");
				PriorityQueue<Integer> numVals = new PriorityQueue<>();
				for(String next : nums) {
					numVals.add(Integer.parseInt(next));
				}
				int total = 0;
				while(numVals.size()!=1) {
					int sum = numVals.poll() + numVals.poll();
					total += sum;
					numVals.add(sum);
				}
				w.write(total+"\n");
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
