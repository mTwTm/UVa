// UVa 488 Triangle Wave
// Current Status: Accepted
// Last Submitted: 2015-05-27 10:16:18
// Run Time: 0.806

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	private int f;
	private int a;
	private boolean first = true;

	private void drawOne() throws IOException {
		if(!first)
			w.write("\n");
		first = false;
		for(int i=1;i<=a;i++) {
			for(int j=0;j<i;j++) {
				w.write(String.valueOf(i));
			}
			w.write("\n");
		}
		for(int i=a-1;i>=1;i--) {
			for(int j=0;j<i;j++) {
				w.write(String.valueOf(i));
			}
			w.write("\n");
		}
	}

	private void draw() throws IOException {
		for(int i=0;i<f;i++)
			drawOne();
	}

	private void run(){
		
		r = new BufferedReader(new InputStreamReader(System.in)); 
		w = new BufferedWriter(new OutputStreamWriter(System.out));
	
		try{
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				int caseC = Integer.parseInt(nextLine);
				for(int i=0 ; i<caseC ; i++) {
					r.readLine();
					a = Integer.parseInt(r.readLine());
					f = Integer.parseInt(r.readLine());
					draw();
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
