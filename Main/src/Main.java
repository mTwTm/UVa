// UVa 477 Points in Figures: Rectangles and Circles
// Current Status: Accepted
// Last Submitted: 2015-05-27 07:27:04
// Run Time: 0.982

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

	private abstract class Shape {
		public abstract boolean surrounds(double x, double y);
	}

	private class Circle extends Shape {
		private double xc;
		private double yc;
		private double r;

		Circle(double x, double y, double r) {
			xc = x;
			yc = y;
			this.r = r;
		}

		@Override
		public boolean surrounds(double x, double y) {
			if(Math.sqrt(Math.pow(x-xc,2)+Math.pow(y-yc,2))<r)
				return true;
			return false;
		}
	}

	private class Rectangle extends Shape {
		private double[] upperLeft ={0, 0};
		private double[] lowerRight ={0, 0};
		Rectangle(double x1, double y1, double x2, double y2) {
			upperLeft[0] = x1;
			upperLeft[1] = y1;
			lowerRight[0] = x2;
			lowerRight[1] = y2;
		}

		@Override
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
			List<Shape> shapes = new ArrayList<>();
			int pointCount = 1;
			while( ( nextLine = r.readLine() ) != null )
			{
				nextLine = nextLine.trim();
				String[] line = nextLine.split("\\s+");
				if(line[0].equals("r"))
					shapes.add(new Rectangle(Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3]), Double.parseDouble(line[4])));
				else if(line[0].equals("c"))
					shapes.add(new Circle(Double.parseDouble(line[1]), Double.parseDouble(line[2]), Double.parseDouble(line[3])));
				else if(line[0].equals("*"))
					;
				else if(line[0].equals("9999.9")&&line[1].equals("9999.9"))
					break;
				else {
					boolean contained = false;
					for(int i=0 ; i<shapes.size() ; i++) {
						if(shapes.get(i).surrounds(Double.parseDouble(line[0]), Double.parseDouble(line[1]))) {
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
