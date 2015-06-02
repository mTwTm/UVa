// UVa 591 Box of Bricks
// Current Status: Accepted
// Last Submitted: 2015-06-02 10:34:12
// Run Time: 0.166

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
			int caseC = 1;
			while( ( nextLine = r.readLine() ) != null )
			{
				int count = Integer.parseInt(nextLine);
				if(count==0)
					break;
				nextLine = r.readLine();
				String[] blocks = nextLine.trim().split("\\s+");
				int average = 0;
				int moves = 0;
				for(int i=0;i<blocks.length;i++) {
					average += Integer.parseInt(blocks[i]);
				}
				average /= blocks.length;
				for(int i=0;i<blocks.length;i++) {
					moves+=Math.abs(Integer.parseInt(blocks[i])-average);
				}
				moves /= 2;
				w.write("Set #" + caseC + "\nThe minimum number of moves is " + moves + ".\n\n");
				caseC++;
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
