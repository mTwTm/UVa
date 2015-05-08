// UVa 357 Let Me Count The Ways
// Current Status: Accepted|Pending|TooSlow
// Last Submitted: 
// Run Time: 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	private BufferedReader r; 
	private BufferedWriter w;
	private static int[] coins = {1, 5, 10, 25, 50};
    private static int max = 30000;
	
	private void run() {

        r = new BufferedReader(new InputStreamReader(System.in));
        w = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] ways = new int[coins.length][];
        for(int i=0;i<coins.length;i++)
            ways[i] = new int[max / coins[1] + 1];
        for (int i = 0; i <= max; i += coins[1]) {
            ways[0][i / coins[1]] = 1;
            for (int j = 1; j < ways.length; j++) {
                int temp = i;
                ways[j][i / coins[1]] = ways[j - 1][i / coins[1]];
                while (temp >= coins[j]) {
                    temp -= coins[j];
                    ways[j][i / coins[1]] += ways[j - 1][temp / coins[1]];
                }
            }
        }

	
		try{
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
                int in = Integer.parseInt(nextLine);
                if(ways[coins.length-1][in/coins[1]]!=1)
				    w.write("There are " + ways[coins.length-1][in/coins[1]]+" ways to produce " + in + " cents change.\n");
                else
                    w.write("There is only 1 way to produce " + in +" cents change.\n");
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
