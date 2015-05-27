// UVa 490 Rotating Sentences
// Current Status: Accepted
// Last Submitted: 2015-05-27 10:17:46
// Run Time: 0.492

import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner s;
		s = new Scanner(System.in);
		String[] input = new String[101];
		int counter = 0;
		while(s.hasNextLine())
		{
			input[counter] = s.nextLine();
			counter++;
		}
		s.close();
		int maxLength = 0;
		for(int i=100;i>=0;i--)
		{
			if(input[i]!=null)
			{
				if(input[i].length()>maxLength)
					maxLength = input[i].length();
			}
		}
		for(int i=0;i<101;i++)
		{
			if(i<maxLength)
			{
				for(int j=100;j>=0;j--)
				{
					if(input[j]!=null)
					{
						if(i<input[j].length())
							System.out.print(input[j].charAt(i));
						else
							System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}

}