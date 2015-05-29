// UVa 568 Just the Facts
// Current Status: Accepted
// Last Submitted: 2015-05-29 06:18:59
// Run Time: 0.192

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	private int[] answer = new int[10001];
	
	private void run(){

		try{

			r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			answer[0] = 1;
			for(int i=1;i<10001;i++) {
				int clone = i;
				while(clone%10==0)
					clone /= 10;
				answer[i] = ( answer[i-1] * clone );
				while(answer[i]%10==0)
					answer[i] /= 10;
				answer[i] = answer[i] % 100000;
			}
			while( ( nextLine = r.readLine() ) != null )
			{
				int next = Integer.parseInt(nextLine);
				w.write(String.format("%5d", next) + " -> " + answer[next]%10 + "\n");
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
