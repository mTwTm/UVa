// UVa 623 500!
// Current Status: Accepted
// Last Submitted: 2015-06-02 10:54:47
// Run Time: 1.086

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	private List<BigInteger> answers;
	
	private void run(){

		try{

			r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			answers = new ArrayList<>();
			answers.add(BigInteger.ONE);
			for(int count = 1;count<=1000; count++)
				answers.add(answers.get(answers.size() - 1).multiply(BigInteger.valueOf(count)));

			while( ( nextLine = r.readLine() ) != null )
			{
				w.write(nextLine.trim()+"!\n");
				w.write(answers.get(Integer.parseInt(nextLine.trim())).toString()+"\n");
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
