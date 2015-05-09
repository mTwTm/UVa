// UVa 438 The Circumference of the Circle
// Current Status: Accepted
// Last Submitted: 2015-05-09 17:28:31
// Run Time: 0.199

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
	private final static double pi =  3.141592653589793;
	
	private void run(){
		
		r = new BufferedReader(new InputStreamReader(System.in)); 
		w = new BufferedWriter(new OutputStreamWriter(System.out));
	
		try{
			String nextLine;
			double x[] = new double[3];
			double y[] = new double[3];
			while( ( nextLine = r.readLine() ) != null )
			{
				String[] args = nextLine.trim().split("\\s+");
				for(int i=0;i<3;i++) {
					x[i] = Double.parseDouble(args[i * 2]);
					y[i] = Double.parseDouble(args[i * 2 + 1]);
				}
				double area = 1.0 / 2 *  (x[0] * y[1]  + y[0] * x[2] + x[1] * y[2] - y[1] * x[2] - y[0] * x[1] - x[0] * y[2]);
				double xc = (x[0]*x[0]+y[0]*y[0]) * y[1] + (x[1]*x[1]+y[1]*y[1]) * y[2] + (x[2]*x[2]+y[2]*y[2]) * y[0] - (x[0]*x[0]+y[0]*y[0]) * y[2] - (x[2]*x[2]+y[2]*y[2]) * y[1] - (x[1]*x[1]+y[1]*y[1]) * y[0];
				double yc = (x[0]*x[0]+y[0]*y[0]) * x[2] + (x[1]*x[1]+y[1]*y[1]) * x[0] + (x[2]*x[2]+y[2]*y[2]) * x[1] - (x[0]*x[0]+y[0]*y[0]) * x[1] - (x[2]*x[2]+y[2]*y[2]) * x[0] - (x[1]*x[1]+y[1]*y[1]) * x[2];
				xc /= area * 4;
				yc /= area * 4;
				w.write(String.format("%.2f\n", pi * 2 * Math.sqrt( (x[0]-xc)*(x[0]-xc)+(y[0]-yc)*(y[0]-yc) )));
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
