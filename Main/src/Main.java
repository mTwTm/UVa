// UVa 392 Polynomial Showdown
// Current Status: Accepted
// Last Submitted: 2015-05-08 14:27:43
// Run Time: 1.762

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;

    private String formatString(boolean isFirst, int power, String value) {
        int val = Integer.valueOf(value);
        if(val==0)
            return "";
        else if(val>0 && power!=0)
            return (isFirst ? "" : " + " ) + (val!=1 ? val : "")  + "x" + (power!=1 ? "^"+power : "");
        else if(val<0 && power!=0)
            return (isFirst ? "-" : " - " ) + (val!=-1 ? -val : "")  + "x" + (power!=1 ? "^"+power : "");
        else if(val>0 && power==0)
            return (isFirst ? "" : " + " ) + val;
        else if(val<0 && power==0)
            return (isFirst ? "-" : " - " ) + -val;
        return "";
    }

	private void run(){
		
		r = new BufferedReader(new InputStreamReader(System.in)); 
		w = new BufferedWriter(new OutputStreamWriter(System.out));
	
		try{
			String nextLine;
			while( ( nextLine = r.readLine() ) != null )
			{
                String[] args = nextLine.trim().split("\\s+");
                if(args[0].equals("0") && args[1].equals("0") && args[2].equals("0") &&
                        args[3].equals("0") && args[4].equals("0") && args[5].equals("0") &&
                        args[6].equals("0") && args[7].equals("0") && args[8].equals("0"))
                    w.write("0\n");
                else
                {
                    int now = 0;
                    while(args[now].equals("0"))
                        now++;
                    w.write(formatString(true, 8 - now,  args[now]));
                    for(int i = now+1 ; i < 9 ; i++) {
                        w.write(formatString(false, 8-i,  args[i]));
                    }
                    w.write("\n");
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
