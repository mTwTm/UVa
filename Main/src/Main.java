// UVa 10591 Happy Number
// Current Status: Accepted
// Last Submitted: 2016-04-17 08:37:12
// Run Time: 0.070

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	// 1 for happy, -1 for unhappy and 0 for unknown
	private Map<Integer, Integer> mapping;

	private int sortDigits(int source) {
		char[] digits = new char[10];
		Arrays.fill(digits, '0');
		for(int index = 0 ; source > 0 ; source/=10, index++ ) {
			digits[index] = (char) ('0' + source%10);
		}
		Arrays.sort(digits);
		int result = 0;
		for(int i=0 ; i<digits.length ; i++) {
			result *= 10;
			result += (digits[i] - '0');
		}
		return result;
	}

	private boolean calVal(int value) {
		value = sortDigits(value);
		if(mapping.containsKey(value)) {
			return mapping.get(value) == 1;
		} else {
			List<Integer> vals = new ArrayList<>();
			vals.add(value);
			while(value!=1 && value!=4) {
				value = sortDigits(sumDigitSquares(value));
				vals.add(value);
			}
			boolean isHappy = value==1;
			for(int next : vals) {
				mapping.put(next, isHappy ? 1 : -1);
			}
			return isHappy;
		}
	}

	private int sumDigitSquares(int value) {
		int sum = 0;
		while (value!=0) {
			sum += (value%10) * (value%10);
			value/=10;
		}
		return sum;
	}

	private void run() {
		try {
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
			int caseNum = Integer.parseInt(r.readLine());
			for ( int i=0 ; i<caseNum ; i++) {
				int next = Integer.parseInt(r.readLine());
				mapping = new HashMap<>();
				if(calVal(next)) {
					w.write("Case #" + (i+1) + ": " + next + " is a Happy number.\n");
				} else {
					w.write("Case #" + (i+1) + ": " + next + " is an Unhappy number.\n");
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
