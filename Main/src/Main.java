// UVa 476 Points in Figures: Rectangles
// Current Status: Accepted
// Last Submitted: 2015-05-26 13:05:20
// Run Time: 0.915

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;

	private class Rectangle {
		private double[] upperLeft ={0, 0};
		private double[] lowerRight ={0, 0};
		Rectangle(double x1, double y1, double x2, double y2) {
			upperLeft[0] = x1;
			upperLeft[1] = y1;
			lowerRight[0] = x2;
			lowerRight[1] = y2;
		}
		public boolean surrounds(double x, double y) {
			if(x<lowerRight[0]&&x>upperLeft[0]&&y>lowerRight[1]&&y<upperLeft[1]) {
				return true;
			}
			return false;
		}
	}

	private void run(){
		
		r = new BufferedReader(new InputStreamReader(System.in)); 
		w = new BufferedWriter(new OutputStreamWriter(System.out));
	
		try{
			String nextLine;
			List<Rectangle> rects = new ArrayList<>();
			int pointCount = 1;
			while( ( nextLine = r.readLine() ) != null )
			{
				nextLine = nextLine.trim();
				String[] line = nextLine.split("\\s+");
				if(line[0].equals("r"))
					rects.add(new Rectangle(Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3]), Double.parseDouble(line[4])));
				else if(line[0].equals("*"))
					;
				else if(line[0].equals("9999.9")&&line[1].equals("9999.9"))
					break;
				else {
					boolean contained = false;
					for(int i=0 ; i<rects.size() ; i++) {
						if(rects.get(i).surrounds(Double.parseDouble(line[0]), Double.parseDouble(line[1]))) {
							contained = true;
							w.write("Point " + pointCount + " is contained in figure " + (i+1) + "\n");
						}
					}
					if(!contained)
						w.write("Point " + pointCount + " is not contained in any figure" + "\n");
					pointCount++;
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
