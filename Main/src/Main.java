// UVa 10189 Minesweeper
// Current Status: Accepted
// Last Submitted: 2016-09-17 16:01:41
// Run Time: 0.060

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private void add(StringBuilder[] board, int x, int y) {
		if(x>=0 && x<board.length && y>=0 && y <board[0].length() && board[x].charAt(y)!='*') {
			board[x].setCharAt(y, (char)(board[x].charAt(y)+1));
		}
	}

	private void fill(StringBuilder[] board, int x, int y) {
		if(board[x].charAt(y)=='*') {
			for(int deltaX = -1 ; deltaX <=1 ; deltaX++) {
				for(int deltaY = -1 ; deltaY <=1 ; deltaY++) {
					add(board, x+deltaX, y+deltaY);
				}
			}
		}
	}

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			int fieldNum = 1;
			while( ( nextLine = r.readLine() ) != null ) {
				String[] values = nextLine.trim().split("\\s+");
				int x = Integer.parseInt(values[0]);
				int y = Integer.parseInt(values[1]);
				if(x==0 && y==0) {
					break;
				}
				StringBuilder[] board = new StringBuilder[x];
				for(int i=0 ; i<x ; i++) {
					board[i] = new StringBuilder(r.readLine().trim());
				}
				for(int i=0 ; i<x ; i++) {
					for(int j=0 ; j<y ; j++) {
						if(board[i].charAt(j)=='.') {
							board[i].setCharAt(j, '0');
						}
					}
				}
				for(int i=0 ; i<x ; i++) {
					for(int j=0 ; j<y ; j++) {
						fill(board, i, j);
					}
				}
				if(fieldNum!=1) {
					w.write("\n");
				}
				w.write(String.format("Field #%d:\n",fieldNum));
				for(int i=0 ; i<x ; i++) {
					w.write(board[i].toString()+"\n");
				}
				fieldNum++;
			}
			r.close();
			w.close();
		} catch(IOException ex) {
			//Nothing to do
		}
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
}
