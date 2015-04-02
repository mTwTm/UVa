// UVa <ID> <Name> 
// Current Status: Accepted|Pending|TooSlow
// Last Submitted: 
// Run Time: 

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	
	private List<Integer> primes;
	private int max;
	private int maxCount;
	
	private void calPrime(){
		primes = new ArrayList<Integer>();
		primes.add(2);
		for(int i=3;i<=31623;i+=2)
		{
			boolean isPrime = true;
			for(int next : primes)
			{
				if( i % next == 0)
				{
					isPrime = false;
					break;
				}
				if( next*next > i)
					break;
			}
			if(isPrime)
				primes.add(i);		
		}
		
	}
	
	private void factorizeRange(int start, int end){
		max = start;
		maxCount = 1;
		
		for(int i=start;i<=end;i++)
		{
			int clone = i;
			int count = 1;
			for(int next : primes)
			{
				int factorPower = 1;
				while( clone % next == 0)
				{
					factorPower++;
					clone /= next;
				}
				count *= factorPower;
				if(clone==1)
					break;
			}
			if(count>maxCount)
			{
				maxCount = count;
				max = i;
			}
		}
	}
	
	private void run(){
		Scanner s = new Scanner(System.in);		
		calPrime();
		int count = s.nextInt();
		for(int c = 0; c<count ; c++)
		{		
			max = 0;
			maxCount = 0;
			int l = s.nextInt();
			int u = s.nextInt();
			factorizeRange(l, u);
			System.out.println("Between "+l+" and "+u+", "+max+" has a maximum of "+maxCount+" divisors.");
		}
		s.close();
	}
	
	public static void main(String[] args) {
		Main myself = new Main();
		myself.run();
	}
	
}
