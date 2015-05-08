// UVa 374 Big Mod
// Current Status: Accepted
// Last Submitted: 2015-05-08 11:00:30
// Run Time: 0.158
// Note: Beware of P==0 & avoid duplicate method call -> presave the result

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private BufferedReader r;
    private BufferedWriter w;

    private long bigMod(long B, long P, long M)
    {
        if(P==0) {
            return 1;
        }
        else if(P==1) {
            return B%M;
        }
        else {
            long temp = bigMod(B, P/2, M);
            if(P%2==0)
            {
                return temp * temp % M;
            }
            else
            {
                return (temp * temp * B) % M;
            }
        }
    }

    private String myNextLine() throws IOException {
        String temp = r.readLine();
        while(!temp.matches("\\d+"))
        {
            if(temp==null)
                return null;
            temp = r.readLine();
        }
        return temp;
    }

    private void run(){

        r = new BufferedReader(new InputStreamReader(System.in));
        w = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            String nextLine;
            while( (nextLine = myNextLine() )!=null)
            {
                long B = Long.valueOf(nextLine);
                long P = Long.valueOf(myNextLine());
                long M = Long.valueOf(myNextLine());
                w.write(bigMod(B, P, M) + "\n");
                if(r.readLine()==null)
                    break;
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
