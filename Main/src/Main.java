// UVa 492 Pig-Latin
// Current Status: Accepted
// Last Submitted: 2016-02-13 09:21:58 
// Run Time: 0.179

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;

	private boolean isVowel(char c) {
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
			return true;
		} else if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U') {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isLetter(int c) {
		if ( c >= 'a' && c <= 'z' ) {
			return true;
		} else if ( c >= 'A' && c <= 'Z' ) {
			return true;
		} else {
			return false;
		}
	}

	private void run(){


	
		try{
			r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			int nextChar;
			while( ( nextChar = r.read() ) != -1 ) {
				if(isLetter(nextChar)) {
					StringBuilder word = new StringBuilder(""+(char)nextChar);
					while(isLetter(nextChar = r.read())) {
						word.append((char)nextChar);
					}
					if(!isVowel(word.charAt(0))) {
						word.append(word.charAt(0));
						word.replace(0, 1, "");
					}
					word.append("ay");
					w.write(word.toString());
					w.write(nextChar);
				} else {
					w.write(nextChar);
				}
			}
			r.close();
			w.close();
		}
		catch(IOException ex)
		{
			//Nothing to do
		}
		
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
