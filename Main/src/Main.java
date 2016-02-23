// UVa 12503 Robot Instructions
// Current Status: Accepted
// Last Submitted: 2016-02-23 13:10:05
// Run Time: 0.082

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private class Robot {
		public static final int TYPE_LEFT = -1;
		public static final int TYPE_RIGHT = 1;
		public static final int TYPE_SAME_AS = 0;
		private int position;
		private int count;
		private int[] instructions;
		Robot() {
			position = 0;
			count = 0;
			instructions = new int[100];
		}
		public void putInstruction(int instructionType, int instructionParam) {
			if(instructionType!=TYPE_SAME_AS) {
				instructions[count] = instructionType;
			} else {
				instructions[count] = instructions[instructionParam-1];
			}
			position += instructions[count];
			count++;
		}
		public int getPosition() {
			return position;
		}
	}

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			nextLine = r.readLine();
			int iterations = Integer.parseInt(nextLine);
			for(int i=0 ; i<iterations ; i++) {
				Robot robot = new Robot();
				nextLine = r.readLine();
				int moves = Integer.parseInt(nextLine);
				for(int j=0 ; j<moves ; j++) {
					nextLine = r.readLine();
					if(nextLine.equals("LEFT")) {
						robot.putInstruction(Robot.TYPE_LEFT, -1);
					} else if(nextLine.equals("RIGHT")) {
						robot.putInstruction(Robot.TYPE_RIGHT, -1);
					} else {
						int param = Integer.parseInt(nextLine.replace("SAME AS", "").trim());
						robot.putInstruction(Robot.TYPE_SAME_AS, param);
					}
				}
				w.write(robot.getPosition()+"\n");
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
