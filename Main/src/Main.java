// UVa <ID> <Name> 
// Current Status: Accepted|Pending|TooSlow
// Last Submitted: 
// Run Time: 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	
	private void run(){
		
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner s = new Scanner(r);
		try{
			while( s.hasNextLine() )
			{
				String line = s.nextLine();
				w.write(line);
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
