// UVa 492 Pig-Latin
// Current Status: Accepted|Pending|TooSlow
// Last Submitted: 
// Run Time: 

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
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
			return true;
		else if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
			return true;
		return false;
	}

	private void run(){


	
		try{
			r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				int begin = 0; 
				Matcher matcher = Pattern.compile("[a-zA-Z]+").matcher(nextLine);
				while(matcher.find())
				{
					StringBuilder word = new StringBuilder(matcher.group());
					if(!isVowel(word.charAt(0))) {
						word.append(word.charAt(0));
						word.replace(0, 1, "");
					}
					word.append("ay");
					w.write(nextLine.substring(begin, matcher.start()));
					begin = matcher.end();
					w.write(word.toString());
				}
				w.write(nextLine.substring(begin, nextLine.length())+"\n");
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
