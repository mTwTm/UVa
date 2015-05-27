// UVa 484 The Department of Redundancy Department
// Current Status: Accepted
// Last Submitted: 2015-05-27 08:38:13
// Run Time: 0.612

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	
	private void run(){
		
		r = new BufferedReader(new InputStreamReader(System.in)); 
		w = new BufferedWriter(new OutputStreamWriter(System.out));
	
		try{
			String nextLine;
			Map<Integer, Integer> departments = new LinkedHashMap<>();
			while( ( nextLine = r.readLine() ) != null )
			{
				nextLine = nextLine.trim();
				String[] things = nextLine.split("\\s+");
				for(String next : things) {
					int val = Integer.parseInt(next);
						departments.put(val, departments.containsKey(val) ? departments.get(val)+1 : 1);
				}
			}
			for(Map.Entry next: departments.entrySet())
				w.write(next.getKey() + " " +next.getValue() + "\n");
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
