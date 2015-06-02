// UVa 575 Skew Binary
// Current Status: Accepted
// Last Submitted: 2015-06-02 05:45:42
// Run Time: 0.119

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	
	private void run(){

		try{

			r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				if(nextLine.equals("0"))
					break;
				long sum = 0;
				long sub = 0;
				for(int i=0 ; i<nextLine.length() ; i++) {
					sum += nextLine.charAt(i)-'0';
					sub += nextLine.charAt(i)-'0';
					sum *= 2;
				}
				sum -= sub;
				w.write(sum+"\n");
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
