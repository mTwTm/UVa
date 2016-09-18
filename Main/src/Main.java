// UVa 10168 Summation of Four Primes
// Current Status: Accepted
// Last Submitted: 2016-09-18 04:33:13
// Run Time: 0.210

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private boolean isPrime(List<Integer> primes, int target) {
		for(int nextPrime : primes) {
			if(nextPrime >= target) {
				break;
			}
			if(target%nextPrime==0) {
				return false;
			}
		}
		return true;
	}

	private List<Integer> getPrimes() {
		List<Integer> ret = new ArrayList<>();
		ret.add(2);
		checkPrimes:
		for(int i=3 ; i<=Math.sqrt(10000000)+1 ; i+=2) {
			for(int nextPrime : ret) {
				if(i%nextPrime==0) {
					continue checkPrimes;
				}
			}
			ret.add(i);
		}
		return ret;
	}

	private int splitIntoTwo(List<Integer> primes, int target) {
		for (int i = 2; i <= (target+1)/2; i++) {
			if(isPrime(primes, i) && isPrime(primes, target-i)) {
				return i;
			}
		}
		return -1;
	}

	private void run() {
		try {

			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			String nextLine;
			List<Integer> primes = getPrimes();
			int[] answer = new int[4];
			while( ( nextLine = r.readLine() ) != null ) {
				int num = Integer.parseInt(nextLine.trim());
				if(num <= 7) {
					w.write("Impossible.\n");
				} else {
					switch (num % 4) {
						case 0:
							int first = splitIntoTwo(primes, num/2);
							answer[0] = first;
							answer[1] = first;
							answer[2] = num/2 - first;
							answer[3] = num/2 - first;
							break;
						case 1:
						case 3:
							answer[0] = 2;
							answer[1] = 3;
							first = splitIntoTwo(primes, num-5);
							answer[2] = first;
							answer[3] = num-first-5;
							break;
						case 2:
							answer[0] = 3;
							answer[1] = 3;
							first = splitIntoTwo(primes, num-6);
							answer[2] = first;
							answer[3] = num-first-6;
					}
					w.write(String.format("%d %d %d %d\n", answer[0], answer[1], answer[2], answer[3]));
				}
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
