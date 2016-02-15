// UVa 913 Joana and the Odd Numbers
// Current Status: Accepted
// Last Submitted: 2016-02-15 15:47:44
// Run Time: 0.042

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
				int nextLength = Integer.parseInt(nextLine);
				long nextIndex = ( nextLength + 1 ) / 2;
				long rightMost = 1 + 2 * (nextIndex - 1) + 2 * nextIndex * (nextIndex-1);
				long sum = ( rightMost - 2 ) * 3;
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
