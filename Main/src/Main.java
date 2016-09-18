// UVa 10107 What is the Median?
// Current Status: Accepted
// Last Submitted: 2016-09-18 13:00:26
// Run Time: 0.100

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			PriorityQueue<Integer> head = new PriorityQueue<>(1, Collections.reverseOrder());
			PriorityQueue<Integer> tail = new PriorityQueue<>();
			int lastMedian = Integer.valueOf(r.readLine().trim());
			boolean sizeIsOdd = true;
			w.write(lastMedian+"\n");
			while( ( nextLine = r.readLine() ) != null ) {
				int next = Integer.valueOf(nextLine.trim());
				if(sizeIsOdd) {
					if(next>lastMedian) {
						head.add(lastMedian);
						tail.add(next);
					} else {
						head.add(next);
						tail.add(lastMedian);
					}
					lastMedian = (head.peek() + tail.peek())/2;
				} else {
					int leftMedian = head.peek();
					int rightMedian = tail.peek();
					if(next >= leftMedian && next <= rightMedian) {
						lastMedian = next;
					} else if (next < leftMedian){
						lastMedian = head.poll();
						head.add(next);
					} else if (next > rightMedian){
						lastMedian = tail.poll();
						tail.add(next);
					}
				}
				sizeIsOdd = !sizeIsOdd;
				w.write(lastMedian+"\n");
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
