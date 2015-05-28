// UVa 499 What's The Frequency, Kenneth?
// Current Status: Accepted
// Last Submitted: 2015-05-28 07:58:08
// Run Time: 0.259

import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner s;
		s = new Scanner(System.in);
		while(s.hasNextLine())
		{
			String line = s.nextLine();
			int[] letterCount = new int[52];
			for(int i=0;i<line.length();i++)
			{
				char next = line.charAt(i);
				if(next<='z'&&next>='a')
					letterCount[next-'a'+26]++;
				if(next<='Z'&&next>='A')
					letterCount[next-'A']++;
			}
			int most = 0;
			for(int i=0;i<letterCount.length;i++)
			{
				if(letterCount[i]>most)
					most = letterCount[i];
			}
			for(int i=0;i<letterCount.length;i++)
			{
				if(letterCount[i]==most)
				{
					if(i<=25)
						System.out.print((char)(i+'A'));
					else
						System.out.print((char)(i+'a'-26));
				}
			}
			System.out.println(" "+most);
		}
		s.close();
	}
}