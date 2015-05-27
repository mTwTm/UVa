// UVa 483 Word Scramble
// Current Status: Accepted
// Last Submitted: 2015-05-27 07:56:16
// Run Time: 0.305

import java.util.Scanner;


class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);
		String line;
		String buffer;
		while(S.hasNextLine())
		{
			line = S.nextLine();
			buffer = "";
			for(int i=0;i<line.length();i++)
			{
				if((""+line.charAt(i)).matches("\\s"))
				{
					for(int j=buffer.length()-1;j>=0;j--)
						System.out.print(buffer.charAt(j));
					buffer = "";
					System.out.print(line.charAt(i));
				}
				else
					buffer+=line.charAt(i);
			}
			for(int j=buffer.length()-1;j>=0;j--)
				System.out.print(buffer.charAt(j));
			System.out.println();
		}
	}

}
