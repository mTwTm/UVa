// UVa 11462 Age Sort
// Current Status: Accepted
// Last Submitted: 2016-03-29 13:04:01
// Run Time: 0.719

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static int MAX_AGE = 99;

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			while(true) {
				nextLine = r.readLine();
				int totalPeople = Integer.parseInt(nextLine);
				if(totalPeople == 0) {
					break;
				}
				int[] ageCount = new int[MAX_AGE+1];
				nextLine = r.readLine();
				String[] ages = nextLine.split("\\s+");
				for(int i=0 ; i<totalPeople ; i++) {
					ageCount[Integer.parseInt(ages[i])]++;
				}
				StringBuilder answer = new StringBuilder();
				for(int i=1 ; i<=MAX_AGE ; i++) {
					for(int j=0 ; j<ageCount[i] ; j++) {
						answer.append(i).append(" ");
					}
				}
				answer.replace(answer.length()-1, answer.length(), "");
				w.write(answer.toString()+"\n");
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
