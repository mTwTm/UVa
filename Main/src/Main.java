// UVa 412 Pi
// Current Status: Accepted
// Last Submitted: 2015-05-09 08:27:40
// Run Time: 0.795

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

	private int gcd (int a, int b) {
		if(b>a) {
			int temp = b;
			b = a;
			a = temp;
		}
		if(b==0)
			return a;
		else
			return gcd(b, a%b);
	}

	private void run(){

		r = new BufferedReader(new InputStreamReader(System.in));
		w = new BufferedWriter(new OutputStreamWriter(System.out));

		try{
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
				int size = Integer.parseInt(nextLine);
				if(size == 0 )
					break;
				List<Integer> samples = new ArrayList<>();
				for(int i=0 ; i<size ; i++) {
					samples.add(Integer.parseInt(r.readLine()));
				}
				int count = 0;
				for(int i=0 ; i<size ; i++) {
					for(int j=i+1 ; j<size ; j++) {
						if( gcd(samples.get(i), samples.get(j)) == 1 )
							count++;
					}
				}
				if(count == 0 )
					w.write("No estimate for this data set.\n");
				else {
					double pi = size * (size -1) / 2 * 6;
					pi /= count;
					pi = Math.sqrt(pi);
					w.write(String.format("%.6f", pi) + "\n");
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
