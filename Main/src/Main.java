// UVa 10327 Flip Sort
// Current Status: Accepted
// Last Submitted: 2016-09-16 11:40:23
// Run Time: 0.220

import java.io.*;

public class Main {

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			while( ( nextLine = r.readLine() ) != null ) {
				int length;
				// Seems to have some ill-formed lines
				try {
					length = Integer.valueOf(nextLine.trim());
				} catch (NumberFormatException ex) {
					continue;
				}
				int[] list = new int[length];
				int index = 0;
				while(index != length) {
					String[] values = r.readLine().split("\\D+");
					for (int i = 0; i < values.length; i++) {
						list[index + i] = Integer.valueOf(values[i]);
					}
					index += values.length;
				}
				int answer = 0;
				for(int i = 0 ; i < list.length ; i++) {
					for(int j = 0 ; j < i ; j++) {
						if(list[j] > list[i]) {
							answer++;
						}
					}
				}
				w.write("Minimum exchange operations : " + answer + "\n");
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
