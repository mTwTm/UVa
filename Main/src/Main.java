// UVa 10346 Peter's Smokes
// Current Status: Accepted
// Last Submitted: 2016-05-04 15:28:16
// Run Time: 0.040

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
			String nextLine;
			while( ( nextLine = r.readLine() ) != null ) {
				String[] args = nextLine.split("\\s+");
				int completeCigaretteCount = Integer.parseInt(args[0]);
				int buttNeededForComplete = Integer.parseInt(args[1]);
				int buttCigaretteCount = 0;
				int sum=0;
				do {
					sum += completeCigaretteCount;
					buttCigaretteCount += completeCigaretteCount % buttNeededForComplete;
					completeCigaretteCount = completeCigaretteCount / buttNeededForComplete;
					completeCigaretteCount += buttCigaretteCount / buttNeededForComplete;
					buttCigaretteCount = buttCigaretteCount % buttNeededForComplete;
				} while(completeCigaretteCount!=0);
				w.write(sum+"\n");
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
