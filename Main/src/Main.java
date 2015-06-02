// UVa 686 Goldbach's Conjecture (II)
// Current Status: Accepted
// Last Submitted: 2015-06-02 12:27:01
// Run Time: 0.285


import java.util.ArrayList;
import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner s;
		s = new Scanner(System.in);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int[] sumWay = new int[Short.MAX_VALUE/2+1];

		boolean[] pr = new boolean[Short.MAX_VALUE+1];
		pr[2] = true;
		for(int i=3;i<pr.length;i+=2)
			pr[i] = true;
		for(int i=3;i<Math.sqrt(pr.length);i++)
		{
			for(int j=i*2;j<pr.length;j+=i)
				pr[j] = false;
		}
		for(int i=0;i<pr.length;i++)
		{
			if(pr[i]==true)
				primes.add(i);
		}


		for(int i=0;i<primes.size();i++)
		{
			for(int j=0;j<=i;j++)
			{
				if((primes.get(i)+primes.get(j))<Short.MAX_VALUE&&(primes.get(i)+primes.get(j))%2==0)
					sumWay[(primes.get(i)+primes.get(j))/2]++;
			}
		}
		while(s.hasNextInt())
		{
			int next = s.nextInt();
			if(next==0)
				break;
			System.out.println(sumWay[next / 2]);
		}
		s.close();
	}

}