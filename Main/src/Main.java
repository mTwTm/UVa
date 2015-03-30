// UVa 113 Power of Cryptography
// Current Status: Accepted
// Last Submitted: 2015-03-30 11:04:39
// Run Time: 0.736
// Brute Force
import java.math.BigInteger;
import java.util.Scanner;


class Main {
	public static void main(String[] args) {
		int n;
		BigInteger p;
		int k;
		BigInteger kn;
		Scanner S = new Scanner(System.in);
		while(S.hasNextBigInteger())
		{
			n = S.nextInt();
			p = S.nextBigInteger();
			k = 1;
			//Find the order of magnitude of k
			kn = new BigInteger(Integer.toString(k));
			while(kn.compareTo(p)==-1)
			{
				if(k>Integer.MAX_VALUE/10)
					k = Integer.MAX_VALUE;
				else
					k*=10;
				kn = new BigInteger(Integer.toString(k));
				kn = kn.pow(n);
			}
			int lower = k/10;
			int higher = k;
			//k<=target<10k
			//Binary Search to find k
			int temp = 0;
			while((new BigInteger(Integer.toString(temp))).pow(n).compareTo(p)!=0)
			{
				temp = higher/2+lower/2+(higher%2+lower%2)/2;
				if((new BigInteger(Integer.toString(temp))).pow(n).compareTo(p)==-1)
				{
					lower = temp;
				}
				else
				{
					higher = temp;
				}					
			}
			System.out.println(temp);
		}
	}

}
