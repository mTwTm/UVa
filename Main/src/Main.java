// UVa 846 Steps
// Current Status: Accepted
// Last Submitted: 2016-02-13 16:50:18
// Run Time: 0.126

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	
	private int sqrt(int num) {
		int sqrt = 1;
		while(sqrt*sqrt<=num&&sqrt<=46340) {
			sqrt++;
		}
		if(sqrt*sqrt<=num) {
			sqrt=46341;
		}
		return sqrt;
	}
	
	private void run(){

		try{

			r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			int times = Integer.parseInt(r.readLine());
			for(int counter=0;counter<times;counter++) {
				nextLine = r.readLine();
				Matcher matcher = Pattern.compile("\\d+").matcher(nextLine);
				matcher.find();
				int first = Integer.parseInt(matcher.group());
				matcher.find();
				int second = Integer.parseInt(matcher.group());
				int diff = second - first;
				int sqrt = sqrt(diff);
				if(diff==0) {
					System.out.println(0);
				} else if((sqrt-1)*(sqrt-1)==diff) {
					System.out.println(2*sqrt-3);
				} else if((sqrt)*(sqrt-1)>=diff) {
					System.out.println(2*sqrt-2);
				} else {
					System.out.println(2*sqrt-1);
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
