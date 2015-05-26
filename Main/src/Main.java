// UVa 458 The Decoder
// Current Status: Accepted
// Last Submitted: 2015-05-26 11:01:14
// Run Time: 0.376

import java.io.*;

public class Main {
	
	private BufferedReader r;
	private BufferedWriter w;
	private final int hi = 0;
	
	private void run(){

		try {
			r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	
		try{
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				StringBuilder sb = new StringBuilder(nextLine);
				for(int i=0;i<sb.length();i++)
					sb.setCharAt(i, (char) (sb.charAt(i) + ('i'-'p') ));
				w.write(sb.toString()+"\n");
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
