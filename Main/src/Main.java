// UVa 382 Perfection
// Current Status: Accepted
// Last Submitted: 2015-05-08 13:25:53
// Run Time: 0.172

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	private BufferedReader r; 
	private BufferedWriter w;
    private List<Integer> primes;
    private final static int MAXPRIME = ((int) Math.sqrt(60000))+1;
    private final static int alignSize = 5;

    private String alignedString(String s) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.length()!=alignSize)
            sb.insert(0, " ");
        return sb.toString();
    }

	private void run(){
		
		r = new BufferedReader(new InputStreamReader(System.in)); 
		w = new BufferedWriter(new OutputStreamWriter(System.out));
        primes = new ArrayList<>();
    search:
        for(int i=2;i<=MAXPRIME;i++)
        {
            for(int nextPrime : primes)
            {
                if(i%nextPrime==0)
                    continue search;
            }
            primes.add(i);
        }
	
		try{
			String nextLine;
            w.write("PERFECTION OUTPUT\n");
run:
			while( ( nextLine = r.readLine() ) != null ) {
                String[] args = nextLine.trim().split("\\s+");
                //List<Integer> factors = new ArrayList<>();
                for (String nextArg : args) {
                    Map<Integer, Integer> factors = new LinkedHashMap<>();
                    if(nextArg.equals("0"))
                        break run;
                    int temp = Integer.valueOf(nextArg);
                    for(int nextPrime : primes)
                    {
                        while(temp%nextPrime==0) {
                            if(!factors.containsKey(nextPrime))
                                factors.put(nextPrime, 1);
                            else
                                factors.put(nextPrime, factors.get(nextPrime) + 1);
                            temp /= nextPrime;
                        }
                        if(temp==1)
                            break;
                    }
                    int sum = 1;
                    for(int nextBase : factors.keySet())
                    {
                        sum *= Math.pow(nextBase, factors.get(nextBase)+1) - 1;
                        sum /= nextBase - 1;
                    }
                    sum -= Integer.valueOf(nextArg);
                    w.write(alignedString(nextArg) + "  ");
                    if(Integer.valueOf(nextArg)>sum)
                        w.write("DEFICIENT");
                    else if(Integer.valueOf(nextArg)<sum)
                        w.write("ABUNDANT");
                    else
                        w.write("PERFECT");
                    w.write("\n");
                }
            }
            w.write("END OF OUTPUT\n");
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
