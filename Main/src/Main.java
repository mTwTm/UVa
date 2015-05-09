// UVa 414 Machined Surfaces
// Current Status: Accepted
// Last Submitted: 2015-05-09 08:55:50
// Run Time: 0.176

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
				int size = Integer.parseInt(nextLine.trim());
				if(size == 0)
					break;
				int min = 25;
				int holes = 0;
				for(int i=0 ; i<size ; i++) {
					nextLine = r.readLine().trim();
					int count = 0;
					for(int j=0 ; j<nextLine.length() ; j++) {
						if(nextLine.charAt(j)==' ')
							count++;
					}
					if(count < min) {
						holes += i * (min - count);
						min = count;
					}
					else {
						holes += count - min;
					}
				}
				w.write(holes+"\n");
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
