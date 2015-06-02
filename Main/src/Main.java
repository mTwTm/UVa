// UVa 573 The Snail
// Current Status: Accepted
// Last Submitted: 2015-06-02 03:08:42
// Run Time: 0.115

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	private int current;
	private int  efficiency;
	private int  up;
	private int  down;
	private int  target;
	private int  day;
	private int fatigue;
	
	private void run(){

		try{

			r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				String[] args = nextLine.split("\\s+");
				day = 1;
				current = 0;
				target = Integer.parseInt(args[0])*100;
				up = Integer.parseInt(args[1])*100;
				down = Integer.parseInt(args[2])*100;
				fatigue = Integer.parseInt(args[3]);
				efficiency = 100;
				if(target==0)
					break;
				boolean success = false;
				boolean failure = false;
				while (true) {
					success = (current+up*efficiency/100) > target;
					failure = (current+up*efficiency/100-down) < 0;
					if(success||failure)
						break;
					current += up*efficiency/100-down;
					efficiency = (efficiency-fatigue>=0) ? efficiency-fatigue : 0;
					day++;
				}
				w.write( (success ? "success" : "failure" ) + " on day " + day + "\n");
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
