// UVa 10082 WERTYU
// Current Status: Accepted
// Last Submitted: 2016-09-18 13:54:20
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
						case '1':
							sb.setCharAt(i, '`');
							break;
						case '2':
							sb.setCharAt(i, '1');
							break;
						case '3':
							sb.setCharAt(i, '2');
							break;
						case '4':
							sb.setCharAt(i, '3');
							break;
						case '5':
							sb.setCharAt(i, '4');
							break;
						case '6':
							sb.setCharAt(i, '5');
							break;
						case '7':
							sb.setCharAt(i, '6');
							break;
						case '8':
							sb.setCharAt(i, '7');
							break;
						case '9':
							sb.setCharAt(i, '8');
							break;
						case '0':
							sb.setCharAt(i, '9');
							break;
						case '-':
							sb.setCharAt(i, '0');
							break;
						case '=':
							sb.setCharAt(i, '-');
							break;
						case 'W':
							sb.setCharAt(i, 'Q');
							break;
						case 'E':
							sb.setCharAt(i, 'W');
							break;
						case 'R':
							sb.setCharAt(i, 'E');
							break;
						case 'T':
							sb.setCharAt(i, 'R');
							break;
						case 'Y':
							sb.setCharAt(i, 'T');
							break;
						case 'U':
							sb.setCharAt(i, 'Y');
							break;
						case 'I':
							sb.setCharAt(i, 'U');
							break;
						case 'O':
							sb.setCharAt(i, 'I');
							break;
						case 'P':
							sb.setCharAt(i, 'O');
							break;
						case '[':
							sb.setCharAt(i, 'P');
							break;
						case ']':
							sb.setCharAt(i, '[');
							break;
						case '\\':
							sb.setCharAt(i, ']');
							break;
						case 'S':
							sb.setCharAt(i, 'A');
							break;
						case 'D':
							sb.setCharAt(i, 'S');
							break;
						case 'F':
							sb.setCharAt(i, 'D');
							break;
						case 'G':
							sb.setCharAt(i, 'F');
							break;
						case 'H':
							sb.setCharAt(i, 'G');
							break;
						case 'J':
							sb.setCharAt(i, 'H');
							break;
						case 'K':
							sb.setCharAt(i, 'J');
							break;
						case 'L':
							sb.setCharAt(i, 'K');
							break;
						case ';':
							sb.setCharAt(i, 'L');
							break;
						case '\'':
							sb.setCharAt(i, ';');
							break;
						case 'X':
							sb.setCharAt(i, 'Z');
							break;
						case 'C':
							sb.setCharAt(i, 'X');
							break;
						case 'V':
							sb.setCharAt(i, 'C');
							break;
						case 'B':
							sb.setCharAt(i, 'V');
							break;
						case 'N':
							sb.setCharAt(i, 'B');
							break;
						case 'M':
							sb.setCharAt(i, 'N');
							break;
						case ',':
							sb.setCharAt(i, 'M');
							break;
						case '.':
							sb.setCharAt(i, ',');
							break;
						case '/':
							sb.setCharAt(i, '.');
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
