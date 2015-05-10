// UVa 439 Knight Moves
// Current Status: Accepted
// Last Submitted: 2015-05-10 06:39:12
// Run Time: 0.748

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	private int [][] reach;

	private BufferedReader r; 
	private BufferedWriter w;

	private int findY (int index) {
		return index % 8;
	}

	private int findX (int index) {
		return index / 8;
	}

	private int flatten (int x, int y) {
		return x*8 + y;
	}

	private void run(){
		
		r = new BufferedReader(new InputStreamReader(System.in)); 
		w = new BufferedWriter(new OutputStreamWriter(System.out));
		final int[] incrementX = {2, 2, 1, 1, -1, -1, -2, -2};
		final int[] incrementY = {1, -1, 2, -2, 2, -2, 1, -1};
		reach = new int[64][];
		for (int i=0 ; i<64 ; i++) {
			reach[i] = new int[64];
			Arrays.fill(reach[i], -1);
			int toDo = 63;
			int loop = 1;
			Set<Integer> lastLoop = new HashSet<>();
			Set<Integer> thisLoop = new HashSet<>();
			lastLoop.add(i);
			reach[i][i] = 0;
			while(toDo!=0) {
				for(int nextLast : lastLoop) {
					int x = findX(nextLast);
					int y = findY(nextLast);
					for (int j=0;j<incrementX.length;j++) {
						if(x+incrementX[j]>=0&&x+incrementX[j]<8 && y+incrementY[j]>=0&&y+incrementY[j]<8) {
							int nextPos = flatten(x + incrementX[j], y + incrementY[j]);
							thisLoop.add(nextPos);
							if( reach[i][nextPos] == -1) {
								toDo--;
								reach[i][nextPos] = loop;
							}
						}
					}
				}
				loop++;
				lastLoop = thisLoop;
				thisLoop = new HashSet<>();
			}
		}

		try{
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				String[] pos = nextLine.trim().split("\\s+");
				w.write("To get from " + pos[0] + " to " + pos[1] + " takes " + reach[flatten(pos[0].charAt(0)-'a', pos[0].charAt(1)-'1')][flatten(pos[1].charAt(0)-'a', pos[1].charAt(1)-'1')] + " knight moves.\n");
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
