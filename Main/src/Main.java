// UVa 10420 List of Conquests
// Current Status: Accepted
// Last Submitted: 2016-05-03 14:16:55
// Run Time: 0.110

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

public class Main {

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			int lineNum = Integer.parseInt(r.readLine());
			Map<String, Integer> countries = new TreeMap<>();
			for(int i=0 ; i<lineNum ; i++) {
				String country = r.readLine().split("\\s+")[0];
				if(countries.containsKey(country)) {
					countries.put(country, countries.get(country)+1);
				} else {
					countries.put(country, 1);
				}
			}
			for(Map.Entry<String, Integer> next : countries.entrySet()) {
				w.write(next.getKey() + " " + next.getValue() + "\n");
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
