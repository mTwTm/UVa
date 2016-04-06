// UVa 11461 Square Numbers
// Current Status: Accepted
// Last Submitted: 2016-04-05 13:52:50
// Run Time:  0.050

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static List<Integer> squares;
	private final static int LARGEST_NUMBER = 100000;

	private int findLesserCount(int target) {
		if(target == 0) {
			return 0;
		}
		for(int i = 0; i< squares.size() ; i++) {
			if(squares.get(i)>target) {
				return i-1+1;
			}
		}
		return -1;
	}

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			while(true) {
				String nextLine = r.readLine();
				String[] args = nextLine.split("\\s+");
				int first = Integer.parseInt(args[0]);
				int second = Integer.parseInt(args[1]);
				if(first == 0 && second == 0) {
					break;
				} else {
					int start = first - 1;
					int end = second;
					w.write(""+(findLesserCount(end)-findLesserCount(start))+"\n");
				}
			}
			r.close();
			w.close();
		} catch(IOException ex) {
			//Nothing to do
		}
	}

	private static void prepareMapping() {
		squares = new ArrayList<>();
		for(int i=1 ; i*i<=LARGEST_NUMBER ; i++) {
			squares.add(i*i);
		}
		squares.add((squares.size()+1)*(squares.size()+1));
	}
	
	public static void main(String[] args) {
		prepareMapping();
		Main myself = new Main();
		myself.run();
	}
}
