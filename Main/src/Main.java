// UVa 146 ID Codes 
// Current Status: Accepted
// Last Submitted: 2015-03-30 16:11:49
// Run Time: 0.182

import java.util.Arrays;
import java.util.Scanner;


class Main {
	
	public static void main(String[] args) {
		Scanner s;		
		s = new Scanner(System.in);
		while(s.hasNextLine())
		{
			
			String line = s.nextLine();
			if(line.equals("#"))
			{
				break;
			}
			boolean found = false;
			for(int h=line.length()-2;h>=0;h--)
			{
				int smallestIndex = -1;
				for(int i=line.length()-1;i>=h;i--)
				{
					if(smallestIndex==-1)
					{
						if(line.charAt(i)>line.charAt(h))
							smallestIndex = i;
					}
					else if(line.charAt(i)<line.charAt(smallestIndex)&&line.charAt(i)>line.charAt(h))
						smallestIndex = i;
				}
				if(smallestIndex == -1)
					continue;
				StringBuilder next = new StringBuilder(line);
				next.setCharAt(smallestIndex, line.charAt(h));
				next.setCharAt(h, line.charAt(smallestIndex));
				char[] subToSort = new char[line.length()-1-h];
				for(int i=0;i<subToSort.length;i++)
					subToSort[i] = next.charAt(h+1+i);
				Arrays.sort(subToSort);
				for(int i=0;i<subToSort.length;i++)
					next.setCharAt(h+1+i, subToSort[i]);
				System.out.println(next);				
				found = true;
				break;
			}
			if(!found)
				System.out.println("No Successor");
		}
		s.close();
	}
}