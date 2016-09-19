// UVa 10062 Tell me the frequencies!
// Current Status: Accepted
// Last Submitted: 2016-09-19 14:23:11
// Run Time: 0.060

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			boolean firstLine = true;
			while( ( nextLine = r.readLine() ) != null ) {
				if(!firstLine) {
					w.write("\n");
				}
				firstLine = false;
				Map<Integer, Integer> characterToNum = new TreeMap<>(Collections.reverseOrder());
				Map<Integer, List<Integer>> numToList = new TreeMap<>();
				for (int i = 0 ; i < nextLine.length() ; i++) {
					int character = nextLine.charAt(i);
					if(!characterToNum.containsKey(character)) {
						characterToNum.put(character, 0);
					}
					characterToNum.put(character, characterToNum.get(character)+1);
				}
				for (Map.Entry<Integer, Integer> nextEntry : characterToNum.entrySet()) {
					if(!numToList.containsKey(nextEntry.getValue())) {
						numToList.put(nextEntry.getValue(), new ArrayList<>());
					}
					numToList.get(nextEntry.getValue()).add(nextEntry.getKey());
				}
				for (Map.Entry<Integer, List<Integer>> nextFrequency : numToList.entrySet()) {
					int frequency = nextFrequency.getKey();
					for(int next : nextFrequency.getValue()) {
						w.write(String.format("%d %d\n", next, frequency));
					}
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
