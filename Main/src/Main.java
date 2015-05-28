// UVa 494 Kindergarten Counting Game
// Current Status: Accepted
// Last Submitted: 2015-05-28 05:38:50
// Run Time: 0.192

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
				String[] split = nextLine.split("[a-zA-z]+");
				w.write(split.length-1+"\n");
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
