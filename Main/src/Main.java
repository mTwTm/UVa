// UVa 382 Perfection
// Current Status: Accepted|Pending|TooSlow
// Last Submitted: 
// Run Time: 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	
	private void run(){
		
		r = new BufferedReader(new InputStreamReader(System.in)); 
		w = new BufferedWriter(new OutputStreamWriter(System.out));
	
		try{
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				w.write(nextLine);
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
