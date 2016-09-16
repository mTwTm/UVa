// UVa 10222 Decode the Mad man
// Current Status: Accepted
// Last Submitted: 2016-09-16 15:57:50
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
				StringBuilder sb = new StringBuilder(nextLine);
				for(int i = 0 ; i<sb.length() ; i++) {
					switch(sb.charAt(i))
					{
						case '}':
						case ']':
							sb.setCharAt(i, 'p');
							break;
						case '"':
						case '\'':
							sb.setCharAt(i, 'l');
							break;
						case '?':
						case '/':
							sb.setCharAt(i, ',');
							break;
						case '>':
						case '.':
							sb.setCharAt(i, 'm');
							break;
						case ':':
						case ';':
							sb.setCharAt(i, 'k');
							break;
						case '{':
						case '[':
							sb.setCharAt(i, 'o');
							break;
						case 'P':
						case 'p':
							sb.setCharAt(i, 'i');
							break;
						case 'L':
						case 'l':
							sb.setCharAt(i, 'j');
							break;
						case '<':
						case ',':
							sb.setCharAt(i, 'n');
							break;
						case 'M':
						case 'm':
							sb.setCharAt(i, 'b');
							break;
						case 'K':
						case 'k':
							sb.setCharAt(i, 'h');
							break;
						case 'O':
						case 'o':
							sb.setCharAt(i, 'u');
							break;
						case 'I':
						case 'i':
							sb.setCharAt(i, 'y');
							break;
						case 'J':
						case 'j':
							sb.setCharAt(i, 'g');
							break;
						case 'N':
						case 'n':
							sb.setCharAt(i, 'v');
							break;
						case 'B':
						case 'b':
							sb.setCharAt(i, 'c');
							break;
						case 'H':
						case 'h':
							sb.setCharAt(i, 'f');
							break;
						case 'U':
						case 'u':
							sb.setCharAt(i, 't');
							break;
						case 'Y':
						case 'y':
							sb.setCharAt(i, 'r');
							break;
						case 'G':
						case 'g':
							sb.setCharAt(i, 'd');
							break;
						case 'V':
						case 'v':
							sb.setCharAt(i, 'x');
							break;
						case 'C':
						case 'c':
							sb.setCharAt(i, 'z');
							break;
						case 'F':
						case 'f':
							sb.setCharAt(i, 's');
							break;
						case 'T':
						case 't':
							sb.setCharAt(i, 'e');
							break;
						case 'R':
						case 'r':
							sb.setCharAt(i, 'w');
							break;
						case 'D':
						case 'd':
							sb.setCharAt(i, 'a');
							break;
						case 'E':
						case 'e':
							sb.setCharAt(i, 'q');
							break;
					}
				}
				w.write(sb.toString()+"\n");
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
