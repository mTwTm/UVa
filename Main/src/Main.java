// UVa 11530 SMS Typing
// Current Status: Accepted
// Last Submitted: 2016-03-28 14:19:38
// Run Time: 0.038

import java.io.*;

public class Main {

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			int caseCount = Integer.parseInt(r.readLine());
			for(int c=0 ; c<caseCount ; c++) {
				String nextLine = r.readLine();
				int sum = 0;
				for(int i=0 ; i<nextLine.length() ; i++) {
					switch (nextLine.charAt(i)) {
						case 'a':
						case 'd':
						case 'g':
						case 'j':
						case 'm':
						case 'p':
						case 't':
						case 'w':
						case ' ':
							sum+=1;
							break;
						case 'b':
						case 'e':
						case 'h':
						case 'k':
						case 'n':
						case 'q':
						case 'u':
						case 'x':
							sum+=2;
							break;
						case 'c':
						case 'f':
						case 'i':
						case 'l':
						case 'o':
						case 'r':
						case 'v':
						case 'y':
							sum+=3;
							break;
						case 's':
						case 'z':
							sum+=4;
							break;
					}
				}
				w.write("Case #" + (c+1) + ": " + sum + "\n");
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
