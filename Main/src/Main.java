// UVa 541 Error Correction
// Current Status: Accepted
// Last Submitted: 2015-05-29 05:24:19
// Run Time: 0.826

import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		Scanner s;
		s = new Scanner(System.in);
		while(s.hasNextInt())
		{
			int size = s.nextInt();
			if(size==0)
				break;
			int[] row = new int[size];
			int[] col = new int[size];
			for(int i=0;i<size;i++)
			{
				for(int j=0;j<size;j++)
				{
					int next = s.nextInt();
					if(next==1)
					{
						row[j]++;
						col[i]++;
					}
				}
			}
			boolean changable = true;
			int corruptRow = -1;
			int corruptCol = -1;
			for(int i=0;i<size;i++)
			{
				if(row[i]%2==1)
				{
					if(corruptRow!=-1)
					{
						changable = false;
						break;
					}
					corruptRow = i;
				}
				if(col[i]%2==1)
				{
					if(corruptCol!=-1)
					{
						changable = false;
						break;
					}
					corruptCol = i;
				}
			}
			if(corruptRow==-1&&corruptCol==-1)
				System.out.println("OK");
			else if(changable)
				System.out.println("Change bit ("+(corruptCol+1)+","+(corruptRow+1)+")");
			else
				System.out.println("Corrupt");

		}
		s.close();
	}
}