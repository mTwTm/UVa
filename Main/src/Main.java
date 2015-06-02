// UVa 694 The Collatz Sequence
// Current Status: Accepted
// Last Submitted: 2015-06-02 12:37:13
// Run Time: 1.473

import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner s;
		s = new Scanner(System.in);
		int caseCounter = 1;
		while(s.hasNextInt())
		{
			int a = s.nextInt();
			int l = s.nextInt();
			if(a==-1&&l==-1)
				break;
			int originalA = a;
			int counter = 1;
			while(true)
			{
				if(a==1)
					break;
				if(a%2==1&&a>715827882)
					break;
				if(a%2==1&&a*3+1>l)
					break;
				if(a%2==0)
					a = a/2;
				else
					a = a*3+1;
				counter++;
			}
			System.out.println("Case "+caseCounter+": A = "+originalA+", limit = "+l+", number of terms = "+counter);
			caseCounter++;
		}
		s.close();
	}
}