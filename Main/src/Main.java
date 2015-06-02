// UVa 579 Clock Hands
// Current Status: Accepted
// Last Submitted: 2015-06-02 06:43:24
// Run Time: 2.111

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
				if(nextLine.equals("0:00"))
					break;
				String[] args = nextLine.trim().split(":");
				// degree doubled to accommondate 0.5
				int degree = Math.abs(Integer.parseInt(args[0])*60 - Integer.parseInt(args[1])*11);
				degree =  degree % 720;
				degree = degree > 360 ? 720 - degree : degree;
				w.write( String.format("%.3f",((double)degree)/2) + "\n");
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
