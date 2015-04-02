// UVa 272 TEX Quotes 
// Current Status: Accepted
// Last Submitted: 2015-04-02 08:47:36
// Run Time: 0.559

import java.util.Scanner;

public class Main {
	
	private void run(){
		Scanner s = new Scanner(System.in);
		boolean first = true;
		while(s.hasNextLine())
		{
			StringBuilder next = new StringBuilder(s.nextLine());
			while(next.indexOf("\"")!=-1)
			{
				next.replace(next.indexOf("\""), next.indexOf("\"")+1, first ? "``" : "''");
				first = !first;
			}
			System.out.print(next.toString());
			//if(s.hasNextLine())
				System.out.println();
		}
		s.close();
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
